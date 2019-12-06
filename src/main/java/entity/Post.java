
package entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 岗位信息管理表
 * </p>
 *
 * @author Mason
 * @since 2018-04-27
 */

@Data
// @EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("post")
public class Post {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    // 岗位名称
    private String name;
/**
     * 部门ID
     */
    private Long departId;
/**
     * 父岗位ID
     */
    private Long postId;
    // 备注
    private String remark;
    // 删除标志
    @TableLogic
    private Integer deleteFlag;

    // @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
