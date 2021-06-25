public class Bear extends Animal
{
    static final String[] EATS = {"fish", "steak"};
    static final int LIFE_EXPECTANCY = 18;
    final String TYPE_OF_TREAT = "generic";

    public Bear(char gender, int age, int health)
    {
        super(gender, age, health, EATS, LIFE_EXPECTANCY);
        setTreatType(TYPE_OF_TREAT);
    }

    private void hug()
    {
        increaseHealth(3);
    }

    @Override
    public void treat()
    {
        hug();
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

    @Override
    public String toString()
    {
        return "\nBear{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
