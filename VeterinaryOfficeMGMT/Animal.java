package VeterinaryOfficeMGMT;

import java.util.ArrayList;
import java.util.Iterator;



class Animal {
    private int animalId;
    private String name;
    private int age;
    private String species;

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    
    public static ArrayList<Animal> backupDataAnimal(Iterator<Animal> iterator) {
        ArrayList<Animal> backupList = new ArrayList<>();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            backupList.add(animal);
        }
        return backupList;
    }

    public static ArrayList<Animal> restoreDataAnimal(ArrayList<Animal> backupList) {
        ArrayList<Animal> restoredList = new ArrayList<>();
        restoredList.addAll(backupList);
        return restoredList;
    }
}
