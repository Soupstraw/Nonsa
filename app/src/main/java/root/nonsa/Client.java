package root.nonsa;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by root on 26.09.14.
 */
public class Client {

    public static final int port = 25536;
    private Socket socket;
    private ServerSocket listener;
    private static Client client;

    private Client(){
        try {
            listener = new ServerSocket(port);
            listener.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client getClient(){
        if(client == null){
            client = new Client();
        }
        return client;
    }

    public boolean connect(InetAddress addr, int timeout){
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(addr, port), timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return socket.isConnected();
    }
}
