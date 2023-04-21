package AdventureTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener
{
    public static ArrayList<dataPlayer> listPlayer = new ArrayList<>();

    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Menu");
    private JMenuItem loginMenuItem = new JMenuItem("Login");
    private JMenuItem registerMenuItem = new JMenuItem("Register");
    private JMenuItem logoutMenuItem = new JMenuItem("Logout");
//    private JMenuItem exitMenuItem = new JMenuItem("Exit");
//    private JMenu masterMenu = new JMenu("Master");
//    private JMenuItem productMenuItem = new JMenuItem("Product");

//    Image img = Toolkit.getDefaultToolkit().createImage("JumbotronRegister.jpg");

    private JDesktopPane desktopPane = new JDesktopPane();

    Main() {
        fileMenu.add(loginMenuItem);
        fileMenu.add(logoutMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(registerMenuItem);
//        fileMenu.add(exitMenuItem);

//        masterMenu.add(productMenuItem);

        loginMenuItem.addActionListener(this);
        registerMenuItem.addActionListener(this);
        logoutMenuItem.addActionListener(this);
//        exitMenuItem.addActionListener(this);
//        productMenuItem.addActionListener(this);

        logout();

        menuBar.add(fileMenu);
//        menuBar.add(masterMenu);
        setJMenuBar(menuBar);

        setContentPane(desktopPane);

        setVisible(true);
//        setContentPane(new ImagePanel(img));
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
//        try {
//            for(var item :UIManager.getInstalledLookAndFeels()){
//                System.out.println(item.getName() + " " + item.getClassName());
//            }
//            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//        } catch (Exception e) {
//            System.out.println("Look and feel not found");
//        }
        new Main();
    }

    private String email = null;

    public String getEmail() {
        return email;
    }

    public void login(String email) {
        this.email = email;
        loginMenuItem.setVisible(false);
        logoutMenuItem.setVisible(true);
    }

    public void logout() {
        this.email = null;
        loginMenuItem.setVisible(true);
        logoutMenuItem.setVisible(false);
    }

    private LoginFrame loginFrame = null;
    private RegistrationFrame registrationFrame = null;

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == exitMenuItem) {
//            System.exit(0);
        if(e.getSource() == loginMenuItem) {
            if(loginFrame == null || loginFrame.isClosed()) {
                loginFrame = new LoginFrame();
                loginFrame.setParent(this);
                desktopPane.add(loginFrame);
            }
        } else if(e.getSource() == logoutMenuItem) {
            logout();
            JOptionPane.showMessageDialog(this, "Success logout!");
        }else if(e.getSource() == registerMenuItem){
            registrationFrame = new RegistrationFrame();
            desktopPane.add(registrationFrame);
        }
    }
}