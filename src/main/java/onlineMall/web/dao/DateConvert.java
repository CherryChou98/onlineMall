package onlineMall.web.dao;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author FT丶Kuroko
 * @date 2018/12/22 23:54
 */
@Repository
public class DateConvert implements Converter {

    @Override
    public Object convert(Object o) {
        return null;
    }

    public Date convert(String s){
        SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try{
            date = sdp.parse(s);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
