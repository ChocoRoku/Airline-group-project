import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class MenuGUI extends JFrame {

    // GUI
     JPanel mainPanel;
     JTextField usernameTextField;
     JButton registerButton;
     JButton signInButton;
     JPasswordField passwordField;
     JRadioButton isUser;
     JRadioButton isAirline;
     JLabel helloLabel;
     JLabel usernameLabel;
     JLabel passwordLabel;

    //
    ArrayList<Traveler> Travelers = new ArrayList<>();
    ArrayList<Airline> Airlines = new ArrayList<>();

    void register(String userName, String password, String accountType){
        if(userName.equals("") || password.equals("") || accountType.equals("")){
            throw new NullPointerException();
        }
        if(accountType.equals("User"))
            Travelers.add(new Traveler(userName, password));
        else if(accountType.equals("Airline"))
            Airlines.add(new Airline(userName, password));

    }

    void signin(String userName, String password, String accountType){
        if(userName.equals("") || password.equals("") || accountType.equals("")){
            throw new NullPointerException();
        }
    }

    public MenuGUI(){
        super("Ticket Booking Application");
        this.setPreferredSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }


    public static void main(String[] args) {
        JFrame menuFrame = new MenuGUI();
        menuFrame.setVisible(true);

        String accountType = "";
        if(((MenuGUI) menuFrame).isUser.isSelected()){
            accountType = "User";
            System.out.println("It's a user");
        }
        else if(((MenuGUI) menuFrame).isAirline.isSelected()){
            accountType = "Airline";
            System.out.println("It's an airline");
        }
        else
            accountType = "";

        String username = ((MenuGUI) menuFrame).usernameTextField.getText();
        String password = ((MenuGUI) menuFrame).passwordField.getText();
        // finalAccountType prevents an error with the following try blocks
        String finalAccountType = accountType;

        ((MenuGUI) menuFrame).registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ((MenuGUI) menuFrame).register(username, password, finalAccountType);

            }
        });

        ((MenuGUI) menuFrame).signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((MenuGUI) menuFrame).signin(username, password, finalAccountType);

            }
        });
    }
}
