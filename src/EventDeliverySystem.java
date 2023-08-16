import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EventDeliverySystem {

     BrokerInfo info;

     BrokerStore brokerstore = new BrokerStore(); // store info about all brokers that we deliver to consumer

     Map<Publisher, List<Consumer>> map = new HashMap<>(); // mapping Publisher with Consumers

     Map<Topic , LinkedList<Value> > topics = new HashMap<>();


/*     public Map<String , LinkedList<String>> getTopics(){

     }
*/

 //    HashMap <String topicname ,LinkedList <MultimediaFile multimediafile> > topics;

 //    Map<Broker, List<Publisher>> map2 = new HashMap<>(); // mapping Broker to Publishers

    public void NotifyConsumers(Publisher publisher) { // notifies consumers
        for (Consumer consumer : map.get(publisher)){
  //         consumer.Notify(publisher.getName());
        }
    }

    public void addConsumer (Publisher publisher , Consumer consumer) { //adds consumers to publishers
        map.get(publisher).add(consumer);
    }

 /*   public void addConsumer (String publisher , String consumer) { //adds consumers to publishers
        map.get(publisher).add(consumer);
    }
*/

  /*  public void addPublisher(Broker broker , Publisher publisher){ //adds publisher to broker
        map2.get(broker).add(publisher);
    }
*/

   /* protected static void startMainThread(){

        EventDeliverySystemThread z = new EventDeliverySystemThread(4444);
        Thread a = new Thread(z);
        a.start();
    }
*/

    public void mainSocketLoop(int port) {

        Socket connectionSocket = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port, 100);

            while (true) {
                connectionSocket = serverSocket.accept();

                System.out.println("New client connected");

                new Thread(new EventDeliverySystemThread(connectionSocket,this)).start();
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args){

        EventDeliverySystem a = new EventDeliverySystem();
        a.mainSocketLoop(8888 );
    }

}
