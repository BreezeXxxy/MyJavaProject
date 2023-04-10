package per.xy.service;

import per.xy.model.TreeNode;

import java.util.List;
import java.util.Map;

public interface ITreeNodeService {
//    查询所有一级父节点
    Map<String,Object> queryAllParentNode();

//    递归调用查询所有的根节点及其下的所有节点
    List<TreeNode> queryMenuWithReturn(TreeNode treeNode);
}
