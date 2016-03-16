package org.zt.ssmm.util;



import java.util.HashMap;
import java.util.Map;

import org.zt.ssmm.core.Returntype;


public class ReturnUtil {

	static Map<String,String> mapty = new HashMap<String,String>(){
		{ 
			put("_KEYS_s01","s01&成功登陆");
			put("_KEYS_s02","s02&添加成功");
			put("_KEYS_s03","s02&删除成功");
			put("_KEYS_s04","s04&成功查询");
			put("_KEYS_s05","s05&成功更新");
			put("_KEYS_s06","s06&上传成功");
			put("_KEYS_f01","f01&失败");
			put("_KEYS_f02","f02&name already exist");
			put("_KEYS_f03","f03&添加失败");
			put("_KEYS_f04","f04&删除失败");
			put("_KEYS_f05","f05&验证码错误");
			put("_KEYS_f06","f06&手机验证码错误");
			put("_KEYS_f07","f07&更新失败");
			put("_KEYS_f08","f08&上传失败");
		}};
		public static void fix(Returntype text,String code)
		{

			String[] fixp=mapty.get(code).toString().split("&");
			text.setCode(fixp[0]);
			text.setMessage(fixp[1]);
		}
}
