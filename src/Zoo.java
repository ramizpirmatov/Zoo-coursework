import java.util.*;

public class Zoo
{

    static public Zoo zoo = new Zoo();
    private List<Enclosure> enclosures = new ArrayList<>();
    private List<Zookeeper> zookeepers = new ArrayList<>();
    static protected Foodstore foodstore = new Foodstore();

    public void aMonthPasses()
    {

        for (Enclosure enclosure : enclosures) {
            enclosure.aMonthPasses();
        }

        Iterator<Zookeeper> z1 = zookeepers.iterator();
        for (Zookeeper zookeeper : zookeepers) {
            if (z1.hasNext()) zookeeper.aMonthPasses();
        }

        removeDeadAnimals();

    }

    public void removeDeadAnimals()
    {
        try {
            for (Enclosure enclosure : enclosures) {
                try {
                    for (Animal animal : enclosure.getAnimals()) {
                        if (animal.isDead()) {
                            enclosure.removeAnimal(animal);
                        }
                    }
                } catch (ConcurrentModificationException e) {
                    enclosures.remove(enclosure);
                }
            }
        }catch (ConcurrentModificationException e){
            EmptyZooException emptyZooException = new EmptyZooException();
        }


    }

    public List<Enclosure> getEnclosures()
    {
        return enclosures;
    }

    public void setEnclosures(Enclosure enclosure)
    {
        this.enclosures.add(enclosure);
    }

    public Foodstore getFoodstore()
    {
        return foodstore;
    }

    public void setFoodstore(Foodstore foodstore)
    {
        Zoo.foodstore = foodstore;
    }

    public List<Zookeeper> getZookeepers()
    {
        return zookeepers;
    }

    public void setZookeepers(List<Zookeeper> zookeepers)
    {
        this.zookeepers = zookeepers;
    }

}
