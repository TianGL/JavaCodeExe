package cn.geliang.designpattern.factory.abstarct;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Classname FactoryUtil
 * @Description TODO
 * @Date 2019-08-01
 * @Created by Geliang TIAN
 */
public class FactoryUtil {
    public static AbstractFactory getFactory() throws Exception {
        String fileName = "factoryConfig.properties";
        Properties props = new Properties();
        props.load(new FileInputStream(fileName));
        String factoryIdStr = props.getProperty("factoryId");
        Class factroyClass = Class.forName(FactoryUtil.class.getPackage().getName() + ".Factory" + factoryIdStr);
        return (AbstractFactory) factroyClass.newInstance();
    }
}
