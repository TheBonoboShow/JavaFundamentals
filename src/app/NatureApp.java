package app;

import entities.animal_entities.Carnivore;
import entities.animal_entities.Herbivore;
import entities.animal_entities.Omnivore;
import entities.plant_entities.*;
import service.ForestNotebook;

import java.util.HashSet;
import java.util.Set;

// Notebook voor de wakkere wandelaar

public class NatureApp {

    // xtra duidelijkheid print statements
    private static void separator() {
        System.out.println("\n=============\n");
    }

    public static void main(String[] args) {
        ForestNotebook notebook = new ForestNotebook();
        Flower duizendblad = new Flower("Duizendblad");
        notebook.addPlant(duizendblad);
        duizendblad.setHeight(21.6);
        duizendblad.setSmell(Scent.MUSKY);
        Bush bosAardbei = new Bush("Bosaardbei", 36.8);
        notebook.addPlant(bosAardbei);
        bosAardbei.setFruit("Aardbei");
        bosAardbei.setLeafType(LeafType.SPEAR);
        Weed robertsKruid = new Weed("Robertskruid", 8.3);
        notebook.addPlant(robertsKruid);
        robertsKruid.setArea(830);
        Flower wolligeBoterbloem = new Flower("Wollige boterbloem", 15.2);
        notebook.addPlant(wolligeBoterbloem);
        wolligeBoterbloem.setSmell(Scent.ORANGE);
        Tree winterLinde = new Tree("Winterlinde", 580);
        notebook.addPlant(winterLinde);
        winterLinde.setLeafType(LeafType.HAND);
        Tree berk = new Tree("Berk", 465);
        notebook.addPlant(berk);
        berk.setLeafType(LeafType.SPEAR);
        Bush wildeLiguster = new Bush("Wilde liguster", 120);
        notebook.addPlant(wildeLiguster);
        wildeLiguster.setFruit("Bessen");
        wildeLiguster.setLeafType(LeafType.HEART);

        Set<Plant> knaagdierenDieet = new HashSet<>();
        Set<Plant> vogelGourmet = new HashSet<>();
        Set<Plant> otherCuisine = new HashSet<>();
        knaagdierenDieet.add(wildeLiguster);
        knaagdierenDieet.add(robertsKruid);
        knaagdierenDieet.add(bosAardbei);
        vogelGourmet.add(winterLinde);
        vogelGourmet.add(berk);
        vogelGourmet.add(wildeLiguster);
        otherCuisine.add(wildeLiguster);
        otherCuisine.add(bosAardbei);
        otherCuisine.add(wolligeBoterbloem);
        otherCuisine.add(duizendblad);

        Herbivore bosmuis = new Herbivore("Bosmuis", 0.22, 0.053, 0.105);
        bosmuis.setPlantDiet(knaagdierenDieet);
        notebook.addAnimal(bosmuis);
        Herbivore edelHert = new Herbivore("Edelhert", 180, 196, 209);
        edelHert.setPlantDiet(otherCuisine);
        notebook.addAnimal(edelHert);
        Carnivore vos = new Carnivore("Vos", 40, 70, 130);
        vos.setMaxFoodSize(200);
        notebook.addAnimal(vos);
        Herbivore noordseVleermuis = new Herbivore("Noordse vleermuis", 0.11, 0.04, 0.066);
        noordseVleermuis.setPlantDiet(knaagdierenDieet);
        notebook.addAnimal(noordseVleermuis);
        Omnivore haas = new Omnivore("Haas", 4, 0.53, 0.46);
        haas.setPlantDiet(otherCuisine);
        haas.setMaxFoodSize(25);
        notebook.addAnimal(haas);
        Carnivore boomMarter = new Carnivore("Boommarter", 1.2, 0.15, 0.41);
        boomMarter.setMaxFoodSize(50);
        notebook.addAnimal(boomMarter);
        Omnivore mol = new Omnivore("Mol", 0.08, 0.03, 0.15);
        mol.setPlantDiet(knaagdierenDieet);
        mol.setMaxFoodSize(10);
        notebook.addAnimal(mol);
        Herbivore pimpelmees = new Herbivore("Pimpelmees", 0.02, 0.05, 0.02);
        pimpelmees.setPlantDiet(vogelGourmet);
        notebook.addAnimal(pimpelmees);
        Herbivore merel = new Herbivore("Merel", 0.025, 0.08, 0.02);
        merel.setPlantDiet(vogelGourmet);
        notebook.addAnimal(merel);
        Herbivore vink = new Herbivore("Vink", 0.1, 0.12, 0.03);
        vink.setPlantDiet(vogelGourmet);
        vink.addPlantToDiet(bosAardbei);
        notebook.addAnimal(vink);

        notebook.printNotebook();
        separator();
        notebook.sortAnimalsByName();
        notebook.sortPlantsByName();
        notebook.printNotebook();
        separator();
        notebook.moreInfoAnimals();
        separator();
        notebook.moreInfoPlants();
    }
}
