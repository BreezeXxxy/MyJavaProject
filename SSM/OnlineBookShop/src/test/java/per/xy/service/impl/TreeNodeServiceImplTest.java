package per.xy.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.xy.model.TreeNode;
import per.xy.service.ITreeNodeService;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class) //通过什么加载。
@ContextConfiguration(locations = {"classpath:spring.xml"})  //加载xml文件路径。
public class TreeNodeServiceImplTest {
    @Autowired
    private ITreeNodeService treeNodeService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void queryAllParentNode() {
//        List<TreeNode> parentNodesList = treeNodeService.queryAllParentNode();
//        for (TreeNode pNode : parentNodesList) {
//            System.out.println(pNode);
//        }

        List<TreeNode> menusList = treeNodeService.queryMenuWithReturn(null);
        System.out.println("==================回调方法查出来的所有菜单：");
        System.out.println(menusList);
        System.out.println("===================总菜单数："+menusList.size());
    }
}