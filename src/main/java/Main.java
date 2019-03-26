import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Generator generator = new Generator(15500);
        generator.generateRandomListOfPeople();
        System.out.println(generator);
        generator.sortArray();
        System.out.println(generator);
    }
}
