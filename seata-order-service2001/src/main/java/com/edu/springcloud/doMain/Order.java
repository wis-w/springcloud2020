package com.edu.springcloud.doMain;

import java.math.BigDecimal;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/18 18:09
 */
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;// 订单状态 0：创建中 1：已完结

    public Order() {  }

    public Order(Long id, Long userId, Long productId, Integer count, BigDecimal money, Integer status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.count = count;
        this.money = money;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", count=" + count +
                ", money=" + money +
                ", status=" + status +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getCount() {
        return count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Integer getStatus() {
        return status;
    }
}
