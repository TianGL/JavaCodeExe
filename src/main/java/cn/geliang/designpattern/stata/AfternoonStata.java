package cn.geliang.designpattern.stata;

/**
 * @Classname AfternoonStata
 * @Description TODO 下午状态
 * @Date 2019-08-08
 * @Created by Geliang TIAN
 */
public class AfternoonStata extends WorkStata {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 18) {
            System.out.println("现在是下午" + work.getHour() + "点，继续工作");
        } else {
            work.setWorkStata(new AfterWorkStata());
            work.writeProgram();
        }
    }
}
