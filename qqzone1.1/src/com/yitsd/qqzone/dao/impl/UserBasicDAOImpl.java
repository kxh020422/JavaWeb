package com.yitsd.qqzone.dao.impl;

import com.yitsd.myssm.basedao.BaseDAO;
import com.yitsd.qqzone.dao.UserBasicDAO;
import com.yitsd.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName UserBasicDAOImpl
 * @Date 2022/7/2 20:38
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("Select * from t_user_basic where loginId = ? and pwd = ?", loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
//        String sql = "SELECT * FROM t_user_basic where id in(SELECT fid from t_friend,t_user_basic WHERE t_friend.uid = t_user_basic.id AND t_user_basic.id = ?);";
        String sql = "SELECT fid AS id from t_friend where uid = ?";
        return super.executeQuery(sql, userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return super.load("select * from t_user_basic where id = ?", id);
    }
}
