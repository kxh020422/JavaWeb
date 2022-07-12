package com.yitsd.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @ClassName Cart
 * @Date 2022/7/6 22:39
 */
public class Cart {

    private Map<Integer, CartItem> cartItemMap;//这个map集合中的key是book的id

    private Double totalMoney;

    private Integer totalCount;//购物项的数量

    private Integer totalBookCount;//购物车中书本的总数量

    public Cart() {

    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> entry : entries) {
                CartItem cartItem = entry.getValue();
                BigDecimal price = new BigDecimal(cartItem.getBook().getPrice()+"");
                BigDecimal buyCount = new BigDecimal(cartItem.getBuyCount()+"");
                totalMoney += price.multiply(buyCount).doubleValue();
            }
        }
        return totalMoney;
    }


    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem cartItem : cartItemMap.values()) {
                totalBookCount += cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }
}
