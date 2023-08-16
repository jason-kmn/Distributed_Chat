import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
* Represents an instance that "follows" one or more Publishers (users).
*
*/

public class Consumer {

    BrokerStore brokerStore = new BrokerStore();

    Profile profile;

    NotificationQueue notifications;



    public Consumer(){

        notifications = new NotificationQueue();
        menu();
    }

    public void connectToEventDeliverySystem(String ip , int port) throws IOException {

//        this.socket = new Socket(ip,port);

    }

    public void disconnect(String x){}
    public void register(String x){}
    public void showConversationData(String x , Value xx){}

    public void Notify(String publisher) {

    }

    public void pull(String topic , int id){

        Message message = new Message(false);
  //      message.header.init(this.profile.profileName, Message.messageType.PULL); // only first message contains header
    }

    public void connect(ConsumerThread.threadType thread_type){

        try {

            Socket socket = new Socket("localhost", 8888);

            Thread ConsumerThread = new Thread(new ConsumerThread(socket,this,thread_type));
            ConsumerThread.start();

        }

        catch (Exception e){}
    }

    public void menu() {

        System.out.println("This is the menu");
        System.out.println("Enter 1 to request topics from broker");
        System.out.println("Enter 2 to request download topic");
        System.out.println("Enter 3 to print broker store");

        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();

        System.out.println(choice);

        switch (choice){

            case "1":
                connect(ConsumerThread.threadType.firstCall);
                menu();
                break;
            case "2":

                System.out.println("Enter topic id and value id separated by space");
                Scanner topic = new Scanner(System.in);
                break;
            case "3":

                brokerStore.printBrokerIpPort();
                menu();
                break;
    /*        default :
                System.out.println("This choice is not correct");
                this.menu();

     */
        }

    }

    public static void main (String[] args) {

        Consumer x = new Consumer();

    }

}
