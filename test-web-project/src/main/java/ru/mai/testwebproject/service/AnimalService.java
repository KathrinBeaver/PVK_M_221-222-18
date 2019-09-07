package ru.mai.testwebproject.service;

import org.springframework.stereotype.Service;
import ru.mai.testwebproject.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> animals = new ArrayList<Animal>();

    public AnimalService() {
        animals.add(new Animal("Sharik", "Dog"));
        animals.add(new Animal("Murka", "Cat"));
        animals.add(new Animal("The Otter", "Otter"));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
}
