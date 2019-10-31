package cn.geliang.designpattern.stata;

/**
 * @Classname ForenoonStata
 * @Description TODO 上午状态
 * @Date 2019-08-08
 * @Created by Geliang TIAN
 */
public class ForenoonStata extends WorkStata {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 9) {
            System.out.println("现在是上午" + work.getHour() + "点，十分精神");
        } else {
            work.setWorkStata(new NoonStata());
            work.writeProgram();
        }
    }
}
