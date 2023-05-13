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

}
