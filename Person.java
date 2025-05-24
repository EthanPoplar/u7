package fit5171.monash.edu;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private String gender;
    public static final List<String> GENDERS = Collections.unmodifiableList(
            Arrays.asList("Woman", "Man", "Non-Binary", "Prefer Not to Say", "Others"));

    public Person(){}

    public Person(String firstName, String secondName, int age, String gender){
        setAge(age);
        setFirstName(firstName);
        setSecondName(secondName);
        setGender(gender);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 || age >= 130) {
            throw new IllegalArgumentException("Age must between 0 and 130.");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || !GENDERS.contains(gender)) {
            throw new IllegalArgumentException("Invalid gender value.");
        }
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || !firstName.matches("^[A-Za-z].*")) {
            throw new IllegalArgumentException("First name must start with a letter and not be null.");
        }
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        if (secondName == null || !secondName.matches("^[A-Za-z].*")) {
            throw new IllegalArgumentException("Second name must start with a letter and not be null.");
        }
        this.secondName = secondName;
    }
}
