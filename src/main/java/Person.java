public class Person {
    private String name;
    private String surrName;
    private String email;

    public Person(String name, String surrName, String email) {
        boolean validName = name.matches("[\\w\\-'\\s]+");
        boolean validSurrName = surrName.matches("[\\w\\-'\\s]+");
        boolean validEmail = email.matches("^(.+)@(.+)$");
        if(validName && validSurrName && validEmail) {
            this.name = name;
            this.surrName = surrName;
            this.email = email;
        }
        else {
            System.out.println("Invalid arguments.");
            System.out.println(name);
            System.out.println(surrName);
            System.out.println(email);
        }
    }

    public String getName() {
        return name;
    }

    public String getSurrName() {
        return surrName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "  Surrname: " +this.surrName + "  e-mail: "+ this.email;
    }


}
