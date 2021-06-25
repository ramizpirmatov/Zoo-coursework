public class Chimpanzee extends Ape
{

    static final int LIFE_EXPECTANCY = 24;

    public Chimpanzee(char gender, int age, int health)
    {
        super(gender, age, health, LIFE_EXPECTANCY);
    }

    private void playChase()
    {
        increaseHealth(4);
    }

    @Override
    public void treat()
    {
        playChase();
    }

    @Override
    public String toString()
    {
        return "\nChimpanzee{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
