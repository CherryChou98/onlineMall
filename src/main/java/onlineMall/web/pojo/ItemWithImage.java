package onlineMall.web.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @ Package: onlineMall.web.pojo
 * @ Author     ：linsola
 * @ Date       ：Created in 16:24 2018/12/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
@Component
public class ItemWithImage extends Item {

    private ArrayList<Integer> imageIds = new ArrayList<>();

    private ArrayList<String> imageUrls = new ArrayList<>();

    private ArrayList<String> imageDescriptions = new ArrayList<>();

    //存放category表的name字段
    private String name1;

    public ArrayList<Integer> getImageIds() {
        return imageIds;
    }

    public void setImageIds(Integer imageId) {
        this.imageIds.add(imageId);
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrl) {
        this.imageUrls.add(imageUrl);
    }

    public ArrayList<String> getImageDescriptions() {
        return imageDescriptions;
    }

    public void setImageDescriptions(String imageDescription) {
        this.imageDescriptions.add(imageDescription);
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}
