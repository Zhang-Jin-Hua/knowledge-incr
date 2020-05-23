package com.meituan.mqclienttest.io.bio;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(8080);
        boolean flag = true;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (flag) {
            Socket client = socket.accept();
            executorService.submit(new EchoClientHandler(client));
        }
        executorService.shutdown();
        socket.close();
    }

    private static class EchoClientHandler implements Runnable {

        private Socket client;
        private Scanner scanner;
        private PrintStream out;
        private boolean flag = true;

        public EchoClientHandler(Socket client) {
            this.client = client;
            try {
                this.scanner = new Scanner(this.client.getInputStream());
                this.scanner.useDelimiter("\n");
                this.out = new PrintStream(this.client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            while (this.flag) {
                if (this.scanner.hasNext()) {
                    String var = this.scanner.next().trim();
                    System.out.println("收到客户端发来的" + var);
                    if ("byebye".equals(var)) {
                        this.out.print("888888");
                        this.flag = false;
                    } else {
                        out.println("【echo】" + var);
                    }
                }
            }
            try {
                this.scanner.close();
                this.out.close();
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
