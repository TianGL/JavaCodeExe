package cn.geliang.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @Classname CashSuper
 * @Description 计算实际花费接口
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public interface CashSuper {
    BigDecimal realPrice(BigDecimal price, int amount);
}
