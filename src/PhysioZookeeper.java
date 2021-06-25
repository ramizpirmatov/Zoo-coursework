public class PhysioZookeeper extends Zookeeper
{
    Enclosure enclosure;
    final private String TREAT_ABILITY = "physio";

    public void aMonthPasses()
    {

        foodFromZooToEnclosure();
        removeWaste();
        treat();

    }

    private void foodFromZooToEnclosure()
    {
        int MAX_COUNT_OF_FOOD = 20;

        for (String food : enclosure.getAnimals().get(0).getEats())
        {
            int COUNT_OF_FOOD = Zoo.foodstore.getStorage().get(food);

            if (COUNT_OF_FOOD > 0)
            {
                if (COUNT_OF_FOOD < MAX_COUNT_OF_FOOD)
                {
                    Zoo.foodstore.takeFood(food, COUNT_OF_FOOD);
                    enclosure.getFoodstore().addFood(food, COUNT_OF_FOOD);
                    MAX_COUNT_OF_FOOD -= COUNT_OF_FOOD;
                } else
                {
                    Zoo.foodstore.takeFood(food, MAX_COUNT_OF_FOOD);
                    enclosure.getFoodstore().addFood(food, MAX_COUNT_OF_FOOD);
                }
            }
        }
    }

    @Override
    protected void treat()
    {
        int MAX_COUNT_OF_TREATS = 2;

        for (Animal animal : enclosure.getAnimals())
        {
            if (TREAT_ABILITY.equals(animal.getTreatType()))
            {
                animal.treat();
                MAX_COUNT_OF_TREATS--;
            }
            if (MAX_COUNT_OF_TREATS == 0) break;
        }
    }

    @Override
    public Enclosure getEnclosure()
    {
        return enclosure;
    }

    @Override
    public void setEnclosure(Enclosure enclosure)
    {
        this.enclosure = enclosure;
    }
}
