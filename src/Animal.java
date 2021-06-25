import java.util.*;

public abstract class Animal
{

    private int age;
    private char gender;
    private String[] eats;
    private int health;
    private int lifeExpectancy;
    private Enclosure enclosure;
    private String treatType;
    static final List<String> TYPE_OF_ANIMALS = Arrays.asList("bear", "chimpanzee", "elephant", "giraffe", "gorilla", "lion", "penguin", "tiger");

    public Animal(char gender, int age, int health, String[] eats, int lifeExpectancy)
    {
        this.gender = gender;
        this.age = age;
        this.health = health;
        this.eats = eats;
        this.lifeExpectancy = lifeExpectancy;
    }

    public boolean canEat(String food)
    {
        for (String eatable : eats)
        {
            if (food.equals(eatable)) return true;
        }
        return false;
    }

    public void eat()
    {
        for (String food : enclosure.getFoodstore().getStorage().keySet())
        {
            if (canEat(food) && enclosure.getFoodstore().getStorage().get(food) > 0)
            {
                enclosure.getFoodstore().takeFood(food, 1);
                increaseHealth(Foodstore.healthOfFood.get(food));
                enclosure.addWaste(Foodstore.wasteOfFood.get(food));
                if (Foodstore.healthOfFood.get(food) > 0) break;
            }
        }
    }

    public void decreaseHealth()
    {
        health -= 2;
    }

    public void increaseHealth(int HP)
    {
        health += HP;
        if (health > 10) health = 10;
    }

    public abstract void treat();

    public boolean isDead()
    {
        return health <= 0 || age == lifeExpectancy;
    }

    public abstract boolean aMonthPasses();


    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public char getGender()
    {
        return gender;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public String[] getEats()
    {
        return eats;
    }

    public void setEats(String[] eats)
    {
        this.eats = eats;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getLifeExpectancy()
    {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy)
    {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Enclosure getEnclosure()
    {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure)
    {
        this.enclosure = enclosure;
    }

    public String getTreatType()
    {
        return treatType;
    }

    public void setTreatType(String treatType)
    {
        this.treatType = treatType;
    }

    @Override
    public String toString()
    {
        return "Animal{" +
                "age=" + age +
                ", gender=" + gender +
                ", eats=" + Arrays.toString(eats) +
                ", health=" + health +
                ", lifeExpectancy=" + lifeExpectancy +
                ", treatType='" + treatType + '\'' +
                '}';
    }
}
