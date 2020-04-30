package service;

import entities.animal_entities.Animal;
import entities.animal_entities.Carnivore;
import entities.animal_entities.Herbivore;
import entities.animal_entities.Omnivore;
import entities.plant_entities.Plant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ForestNotebook {
    private List<Carnivore> carnivores = new ArrayList<>();
    private List<Omnivore> omnivores = new ArrayList<>();
    private List<Herbivore> herbivores = new ArrayList<>();
    private int plantCount;
    private int animalCount;
    private List<Animal> animals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();

    public ForestNotebook() {
    }

    public List<Carnivore> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(List<Carnivore> carnivores) {
        this.carnivores = carnivores;
    }

    public List<Omnivore> getOmnivores() {
        return omnivores;
    }

    public void setOmnivores(List<Omnivore> omnivores) {
        this.omnivores = omnivores;
    }

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(List<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void addAnimal(Animal animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
            animalCount++;
            addAnimalSub(animal);
        } else {
            System.out.println("Your animal is already in the collection!");
        }
    }

    // methode om het dier bij de juiste lijst van subklasse toe te voegen
    private void addAnimalSub(Animal animal) {
        if (animal instanceof Omnivore) omnivores.add((Omnivore) animal);
        if (animal instanceof Carnivore) carnivores.add((Carnivore) animal);
        if (animal instanceof Herbivore) herbivores.add((Herbivore) animal);
    }

    public void addPlant(Plant plant) {
        if (!plants.contains(plant)) {
            plants.add(plant);
            plantCount++;
        } else {
            System.out.println("Your plant is already in the collection!");
        }
    }

    public void printNotebook() {
        System.out.println("You encountered the following things in the forest: ");
        if ((plantCount > 1)) {
            System.out.println(plantCount + " different kind of plants:");
        } else if (plantCount == 1) {
            System.out.println("1 plant: ");
        }
        plants.stream().map(a -> a.getName() + ", ").forEach(System.out::print);
        System.out.println();
        if (animalCount > 1) {
            if (plantCount > 0) System.out.print("And ");
            System.out.println(animalCount + " different animals: ");
            System.out.print(herbivores.size() + " Herbivore(s): ");
            herbivores.stream().map(a -> a.getName() + ", ").forEach(System.out::print);
            System.out.print("\n" + carnivores.size() + " Carnivore(s): ");
            carnivores.stream().map(a -> a.getName() + ", ").forEach(System.out::print);
            System.out.print("\n" + omnivores.size() + " Omnivore(s): ");
            omnivores.stream().map(a -> a.getName() + ", ").forEach(System.out::print);
            System.out.println();
        }
        if (animalCount == 1) {
            if (plantCount > 0) System.out.print("And 1 animal:\n");
            System.out.println(animals.get(0).getName());
        }
    }

    // extra methode omwille van beknopte uitleg printNotebook ten voordele van de overzichtelijkheid
    public void moreInfoAnimals() {
        animals.stream().map(Animal::toString).forEach(System.out::println);
    }

    // extra methode omwille van beknopte uitleg printNotebook ten voordele van de overzichtelijkheid
    public void moreInfoPlants() {
        plants.stream().map(Plant::toString).forEach(System.out::println);
    }

    public void sortAnimalsByName() {
        animals = animals.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        herbivores = herbivores.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        carnivores = carnivores.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        omnivores = omnivores.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
    }

    public void sortPlantsByName() {
        plants = plants.stream().sorted(Comparator.comparing(Plant::getName)).collect(Collectors.toList());
    }
}
