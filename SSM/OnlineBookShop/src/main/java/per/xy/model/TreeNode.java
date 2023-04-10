package per.xy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class TreeNode {
    private Integer treeNodeId;

    private String treeNodeName;

    private Integer treeNodeType;

    private Integer parentNodeId;

    private String url;

    private Integer position;

    private String icon;

    public TreeNode(Integer treeNodeId, String treeNodeName, Integer treeNodeType, Integer parentNodeId, String url, Integer position, String icon) {
        this.treeNodeId = treeNodeId;
        this.treeNodeName = treeNodeName;
        this.treeNodeType = treeNodeType;
        this.parentNodeId = parentNodeId;
        this.url = url;
        this.position = position;
        this.icon = icon;
    }

        private List<TreeNode> treeNodesList = new ArrayList<>();

}