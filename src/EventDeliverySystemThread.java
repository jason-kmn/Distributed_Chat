import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class EventDeliverySystemThread implements Runnable {

    EventDeliverySystem eventDeliverySystem;
    Socket socket;
    OutputStream outputStream;
    InputStream inputStream;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;


    public EventDeliverySystemThread(Socket socket,EventDeliverySystem eventDeliverySystem) throws IOException {
        this.socket = socket;
        this.outputStream = socket.getOutputStream();
        this.inputStream = socket.getInputStream();
        this.objectOutputStream = new ObjectOutputStream(outputStream);
        this.objectInputStream = new ObjectInputStream(inputStream);
        this.eventDeliverySystem = eventDeliverySystem;
    }

    public void addData(String profile_name , String topic_name , Message.Data data_p){

        Value data = new Value(data_p.text);

        if (eventDeliverySystem.topics.containsKey(topic_name)){
            eventDeliverySystem.topics.get(topic_name).add(data);
        }

        LinkedList<Value> add = new LinkedList<>();
        add.add(data);

        Topic topic = new Topic(profile_name,topic_name);
        eventDeliverySystem.topics.put(topic,add);

    }

    public void SendBrokerStore(){
        try{

        Message message = new Message();
        message.data.brokerStore = eventDeliverySystem.brokerstore;
        objectOutputStream.writeObject(message);
        }
        catch (Exception e){System.out.println(e);}
    }


    @Override
    public void run() {

  //      eventDeliverySystem.addConsumer(); // add consumer to publisher , todo add it on the correct place

        try {

            while (true) {

                Message message = (Message) objectInputStream.readObject();

                //     System.out.println(message.data.text);

    /*        if (message.equals("Hello from the other side!")) {

                String messages = "Hello From Server";

                objectOutputStream.writeObject(messages);

            }
*/
                if (message.header != null) { // check if message is headless

                    switch (message.header.messageType) {

                        case REQUEST_BROKER_INFO:
                            SendBrokerStore();

                        case PUSH: {

                            addData(message.header.identifier, message.header.channel, message.data);

                            switch (message.header.valueType) {
                                case TEXT:

                                    break;

                                case MULTIMEDIA_FILE:
                                    MultimediaFile multimedia = new MultimediaFile(message.multimediainfo.filename, message.multimediainfo.size);
                                    break;
                            }


                            //       eventDeliverySystem.topics.put()

                            break;
                        }
                        case PULL: {
                            break;
                        }
                    }
                }
            }
        }
            catch(Exception e){}


        }
    }