import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Simulation
{

    public static Animal createAnAnimal(String[] config)
    {
        Animal animal = null;
        switch (config[0]) {
            case "bear":
                animal = new Bear(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
            case "chimpanzee":
                animal = new Chimpanzee(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
            case "elephant":
                animal = new Elephant(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
            case "giraffe":
                animal = new Giraffe(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
            case "gorilla":
                animal = new Gorilla(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
            case "lion":
                animal = new Lion(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
            case "penguin":
                animal = new Penguin(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
            case "tiger":
                animal = new Tiger(config[1].charAt(0), Integer.parseInt(config[2]), Integer.parseInt(config[3]));
                break;
        }

        return animal;
    }

    public static void main (String[] args)
    {

        Path configFile = Paths.get("C:\\Users\\Ramiz\\IdeaProjects\\FinalZoo\\configuration_file.txt");
        int numberOfEnclosure = 0;


        try {
            List<String> configs = Files.readAllLines(configFile);

            for (String item : configs) {
                String[] config = item.split("[:,]");

                if (config[0].equals("zoo")) {
                    Zoo zoo = new Zoo();
                }
                else if (Foodstore.healthOfFood.containsKey(config[0])) {
                    if (numberOfEnclosure > 0) {
                        Zoo.zoo.getEnclosures().get(numberOfEnclosure - 1).getFoodstore().addFood(config[0], Integer.parseInt(config[1]));
                    }
                    else {
                        Foodstore foodstore = new Foodstore();
                        foodstore.addFood(config[0], Integer.parseInt(config[1]));
                       Zoo.zoo.setFoodstore(foodstore);
                    }
                }
                else if (config[0].equals("enclosure")) {
                    Enclosure enclosure = new Enclosure();
                    enclosure.addWaste(Integer.parseInt(config[1]));
                    Zoo.zoo.setEnclosures(enclosure);
                    numberOfEnclosure++;
                }
                else if (Animal.TYPE_OF_ANIMALS.contains(config[0])) {
                    int enclosureNo = (config.length == 5 ? Integer.parseInt(config[4]) - 1 : (numberOfEnclosure - 1));
                    Animal animal = createAnAnimal(config);
                    animal.setEnclosure(Zoo.zoo.getEnclosures().get(numberOfEnclosure - 1));
                    Zoo.zoo.getEnclosures().get(enclosureNo).addAnimal(animal);
                }
                else if (config[0].equals("zookeeper")) {
                    Zookeeper zookeeper = new Zookeeper();
                    zookeeper.setEnclosure(Zoo.zoo.getEnclosures().get(numberOfEnclosure - 1));
                    Zoo.zoo.getZookeepers().add(zookeeper);
                }
                else if (config[0].equals("playZookeeper")) {
                    Zookeeper zookeeper = new PlayZookeeper();
                    zookeeper.setEnclosure(Zoo.zoo.getEnclosures().get(numberOfEnclosure - 1));
                    Zoo.zoo.getZookeepers().add(zookeeper);
                }
                else if (config[0].equals("physioZookeeper")) {
                    Zookeeper zookeeper = new PhysioZookeeper();
                    zookeeper.setEnclosure(Zoo.zoo.getEnclosures().get(numberOfEnclosure - 1));
                    Zoo.zoo.getZookeepers().add(zookeeper);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Count of animals at the limit of enclosure!");
        }
        for (int i = 0; i < 4; i++) {
            Zoo.zoo.aMonthPasses();
            //System.out.println(Zoo.zoo.getEnclosures().get(0).getAnimals().get(0).getEnclosure());
            System.out.println(Zoo.zoo.getEnclosures().get(0).getAnimals().get(0).getEnclosure().getFoodstore().getStorage());
        }
    }
}
