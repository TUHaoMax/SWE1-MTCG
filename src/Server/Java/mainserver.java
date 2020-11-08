import java.util.Scanner;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;


public class mainserver  {
    private static ServerSocket _listener = null;
    Socket s;


    public static void main(String[] args) {
        System.out.println("start server");

        try {
            _listener = new ServerSocket(8000, 5);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            while (true) {
                Socket s = _listener.accept();
                System.out.println("srv: sending welcome message");

                new Thread(new threadserver(s)).start();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            _listener.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        _listener = null;
        System.out.println("close server");
    }


}
