package cn.itcast.core.web.controller;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import cn.itcast.common.log.annotation.ControllerLog;
import cn.itcast.common.utils.Encodes;
import cn.itcast.common.utils.ImageUtil;
import cn.itcast.common.utils.Page;
import cn.itcast.common.utils.excel.ExportExcel;
import cn.itcast.common.utils.excel.ImportExcel;
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
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	// 依赖注入
	@Autowired
	private MemberService memberService;
	//图片存放位置
	@Value("${upload.dir}")
	private String pic_upload_dir;
	
	/**
	 * 成员列表
	 * @param page 起始页
	 * @param rows 每页记录数
	 */

	@RequestMapping(value = {"list", ""})
	@RequiresPermissions(value={"user:view","admin:crud"},logical=Logical.OR)
//	@ControllerLog(operationType="list",operationName="分页查询")  
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
//	@ControllerLog(operationType="selectFamily:",operationName="查询家庭列表")  
	public List<Family> selectFamily(){
		List<Family> family = memberService.selectFamily();
		return family;
	}
	
	/*
	 * 成员编辑
	*/
	@RequestMapping("/edit")
	@ControllerLog(operationType="getmemberById",operationName="根据id获取成员信息")  
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
	@ControllerLog(operationType="memberUpdate",operationName="成员更新操作")  
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
	@ControllerLog(operationType="memberAdd",operationName="新增成员") 
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
	@ControllerLog(operationType="memberDelete",operationName="根据id删除成员") 
	@RequiresPermissions("admin:crud")
	public String memberDelete(@RequestParam("memId")int id) {
		memberService.deletemember(id);
		return "succ";
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
	@ControllerLog(operationType="updateItem",operationName="图片上传") 
	public String updateItem(HttpServletRequest request,FileDemo fileDemo,@RequestParam("myfile")MultipartFile[] pictureFile) throws Exception{
		//设置字符集
		request.setCharacterEncoding("utf-8");
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
	@ControllerLog(operationType="deleteChecked",operationName="复选删除")
	@RequiresPermissions("admin:crud")
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
	
	/*
	 * 导出Excel
	 */
	@RequestMapping("/exportExcel")
	@ControllerLog(operationType="exportExcel",operationName="导出Excel") 
	public void exportExcel(QueryVo queryVo, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes){
		try {
			//查询所有分区数据
			List<QueryVo> list = memberService.findList(queryVo);
			String filename = "这是文件名"+".xlsx";
			//new ExportExcel()创建一个excel并初始化
			//setDataList()往excel添加数据。dispose()清理临时文件。
			new ExportExcel("成员信息表", QueryVo.class).setDataList(list).write(response, filename).dispose();
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
	
	/*
	 * 导出pdf
	 */
	@RequestMapping(value="exportpdf", method=RequestMethod.POST)
	@ControllerLog(operationType="exportPDF",operationName="导出pdf") 
	public String exportPDF(QueryVo queryVo, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception{
		RequestContext requestContext = new RequestContext(request);
		BaseFont bfFont = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",true);
		Font chineseFont = new Font(bfFont,8,Font.NORMAL,Color.BLACK);
		String fileName ="pdf导出测试";
    	response.setHeader("Content-disposition", "attachment;filename="+Encodes.urlEncode(fileName+".pdf"));
    	response.setContentType("application/octet-stream; charset=utf-8");
    	String doctitle = "成员信息表";
    	List<QueryVo> list = memberService.findList(queryVo);
		
		//创建一个文档对象纸张大小A4
		Document doc = new Document(PageSize.A4,10,10,50,50);
		//设置输出文件名
		//PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path+"\\"+fileName+".pdf"));
		PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());
		//设置作者信息
		doc.addAuthor("xiaoyin");
		doc.addCreationDate();
		doc.addTitle(doctitle);
		doc.addSubject("");
		HeaderFooter footer = new HeaderFooter(new Phrase(), true);
		footer.setBorder(0);
		footer.setAlignment(Element.ALIGN_CENTER);
		doc.setFooter(footer);
		doc.open();
		Paragraph par3 = new Paragraph(doctitle,chineseFont);
		par3.setAlignment(Element.ALIGN_CENTER);
		doc.add(par3);
		Table table = new Table(10);
		//按比例设置单元格宽度  
		float[] widths = {0.25f, 0.5f, 0.25f, 0.5f,0.5f,2f,1f,2f,2f,1f};
		table.setWidths(widths);
		table.setBorder(1);
		table.setPadding(5);
		Cell cell1 = new Cell(new Phrase("编号",chineseFont));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setHeader(true);
		cell1.setBackgroundColor(Color.WHITE);
		Cell cell2 = new Cell(new Phrase("名称",chineseFont));
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setHeader(true);
		cell2.setBackgroundColor(Color.WHITE);
		Cell cell3 = new Cell(new Phrase("性别",chineseFont));
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3.setHeader(true);
		cell3.setBackgroundColor(Color.WHITE);
		Cell cell4 = new Cell(new Phrase("婚否",chineseFont));
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell4.setHeader(true);
		cell4.setBackgroundColor(Color.WHITE);
		Cell cell5 = new Cell(new Phrase("配偶",chineseFont));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell5.setHeader(true);
		cell5.setBackgroundColor(Color.WHITE);
		Cell cell6 = new Cell(new Phrase("子女",chineseFont));
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell6.setHeader(true);
		cell6.setBackgroundColor(Color.WHITE);
		Cell cell7 = new Cell(new Phrase("成员家庭",chineseFont));
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7.setHeader(true);
		cell7.setBackgroundColor(Color.WHITE);
		Cell cell8 = new Cell(new Phrase("籍贯",chineseFont));
		cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell8.setHeader(true);
		cell8.setBackgroundColor(Color.WHITE);
		Cell cell9 = new Cell(new Phrase("现居地",chineseFont));
		cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell9.setHeader(true);
		cell9.setBackgroundColor(Color.WHITE);
		Cell cell10 = new Cell(new Phrase("联系电话",chineseFont));
		cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell10.setHeader(true);
		cell10.setBackgroundColor(Color.WHITE);
		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell5);
		table.addCell(cell6);
		table.addCell(cell7);
		table.addCell(cell8);
		table.addCell(cell9);
		table.addCell(cell10);
		table.endHeaders();
		for (int i = 0; i < list.size(); i++) {
			QueryVo sub=  list.get(i);
			String memId = sub.getMemId()+"";
			String memName = sub.getMemName();
			String memSex = sub.getMemSex();
			String memMarry = sub.getMemMarry();
			String worh = sub.getWorh();
			String memChildren = sub.getMemChildren();
			String familyName = sub.getFamilyName();
			String familyLocation = sub.getFamilyLocation();
			String memAddress = sub.getMemAddress();
			String memPhone = sub.getMemPhone();
			Cell cell11 = new Cell(new Phrase(memId+"",chineseFont));
			Cell cell22 = new Cell(new Phrase(memName+"",chineseFont));
			Cell cell33 = new Cell(new Phrase(memSex+"",chineseFont));
			Cell cell44 = new Cell(new Phrase(memMarry+"",chineseFont));
			Cell cell55 = new Cell(new Phrase(worh+"",chineseFont));
			Cell cell66 = new Cell(new Phrase(memChildren+"",chineseFont));
			Cell cell77 = new Cell(new Phrase(familyName+"",chineseFont));
			Cell cell88 = new Cell(new Phrase(familyLocation+"",chineseFont));
			Cell cell99 = new Cell(new Phrase(memAddress+"",chineseFont));
			Cell cell1010 = new Cell(new Phrase(memPhone+"",chineseFont));
			
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell11.setVerticalAlignment(Element.ALIGN_CENTER);
			cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell22.setVerticalAlignment(Element.ALIGN_CENTER);
			cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell33.setVerticalAlignment(Element.ALIGN_CENTER);
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell44.setVerticalAlignment(Element.ALIGN_CENTER);
			cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell55.setVerticalAlignment(Element.ALIGN_CENTER);
			cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell66.setVerticalAlignment(Element.ALIGN_CENTER);
			cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell77.setVerticalAlignment(Element.ALIGN_CENTER);
			cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell88.setVerticalAlignment(Element.ALIGN_CENTER);
			cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell99.setVerticalAlignment(Element.ALIGN_CENTER);
			cell1010.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1010.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell11);
			table.addCell(cell22);
			table.addCell(cell33);
			table.addCell(cell44);
			table.addCell(cell55);
			table.addCell(cell66);
			table.addCell(cell77);
			table.addCell(cell88);
			table.addCell(cell99);
			table.addCell(cell1010);
		}
		doc.add(table);
		doc.newPage();
		doc.close();
		writer.close();
		return null;
	}
	
	/**
	 * 导入Excel数据
	 */
    @RequestMapping(value = "importExcel", method=RequestMethod.POST)
    @ControllerLog(operationType="importExcel",operationName="导入Excel数据") 
    public String importExcel(@RequestParam(value="myfile",required=false)MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<QueryVo> list = ei.getDataList(QueryVo.class);
			for (QueryVo queryVo : list){
				memberService.addmember(queryVo);
				successNum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/list.action";
    }
	
}
