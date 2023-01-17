package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserRepository { // 기능을 모를때 CRUD
    public int insert(String username, String password, String email);
    public List<User> findAll();
    public User findById(int id); // id에 의해서 찾겠다 findOne으로 적으면 헷갈림
    public int updateById(int id, String password); // id로 찾아서 업데이트 하겠다.
    public int deleteById(int id); // id로 삭제를 하겠다.

    // public int insert(String username, String password, String email);

    // public User login(String username, String password);

    // public int delete(int id);

    // public int updatePassword(int id, String password); // 동사 먼저 쓰고 명사 쓰기 

}
