public class Value {

    int id;
    MultimediaFile multimediaFile;
    String Chat_text;

    public Value(MultimediaFile multimediafile){
        this.multimediaFile = multimediafile;
    }
    public Value(String chat_text){
        this.Chat_text = chat_text;
    }

}
