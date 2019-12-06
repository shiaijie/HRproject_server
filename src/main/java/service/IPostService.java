package service;

import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface IPostService extends IService {
    /**
     * 获取所有岗位
     *
     * @return 全部岗位
     * @author saj
     */
    List<String> getAll();
}
