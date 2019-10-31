package cn.geliang.designpattern.factory.method;

/**
 * @Classname VolunteerFactory
 * @Description TODO
 * @Date 2019-07-31
 * @Created by Geliang TIAN
 */
public class VolunteerFactory implements IFactory {
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}
