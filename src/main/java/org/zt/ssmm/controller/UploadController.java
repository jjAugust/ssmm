package org.zt.ssmm.controller;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;










import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zt.ssmm.core.Returntype;
import org.zt.ssmm.core.Uploadpic;
import org.zt.ssmm.service.PicService;
import org.zt.ssmm.service.UserService;
import org.zt.ssmm.util.ReturnUtil;
@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	private PicService pics;


	@RequestMapping("/toUpload")
	public String toUpload() {
		return "/upload";
	}

	/***
	 * 保存文件
	 *
	 * @param file
	 * @return
	 */
	private boolean saveFile(HttpServletRequest request, MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				Date i= new Date();
				DateFormat j= new SimpleDateFormat("yyyyMMddhhmmss");
				int p=(int)Math.round(Math.random()*9000+1000);
				String filename=j.format(i)+""+p;
				// 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  )
				String filePath = 
						//						request.getSession().getServletContext().getRealPath("/") +
						"/data/wwwroot/default/upload/" 
						//"C:/upload/"
						+filename+".jpg";

				Uploadpic temp=new Uploadpic();
				temp.setName(request.getSession().getAttribute("id").toString());
				temp.setBelong("");
				temp.setUrl(filename);
				pics.insertUploadPic(temp);

				//	                    file.getOriginalFilename();
				File saveDir = new File(filePath);
				if (!saveDir.getParentFile().exists())
					saveDir.getParentFile().mkdirs();

				// 转存文件
				file.transferTo(saveDir);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 上传图片
	 *
	 * @param files
	 * @param request
	 * @return
	 */
	@RequestMapping("/filesUpload")
	@ResponseBody
	public Object filesUpload(@RequestParam("myfiles") MultipartFile[] files,
			HttpServletRequest request) {
		boolean j = false;
		Returntype text=new Returntype();
		if(request.getSession().getAttribute("id")==null){
			ReturnUtil.fix(text,"_KEYS_f08");
			return text;
		}
		else{
			if (files != null && files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					MultipartFile file = files[i];
					// 保存文件
					j= saveFile(request, file);
					System.out.println(j);
				}
			}

			if(j==true){
				ReturnUtil.fix(text,"_KEYS_s06");
				return text;
			}

			else{
				ReturnUtil.fix(text,"_KEYS_f08");
				return text;
			}
		}
	}

}
