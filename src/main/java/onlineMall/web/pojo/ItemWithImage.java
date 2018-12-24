package onlineMall.web.pojo;

import org.springframework.stereotype.Component;

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
    private Integer imageId;

    private String imageUrl;

    private String imageDescription;

    //存放category表的name字段
    private String name1;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageDescription() { return imageDescription; }

    public void setImageDescription(String imageDescription) { this.imageDescription = imageDescription; }

    public String getName1() { return name1; }

    public void setName1(String name1) { this.name1 = name1; }
}
