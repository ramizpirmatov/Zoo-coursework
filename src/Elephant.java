public class Elephant extends Animal
{

    static final String[] EATS = {"hay", "fruit"};
    static final int LIFE_EXPECTANCY = 36;
    final String TYPE_OF_TREAT = "physio";

    public Elephant(char gender, int age, int health)
    {
        super(gender, age, health, EATS, LIFE_EXPECTANCY);
        setTreatType(TYPE_OF_TREAT);
    }

    @Override
    public boolean aMonthPasses()
    {
        if (!isDead())
        {
            eat();
            decreaseHealth();
            setAge(getAge() + 1);
            return true;
        }
        return false;
    }

    private void bath()
    {
        increaseHealth(5);
    }

    @Override
    public void treat()
    {
        bath();
    }

    @Override
    public String toString()
    {
        return "\nElephant{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
