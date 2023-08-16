import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

public class Node {

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    Socket socket;

    String IpAddress = null;
    String port = null;

    public Node(int port){

    }

    public Node(String ip , String port){
        this.IpAddress = ip;
        this.port = port;
    }

    public void connect(SocketAddress ip , int port){

        try {
            socket.connect(ip,port);
        }
        catch (Exception e){}
    }
    public void disconnect(){
        try {
            socket.close();
        }
        catch (Exception e){}
    }

}
