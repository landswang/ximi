package com.ejie.nbrs.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 自定义返回JSON 数据格中日期格式化处理
 * 
 * @author torreswangzh@gmail.com
 * @version
 * @since Ver 1.1
 * @Date 2017年7月11日 下午2:34:33
 * @see
 * 
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

  @Override
  public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    jsonGenerator.writeString(sdf.format(value));
  }

}