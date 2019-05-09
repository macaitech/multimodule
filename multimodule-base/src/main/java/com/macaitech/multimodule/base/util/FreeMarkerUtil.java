/**
 * 
 */
package com.macaitech.multimodule.base.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * @author yuhui.tang  
 * 2018年9月6日 下午4:01:02
 *  
 */
public class FreeMarkerUtil {
	
	/**
	 * 渲染为字符返回
	 * @param sourceTemplate
	 * @param model
	 * @return
	 * @throws IOException
	 */
	public static String renderString(File sourceTemplate,Map<String, Object> model) throws IOException {
		 Configuration configuration = new Configuration();  
         configuration.setDirectoryForTemplateLoading(new File(sourceTemplate.getParentFile().getPath()));  
         configuration.setObjectWrapper(new DefaultObjectWrapper());  
         configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码  
         //获取或创建一个模版。  
         Template template = configuration.getTemplate(sourceTemplate.getName()); 
		String content = FreeMarkers.renderTemplate(template, model);
		return content;
	}
}
