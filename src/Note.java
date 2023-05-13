import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Note implements Serializable{
    String topic;
    String body;
    Random random = new Random();
    private int day = random.nextInt(30);
    private int month = random.nextInt(12);
    public Note(String topic, String body) {
        this.topic = topic;
        this.body = body;
    }


    public String getTopic(){
        return topic;
    }

    @Override
    public String toString() {
        return  "----    "+topic + "    ----"  +'\n'+ body + "       ";
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

}
