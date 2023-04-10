package per.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.xy.mapper.UserMapper;
import per.xy.model.User;
import per.xy.service.IUserService;

import java.util.HashMap;
import java.util.Map;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, Object> login(User user) {
        Map<String,Object> map = new HashMap<>();
        User user1 = userMapper.login(user);
        int code = 200;
        String msg = "登入成功！";
//        进行业务判断
//        1、用户不存在
        if(null==user1){
            code = 204;
            msg = "该账号不存在";
        }else{
            if(!user1.getUserPwd().equals(user.getUserPwd())){
//            2、用户存在，但密码错误
                code = 203;
                msg = "密码错误";
            }else{
//            3、没问题，把成功登入对象放入
                map.put("user",user1);
            }
        }
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }

    @Override
    public Map<String, Object> register(User user) {
        Map<String,Object> userRegMap = new HashMap<>();
        int code = 200;
        String msg = "注册成功！";

//        注册失败情况-用户重名
        User u = userMapper.selectUserByUserName(user);
        if(null != u){
            code = 203;
            msg = "用户名不能重复";
        }else {
            userMapper.Register(user);
        }
        userRegMap.put("code",code);
        userRegMap.put("msg",msg);
        return userRegMap;
    }
}
