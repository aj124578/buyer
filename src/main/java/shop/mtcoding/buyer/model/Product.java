package shop.mtcoding.buyer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.buyer.util.DateUtil;

@Setter
@Getter
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private Timestamp createdAt;

    // createdAtToString
    public String getCreatedAtToString(){ // getter를 따로만들면 lombok이 인식해서 얘는 getter 안만듦
        return DateUtil.format(createdAt);
    }

}
