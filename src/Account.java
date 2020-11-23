import java.util.Random;

public class Account {
    private String username;
    private String password;
    private int IDNumber;
    Random random = new Random();
    Account(String username, String password){

        this.username = username;
        this.password = password;
        generateIDNumber();

    }


    private void generateIDNumber() {
        IDNumber = random.nextInt(899999)+100000;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
