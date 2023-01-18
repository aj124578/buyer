package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserRepository { // 기능을 모를때 CRUD
    public User findById(int id); // id에 의해서 찾겠다 findOne으로 적으면 헷갈림
    public List<User> findAll();
    public int insert(@Param("username") String username, @Param("password") String password, @Param("email") String email);
    public int updateById(@Param("id") int id, @Param("password") String password); // id로 찾아서 업데이트 하겠다.
    public int deleteById(int id); // id로 삭제를 하겠다.
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    // public int insert(String username, String password, String email);

    // public User login(String username, String password);

    // public int delete(int id);

    // public int updatePassword(int id, String password); // 동사 먼저 쓰고 명사 쓰기 

}
