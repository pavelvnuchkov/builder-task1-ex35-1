public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Не корректно введен возраст");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person;
        System.out.println(name);
        if (name != null && surname != null) {
            person = new Person(name, surname);
            person.setAge(this.age);
            person.setAddress(this.address);
        } else {
            throw new IllegalStateException("Не введено одно из обязательных полей!");
        }
        return person;
    }
}
