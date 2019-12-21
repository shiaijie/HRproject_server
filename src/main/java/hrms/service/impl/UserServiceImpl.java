package hrms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import hrms.entity.SystemConstants;
import hrms.entity.User;
import hrms.mapper.UserMapper;
import hrms.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrms.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @since 2019-12-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper mapper;

    @Override
    public User login(String jobCode, String password) throws Exception {
        /*String passwordDes = PasswordDecrypt.desEncrypt(password);
        if (passwordDes == null) {
            throw new SysRuntimeException(message.getMessage("W004", this.message.getMessage("L002")));
        }*/
        // 加密
        // String md5Pw = DigestUtils.md5DigestAsHex(passwordDes.getBytes("utf-8"));

        User userEntity;
        User user = new User();
        // 检索工号
        userEntity = user.selectOne(new EntityWrapper<User>().eq("jobCode", jobCode).eq("password", password));
        // 没有符合条件的账号信息（账号密码错误）
        if (userEntity == null) {
            return null;
        }
        return userEntity;


        /*// 工号不存在时按邮箱检索
        if (userEntity == null) {
            // 考虑有邮箱相同账号被禁用情况
            List<SysUser> userList = user.selectList(
                    new EntityWrapper<SysUser>()
                            .eq("mail", jobNum.toLowerCase())
                            .eq("password", md5Pw)
            );
*/
            // 没有符合条件的账号信息（账号密码错误）
            /*if (userEntity == null) {
                throw new SysRuntimeException(message.getMessage("W017"));
                return null;
            }

            // 有账号的情况下过滤已禁用账号
            List<SysUser> validUserList = userList.stream().filter(su -> su.getDeleteFlag() == 0).collect(Collectors.toList());*/

            /*// 账号已被禁用时
            if (CollectionUtils.isEmpty(validUserList)) {
                throw new SysRuntimeException(message.getMessage("W003"));
            }*/

            /*userEntity = validUserList.get(0);*/


        // return setLoginInfo(userEntity);

    }

