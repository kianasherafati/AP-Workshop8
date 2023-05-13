import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        NoteBook noteBook = new NoteBook();
        noteBook.loadFile();
        try {
            while (true) {
                NoteBook.showMenu();
                System.out.println("please choose an option:");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> noteBook.addNote();
                    case "2" -> noteBook.removeNote();
                    case "3" -> noteBook.showNote();
                    case "4" -> noteBook.export();
                    case "5" -> System.exit(0);
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("Could not find the file!");
        }
        catch (IOException e){
            System.out.println("I/O error occurred!");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
