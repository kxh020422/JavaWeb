//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.yitsd.myssm.basedao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

public class ConnUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal();
    static Properties properties = new Properties();

    public ConnUtil() {
    }

    private static Connection createConn() {
        try {
            DataSource druidDataSource = DruidDataSourceFactory.createDataSource(properties);
            return druidDataSource.getConnection();
        } catch (Exception var1) {
            var1.printStackTrace();
            return null;
        }
    }

    public static Connection getConn() {
        Connection conn = (Connection)threadLocal.get();
        if (conn == null) {
            conn = createConn();
            threadLocal.set(conn);
        }

        return (Connection)threadLocal.get();
    }

    public static void closeConn() throws SQLException {
        Connection conn = (Connection)threadLocal.get();
        if (conn != null && !conn.isClosed()) {
            conn.close();
            threadLocal.set(null);
        }

    }

    static {
        InputStream is = ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try {
            properties.load(is);
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }
}
