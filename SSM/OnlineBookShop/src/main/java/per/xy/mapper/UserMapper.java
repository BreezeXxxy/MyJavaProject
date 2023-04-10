package per.xy.mapper;

import org.springframework.stereotype.Repository;
import per.xy.model.User;

import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

//    通过姓名查找用户
    User selectUserByUserName(User user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//    登入
    User login(User user);
//    注册
    int Register(User user);
}