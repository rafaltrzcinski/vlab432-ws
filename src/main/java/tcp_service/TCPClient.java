package tcp_service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 55443);
            InputStream inputStream = clientSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte[] outputData = new byte[5];
            dataInputStream.read(outputData, 0, 5);
            String output = new String(outputData);
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
