package com.jumbo;

import org.springframework.util.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/1/25.
 */
public class checkRunServlet extends HttpServlet {

    private final static String WEB = "web";
    private final static String SERVICE = "service";
    private final static String DEMO = "deamon";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryStr = request.getQueryString();
        String[] split = queryStr.split("=");
        String host = split[0];
        if(!(WEB.equals(host) || SERVICE.equals(host) || DEMO.equals(host))){
            throw new IllegalArgumentException();
        }
        ResourceBundle hostConf = ResourceBundle.getBundle("hostConf");
        String hostKey = queryStr.replace("=", "");
        String host0 = hostConf.getString(hostKey);
        String[] hostArr = host0.split(":");
        String adrrIp = hostArr[0];
        String port = hostArr[1];
        Integer addrPort = NumberUtils.parseNumber(port, Integer.class);

        PrintWriter writer = response.getWriter();
        Socket socket = null;
        try{
            socket = new Socket(adrrIp, addrPort);
            if(socket.isConnected()){
                writer.write(host +" "+ host0 + "  run success");
            }else{
                writer.write(host + " run fail");
//                throw new HTTPException(404);
            }
            socket.close();
        }catch (Exception e){
            writer.write(host + " run fail");
//            throw new HTTPException(404);
        }
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
