import java.util.HashMap;
import java.util.Map;

public class Foodstore
{
    private Map<String, Integer> storage = new HashMap<>();
    static final Map<String, Integer> healthOfFood = new HashMap<>();
    static final Map<String, Integer> wasteOfFood = new HashMap<>();

    static
    {
        healthOfFood.put("hay", 1);
        healthOfFood.put("steak", 3);
        healthOfFood.put("fruit", 2);
        healthOfFood.put("celery", 0);
        healthOfFood.put("fish", 3);
        healthOfFood.put("ice cream", 1);

        wasteOfFood.put("hay", 4);
        wasteOfFood.put("steak", 4);
        wasteOfFood.put("fruit", 3);
        wasteOfFood.put("celery", 1);
        wasteOfFood.put("fish", 2);
        wasteOfFood.put("ice cream", 3);

    }

    public Foodstore()
    {
        for (String item : healthOfFood.keySet())
        {
            storage.put(item, 0);
        }
    }

    public void addFood(String food, int count)
    {
        storage.put(food, count + storage.get(food));
    }

    // out of instruction
    public void takeFood(String food, int count)
    {
        if (count > storage.get(food) || count == storage.get(food))
        {
            storage.put(food, 0);
        }
        else
        {

            //storage.remove(food, count);
            storage.put(food, storage.get(food) - count);
        }
    }


    public Map<String, Integer> getStorage()
    {
        return storage;
    }

    public void setStorage(Map<String, Integer> storage)
    {
        this.storage = storage;
    }

    public static Map<String, Integer> getHealthOfFood(String food)
    {
        return healthOfFood;
    }

    public static Map<String, Integer> getWasteOfFood()
    {
        return wasteOfFood;
    }

    @Override
    public String toString()
    {
        return "Foodstore{" +
                "\nstorage=" + storage +
                '}';
    }
}
