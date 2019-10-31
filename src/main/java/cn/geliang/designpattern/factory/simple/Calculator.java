package cn.geliang.designpattern.factory.simple;

import java.util.Scanner;

/**
 * @Classname Calculator
 * @Description 计算加减发
 * @Date 2019-07-23
 * @Created by Geliang TIAN
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("num1 = ");
        int num1 = scanner.nextInt();
        System.out.println("num2 = ");
        int num2 = scanner.nextInt();
        System.out.println("operation(+/-) = ");
        char opt = scanner.next().charAt(0);

        Operation operation = OperationFactory.getOperation(opt);
        operation.setNum1(num1);
        operation.setNum2(num2);
        System.out.println("result = " + operation.operate());
    }
}
