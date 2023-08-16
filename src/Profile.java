import java.util.ArrayList;
import java.util.HashMap;

public class Profile {

    String profileName;

    // remember to initialize the arrays before add items

    HashMap<String , ArrayList<Value>> userVideoFilesMap; // Chunks of Multimedia / Chats

    HashMap<String,Integer> subscribedConversations; // Consumer subscriptions

    public Profile(String profileName){
        this.profileName = profileName;
    }

}
