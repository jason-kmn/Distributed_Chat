import java.io.*;
import java.net.Socket;

public class ConsumerThread implements Runnable {

    Consumer consumer;
    Socket socket;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    InputStream inputStream;
    ObjectInputStream objectInputStream;
    threadType thread_Type;

    enum threadType{
        firstCall
    }

    public ConsumerThread(Socket socket,Consumer consumer , threadType threadtype) throws IOException {

        this.consumer = consumer;
        this.socket = socket;
        this.outputStream = socket.getOutputStream();
        this.objectOutputStream = new ObjectOutputStream(outputStream);
        this.inputStream = socket.getInputStream();
        this.objectInputStream = new ObjectInputStream(inputStream);
        this.thread_Type = threadtype;
    }

    public void WriteToSteam(String message) {

    }


    public void firstCall (){ // at first call to event delivery system we request info

        Message message = new Message(false);

        message.header.messageType = Message.messageType.REQUEST_BROKER_INFO;

        try {
            objectOutputStream.writeObject(message);

            Message message_received = new Message();
            message_received = (Message) objectInputStream.readObject();

            BrokerStore brokerstore = new BrokerStore(message_received.data.brokerStore);

            consumer.brokerStore = brokerstore;

            System.out.println("Broker Store Updated !!!");

        }
        catch (Exception e){System.out.println(e);}
    }


    @Override
    public void run() {

        if (this.thread_Type == threadType.firstCall){
            firstCall();
        }

        String messages = "Hello from the other side!";
        try {
            objectOutputStream.writeObject(messages);

            // read the list of messages from the socket
            String listOfMessages = (String) objectInputStream.readObject();

            System.out.println(listOfMessages);

            if (listOfMessages.equals("Hello From Server")) {

                System.out.println("Ready to be served");

            }

            while(true){
                Thread.sleep(5000);
                String message = (String) objectInputStream.readObject();
                System.out.println(message);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
