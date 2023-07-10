import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu1(AnimalList animalList, Scanner scan, Counter count) {
        System.out.println("""
                список животных пока пуст желаете добавить новое животное ?
                1 - добавить новое животное  2 - закрыть и выйти  3 - Список Животных
                            """);


        System.out.println("11111");


        System.out.println("2222222");

        System.out.println("333333333");

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
            case "3" -> {menuCommands(animalList, scan, count);}

            default -> menu1(animalList, scan, count);
        }

    }

    private static void menuAnimal(AnimalList animalList, Scanner scan,Counter count) {
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
        Animal animall = animalList.getAnimal(scan.nextInt());
        animalList.printAnimalList();
        animall.printAnimal();
        System.out.println("введите номер нужного животного ");
        System.out.println("""
                ВЫБЕРИТЕ ПУНКТ МЕНЮ
                1 - обучить новым командам  2 - посмотреть список команд  3 - выйти в меню
                
                """);

        switch (scan.nextLine()) {
            case "1" -> {
                System.out.println(animall.getName());
                System.out.println("Нажмите Enter для продолжения...+");
                scan.nextLine();
                System.out.println("введите новую команду для   " + animall.getName());
                animall.addCommand(scan.nextLine());
                animall.printCommands();
                System.out.println("Нажмите Enter для продолжения...");
                scan.nextLine();
                menuCommands(animalList, scan, count);
            }
            case "2" -> {
                animall.printCommands();
                System.out.println("Нажмите Enter для продолжения...=");
                scan.nextLine();
                menuCommands(animalList, scan, count);
            }
            case "3" -> menu1(animalList, scan, count);

            default -> menuCommands(animalList, scan, count);

            }
        }
}
