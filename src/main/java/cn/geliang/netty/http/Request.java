package cn.geliang.netty.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname Request
 * @Description TODO
 * @Date 2019-08-12
 * @Created by Geliang TIAN
 */
public class Request {
    InputStream in = null;

    //获得输入流。这是客户的请求数据。
    public Request(InputStream input) {
        this.in = input;
    }

    //解析客户的请求
    public String parse() {
        //从 Socket 读取一组数据
        StringBuffer requestStr = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            requestStr.append((char) buffer[j]);
        }
        System.out.print(requestStr.toString());
        return getUri(requestStr.toString());
    }

    //获取 URI 信息字符
    private String getUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }
}
