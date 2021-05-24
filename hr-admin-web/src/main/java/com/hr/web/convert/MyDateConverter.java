package com.hr.web.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author junjie
 * @version 1.0.0
 */
@Component
public class MyDateConverter implements Converter<String, Date> {

    private static final String shortDateFormat = "yyyy-MM-dd";

    @Override
    public Date convert(String source) {

        System.out.println("时间："+source);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(shortDateFormat) ;
        Date parse = null ;
        try {
            parse = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("转换后的时间："+parse);
        return parse;
    }
}
