package per.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.xy.mapper.TreeNodeMapper;
import per.xy.model.TreeNode;
import per.xy.service.ITreeNodeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreeNodeServiceImpl implements ITreeNodeService {
    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public Map<String, Object> queryAllParentNode() {
        Map<String,Object> menuMap = new HashMap<>();
        int code = 200;
        String msg = "操作成功(菜单)！";
        List<TreeNode> parentNodesList = treeNodeMapper.queryAllParentNode();
        System.out.println(parentNodesList.size());
        if(parentNodesList.size()>0){
            for (TreeNode parentNode : parentNodesList) {
//                根据1级父节点的节点id查出子节点
                List<TreeNode> treeNodesList = treeNodeMapper.queryAllChildNodeByParentNodeId(parentNode);
                parentNode.setTreeNodesList(treeNodesList);
            }
        }
        menuMap.put("obj",parentNodesList);
        menuMap.put("code",code);
        menuMap.put("msg",msg);
        return menuMap;
    }

//    回调方法
    @Override
    public List<TreeNode> queryMenuWithReturn(TreeNode treeNode) {
        List<TreeNode> tree = treeNodeMapper.queryMenuWithReturn(treeNode);
//        查出了子节点，回调终止的关键。
        if (tree.size()>0 && null != tree){
            for (TreeNode node : tree) {
//                查出子节点后，回调方法放入子节点看是否还有子节点,接受查到的子节点。
                List<TreeNode> menu = queryMenuWithReturn(node);
//                将查到的子节点放入当前的父节点的list属性里
                node.setTreeNodesList(menu);
            }
        }
        return tree;
    }


//    programEnding...
}
