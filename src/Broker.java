import java.util.List;

/*
* Holds and sends data to Consumers.
*/

public class Broker {

    String BrokerName;

    List<Consumer> registeredUsers;
    List<Publisher> registeredPublishers;

  //  public Consumer acceptConnection(Consumer x){}
   // public Publisher acceptConnection(Publisher x){}
    public void calculateKeys(){}
    public void filterConsumers(String x){}
    public void notifyBrokersOnChanges(){}
    public void notifyPublisher(String x){}
    public void pull(String x){}
}
