package pojo;


import lombok.Data;

/**
 * 员工岗位信息相关VO
 */
@Data
public class DepartInfoVo {

    /**
     * 部门ID
     */
    private String departId;

    /**
     * 部门名称
     */
    private String departName;

    /**
     * 岗位ID
     */
    private String postId;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 职位ID
     */
    private String dutyId;

    /**
     * 职位名称
     */
    private String dutyName;
}
