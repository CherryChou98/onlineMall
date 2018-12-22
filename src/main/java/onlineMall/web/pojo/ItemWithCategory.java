package onlineMall.web.pojo;

import org.springframework.stereotype.Component;

/**
 * @ Package: onlineMall.web.pojo
 * @ Author     ：linsola
 * @ Date       ：Created in 23:59 2018/12/22
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Component
public class ItemWithCategory extends Item {

    private String name1;

    public String getName1() { return name1; }

    public void setName1(String name1) { this.name1 = name1; }
}
