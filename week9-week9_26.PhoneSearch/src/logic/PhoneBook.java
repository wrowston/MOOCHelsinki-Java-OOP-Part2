package logic;

import java.util.*;

public class PhoneBook {
    private List<Person> people = new ArrayList<Person>();
    private Map<String, Person> namePerson = new HashMap<String, Person>();
    private Map<List<String>, Person> numberPerson = new HashMap<List<String>, Person>();
    private Map<String, Person> addressPerson = new HashMap<String, Person>();

    public void addPerson(Person person) {
        this.people.add(person);
        this.namePerson.put(person.getName(), person);
        this.numberPerson.put(person.getNumbers(), person);
        this.addressPerson.put(person.getAddress(), person);
    }

    public Person getPersonByName(String name) {
        return this.namePerson.get(name);
    }

    public String getNameByNumber(String number) {
        for (Person person : this.people) {
            if (person.getNumbers().contains(number)) {
                return person.getName();
            }
        }
        return "not found";
    }

    public void addNumber(String name, String number) {
        if (this.namePerson.containsKey(name)) {
            Person person = getPersonByName(name);
            person.addNumber(number);
            this.numberPerson.put(person.getNumbers(), person);
        } else {
            Person person = new Person(name);
            person.addNumber(number);
            this.addPerson(person);
        }
    }

    public void addAddress(String name, String street, String city) {
        if (this.namePerson.containsKey(name)) {
            Person person = getPersonByName(name);
            person.addAddress(street, city);
            this.addressPerson.put(person.getAddress(), person);
        } else {
            Person person = new Person(name);
            person.addAddress(street, city);
            this.addPerson(person);
        }
    }

    public void deleteInfoByName(String name) {
        Person person = getPersonByName(name);

        this.people.remove(person);
        this.namePerson.remove(person.getName());
        this.numberPerson.remove(person.getNumbers());
        this.addressPerson.remove(person.getName());
    }

    public List<Person> searchByKeyword(String keyword) {
        List<Person> personList = new ArrayList<Person>();
        if (keyword.isEmpty()) {
            return this.people;
        }
        for (Person person : this.people) {
            if (person.getName().contains(keyword) || person.getAddress().contains(keyword)) {
                personList.add(person);
            } else {
                for (String number : person.getNumbers()) {
                    if (number.contains(keyword)) {
                        personList.add(person);
                    }
                }
            }
        }
        return personList;
    }

    public boolean containsPersonByName(String name) {
        return this.namePerson.containsKey(name);
    }

    public boolean containsPersonByNumber(String number) {
        for (List<String> list : this.numberPerson.keySet()) {
            if (list.contains(number)) {
                return true;
            }
        }
        return false;
    }

}
