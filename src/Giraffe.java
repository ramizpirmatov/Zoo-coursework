public class Giraffe extends Animal
{

    static final String[] EATS = {"hay", "fruit"};
    static final int LIFE_EXPECTANCY = 28;
    final String TYPE_OF_TREAT = "physio";

    public Giraffe(char gender, int age, int health)
    {
        super(gender, age, health, EATS, LIFE_EXPECTANCY);
        setTreatType(TYPE_OF_TREAT);
    }

    private void neckMassage()
    {
        increaseHealth(4);
    }

    @Override
    public void treat()
    {
        neckMassage();
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
        return "\nGiraffe{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
