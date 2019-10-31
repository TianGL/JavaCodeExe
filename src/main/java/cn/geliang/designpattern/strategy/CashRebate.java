package cn.geliang.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @Classname CashRebate
 * @Description 以打折率计算
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class CashRebate implements CashSuper {
    private BigDecimal rate;
    public CashRebate(double rate) {
        this.rate = BigDecimal.valueOf(rate);
    }


    public BigDecimal realPrice(BigDecimal price, int amount) {
        BigDecimal priceSrc = price.multiply(BigDecimal.valueOf(amount));
        return priceSrc.multiply(rate);
    }
}
