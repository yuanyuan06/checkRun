package com.test;

import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Administrator on 2016/1/25.
 */
public class Test1 {

    @Test
    public void testq() throws IOException {
//        service4=172.23.124.1:20881
//        SocketAddress addr = new InetSocketAddress("10.8.4.27", 2181);
        Socket socket= new Socket("10.8.4.27", 20881);
//        Socket socket= new Socket("10.8.4.74", 20881);
//        socket.connect(addr);
//        Socket socket= new Socket("172.23.124.1", 20881);
        socket.isConnected();
        System.out.println(socket.isConnected());
        socket.close();
    }

    @Test
    public void teste(){
        String df = "df=1";
        String re = df.replace("=", "");
        System.out.println(re.length());


    }
}
