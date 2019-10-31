package cn.geliang.designpattern.stata;

/**
 * @Classname Work
 * @Description TODO 工作类
 * @Date 2019-08-08
 * @Created by Geliang TIAN
 */
public class Work {
    private WorkStata workStata;
    private double hour;

    public Work() {
        workStata = new ForenoonStata();
    }

    public void setWorkStata(WorkStata workStata) {
        this.workStata = workStata;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public double getHour() {
        return hour;
    }

    public void writeProgram(){
        workStata.writeProgram(this);
    }
}