/*    private User setLoginInfo(User userEntity) {
        // 校验账号是否有效
        validateExpiration(userEntity);

        LoginInfo info = new LoginInfo();
        info.setUid(userEntity.getId());
        info.setToken(tokenManager.genToken(userEntity));
        info.setName(userEntity.getName());
        info.setMail(userEntity.getMail());
        info.setJobCode(userEntity.getJobCode());

        // 如果有对应职员信息的话设置StaffId
        StaffBasic staffBasic = new StaffBasic();
        staffBasic = staffBasic.selectOne(new EntityWrapper<StaffBasic>().eq("jobCode", userEntity.getJobCode()));
        if (staffBasic != null) {
            info.setStaffId(staffBasic.getId());
        }

        // 请求中不带L-Authorization的话，重新生成
        HttpServletRequest request = HttpUtil.getRequest();
        String longToken = request.getHeader(LONG_TOKEN_NAME);

        longToken = tokenManager.saveLongToken(longToken, userEntity);
        info.setRefreshToken(longToken);

        // 获取角色列表
        Set<AuthorityVo> authorityInfosList = new LinkedHashSet<>();
        Set<String> roleIdList = new HashSet<>();
        List<Integer> permissonValueList = new ArrayList<>();
        if (userEntity.getId() != null) {
            Map<String, Long> paramsRole = new HashMap<>(2);
            paramsRole.put("userId", userEntity.getId());
            List<RoleInfo> roleResult = roleMapper.selectRole(paramsRole);
            for (RoleInfo role : roleResult) {
                roleIdList.add(String.valueOf(role.getRoleId()));
                permissonValueList.add(role.getPermissionsValue());
                List<AuthorityVo> authorityInfos = this.roleFunctionMapper.queryAuthorityByRoleId(role.getRoleId());
                authorityInfosList.addAll(authorityInfos);
            }
        }
        info.setRoleList(roleIdList);
        // 设置权限最大值
        if (!CollectionUtils.isEmpty(permissonValueList)) {
            info.setPermissionsValue(Collections.max(permissonValueList));
        }

        String firstUrl = null;
        if (authorityInfosList.size() > 0) {
            for (AuthorityVo au : authorityInfosList) {
                if (au.getMenuFlag() != null && au.getMenuFlag().equals(ResourceTypeEnum.MENU.getValue())) {
                    if (StringUtils.isNotBlank(au.getLink())) {
                        firstUrl = au.getLink();
                        break;
                    }
                }
            }
        }
        if (firstUrl == null) {
            throw new SysRuntimeException(message.getMessage("W005"));
        }

        // 设置最后登录时间、IP
        userEntity.setLastLogin(new Date());
        userEntity.setLoginIp(AccessDataUtil.getIpAddress(request));
        this.updateAllColumnById(userEntity);

        // 写入登录日志
        BusinessLog log = new BusinessLog();
        log.setModule(this.message.getMessage("L200"));
        log.setOp(AutoLog.Op.LOGIN.getValue());
        log.setType(AutoLog.Type.LOGIN_OUT.getValue());
        log.setIp(AccessDataUtil.getIpAddress(request));
        log.setUrl(request.getRequestURI());
        log.setUid(userEntity.getId());
        log.setGmtCreate(new Date());
        logService.addLog(log);

        info.setFirstUrl(firstUrl);
        return info;
    }*/


    @Override
    public boolean register(Map<String, Object> params) {
        String jobCode = params.get("jobCode").toString();
        String phone = params.get("phone").toString();
        String password = params.get("password").toString();
        String name = params.get("name").toString();
        // 若工号和手机号不重复，注册成功
        if (checkJobCode(jobCode) && checkPhone(phone)) {
            User user = new User();
            user.setName(name);
            user.setJobCode(jobCode);
            user.setPassword(password);
            user.insert();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkJobCode(String jobCode) {
        List<User> userList = new User().selectList(new EntityWrapper<>().eq("jobCode", jobCode));
        if (CollectionUtils.isEmpty(userList)) {
            return false;
        }
        if (jobCode == null) {
            return true;
        }
        return !userList.get(0).getPhone().equals(jobCode);
    }

    @Override
    public boolean checkPhone(String phone) {
        List<User> userList = new User().selectList(new EntityWrapper<>().eq("phone", phone));
        if (CollectionUtils.isEmpty(userList)) {
            return false;
        }
        if (phone == null) {
            return true;
        }
        return !userList.get(0).getPhone().equals(phone);
    }

    @Override
    public boolean checkIDnumber(String IDnumber) {
        List<User> userList = new User().selectList(new EntityWrapper<>().eq("IDnumber", IDnumber));
        if (CollectionUtils.isEmpty(userList)) {
            return false;
        }
        if (IDnumber == null) {
            return true;
        }
        return !userList.get(0).getIDnumber().equals(IDnumber);
    }

    @Override
    public void addUser(Map<String, Object> params) {
        User user = new User();
        user.setName(params.get("name").toString());
        user.setJobCode(params.get("jobCode").toString());
        user.setPhone(params.get("phone").toString());
        // 初始密码设为111111
        user.setPassword("111111");
        user.setSex(Integer.parseInt(params.get("sex").toString()));
        user.setAge(Integer.parseInt(params.get("age").toString()));
        user.setIDnumber(params.get("IDnumber").toString());
        //
        user.setDepartId(Integer.parseInt(params.get("departId").toString()));
        user.setPostId(Integer.parseInt(params.get("postId").toString()));
        //
        user.setPolitical(params.get("political").toString());
        user.setNation(params.get("nation").toString());
        user.setMarriageStatus(params.get("marriageStatus").toString());
        user.setAddress(params.get("address").toString());
        user.setInductionDay(new Date());
        user.setIsLeave(0);
        user.setLeavingDay(null);
        user.setIsAdmin(Integer.parseInt(params.get("isAdmin").toString()));
        user.setDeleteFlag(0);
        user.updateAllColumnById();
        /*if (params.get("IDnumber") != null && StringUtils.isNotBlank(params.get("deptId").toString())){
            user.setIDnumber(params.get("IDnumber").toString());
        }*/
        user.insert();
    }

    @Override
    public User updateUserInfo(User userInfo) {
        // 更新用户信息
        //前端先验证手机号是否重复
        // 根据手机号查找userInfo（selectList
        // 赋值进去
        // updateAllColumnById();
        List<User> userList = this.mapper.selectList(new EntityWrapper<User>()
                .eq("name", userInfo.getName()).eq("deleteFlag", 0));
        if (userList.size() == 1){
            User user = new User();
            user = userList.get(0);
            user.setName(userInfo.getName());
            user.setPassword(userInfo.getPassword());
            user.setJobCode(userInfo.getJobCode());
            user.setAge(userInfo.getAge());
            user.setSex(userInfo.getSex());
            user.setDepartId(userInfo.getDepartId());
            user.setPostId(userInfo.getPostId());
            user.setPolitical(userInfo.getPolitical());
            user.setNation(userInfo.getNation());
            user.setMarriageStatus(userInfo.getMarriageStatus());
            user.setIDnumber(userInfo.getIDnumber());
            user.setAddress(userInfo.getAddress());
            user.setPhone(userInfo.getPhone());
            user.setInductionDay(userInfo.getInductionDay());
            user.setIsLeave(userInfo.getIsLeave());
            user.setLeavingDay(userInfo.getLeavingDay());
            user.setIsAdmin(userInfo.getIsAdmin());
            user.setDeleteFlag(userInfo.getDeleteFlag());
            user.updateAllColumnById();
        }else {
            throw new RuntimeException();
        }
        return new User().selectById(userInfo.getId());
    }

    @Override
    public List<User> getAllUserInfo() {
        // 要写sql语句，因为有departId啥的，要左连接三个表 depart、post、duty。
        Wrapper<User> wrapper = new EntityWrapper<>(new User(), "id, name, jobCode, age, sex, departId")
                .eq("deleteFlag", "0").orderBy(true, "id", false);
        return this.mapper.selectList(wrapper);
        // this.mapper.getAllUserInfoPage();
    }

    @Override
    public Page<User> getAllUserInfoPage(Map<String, String> params) {
        // 排序
        SortUtil.genOrderBy(params);
        //分页
        Page<User> page = new Page<>();
        page.setCurrent(Integer.parseInt(params.get(SystemConstants.CURRENT)));
        page.setSize(Integer.parseInt(params.get(SystemConstants.PAGE_SIZE)));
        page.setRecords(this.mapper.getAllUserInfoPage(page, params));
        return page;
    }
}
