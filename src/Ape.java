public abstract class Ape extends Animal
{
    static final String[] EATS = {"fruit", "ice cream"};
    final String TYPE_OF_TREAT = "playing";

    public Ape(char gender, int age, int health, int lifeExpectancy)
    {
        super(gender, age, health, EATS, lifeExpectancy);
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
}
