package pojo;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class TreeDataVo {

    private String id;
    private String title;
    private String parentId;
    private long hasChildren;

    public boolean isLeaf() {
        if (this.hasChildren <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId(){
        return this.parentId;
    }

    public long getHasChildren() {
        return this.hasChildren;
    }

    public void setHasChildren(long hasChildren) {
        this.hasChildren = hasChildren;
    }

    public boolean isTopNode() {
        if (this.parentId == null
                || StringUtils.isEmpty(this.parentId)
                || "0".equals(this.parentId)) {
            return true;
        } else {
            return false;
        }
    }

}

