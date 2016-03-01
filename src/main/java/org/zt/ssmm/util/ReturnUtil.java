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
			put("_KEYS_f01","f01&失败");
			put("_KEYS_f02","f02&name already exist");
			put("_KEYS_f03","f03&添加失败");
			put("_KEYS_f04","f04&删除失败");
		}};
		public static void fix(Returntype text,String code)
		{

			String[] fixp=mapty.get(code).toString().split("&");
			text.setCode(fixp[0]);
			text.setMessage(fixp[1]);
		}
}