package per.xy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.xy.model.TreeNode;
import per.xy.service.ITreeNodeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {
    @Autowired
    private ITreeNodeService treeNodeService;

    @RequestMapping("/createMenu")
    public Map<String,Object> createMenu(){
        Map<String,Object> menuMap = new HashMap<>();
        String msg = "查询菜单操作成功！";
        int code = 200;
//        List<TreeNode> menuList = treeNodeService.queryMenuWithReturn(null);
        Map<String, Object> menuList = treeNodeService.queryAllParentNode();

        if(menuList.size()>0){
            menuMap.put("obj",menuList);
        }else {
            code = 203;
            msg = "查询菜单操作失败！";
        }
        menuMap.put("code",code);
        menuMap.put("msg",msg);
        return menuMap;
    }
}
