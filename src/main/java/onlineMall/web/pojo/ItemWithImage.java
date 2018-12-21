package onlineMall.web.pojo;

/**
 * @ Package: onlineMall.web.pojo
 * @ Author     ：linsola
 * @ Date       ：Created in 16:24 2018/12/21
 * @ Description：
 * @ Modified By：
 * @ Version:
 */
public class ItemWithImage extends Item {
    private Integer imageId;

    private String imageUrl;

    private String imageDescription;

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

}
