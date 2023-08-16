import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BrokerStore implements Serializable {

    Map<String , String> brokerIpPort = new HashMap<>(); // broker ip / port

    Map <String , Topic> brokerChannels = new HashMap<>(); // broker

    Map <String , String> brokerNamesIp = new HashMap<>(); // link broker names with ip

    public BrokerStore(){

        brokerIpPort.put("TEST","tEST");
    }

    public void printBrokerIpPort(){
        for (String x : brokerIpPort.keySet()){
            System.out.println("Key = " + x );
            System.out.println("Value = " + brokerIpPort.get(x));
        }
    }

    public BrokerStore(BrokerStore brokerstore){ // copy constructor

        this.brokerIpPort = brokerstore.brokerIpPort;
        this.brokerChannels = brokerstore.brokerChannels;
        this.brokerNamesIp = brokerstore.brokerNamesIp;
    }

}
