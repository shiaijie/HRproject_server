package hrms.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import pojo.TreeDataVo;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class NzTreeNode {
    private String title;
    private String key;
    private boolean checked;
    private boolean isLeaf;

    private List<NzTreeNode> children = new ArrayList<>();

    public boolean isIsLeaf() {
        return isLeaf;
    }

    public boolean getChecked(){
        return this.checked;
    }

    public void setChecked(boolean checked){
        this.checked = checked;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getKey(){
        return this.key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public NzTreeNode setIsLeaf(boolean leaf) {
        isLeaf = leaf;
        return this;
    }

    public void fillInChildren(List<TreeDataVo> dataSource) {

        if(dataSource != null && !this.isLeaf && dataSource.size()>0) {
            NzTreeNode node;
            for(TreeDataVo item : dataSource) {
                if(!item.isTopNode() && item.getParentId().equals(key)) {
                    node = new NzTreeNode();
                    node.setKey(item.getId());
                    node.setTitle(item.getTitle());
                    node.setIsLeaf(item.isLeaf());
                    this.children.add(node);
                }
            }
        }

        for(NzTreeNode node : this.children) {
            node.fillInChildren(dataSource);
        }
    }

    public static List<NzTreeNode> buildTree(List<TreeDataVo> dataSource) {
        List<NzTreeNode> topNodes = new ArrayList<>();

        if(dataSource != null&& dataSource.size()>0) {
            for(TreeDataVo item : dataSource){
                if(item.isTopNode()){
                    NzTreeNode node = new NzTreeNode();
                    node.setKey(item.getId());
                    node.setTitle(item.getTitle());
                    node.setIsLeaf(item.isLeaf());
                    node.fillInChildren(dataSource);
                    topNodes.add(node);
                }
            }
        }
        return topNodes;
    }

}
