package level2.homeWork6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private final int PORT = 11223;
    ServerSocket server = null;
    Socket socket = null;

    public Server() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner inConsole = new Scanner(System.in);

            Thread threadClientListening = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.nextLine();

                            if (str.equals("/end")) {
                                System.out.println("Клиент отключился");
                                break;
                            }

                            System.out.println("Клиент: " + str);
                        }
                    } finally {
                        System.out.println("Мы отключились от сервера");
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread threadServerListening = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = inConsole.nextLine();

                            if (str.equals("/end")) {
                                break;
                            }
                            out.println(str);
                        }
                    } finally {
                        System.out.println("Мы отключились от сервера");
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            threadClientListening.start();
            threadServerListening.start();
            threadClientListening.join();
            threadServerListening.join();

        } catch (
            IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
