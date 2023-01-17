package shop.mtcoding.buyer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Timestamp createdAt; // db에서 select 하면 yml에서 스네이크를 커멜로 바꿔주게 설정해놔서 가능함
}
