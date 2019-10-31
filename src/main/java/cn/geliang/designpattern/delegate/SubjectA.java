package cn.geliang.designpattern.delegate;


/**
 * @Classname SubjectA
 * @Description TODO 具体通知主题
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class SubjectA extends Subject {
    private String state;
    private EventHandler eventHandlers;

    public SubjectA(String state) {
        this.state = state;
        eventHandlers = new EventHandler();
    }

    public String getState() {
        return state;
    }

    @Override
    public void notice(Object... parameters) throws Exception {
        eventHandlers.notifyObservers(parameters);
    }

    @Override
    public void attach(Object observer, String methodName) {
        eventHandlers.addEvent(observer, methodName);
        ((Observer) observer).setSubject(this);
    }

    @Override
    public void remove(Object observer, String methodName) {
        eventHandlers.removeEvent(observer, methodName);
    }


}
