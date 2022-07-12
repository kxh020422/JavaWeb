package com.yitsd.fruit.service.impl;

import com.yitsd.fruit.dao.FruitDAO;
import com.yitsd.fruit.dao.impl.FruitDAOImpl;
import com.yitsd.fruit.pojo.Fruit;
import com.yitsd.fruit.service.FruitService;

import java.util.List;

/**
 * @ClassName FruitServiceImpl
 * @Date 2022/6/28 23:10
 */
public class FruitServiceImpl implements FruitService {


    private  FruitDAO fruitDAO = null;

    @Override
    public List<Fruit> getFruitList(String keyword, Integer pageNo) {
        return fruitDAO.getFruitList(keyword,pageNo);
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
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
        //总记录条数
        int fruitCount = fruitDAO.getFruitCount(keyword);
        //总页数
        return (fruitCount + 5 - 1) / 5;
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruit(fruit);
    }
}
