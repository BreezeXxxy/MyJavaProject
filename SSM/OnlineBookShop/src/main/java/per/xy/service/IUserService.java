package per.xy.service;

import per.xy.model.User;

import java.util.Map;

public interface IUserService {
//    用户登入
    public Map<String,Object> login(User user);
//    用户注册
    public Map<String,Object> register(User user);
}
