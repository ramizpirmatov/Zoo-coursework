public class Gorilla extends Ape
{

    static final int LIFE_EXPECTANCY = 32;

    public Gorilla(char gender, int age, int health)
    {
        super(gender, age, health, LIFE_EXPECTANCY);
    }

    private void painting()
    {
        increaseHealth(4);
    }

    @Override
    public void treat()
    {
        painting();
    }

    @Override
    public String toString()
    {
        return "\nGorilla{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
