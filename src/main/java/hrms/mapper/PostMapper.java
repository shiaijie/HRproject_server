package hrms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import hrms.entity.Post;

import java.util.List;
import java.util.Map;

public interface PostMapper extends BaseMapper<Post> {

    /**
     * 根据岗位Id获取岗位信息
     * @param params 只存一个岗位id
     * @return 岗位详情 岗位id，岗位名称，备注，岗位所属部门
     */
    Post getPostById(Map<String, Long> params);

    /**
     * 获取所有岗位
     * @return 岗位列表
     */
    List<Post> getAll();


}
