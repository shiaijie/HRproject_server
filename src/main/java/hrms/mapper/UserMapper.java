package hrms.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import hrms.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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
    List<User> getAllUserInfoPage(Pagination page, Map<String, String> params);

    //List<User> getAllUserInfoPage();

    //List<User> getProductByNameOrCode(Pagination page, Map<String, String> params);

    //List<User> getProductByFigureCode(Pagination page, Map<String, String> params);
}
