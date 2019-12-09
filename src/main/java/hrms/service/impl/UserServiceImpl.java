package hrms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import hrms.entity.User;
import hrms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hrms.service.IUserService;

import javax.annotation.Resource;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2019-12-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper mapper;

    public UserServiceImpl() {
    }

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
}
