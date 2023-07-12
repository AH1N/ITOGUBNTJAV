import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu1(AnimalList animalList, Scanner scan, Counter count) {
        System.out.println("""
                список животных пока пуст желаете добавить новое животное ?
                1 - добавить новое животное  2 - закрыть и выйти  3 - Список Животных
                            """);


        System.out.println("ГЛАВНОЕ МЕНЮ");


        switch (scan.nextLine()) {
            case "1" -> {
                System.out.println("длбавим животное");
                menuAnimal(animalList, scan, count);
                System.out.println("Нажмите Enter для продолжения...!");
                scan.nextLine();
                menu1(animalList, scan, count);
            }
            case "2" -> {
                System.out.println("Программа завершена.");
                System.exit(0);
            }
            case "3" -> {menuCommands(animalList, scan, count);
                System.out.println("мы зашли в 3 пункт");
            }

            default -> menu1(animalList, scan, count);
        }

    }

    public static void menuAnimal(AnimalList animalList, Scanner scan,Counter count) {
        System.out.println("""
                ВВЕДИТЕ ТИП ЖИВОТНОГО
                1 - КОШКА
                2 - СОБАКА
                3 - ХОМЯК""");


        switch (scan.nextLine()) {
            case "1" -> {
                System.out.print("Введите имя: ");
                String cname = scan.nextLine();
                System.out.print("Введите  цвет: ");
                String ccolor = scan.nextLine();
                System.out.print("Введите  дату рождения: ");
                String cdate = scan.nextLine();
                Cat cat = new Cat(cname, ccolor, new ArrayList<>(), cdate);
                cat.fillCommandsFromInput(scan);
                System.out.println("КОШКА ГОТОВА");
                cat.printAnimal();
                cat.printCommands();
                animalList.addInAnimalList(cat);
                count.add();
            }
            case "2" -> {
                System.out.print("Введите имя: ");
                String dname = scan.nextLine();
                System.out.print("Введите  цвет: ");
                String dcolor = scan.nextLine();
                System.out.print("Введите  дату рождения: ");
                String ddate = scan.nextLine();
                Dog dog = new Dog(dname, dcolor, new ArrayList<>(), ddate);
                dog.fillCommandsFromInput(scan);
                System.out.println("ГОТОВО");
                System.out.println("СОБАКА");
                dog.printAnimal();
                dog.printCommands();
                animalList.addInAnimalList(dog);
                count.add();
            }
            case "3" -> {
                System.out.print("Введите имя: ");
                String hname = scan.nextLine();
                System.out.print("Введите  цвет: ");
                String hcolor = scan.nextLine();
                System.out.print("Введите  дату рождения: ");
                String hdate = scan.nextLine();
                Hamster hamster = new Hamster(hname, hcolor, new ArrayList<>(), hdate);
                hamster.fillCommandsFromInput(scan);
                System.out.println("ГОТОВО");
                System.out.println("ХОМЯК");
                hamster.printAnimal();
                hamster.printCommands();
                animalList.addInAnimalList(hamster);
                count.add();
            }
            default ->  menuAnimal(animalList, scan, count);
        }
    }

    public static void menuCommands(AnimalList animalList, Scanner scan, Counter count) {
        System.out.println("СПИСОК ВСЕХ ЖИВОТНЫХ");
        animalList.printAnimalList();
        System.out.println("введите номер нужного животного ");
        String inpt1 = scan.nextLine();
        System.out.println(inpt1);
        while(!(inpt1.matches("-?\\d+")) || Integer.parseInt(inpt1) > 2
                || inpt1.toString() == "" || inpt1 == null || Integer.parseInt(inpt1) < 0){
            System.out.println("ПОПРОБУЙТЕ ЕЩЁ РАЗОК");
            inpt1 = scan.nextLine();
        }
        Animal animall;
        animall = animalList.getAnimal(Integer.parseInt(inpt1));

        System.out.println("""
                ВЫБЕРИТЕ ПУНКТ МЕНЮ
                1 - обучить новым командам  2 - посмотреть список команд  3 - выйти в меню

                """);
        String inpt2 = scan.nextLine();


        switch (inpt2) {
            case "1" -> {
                System.out.println("введите новую команду для   " + animall.getName());
                String newcommand = scan.nextLine();
                animall.addCommand(newcommand);
                animall.printCommands();
                System.out.println("Нажмите Enter для продолжения...");
                scan.nextLine();
                menuCommands(animalList, scan, count);
            }
            case "2" -> {
                animall.getName();
                System.out.println(animall.commands.size() + "СТОЛЬКО КОМАНД");
                animall.printCommands();
                System.out.println("Нажмите Enter для продолжения...");
                scan.nextLine();
                menuCommands(animalList, scan, count);
            }
            case "3" -> menu1(animalList, scan, count);

            default -> menuCommands(animalList, scan, count);

            }
        }
}
