import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class NoteBook {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Note> notes = new ArrayList<>();

    public ArrayList<Note> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fIn = new FileInputStream("notebook.bin");
        ObjectInputStream in = new ObjectInputStream(fIn);
        ArrayList<Note> temp = new ArrayList<>();
        temp = (ArrayList<Note>) in.readObject();
        fIn.close();
        in.close();
        return temp;
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        notes = readFile();
    }

    public void write() throws IOException {
        FileOutputStream  fOut = new FileOutputStream("notebook.bin");
        ObjectOutputStream out = new ObjectOutputStream(fOut);
        ArrayList<Note> temp = notes;
        out.writeObject(temp);
        fOut.close();
        out.close();
    }

    public void addNote() throws IOException, ClassNotFoundException {
        System.out.println("please choose a topic for the note:");
        String topic = scanner.nextLine();
        System.out.println("ok. feel free to write:)");
        System.out.println("enter 'finish' to finish!");
        String body = scanner.nextLine();
        if (!body.equals("finish")){
            body = scanner.nextLine();
        }
        else {
            System.out.println("the new note has been added successfully");
        }
        Note note = new Note(topic,body);
        notes.add(note);
        write();
    }
}
