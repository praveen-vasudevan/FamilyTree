package FamilyTree;

import java.util.*;

public class Person extends Object{


    public String name;
    public char gender;
    public Person father;
    public Person mother;
    public final ArrayList<Person> brothers = new ArrayList<>();
    public final ArrayList<Person> sisters = new ArrayList<>();
    public Person spouse;
    public final ArrayList<Person> children = new ArrayList<>();

    public final static Map<String, Person> persons = new HashMap<>();


    public Person() {

    }

    public Person(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }



    public void setFather(Person father) {
        this.father = father;
    }

    public Person getFather() {
        return father;
    }

    public char getGender() {
        return gender;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getMother() {
        return mother;
    }

    public ArrayList<Person> getBrothers(){
        return brothers;
    }

    public ArrayList<Person> getSisters() {
        return sisters;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse() {
        return spouse;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {

        return  this.name + " " + this.gender ;

    }

    public static void init(String name, char gender, String father, String mother) {

        //method
        Person f = persons.get(father);

        if(f == null) {
            f = new Person(father, 'M');
            persons.put(father, f);
        }

        Person m =  persons.get(mother);

        if(m == null) {
            m = new Person(mother, 'F');
            persons.put(mother, m);
        }

        f.setSpouse(m);
        m.setSpouse(f);

        Person p = persons.get(name);

        if(p == null) {
            p = new Person(name, gender);
            persons.put(name, p);
        }

        p.setFather(f);
        p.setMother(m);

        for(Person temp : p.getFather().getChildren()) {
            if(temp.gender == 'F') {
                p.sisters.add(temp);
                if(p.gender == 'F') {
                    temp.sisters.add(p);
                }
                else {
                    temp.brothers.add(p);
                }
            }
            else {
                p.brothers.add(temp);
                if(p.gender == 'F') {
                    temp.sisters.add(p);
                }
                else {
                    temp.brothers.add(p);
                }
            }
        }

        f.children.add(p);
        m.children.add(p);
    }

    public void findMoraponnu(String name) {
        Person p = persons.get(name);


    }

    public static void main(String args[]) {

        Person.init("suriya",'M' , "siva", "sivagami");
        Person.init("karthik", 'M', "siva", "sivagaami");
        Person.init("jothika", 'F', "raja", "rani");
        Person.init("nagma", 'F', "raja", "rani");
        Person.init("siva", 'M', "ravi", "revathi");
        Person.init("rani", 'F', "ravi", "revathi");


        System.out.println(persons);

        Person p = persons.get("rani");

        ArrayList<Person> siblings = new ArrayList<>();

        siblings.addAll(p.getBrothers());

        for(Person sibling: siblings) {
            System.out.println(sibling);
        }
    }


}
