import java.io.Serializable;

public class Message implements Serializable {

    Data data = new Data();
    Header header;
    MultimediaInfo multimediainfo;

     enum messageType{
        PUSH, // upload
        PULL, // consumer request for file
        REQUEST_BROKER_INFO,
        REQUEST_SUBSCRIPTION, // consumer request to subscribe to publisher
        NOTIFICATION  // consumer gets notified for new file

    }

    enum ValueType{
        TEXT,
        MULTIMEDIA_FILE
    }

      class Header implements Serializable{

        String identifier;
        messageType messageType;
        ValueType valueType;
        String channel;

        public void init(String identifier , messageType messageType){

            this.identifier = identifier;
            this.messageType = messageType;
        }

    }

    class MultimediaInfo {
        long size;
        String filename;

        public void init(String filename , long size){

            this.filename = filename;
            this.size = size;
        }
    }

    class Data implements Serializable{

        String text;
        byte[] data;
        BrokerStore brokerStore;

        public void init(String text){
            this.text = text;
        }

        public void init(byte[] data){
            this.data = data;
        }



    }

    public Message(boolean headless){ // headless messages do not contain header

         if (!headless){
          this.header = new Header();
         }
    }

    public Message(){}


}
