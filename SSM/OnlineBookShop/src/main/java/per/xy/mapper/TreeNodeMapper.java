package per.xy.mapper;

import org.springframework.stereotype.Repository;
import per.xy.model.TreeNode;

import java.util.List;
@Repository
public interface TreeNodeMapper {
    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

//    查询一级菜单及其之下的二级菜单
    List<TreeNode> queryAllParentNode();

//    根据父节点id查到子节点
    List<TreeNode> queryAllChildNodeByParentNodeId(TreeNode parentNode);

//    查导航菜单_回调方式
    List<TreeNode> queryMenuWithReturn(TreeNode treeNode);
}