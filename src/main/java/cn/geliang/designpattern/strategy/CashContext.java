package cn.geliang.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @Classname CashContext
 * @Description 真实价格
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class CashContext {
    private CashSuper cashSuper;

    public CashContext(Strategy strategy) {
        if (strategy.code == Strategy.NORMAL.code) {
            cashSuper = new CashNormal();
        } else if (strategy.code == Strategy.RETURN.code) {
            cashSuper = new CashReturn(300.0, 100.0);
        } else if (strategy.code == Strategy.REBATE.code) {
            cashSuper = new CashRebate(0.8);
        }
    }
    public BigDecimal getResult(BigDecimal price, int amount) {
        return cashSuper.realPrice(price, amount);
    }

}
