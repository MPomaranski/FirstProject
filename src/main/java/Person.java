public class Person {
    private String name;
    private String surName;
    private String email;

    public Person(String name, String surName, String email) {
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getsurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }
    private boolean checkName(String name){
        boolean validName = name.matches("[\\w\\-'\\s]+");
        return validName;
    }
    private boolean checkSurName(String surName){
        boolean validsurName = surName.matches("[\\w\\-'\\s]+");
        return validsurName;
    }
    private boolean checkEmail(String email){
        boolean validEmail = email.matches("^(.+)@(.+)$");
        return validEmail;
    }

    @Override
    public String toString() {
        if(checkName(surName) && checkEmail(email) && checkSurName(surName)) {
            return "Name: " + name + "  surname: " + surName + "  e-mail: " + email + "\n";
        }
        else {
            throw new IllegalArgumentException("Invalid arguments\n");
        }
    }


}
