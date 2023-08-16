import java.net.Socket;
import java.util.ArrayList;

/*
* Represents a user of the application.
 */

public class Publisher {

    Profile profile;

    public Publisher(Profile profile){
    this.profile = profile;
    }

    /*
    * Takes a multimedia file and generate chunks of it.
    */

   // public ArrayList<Value> generateChunks(MultimediaFile file){}

    public void getBrokerList(){}
  //  public Broker hashTopic(String x){}
    public void notifyBrokersNewMessage(String x){}
    public void notifyFailure(Broker x){}

    public void connect(){

        try {

            Socket socket = new Socket("localhost", 8888);

            Thread ConsumerThread = new Thread(new PublisherThread(socket,this));
            ConsumerThread.start();

        }

        catch (Exception e){}
    }

    public void push(String topic,Value value){

        Message message = new Message(false);

 //       message.header.init(this.profile.profileName, Message.messageType.PUSH);

    }

    public static void main(String[] args){
        Profile profile_publisher_1 = new Profile("profile1");
        Publisher publisher_1 = new Publisher(profile_publisher_1);
        publisher_1.connect();
    }
}
