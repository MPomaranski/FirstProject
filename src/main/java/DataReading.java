import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReading {

    private File fileName;
    private File filesurName;
    private File fileDomains;

    private List<String> nameList;
    private List<String> surNameList;
    private List<String> emailList;

    public DataReading() {
        this.fileName = new File("src/main/resources/names.txt");
        this.filesurName = new File("src/main/resources/surName.txt");
        this.fileDomains = new File("src/main/resources/domains.txt");

        this.nameList = new ArrayList<>();
        this.surNameList = new ArrayList<>();
        this.emailList = new ArrayList<>();
    }

    public List<String> readingNameData() throws FileNotFoundException {
        Scanner scannerName = new Scanner(fileName);
        while(scannerName.hasNext()){
            nameList.add(scannerName.nextLine());
        }
        return nameList;
    }
    public List<String> readingSurNameData() throws FileNotFoundException {
        Scanner scannersurName = new Scanner(filesurName);
        while(scannersurName.hasNext()){
            surNameList.add(scannersurName.nextLine());
        }
        return surNameList;
    }
    public List<String> readingeEmailData() throws FileNotFoundException {
        Scanner scannerEmail = new Scanner(fileDomains);
        while(scannerEmail.hasNext()){
            emailList.add(scannerEmail.nextLine());
        }
        return emailList;
    }
}
