import java.util.ArrayList;
import java.util.List;

public class Enclosure
{

    private Foodstore foodstore = new Foodstore();
    private List<Animal> animals = new ArrayList<>();
    private int wasteSize;

    public void addAnimal(Animal animal) throws Exception
    {
        if (size() < 20)
        {
            animals.add(animal);
            animal.setEnclosure(this);
        } else {
            throw new Exception();
        }
    }

    public void removeAnimal(Animal animal)
    {
        animals.remove(animal);
    }

    public void removeWaste(int count)
    {
        wasteSize -= count;
    }

    public void addWaste(int count)
    {
        wasteSize += count;
    }

    public int size()
    {
        return getAnimals().size();
    }

    public void aMonthPasses()
    {
        for (Animal animal : animals)
        {
            animal.aMonthPasses();
        }
    }


    public Foodstore getFoodstore()
    {
        return foodstore;
    }

    public void setFoodstore(Foodstore foodstore)
    {
        this.foodstore = foodstore;
    }

    public List<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(List<Animal> animals)
    {
        this.animals = animals;
    }

    public int getWasteSize()
    {
        return wasteSize;
    }

    public void setWasteSize(int wasteSize)
    {
        this.wasteSize = wasteSize;
    }

    @Override
    public String toString()
    {
        return "Enclosure{" +
                "\nfoodstore=" + foodstore +
                "\n animals=" + animals.toString() +
                "\n wasteSize=" + wasteSize +
                '}';
    }
}
