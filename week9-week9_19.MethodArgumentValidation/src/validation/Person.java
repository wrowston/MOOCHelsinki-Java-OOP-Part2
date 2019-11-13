package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {

        this.name = name;
        this.age = age;

        if (this.age < 0 || this.age > 120) {
            throw new IllegalArgumentException("Age must be in range 0-120");
        } else if (this.name == null) {
            throw  new IllegalArgumentException("Name is null");
        } else if (this.name.isEmpty()) {
            throw  new IllegalArgumentException("Name is empty");
        } else if (this.name.length() > 40) {
            throw new IllegalArgumentException("Name must be less than 40 characters");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
