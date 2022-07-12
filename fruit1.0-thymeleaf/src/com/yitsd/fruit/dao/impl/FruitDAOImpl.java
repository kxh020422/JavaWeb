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
}
