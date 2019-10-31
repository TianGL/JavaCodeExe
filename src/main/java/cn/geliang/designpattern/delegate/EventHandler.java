package cn.geliang.designpattern.delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname EventHandler
 * @Description TODO
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class EventHandler {
    List<Event> events;

    public EventHandler() {
        this.events = new ArrayList<Event>();
    }

    // 添加要执行的事件
    public void addEvent(Object obj,String methodName) {
        events.add(new Event(obj, methodName));
    }

    // 删除要执行的事件(需要保证equals方法可用)
    public void removeEvent(Object obj,String methodName) {
        Event delEvent = new Event(obj, methodName);
        events.remove(delEvent);
    }

    public void notifyObservers(Object...parameters) throws Exception {
        for (Event event : events) {
            event.invoke(parameters);
        }
    }

}
