public abstract class BigCat extends Animal
{
    static final String[] EATS = {"steak", "celery"};
    static final int LIFE_EXPECTANCY = 24;
    final String TYPE_OF_TREAT = "generic";

    public BigCat(char gender, int age, int health)
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
}
