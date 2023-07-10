import java.util.ArrayList;
public class AnimalList {
    private ArrayList<Animal> animalList;
    public AnimalList (){
        this.animalList = new ArrayList<>();;
    }

    public void addInAnimalList(Animal animal){
        this.animalList.add(animal);
    }
    public void printAnimalList() {
        if (this.animalList != null) for (Animal animal : this.animalList) {
            System.out.print(this.animalList.indexOf(animal)); animal.printAnimal();
        }
        else System.out.println("Список пуст");
    }
    public void getAnimalCommands(Integer index){
        this.animalList.get(index).printCommands();
    }
    public Animal getAnimal(Integer index){
        return this.animalList.get(index);
    }

}
