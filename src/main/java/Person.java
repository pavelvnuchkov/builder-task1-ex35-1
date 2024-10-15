import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
        this.address = "";
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = age;
    }

    public boolean hasAge() {

        return getAge().getAsInt() > 0;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return hasAddress() ? address : "Адреса нет!";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Возраст уже введен!");
        } else {
            this.age = age;
        }
    }

    public void happyBirthday() {
        if (hasAge()) {
            ++age;
        } else {
            System.out.println("У человека неизвестен возраст!");
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address).setAge(0);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
