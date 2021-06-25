public class PlayZookeeper extends Zookeeper
{
    final private String TREAT_ABILITY = "playing";

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

}
