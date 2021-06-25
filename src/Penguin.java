public class Penguin extends Animal
{
    static final String[] EATS = {"fish", "ice cream"};
    static final int LIFE_EXPECTANCY = 15;
    final String TYPE_OF_TREAT = "playing";

    public Penguin(char gender, int age, int health)
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

    private void watchAFilm()
    {
        increaseHealth(2);
    }

    @Override
    public void treat()
    {
        watchAFilm();
    }

    @Override
    public String toString()
    {
        return "\nPenguin{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
