package cn.geliang.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @Classname CashNormal
 * @Description 正常计费类
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class CashNormal implements CashSuper {
    public BigDecimal realPrice(BigDecimal price, int amount) {
        return price.multiply(BigDecimal.valueOf(amount));
    }
}
