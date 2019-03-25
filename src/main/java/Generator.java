import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Generator{

    private int amount;

    private File fileName;
    private File filesurrName;
    private File fileDomains;

    private ArrayList<String> nameList;
    private ArrayList<String> surrNameList;
    private ArrayList<String> emailList;
    private ArrayList<Person> personArrayList;

    public Generator(int amount){

        this.amount = amount;

        this.fileName = new File("src/main/resources/names.txt");
        this.filesurrName = new File("src/main/resources/surrName.txt");
        this.fileDomains = new File("src/main/resources/domains.txt");

        this.nameList = new ArrayList<>();
        this.surrNameList = new ArrayList<>();
        this.emailList = new ArrayList<>();

        this.personArrayList = new ArrayList<>();
    }
    public void generateRandomListOfPeople() throws FileNotFoundException {
        Person newPerson;
        readingData();
        for(int i = 0; i < this.amount; i++) {
            newPerson = new Person(generateRandomName(),generateRandomSurrName(),generateRandomEmail());
            personArrayList.add(newPerson);
        }
    }
    private String generateRandomName(){
        String name;
        Random rand = new Random();
        int x = rand.nextInt(this.nameList.size());
        //System.out.println(x);
        name = this.nameList.get(x);
        return name;
    }
    private String generateRandomSurrName(){
        String surrName;
        Random rand = new Random();
        int x = rand.nextInt(this.surrNameList.size());
        //System.out.println(x);
        surrName = this.surrNameList.get(x);
        return surrName;
    }
    private String generateRandomEmail(){
        String email = "";
        Random rand = new Random();
        email = email + generateRandomName() + generateRandomSurrName() +"@";
        int x = rand.nextInt(this.emailList.size());
        //System.out.println(x);
        email = email+this.emailList.get(x);
        return email;
    }
    private void readingData() throws FileNotFoundException {
        Scanner scannerName = new Scanner(fileName);
        Scanner scannerSurrName = new Scanner(filesurrName);
        Scanner scannerEmail = new Scanner(fileDomains);
        while(scannerName.hasNext()){
            this.nameList.add(scannerName.nextLine());
        }
        while(scannerSurrName.hasNext()){
            this.surrNameList.add(scannerSurrName.nextLine());
        }
        while(scannerEmail.hasNext()){
            this.emailList.add(scannerEmail.nextLine());
        }
    }

    public void printArrayList(){
        for(int i = 0; i < this.personArrayList.size(); i++){
            System.out.println(personArrayList.get(i));
        }
    }
    public void sortArray(){
        Collections.sort(this.personArrayList, Comparator.comparing(Person::getName).
                thenComparing(Person::getSurrName).thenComparing(Person::getEmail));
    }
}
