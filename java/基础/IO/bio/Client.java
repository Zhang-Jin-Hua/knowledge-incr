package com.meituan.mqclienttest.io.bio;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 8080);
        Scanner scan = new Scanner(client.getInputStream());
        scan.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            String inputData = "请输入要发送的内容";
            out.println(inputData);
            if (scan.hasNext()) {
                String str = scan.next();
                System.out.println(str);
            }
            if ("byebye".equalsIgnoreCase(inputData)) {
                flag = false;
            }
        }
        client.close();
    }
}
