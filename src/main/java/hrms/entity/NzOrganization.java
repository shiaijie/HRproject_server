package hrms.entity;

import lombok.Data;

import java.util.List;

@Data
public class NzOrganization implements Comparable<NzOrganization> {

    private Long key;

    private Long parentDepartId;

    private String name;

    private Integer root;

    private String title;

    private String leader;

    private String assist;
    /**
     * 编制-直属
     */
    private Integer formationFullPeopleNumber;
    /**
     * 编制-总共
     */
    private Integer formationTotal;

    /**
     * 在职-直属
     */
    private Integer incumbencyFullPeopleNumber;
    /**
     * 在职-总共
     */
    private Integer incumbencyTotal;

    private String leaderName;

    private String parentDepart;

    private Integer orderNum;

    private Integer orderNumForStaffLib;

    private Long version;

    private List<NzOrganization> children;

    private boolean isLeaf;

    /**
     * 是否跨级显示
     */
    private Integer skipNode;

    /**
     * 用于岗位树状图判断是否部门
     */
    private boolean dept = true;

    /**
     * 层次结构
     */
    private Integer hierarchy;
    /**
     * 层次结构名称
     */
    private String hierarchyName;

    private List<User> memberList;

    public boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 按照是否是半层部门排序
     */
    @Override
    public int compareTo(NzOrganization o) {
        return (Integer.parseInt(o.assist) - Integer.parseInt(assist));
    }
}
