import java.util.ArrayList;

public class Cat extends Animal {

    public Cat(String name, String color, ArrayList<String> commands, String dateBirth) {
        super(name, color, commands, dateBirth);
    }

    @Override
    public void printAnimal() {
        super.printAnimal();
    }

    @Override
    public void printCommands() {
        super.printCommands();
    }
}
