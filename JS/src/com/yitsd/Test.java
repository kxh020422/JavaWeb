package com.yitsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * @ClassName Test
 * @Date 2022/6/29 20:20
 */
public class Test {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String USER = "root";
    public static final String PWD = "kouxiaohui0310";


    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER);

        Connection connection = DriverManager.getConnection(URL, USER, PWD);

        Map<Integer, Integer> scoreRankingMap = new HashMap<>();


        String sql1 = "select * from ncee";






        List<NCEE> lists = new ArrayList<>();

        ResultSet resultSet1 = connection.prepareStatement(sql1).executeQuery();
        while (resultSet1.next()) {
            lists.add(new NCEE(resultSet1.getString("school"), resultSet1.getString("profession"), Integer.valueOf(resultSet1.getString("scale"))));
        }


        for (NCEE list : lists) {
            String sql2 = "UPDATE ncee_copy1 SET ncee_copy1.school = ? WHERE ncee_copy1.schoolcode = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            String school = list.getSchool();
            list.setCode(school.substring(0, 4));
            preparedStatement.setString(1,list.getSchool().substring(4));
            preparedStatement.setString(2,list.getCode());
            preparedStatement.executeUpdate();
        }


        String school = lists.get(1).getSchool();
        String substring = school.substring(4);
        System.out.println("substring = " + substring);




        /*for (int i = 200; i < 250; i++) {
            System.out.println(lists.get(i));

        }
*/

    }
}
