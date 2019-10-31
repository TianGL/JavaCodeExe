package cn.geliang.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @Classname CashReturn
 * @Description 满减优惠
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class CashReturn implements CashSuper {
    BigDecimal priceReach;
    BigDecimal priceReturn;

    public CashReturn(double priceReach, double priceReturn) {
        this.priceReach = BigDecimal.valueOf(priceReach);
        this.priceReturn = BigDecimal.valueOf(priceReturn);
    }


    public BigDecimal realPrice(BigDecimal price, int amount) {
        BigDecimal priceSrc = price.multiply(BigDecimal.valueOf(amount));
        return priceSrc.subtract(priceSrc.divide(priceReach).multiply(priceReturn));
    }
}
