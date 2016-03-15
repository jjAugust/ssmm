package org.zt.ssmm.controller;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
	@Controller
	@RequestMapping("/upload")
	public class UploadController {
	 
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
	                // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  )
	                String filePath = request.getSession().getServletContext()
	                    .getRealPath("/") + "upload/" + file.getOriginalFilename();
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
	    public String filesUpload(@RequestParam("myfiles") MultipartFile[] files,
	            HttpServletRequest request) {
	        if (files != null && files.length > 0) {
	            for (int i = 0; i < files.length; i++) {
	                MultipartFile file = files[i];
	                // 保存文件
	                saveFile(request, file);
	            }
	        }
	         
	        // 重定向
	        return "redirect:/upload/toUpload";
	    }
}
