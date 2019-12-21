package hrms.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门信息管理表
 */

@Data
@Accessors(chain = true)
@TableName("depart")
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门全称
     */
    private String fullName;
    /**
     * 父部门
     */
    private Long parentDepart;
    /**
     * 是否为根部门
     */
    private String root;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否删除
     */
    private String deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getParentDepart() {
        return parentDepart;
    }

    public void setParentDepart(Long parentDepart) {
        this.parentDepart = parentDepart;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", parentDepart=" + parentDepart +
                ", root=" + root +
                ", remark=" + remark +
                ", deleteFlag=" + deleteFlag +
                "}";
    }
}
