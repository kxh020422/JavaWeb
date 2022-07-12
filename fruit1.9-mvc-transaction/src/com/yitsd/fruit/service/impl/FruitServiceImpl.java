package com.yitsd.fruit.service.impl;

import com.yitsd.fruit.dao.FruitDAO;
import com.yitsd.fruit.dao.impl.FruitDAOImpl;
import com.yitsd.fruit.pojo.Fruit;
import com.yitsd.fruit.service.FruitService;
import com.yitsd.myssm.basedao.ConnUtil;

import java.util.List;

/**
 * @ClassName FruitServiceImpl
 * @Date 2022/6/28 23:10
 */
public class FruitServiceImpl implements FruitService {


    private FruitDAO fruitDAO = null;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        System.out.println("getFruitList -> " + ConnUtil.getConn());
        return fruitDAO.getFruitList(keyword, pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
        Fruit fruit2 = fruitDAO.getFruitByFid(2);
        fruit2.setFcount(99);
        fruitDAO.updateFruit(fruit2);
    }

    @Override
    public Fruit getFruitByFid(Integer fid) {
        return fruitDAO.getFruitByFid(fid);
    }

    @Override
    public void delFruit(Integer fid) {
        fruitDAO.delFruit(fid);
    }

    @Override
    public Integer getPageCount(String keyword) {
        System.out.println("getPageCount -> " + ConnUtil.getConn());
        int count = fruitDAO.getFruitCount(keyword);
        int pageCount = (count + 5 - 1) / 5;
        return pageCount;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
