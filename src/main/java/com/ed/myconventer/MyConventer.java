package com.ed.myconventer;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

/**
 * 自定义日期转换器
 * @author pk
 *
 */
public class MyConventer implements Converter{

	@Override
	public Object convert(Class clazz, Object value) {
		//将object转成Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse((String) value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
