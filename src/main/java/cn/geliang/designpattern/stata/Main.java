package cn.geliang.designpattern.stata;

/**
 * @Classname Main
 * @Description TODO 状态模式测试
 * @Date 2019-08-08
 * @Created by Geliang TIAN
 */
public class Main {

    public static void main(String[] args) {
        Work work = new Work();
        work.writeProgram();
        work.setHour(11.0);
        work.writeProgram();
        work.setHour(12.5);
        work.writeProgram();
        work.setHour(15.0);
        work.writeProgram();
        work.setHour(20.0);
        work.writeProgram();
    }
}
