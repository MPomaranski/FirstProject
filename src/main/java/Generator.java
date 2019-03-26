import java.io.FileNotFoundException;
import java.util.*;

public class Generator{

    private DataReading dataReading;

    private int amount;

    private List<String> nameList;
    private List<String> surNameList;
    private List<String> emailList;
    private List<Person> personArrayList;

    public Generator(int amount){

        this.dataReading = new DataReading();
        this.amount = amount;
        this.nameList = new ArrayList<>();
        this.surNameList = new ArrayList<>();
        this.emailList = new ArrayList<>();
        this.personArrayList = new ArrayList<>();
    }
    public void generateRandomListOfPeople() throws FileNotFoundException {
        Person newPerson;
        setLists();
        for(int i = 0; i < this.amount; i++) {
            newPerson = new Person(generateRandomName(),generateRandomsurName(),generateRandomEmail());
            personArrayList.add(newPerson);
        }
    }
    private String generateRandomName(){
        String name;
        Random rand = new Random();
        int x = rand.nextInt(this.nameList.size());
        name = this.nameList.get(x);
        return name;
    }
    private String generateRandomsurName(){
        String surName;
        Random rand = new Random();
        int x = rand.nextInt(this.surNameList.size());
        surName = this.surNameList.get(x);
        return surName;
    }
    private String generateRandomEmail(){
        String email = "";
        Random rand = new Random();
        email = email + generateRandomName() + generateRandomsurName() +"@";
        int x = rand.nextInt(this.emailList.size());
        email = email+this.emailList.get(x);
        return email;
    }

    private void setLists() throws FileNotFoundException {
        this.nameList = dataReading.readingNameData();
        this.surNameList = dataReading.readingSurNameData();
        this.emailList = dataReading.readingeEmailData();
    }

    public void sortArray(){
        Collections.sort(this.personArrayList, Comparator.comparing(Person::getName).
                thenComparing(Person::getsurName).thenComparing(Person::getEmail));
    }

    @Override
    public String toString() {
        return this.personArrayList.toString();
    }
}
