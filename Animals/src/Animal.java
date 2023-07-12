
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Animal {
    private String name;
    private String color;
    public ArrayList<String> commands = new ArrayList<>();
    private String dateBirth;

    public Animal(String name, String color, ArrayList<String> commands, String dateBirth){
        this.name = name;
        this.color = color;
        this.commands = commands;
        this.dateBirth = dateBirth;
    }

    public String getName() {
        return name;
    }

    public void printAnimal() {
        System.out.println("<" + this.name + ">" +"\t"+
                            "<" + this.color + ">" +"\t"+
                            "<" + this.dateBirth + ">" + "\n");


    }
    public void printCommands(){
        System.out.println("СПИСОК КОМАНД  " + this.name);
        if (this.commands != null){
            for (String command : this.commands) {
                System.out.println("команда->" + command);
            }
        } else {
            System.out.println("...НЕТ КОМАНД...");
        }
    }

    public ArrayList<String> addCommand(String command){
        this.commands.add(command);
        return this.commands;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void fillCommandsFromInput(Scanner scanner) {

        System.out.println("Введите команды, которые может выполнять животное (введите '1' для завершения):");

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("1")) {
                break;
            }
            addCommand(command);
        }
    }

}
