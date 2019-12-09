package hrms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import hrms.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2019-12-01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
