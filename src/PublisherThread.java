import java.io.*;
import java.net.Socket;

public class PublisherThread implements Runnable{

    Publisher publisher;
    Socket socket;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    InputStream inputStream;
    ObjectInputStream objectInputStream;

    public PublisherThread(Socket socket,Publisher publisher) throws IOException {
    this.socket = socket;
    this.publisher = publisher;
    this.outputStream = socket.getOutputStream();
    this.objectOutputStream = new ObjectOutputStream(outputStream);
    this.inputStream = socket.getInputStream();
    this.objectInputStream = new ObjectInputStream(inputStream);

    }
    @Override
    public void run() {

        Message message = new Message(false);
        message.header.identifier = publisher.profile.profileName;
        message.header.messageType = Message.messageType.PUSH;
        message.header.valueType = Message.ValueType.TEXT;
        message.header.channel = "topic1";
        message.data.text = "Test";

        try {
            objectOutputStream.writeObject(message);
        }
        catch (Exception e){System.out.println(e);}
    }

}
