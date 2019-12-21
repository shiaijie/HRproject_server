package pojo;
import lombok.Data;

@Data
// @ApiModel(value = "移动岗位")
public class MovePostAo {
    // @ApiModelProperty(name = "postId", example = "1", value = "待移动岗位ID")
    private Long postId;
    // @ApiModelProperty(name = "targetDeptId", example = "1", value = "目标部门ID")
    private Long targetDeptId;
    // @ApiModelProperty(name = "targetPostId", example = "1", value = "目标岗位ID")
    private Long targetPostId;
}
