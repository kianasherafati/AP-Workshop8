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
        System.out.println("please choose a topic for the note or enter '0' to go back to the main menu :");
        String topic = scanner.nextLine();
        if (topic.equals("0")){
            showMenu();
        }
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

    public void printList() throws IOException, ClassNotFoundException {
        notes = readFile();
        int i = 1;
        for (Note note : notes) {
            System.out.println(i + "- " + note.toString());
            i++;
        }
    }
    public static void showMenu(){
        System.out.println("1- Add\n2- Remove\n3- Notes\n4- Export\n5- Exit");
    }

    public void removeNote() throws IOException, ClassNotFoundException {
        System.out.println("choose one of the notes to remove or enter '0' to go back to the main menu :");
        printList();
        String choice = scanner.nextLine();
        if(choice.equals("0")){
            showMenu();
        }
        notes.remove(Integer.parseInt(choice)-1);
        System.out.println("the note has been removed successfully!");
        write();
    }

    public void showNote() throws IOException, ClassNotFoundException {
        System.out.println("choose a note to show or enter '0' to go back to the main menu :");
        printList();
        String choice = scanner.nextLine();
        ArrayList<Note> temp = readFile();

        if(choice.equals("0")){
            showMenu();
        }
        temp.get(Integer.parseInt(choice)-1).toString();
    }

    public void export() throws IOException, ClassNotFoundException {
        System.out.println("choose a note to export or enter '0' to go back to the main menu :");
        printList();
        int choice = scanner.nextInt();
        ArrayList<Note>temp = readFile();
        FileOutputStream fOut = new FileOutputStream("export.txt");
        ObjectOutputStream out = new ObjectOutputStream(fOut);
        out.writeObject(temp.get(choice - 1));
        System.out.println("the note has been successfully exported!");
        System.out.println("you can find it on" + "\"" + "export" + "\"" + "directory.");
        if(choice==0){
            showMenu();
        }
    }
}
