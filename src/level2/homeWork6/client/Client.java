package level2.homeWork6.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String IP_ADDRESS = "localhost";
    private final int PORT = 11223;
    private Socket socket;

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner inConsole = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.nextLine();

                            if (str.equals("/end")) {
                                break;
                            }
                            System.out.println("Сервер: " + str);
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
            }).start();

            new Thread(new Runnable() {
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
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
