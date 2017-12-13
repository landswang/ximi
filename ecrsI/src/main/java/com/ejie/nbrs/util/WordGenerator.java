package com.ejie.nbrs.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * word工具类
 * 
 * @author Administrator
 *
 */
public class WordGenerator {
	/**
	 * 配置管理
	 */
	private static Configuration configuration = null;
	/**
	 * 模板
	 */
	private static Map<String, Template> allTemplates = null;

	public static void cDoc(String type,String source){
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");// 设置编码格式
		configuration.setClassForTemplateLoading(WordGenerator.class,
				"/com/ejie/nbrs/ftl");// 获取模板路劲关联类
		allTemplates = new HashMap<>();
		try {
			allTemplates
					.put(type, configuration.getTemplate(source));// 解析得到模板存进map
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private WordGenerator() {
		throw new AssertionError();
	}

	/**
	 * 将参数已map形式写如模板
	 * 
	 * @param dataMap
	 * @param type
	 * @return
	 */
	public static File createDoc(Map<?, ?> dataMap, String type, String source) {
		cDoc(type,source);
		String name = type + ".doc";
		File f = new File(name);
		Template t = allTemplates.get(type);// 通过map的键得到模板
		// System.out.println(t);
		try {
			// 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
			Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
			t.process(dataMap, w);// 把值写入临时文件f中
			w.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return f;
	}

	/**
	 * 将参数已map形式写如模板
	 * 
	 * @param dataMap
	 * @param type
	 * @return
	 */
	public static File createExcel(Map<?, ?> dataMap, String type, String source) {
		cDoc(type,source);
		String name = type + ".xls";
		File f = new File(name);
		Template t = allTemplates.get(type);// 通过map的键得到模板
		// System.out.println(t);
		try {
			// 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
			Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
			t.process(dataMap, w);// 把值写入临时文件f中
			w.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return f;
	}

}