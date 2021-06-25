public class Tiger extends BigCat
{

    public Tiger(char gender, int age, int health)
    {
        super(gender, age, health);
        setTreatType(TYPE_OF_TREAT);
    }

    private void stroke()
    {
        increaseHealth(3);
    }

    @Override
    public void treat()
    {
        stroke();
    }

    @Override
    public String toString()
    {
        return "\nTiger{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
