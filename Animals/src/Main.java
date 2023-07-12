import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Counter count = new Counter(0);
        AnimalList animalList = new AnimalList();
        Menu.menu1(animalList, scan, count);
        scan.close();
    }
}
