package entities.animal_entities;

import entities.plant_entities.Plant;

import java.util.Set;
import java.util.stream.Stream;

public class Herbivore extends Animal {
    private Set<Plant> plantDiet;

    public Herbivore(String name) {
        super(name);
    }

    public Herbivore(String name, double weight, double height, double length) {
        super(name, weight, height, length);
    }

    public Set<Plant> getPlantDiet() {
        return plantDiet;
    }

    public void setPlantDiet(Set<Plant> plantDiet) {
        this.plantDiet = plantDiet;
    }

    public void addPlantToDiet(Plant plant) {
        plantDiet.add(plant);
    }

    public void printDiet() {
        System.out.println("The diet of this animal is the following");
        Stream.of(plantDiet).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    @Override
    public String toString() {
        return name +
                " - Herbivore{" +
                "plantDiet=" + plantDiet +
                ", weight=" + weight +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
