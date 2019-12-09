package hrms.com.shiaj.hr;

import hrms.entity.User;

public interface  TokenManager {
    /**
     * 生成token
     * @param user 实体
     * @return token值
     */
    String createToken(User user);

    /**
     * 根据token获取
     * @param token token
     * @return 根据token获取的实体
     */
    User findByToken(String token);

    /**
     * 更新token的过期
     * @param token token
     */
    void updateExpires(String token);

    /**
     * 删除
     * @param token token
     * @return 删除是否成功
     */
    boolean deleteToken(String token);

    /**
     * 产生token
     * @param user 实体
     * @return token
     */
    String getToken(User user);


    /**
     * 踢人
     * @param user 实体
     * @param newToken 新token
     * @param doMore 还要做的事情
     */
    default void kickingOld(User user, String newToken, Runnable doMore){
        kickingOld(user , newToken);

        if(null != doMore){
            doMore.run();
        }
    }

    /**
     * 踢人
     * @param user 实体
     * @param newToken token
     */
    void kickingOld(User user, String newToken);

}