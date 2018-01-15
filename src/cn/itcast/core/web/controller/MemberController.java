package cn.itcast.core.web.controller;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONObject;
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
import org.springframework.web.servlet.ModelAndView;

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
import cn.itcast.common.utils.Page;
import cn.itcast.common.utils.PropertyCopyUtil;
import cn.itcast.common.utils.excel.ExportExcel;
import cn.itcast.common.utils.excel.ImportExcel;
import cn.itcast.core.bean.dto.MemberDto;
import cn.itcast.core.bean.entity.Family;
import cn.itcast.core.bean.entity.FileDemo;
import cn.itcast.core.bean.entity.Member;
import cn.itcast.core.bean.entity.Pcat;
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
	 * @param start 起始页
	 * @param rows 每页记录数
	 */
	@RequestMapping(value = {"list", ""})
	@RequiresPermissions(value="view")
	@ControllerLog(operationType="list",operationName="分页查询")  
	public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows, Model model) {
		Page<MemberDto> pageList = memberService.findMemberList(page,rows);
        model.addAttribute("page", pageList);
        logger.debug("分页查询");
		return "MyJsp";
	}
	/**
	 * 条件分页查询
	 * @param start 起始页
	 * @param rows 每页记录数
	 */
	@RequestMapping(value = {"selectPageWhere"})
	@RequiresPermissions(value="view")
	@ControllerLog(operationType="selectPageWhere",operationName="条件分页查询")  
	public String selectPageWhere(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows,
			MemberDto memberDto, Model model) {
		Page<MemberDto> pageList = memberService.selectPageWhere(page,rows,memberDto);
		model.addAttribute("page", pageList);
		logger.debug("条件分页查询");
		return "MyJsp";
	}
	
	/*@RequestMapping(value = {"list_layui", ""})
	@RequiresPermissions(value={"user:view","admin:view"},logical=Logical.OR)
	@ResponseBody
	public String list_layui(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows,QueryVo queryVo) {
		//当前页
		queryVo.setStart((page-1) * rows) ;
		//每页数
		queryVo.setRows(rows);
		List<QueryVo> list = memberService.findList(queryVo);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 200);
		jsonObject.put("msg", "妈卖批");
		jsonObject.put("count", 13);
		jsonObject.put("data", list);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}*/
	
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
	 * 根据id获取成员信息
	*/
	@RequestMapping("/edit")
	@ControllerLog(operationType="getmemberById",operationName="根据id获取成员信息")  
	@RequiresPermissions(value={"view","select"},logical=Logical.OR)
	@ResponseBody
	public MemberDto getmemberById(int id) throws IllegalArgumentException, IllegalAccessException {
		if(id == -1){
			return new MemberDto();
		}
		//根据id查询数据库
		Member member = memberService.selectById(id);
		MemberDto memberDto = new MemberDto();
		//将member属性值复制到memberDto
		PropertyCopyUtil.copy(member, memberDto);
		//将省市区乡的数据复制到memberDto
		Pcat pcat = memberService.selectPcatById(member.getMemId());
		PropertyCopyUtil.copy(pcat, memberDto);
		//
		Family family = memberService.selectFamilyById(member.getFamilyId());
		memberDto.setFamilyName(family.getFamilyName());
		memberDto.setFamilyLocation(family.getFamilyLocation());
		
		if(member != null){
			//将图片名称截取到memberDto中
			String pic = member.getMemPic();
			if(pic != null){
				int index = pic.lastIndexOf("/")+1;
				String picName = pic.substring(index);
				memberDto.setMemPic(picName);
			}
		}
		return memberDto;
	} 

	
	/*
	 * 成员编辑
	 */
	@RequestMapping("/add")
	@ControllerLog(operationType="memberAdd",operationName="新增成员") 
	@RequiresPermissions(value={"view","select"},logical=Logical.OR)
	public String memberAdd(HttpServletRequest request,MemberDto memberDto) {
		if(memberDto.getMemId() != 0){
			//成员更新操作
			memberService.updatemember(memberDto);
		}else{
			//成员添加
			memberService.addmember(memberDto); 
		}
		return "redirect:/member/list.action";
	}
	
	/*
	 * 成员更新操作
	 */
	/*@RequestMapping("/update")
	@ControllerLog(operationType="memberUpdate",operationName="成员更新操作")  
	//@RequiresPermissions(value={"user:update","admin:crud"},logical=Logical.OR)
	public String memberUpdate(HttpServletRequest request,MemberDto memberDto) {
		memberService.updatemember(memberDto);
		return "redirect:/member/list.action";
	}*/
	
	
	/*
	 * 成员删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@ControllerLog(operationType="memberDelete",operationName="根据id删除成员") 
	@RequiresPermissions("delete")
	public String memberDelete(@RequestParam("memId")int id) {
		memberService.deletemember(id);
		return "succ";
	}
	
	
	/*
	 * 图片上传下载跳转
	 */
	@RequestMapping("/uploadDown")
	public String uploadDown(Model model,String picPrefix){
		model.addAttribute("picPrefix", picPrefix);
		return "fileUpDown";
	} 
	
	/*
	 * 图片上传，
	 */
	@RequestMapping("/upload")
	@ControllerLog(operationType="updateItem",operationName="图片上传") 
	public ModelAndView updateItem(HttpServletRequest request,String picPrefix,@RequestParam("myfile")MultipartFile[] pictureFile) throws Exception{
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
                picName = picPrefix+"-"+picName;
              //文件上传
                file.transferTo(new File(pathRoot+"//"+picName));
              //把文件名保存到数据库
                FileDemo fileDemo = new FileDemo();
        		fileDemo.setFileName(picName);
        	    fileDemo.setFilePath(pathRoot+"//"+picName);
        	    fileDemo.setPicPrefix(picPrefix);
        	    memberService.fileUpload(fileDemo);
            }
        }
		return new ModelAndView("redirect:/member/sb.action").addObject("picPrefix",picPrefix);
	}
	
	/*
	 * 头像上传，
	 */
	@RequestMapping("/ajax_upload")
	@ControllerLog(operationType="ajax_upload",operationName="头像上传") 
    @ResponseBody
    public String up(@RequestParam MultipartFile file) throws IOException{
		String pathRoot = pic_upload_dir;
		//原始文件名
        String picName = file.getOriginalFilename();
		file.transferTo(new File(pathRoot+"/"+picName));
		//把文件名保存到数据库
		FileDemo fileDemo = new FileDemo();
		fileDemo.setFileName(picName);
	    fileDemo.setFilePath(pathRoot+"/"+picName);
	   // memberService.fileUpload(fileDemo);  
	    JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 200);
		jsonObject.put("msg", pathRoot+"/"+picName);
		jsonObject.put("src", picName);
		jsonObject.put("data", fileDemo);
		System.out.println(jsonObject.toString());
		return jsonObject.toString();

    }

	
	/*
	 * 上传图片列表
	 */
	@RequestMapping("/sb")
	public String sb(Model model,String picPrefix) {
		if("".equals(picPrefix)){
			model.addAttribute("fileDemo", null);
		}else{
			List<FileDemo> fileDemo = memberService.findFileList(picPrefix);
			model.addAttribute("fileDemo", fileDemo);
		}
		return "gallary";
	}
	
	/*
	 * 照片墙
	 * */
	@RequestMapping("/phoneWall")
	public String phoneWall(Model model) {
		
		List<FileDemo> fileDemo = memberService.findAll();
		model.addAttribute("fileDemo", fileDemo);
		
		return "gallary";
	}
	
	
	/*
	 * 百度地图api
	 * 家庭住址
	 */
	@RequestMapping("baiduMap")
	public String baiduMap(Model model ,String picPrefix){
		Family family = memberService.findFamilyLocation(picPrefix);
		model.addAttribute("data",family.getFamilyLocation() );
		return "baiduMap";
	}
	
	
	/*
	 * 百度地图api
	 * 现居地
	 */
	@RequestMapping("baiduMapAddress")
	public String baiduMapAddress(Model model ,String city){
		model.addAttribute("data",city );
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
	@RequiresPermissions("delete")
	public String deleteChecked(@RequestParam("Str")String ids) {
		String[] id = ids.split(",");
		try {
			for (String idStr : id) {
				memberService.deletemember(Integer.valueOf(idStr));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK";
	}
	
	
	
	/*
	 * 导出Excel
	 */
	@RequestMapping("/exportExcel")
	@ControllerLog(operationType="exportExcel",operationName="导出Excel") 
	public void exportExcel(MemberDto memberDto, HttpServletResponse response){
		try {
			//查询所有分区数据
			List<MemberDto> list = memberService.findList();
			String filename = "这是文件名"+".xlsx";
			//new ExportExcel()创建一个excel并初始化
			//setDataList()往excel添加数据。dispose()清理临时文件。
			new ExportExcel("成员信息表", MemberDto.class).setDataList(list).write(response, filename).dispose();
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
	public String exportPDF(MemberDto memberDto, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//RequestContext requestContext = new RequestContext(request);
		BaseFont bfFont = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",true);
		Font chineseFont = new Font(bfFont,8,Font.NORMAL,Color.BLACK);
		String fileName ="pdf导出测试";
    	response.setHeader("Content-disposition", "attachment;filename="+Encodes.urlEncode(fileName+".pdf"));
    	response.setContentType("application/octet-stream; charset=utf-8");
    	String doctitle = "成员信息表";
    	List<MemberDto> list = memberService.findList();
		
		//创建一个文档对象纸张大小A4
		Document doc = new Document(PageSize.A4.rotate(),10,10,50,50);
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
		Table table = new Table(9);
		//按比例设置单元格宽度  
		float[] widths = {0.5f, 1f, 0.25f, 0.5f,1f,2f,1.25f,2.5f,1f};
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
		Cell cell7 = new Cell(new Phrase("联系电话",chineseFont));
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7.setHeader(true);
		cell7.setBackgroundColor(Color.WHITE);
		Cell cell8 = new Cell(new Phrase("现居地",chineseFont));
		cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell8.setHeader(true);
		cell8.setBackgroundColor(Color.WHITE);
		Cell cell9 = new Cell(new Phrase("成员家庭",chineseFont));
		cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell9.setHeader(true);
		cell9.setBackgroundColor(Color.WHITE);
		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell5);
		table.addCell(cell6);
		table.addCell(cell7);
		table.addCell(cell8);
		table.addCell(cell9);
		table.endHeaders();
		for (int i = 0; i < list.size(); i++) {
			MemberDto sub=  list.get(i);
			String memId = sub.getMemId()+"";
			String memName = sub.getMemName();
			String memSex = sub.getMemSex();
			String memMarry = sub.getMemMarry();
			String memWorh = sub.getMemWorh();
			String memChildren = sub.getMemChildren();
			String memPhone = sub.getMemPhone();
			String memAddress = sub.getMemAddress();
			String familyName = sub.getFamilyName();
			Cell cell11 = new Cell(new Phrase(memId+"",chineseFont));
			Cell cell22 = new Cell(new Phrase(memName+"",chineseFont));
			Cell cell33 = new Cell(new Phrase(memSex+"",chineseFont));
			Cell cell44 = new Cell(new Phrase(memMarry+"",chineseFont));
			Cell cell55 = new Cell(new Phrase(memWorh+"",chineseFont));
			Cell cell66 = new Cell(new Phrase(memChildren+"",chineseFont));
			Cell cell77 = new Cell(new Phrase(memPhone+"",chineseFont));
			Cell cell88 = new Cell(new Phrase(memAddress+"",chineseFont));
			Cell cell99 = new Cell(new Phrase(familyName+"",chineseFont));
			
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
			table.addCell(cell11);
			table.addCell(cell22);
			table.addCell(cell33);
			table.addCell(cell44);
			table.addCell(cell55);
			table.addCell(cell66);
			table.addCell(cell77);
			table.addCell(cell88);
			table.addCell(cell99);
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
    public String importExcel(@RequestParam(value="myfile",required=false)MultipartFile file) {
		try {
			int successNum = 0;
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<MemberDto> list = ei.getDataList(MemberDto.class);
			for (MemberDto memberDto : list){
				memberService.addmember(memberDto);
				successNum++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/list.action";
    }
	
}
