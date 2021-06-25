public class Lion extends BigCat
{

    public Lion(char gender, int age, int health)
    {
        super(gender, age, health);
    }

    private void stroke()
    {
        increaseHealth(2);
    }

    @Override
    public void treat()
    {
        stroke();
    }

    @Override
    public String toString()
    {
        return "\nLion{" +
                "age = " + getAge() +
                " gender = '" + getGender() +
                "' health = " + getHealth() +
                " life expectancy = " + getLifeExpectancy() +
                " TYPE_OF_TREAT = '" + TYPE_OF_TREAT + '\'' +
                '}';
    }
}
