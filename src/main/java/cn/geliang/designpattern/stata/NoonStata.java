package cn.geliang.designpattern.stata;

/**
 * @Classname NoonStata
 * @Description TODO 中午状态
 * @Date 2019-08-08
 * @Created by Geliang TIAN
 */
public class NoonStata extends WorkStata {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.println("现在是中午" + work.getHour() + "点，该吃饭了");
        } else {
            work.setWorkStata(new AfternoonStata());
            work.writeProgram();
        }
    }
}
