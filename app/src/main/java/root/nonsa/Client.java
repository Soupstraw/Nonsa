package root.nonsa;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by root on 26.09.14.
 */
public class Client {

    private Socket socket;

    public boolean connect(InetAddress addr, int port, int timeout){
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(addr, port), timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return socket.isConnected();
    }
}
