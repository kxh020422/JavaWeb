package com.yitsd.myssm.trans;

import com.yitsd.myssm.basedao.ConnUtil;

import java.sql.Connection;

/**
 * @ClassName TransactionManager
 * @Date 2022/6/29 23:15
 */
public class TransactionManager {

    //开启事务
    public static void beginTrans() throws Exception {
        ConnUtil.getConn().setAutoCommit(false);
    }

    //提交事务
    public static void commit() throws Exception {
        Connection conn = ConnUtil.getConn();
        conn.commit();
        conn.close();
        ConnUtil.closeConn();
    }

    //回滚事务
    public static void rollback() throws Exception {
        Connection conn = ConnUtil.getConn();
        conn.rollback();
        conn.close();
        ConnUtil.closeConn();
    }
}
