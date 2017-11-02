package cn.itcast.core.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.common.utils.ImageUtil;
import cn.itcast.common.utils.Page;
import cn.itcast.core.bean.Family;
import cn.itcast.core.bean.FileDemo;
import cn.itcast.core.bean.QueryVo;
import cn.itcast.core.service.MemberService;


/**
 * 家庭成员管理
 * @version 1.0
 */
@Controller
@RequestMapping("/member")
public class MemberController {

	// 依赖注入
	@Autowired
	private MemberService memberService;
	//图片存放位置
	@Value("${pic_upload_dir}")
	private String pic_upload_dir;
	
	/*
	 * 成员列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows,
			QueryVo queryVo, Model model) {
		Page<QueryVo> pageList = memberService.findMemberList(page,rows,queryVo);
        model.addAttribute("page", pageList);
		return "member";
	}
	
	/*
	 * 家庭列表
	 */
	@RequestMapping("/selectFamily")
	@ResponseBody
	public List<Family> selectFamily(){
		List<Family> family = memberService.selectFamily();
		return family;
	}
	
	/*
	 * 成员编辑
	*/
	@RequestMapping("/edit")
	public String getmemberById(int id,Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		QueryVo queryVo = memberService.getmemberById(id);
		String pic = queryVo.getPic();
		if(pic != null){
			int index = pic.lastIndexOf("/")+1;
			String picName = pic.substring(index);
			model.addAttribute("picName", picName);
		}
		model.addAttribute("member", queryVo);
		return "info";
	} 

	/*
	 * 成员更新操作
	 */
	@RequestMapping("/update")
	public String memberUpdate(HttpServletRequest request,QueryVo queryVo,@RequestParam("myfile")MultipartFile pictureFile) throws IOException {
		 if (pictureFile.getSize() != 0) {  
			 //设置字符集
			 request.setCharacterEncoding("utf-8");
			 String pathRoot = pic_upload_dir;
			 //接收上传文件
			 MultipartFile file = pictureFile;
			 //原始文件名
			 String picName = file.getOriginalFilename();
			 //文件上传
			 file.transferTo(new File(pathRoot+"/"+picName));
			 //把文件名保存到数据库
			 queryVo.setPic(pathRoot+"/"+picName);
			 //使用图片工具类裁剪图片
	         File fromFile = new File(pathRoot+"/"+picName); 
	         File toFile = new File(pathRoot+"/"+picName);  
	         ImageUtil.resizePng(fromFile, toFile, 500, 700, false); 
	        } 
		memberService.updatemember(queryVo);
		return "redirect:/member/list.action";
	}
	
	/*
	 * 成员添加
	 */
	@RequestMapping("/add")
	public String memberAdd(HttpServletRequest request,QueryVo queryVo,@RequestParam("myfile")MultipartFile pictureFile) throws IOException {
		if (pictureFile.getSize() != 0) {  
			//设置字符集
			request.setCharacterEncoding("utf-8");
			String pathRoot = pic_upload_dir;
			//接收上传文件
	        MultipartFile multipartFile = pictureFile;  
	        //原始文件名
	        String picName = multipartFile.getOriginalFilename();
	        //文件上传
	        multipartFile.transferTo(new File(pathRoot+"/"+picName));
	        //把文件名保存到数据库
	        queryVo.setPic(pathRoot+"/"+picName);
	        //使用图片工具类裁剪图片
	        File fromFile = new File(pathRoot+"/"+picName); 
	        File toFile = new File(pathRoot+"/"+picName);  
	        ImageUtil.resizePng(fromFile, toFile, 500, 700, false);  
		}
		memberService.addmember(queryVo); 
		return "redirect:/member/list.action";
	}
	
	/*
	 * 成员删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public void memberDelete(@RequestParam("memId")int id) {
		memberService.deletemember(id);
		return ;
	}
	
	
	/*
	 * 图片上传下载跳转
	 */
	@RequestMapping("/uploadDown")
	public String uploadDown(){
		return "fileUpDown";
	} 
	
	/*
	 * 图片上传，
	 */
	@RequestMapping("/upload")
	public String updateItem(HttpServletRequest request,FileDemo fileDemo,@RequestParam("myfile")MultipartFile[] pictureFile) throws Exception{
		//设置字符集
		request.setCharacterEncoding("utf-8");
		//接收上传的文件
		List<String> list = new ArrayList<String>();
		//获得物理路径webapp所在路径  
        //String pathRoot = request.getSession().getServletContext().getRealPath("/static/images"); 
		String pathRoot = pic_upload_dir;
        if (pictureFile != null && pictureFile.length > 0) {
            for (int i = 0; i < pictureFile.length; i++) {
                MultipartFile file = pictureFile[i];
              //原始文件名
                String picName = file.getOriginalFilename();
              //文件上传
                file.transferTo(new File(pathRoot+"//"+picName));
              //把文件名保存到数据库
        		fileDemo.setFileName(picName);
        	    fileDemo.setFilePath(pathRoot+"//"+picName);
        	    memberService.fileUpload(fileDemo);
            }
        }

		//memberService.fileUpload(fileDemo);
		//重定向到itemList.action地址,request无法带过去
		return "redirect:/member/sb.action";
		//结果转发到itemList.action，request可以带过去
		//request.setAttribute("picPath", picPath);
		//return "forward:/member/fileList.action";
	}
	
	/*
	 * 上传图片列表
	 */
	@RequestMapping("/sb")
	public String sb(Model model) {
		List<FileDemo> fileDemo = memberService.findFileList();
		model.addAttribute("fileDemo", fileDemo);
		return "gallary";
	}
	
	/*
	 * 跳转到静态HTML页面
	 
	@RequestMapping("/fileList")
	public String fileList() {
		return "fileList";
	}*/
	
	/*
	 * 百度地图api
	 */
	@RequestMapping("baiduMap")
	public String baiduMap(){
		return "baiduMap";
	}
	
	
	/*
	 * 图片下载
	 
	@RequestMapping("download")
	 public String downloadFile(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (fileName != null) {
         // String pathRoot = request.getSession().getServletContext().getRealPath("/upload"); 
		String  pathRoot = pic_upload_dir;
          File file = new File(pathRoot, fileName);
          if (file.exists()) {
              response.setContentType("application/force-download");// 设置强制下载不打开
              response.setCharacterEncoding("utf-8");
              response.addHeader("Content-Disposition",
                      "attachment;fileName=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));// 设置文件名
             byte[] buffer = new byte[1024];
              FileInputStream fis = null;
              BufferedInputStream bis = null;
              try {
                  fis = new FileInputStream(file);
                  bis = new BufferedInputStream(fis);
                  OutputStream os = response.getOutputStream();
                  int i = bis.read(buffer);
                  while (i != -1) {
                      os.write(buffer, 0, i);
                      i = bis.read(buffer);
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  if (bis != null) {
                      try {
                          bis.close();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                 }
                  if (fis != null) {
                      try {
                          fis.close();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }
             }
          }
        }
          return null;
     }*/
	
	/*
	 * 复选删除
	 */
	@RequestMapping("/deleteChecked")
	@ResponseBody
	public String deleteChecked(@RequestParam("Str")String ids) {
		String[] id = ids.split(",");
		try {
			for (String idStr : id) {
				memberService.deletemember(Integer.valueOf(idStr));
			}
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	
}
