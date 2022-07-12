package com.yitsd.fruit.dao.impl;

import com.yitsd.fruit.dao.FruitDAO;
import com.yitsd.fruit.pojo.Fruit;
import com.yitsd.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassName FruitDAOImpl
 * @Date 2022/6/25 16:53
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("SELECT * FROM t_fruit");
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return super.load("SELECT * FROM t_fruit WHERE fid = ?", fid);

    }

    @Override
    public void updateFruit(Fruit fruit) {
        String sql = "update t_fruit set fname = ? , price = ? , fcount = ? , remark = ? where fid = ?";
        super.executeUpdate(sql, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
    }

    @Override
    public void delFruit(Integer fid) {
        String sql = "DELETE FROM t_fruit where fid = ?";
        super.executeUpdate(sql, fid);
    }

    @Override
    public void addFruit(Fruit fruit) {
        String SQL = "INSERT INTO t_fruit VALUES(0,?,?,?,?)";
        super.executeUpdate(SQL, fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
    }


}
