import java.io.Serializable;
public class Note implements Serializable{
    String topic;
    String body;
    public Note(String topic, String body) {
        this.topic = topic;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Note{" +
                "topic='" + topic + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

}
