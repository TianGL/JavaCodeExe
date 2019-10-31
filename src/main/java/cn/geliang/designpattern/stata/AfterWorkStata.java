package cn.geliang.designpattern.stata;

/**
 * @Classname AfterWorkStata
 * @Description TODO 下班状态
 * @Date 2019-08-08
 * @Created by Geliang TIAN
 */
public class AfterWorkStata extends WorkStata {
    @Override
    public void writeProgram(Work work) {
        System.out.println("现在是晚上" + work.getHour() + "点，下班回家");
    }
}
