package cn.geliang.designpattern.strategy;

import java.math.BigDecimal;

/**
 * @Classname CalculateMoney
 * @Description 策略模式demo
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class CalculateMoney {
    public static void main(String[] args) {
        BigDecimal price = new BigDecimal("1000");
        Integer amount = 3;

        // 不同策略计算
        System.out.println(new CashContext(Strategy.NORMAL).getResult(price, amount));
        System.out.println(new CashContext(Strategy.REBATE).getResult(price, amount));
        System.out.println(new CashContext(Strategy.RETURN).getResult(price, amount));

    }
}
