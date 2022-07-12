package com.yitsd.fruit.dao;

import com.yitsd.fruit.pojo.Fruit;

import java.util.List;

public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList();

    //根据fid获取特定的水果的信息
    Fruit getFruitByFid(Integer fid);

    //修改指定的库存信息
    void updateFruit(Fruit fruit);

    //根据fid删除指定记录
    void delFruit(Integer fid);

    //添加新库存记录
    void addFruit(Fruit fruit);

    //获取指定页码上的所有库存列表信息 每页显示五条
    List<Fruit> getFruitList(Integer pageNo);

    //查询库存总记录条数
    int getFruitCount();

}
