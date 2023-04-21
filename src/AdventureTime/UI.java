package AdventureTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI extends JFrame {
    private GameManager gm;
    private JFrame window;
    //messagetext
    private JTextArea messageText;

    public void setMessageText(String text) {
        this.messageText.setText(text);
    }

    public void addMessageText(String text) {
        this.messageText.append(text);
    }

    //bgPanel
    private JPanel bgPanel[] = new JPanel[10];
    public JPanel[] getBgPanel() {
        return bgPanel;
    }

    public void setBgPanel(JPanel[] bgPanel) {
        this.bgPanel = bgPanel;
    }
    //bgLabel
    private JLabel bgLabel[] = new JLabel[10];
    public JLabel[] getBgLabel() {
        return bgLabel;
    }

    public void setBgLabel(JLabel[] bgLabel) {
        this.bgLabel = bgLabel;
    }

    private JLabel objectLabel[][] = new JLabel[10][10];

    private ImageIcon objectIcon[][] = new ImageIcon[10][10];


    private JPanel lifePanel;
    private JLabel lifeLabel[] = new JLabel[6];

    public JLabel[] getLifeLabel() {
        return lifeLabel;
    }

    private JPanel inventoryPanel;


    public JLabel swordLabel, shieldLabel, lanternLabel, ropeLabel, applelabel, bowlabel;

    private JLabel titlelabel;
    private JButton restartButton;

    public JLabel getTitlelabel() {
        return titlelabel;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();
        createPlayerField();
        createGameOverField();
        generateScreen();
        window.setVisible(true);
    }


    public void createMainField() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        messageText = new JTextArea("Let's start the game");
        messageText.setBounds(50, 400, 700, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
//        message.setFont(new Font(b));
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);

        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }

    public void createBackground(int num, String bgname) {
        bgPanel[num] = new JPanel();
        bgPanel[num].setBounds(50, 50, 700, 350);
        bgPanel[num].setBackground(Color.blue);
        bgPanel[num].setLayout(null);
        bgPanel[num].setVisible(false);
        window.add(bgPanel[num]);

        bgLabel[num] = new JLabel();
        bgLabel[num].setBounds(0, 0, 700, 350);
        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgname));

        bgLabel[num].setIcon(bgIcon);

    }

    public void createPlayerField() {
        lifePanel = new JPanel();
        lifePanel.setBounds(50, 0, 250, 50);
        lifePanel.setBackground(Color.BLACK);
        lifePanel.setLayout(new GridLayout(1, 5));
        window.add(lifePanel);
        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("AdventureTime/image/heart.png"));
        Image image = lifeIcon.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);

        int i = 1;
        while( i < 6) {
            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            lifePanel.add(lifeLabel[i]);
            i++;
        }


        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(590, 0, 200, 50);
        inventoryPanel.setBackground(Color.BLACK);
        inventoryPanel.setLayout(new GridLayout(1, 4));
        window.add(inventoryPanel);

        // Create Items
        swordLabel = new JLabel();
        ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("AdventureTime/image/sword.png"));
        image = swordIcon.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
        swordIcon = new ImageIcon(image);
        swordLabel.setIcon(swordIcon);
        inventoryPanel.add(swordLabel);

        shieldLabel = new JLabel();
        ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("AdventureTime/image/shield.png"));
        image = shieldIcon.getImage().getScaledInstance(40,35, Image.SCALE_DEFAULT);
        shieldIcon = new ImageIcon(image);
        shieldLabel.setIcon(shieldIcon);
        inventoryPanel.add(shieldLabel);

        lanternLabel = new JLabel();
        ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("AdventureTime/image/lantern-icon.png"));
        image = lanternIcon.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
        lanternIcon = new ImageIcon(image);
        lanternLabel.setIcon(lanternIcon);
        inventoryPanel.add(lanternLabel);

        ropeLabel = new JLabel();
        ImageIcon ropeIcon = new ImageIcon(getClass().getClassLoader().getResource("AdventureTime/image/rope-icon.png"));
        image = ropeIcon.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
        ropeIcon = new ImageIcon(image);
        ropeLabel.setIcon(ropeIcon);
        inventoryPanel.add(ropeLabel);

        applelabel = new JLabel();
        ImageIcon appleicon = new ImageIcon(getClass().getClassLoader().getResource("AdventureTime/image/apple.png"));
        image = appleicon.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
        appleicon = new ImageIcon(image);
        applelabel.setIcon(appleicon);
        inventoryPanel.add(applelabel);

        bowlabel = new JLabel();
        ImageIcon bowicon = new ImageIcon(getClass().getClassLoader().getResource("AdventureTime/image/bow.png"));
        image = bowicon.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
        bowicon = new ImageIcon(image);
        bowlabel.setIcon(bowicon);
        inventoryPanel.add(bowlabel);
    }

    public void createGameOverField(){
        titlelabel = new JLabel("", JLabel.CENTER);
        titlelabel.setBounds(200,150,400,200);
        titlelabel.setForeground(Color.red);
        titlelabel.setFont(new Font("Times New Roman", Font.PLAIN, 70));
        titlelabel.setVisible(false);
        window.add(titlelabel);

        restartButton = new JButton();
        restartButton.setBounds(340, 320, 120, 50);
        restartButton.setBorder(null);
        restartButton.setBackground(null);
        restartButton.setForeground(Color.WHITE);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(gm.aHandler);
        restartButton.setActionCommand("restart");
        restartButton.setVisible(false);
        window.add(restartButton);
    }


    public void createObject(int num, int objnum, int x, int y, int width, int height, String imgname, String interact1, String interact2, String interact3, String cmd1, String cmd2, String cmd3) {
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem menuItem[] = new JMenuItem[4];
        menuItem[1] = new JMenuItem(interact1);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(cmd1);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(interact2);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(cmd2);
        popMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(interact3);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(cmd3);
        popMenu.add(menuItem[3]);

        objectLabel[num][objnum] = new JLabel();
        objectLabel[num][objnum].setBounds(x, y, width, height);

        objectIcon[num][objnum] = new ImageIcon(getClass().getClassLoader().getResource(imgname));
        objectLabel[num][objnum].setIcon(objectIcon[num][objnum]);

        objectLabel[num][objnum].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popMenu.show(objectLabel[num][objnum], e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        bgPanel[num].add(objectLabel[num][objnum]);

    }

    public void changeimage(int num, int objnum, int x, int y, int width, int height, String imgname, String interact1, String interact2, String interact3, String cmd1, String cmd2, String cmd3) {
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem menuItem[] = new JMenuItem[4];
        menuItem[1] = new JMenuItem(interact1);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(cmd1);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(interact2);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(cmd2);
        popMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(interact3);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(cmd3);
        popMenu.add(menuItem[3]);

//        objectLabel[num][objnum] = JLabel[num][objnum];
        objectLabel[num][objnum].setBounds(x, y, width, height);

        objectIcon[num][objnum] = new ImageIcon(getClass().getClassLoader().getResource(imgname));
        objectLabel[num][objnum].setIcon(objectIcon[num][objnum]);

        objectLabel[num][objnum].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popMenu.show(objectLabel[num][objnum], e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
//        bgPanel[num].(objectLabel[num][objnum]);

    }


    public void createArrowButton(int num, int x, int y, int width, int height, String arrowFileName, String command) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[num].add(arrowButton);
    }

    public void createDiff(int num, int x, int y, int width, int height, String arrowFileName, String command) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));

        JButton diffButton = new JButton();
        diffButton.setBounds(x, y, width, height);
        diffButton.setBackground(null);
        diffButton.setContentAreaFilled(false);
        diffButton.setFocusPainted(false);
        diffButton.setIcon(arrowIcon);
        diffButton.addActionListener(gm.aHandler);
        diffButton.setActionCommand(command);
        diffButton.setBorderPainted(false);

        bgPanel[num].add(diffButton);
    }


    public void generateScreen() {
        //Title
        createBackground(0, "AdventureTime/image/modeBackground.jpg");
        createObject(0, 1,150, 40, 400, 200, "AdventureTime/image/title.png", "", "", "", "", "", "");
        createDiff(0, 65, 250, 150, 75, "AdventureTime/image/EASY.png", "easy");
        createDiff(0, 270, 250, 150, 75, "AdventureTime/image/MEDIUM.png", "medium");
        createDiff(0, 480, 250, 150, 75, "AdventureTime/image/HARD.png", "hard");

        bgPanel[0].add(bgLabel[0]);

        //Scene 1 (Home)
        createBackground(1, "AdventureTime/image/background.jpg");
        createObject(1, 1,400, 100, 200, 200, "AdventureTime/image/hut.png", "Look", "Talk", "Rest", "lookHut", "talkHut", "restHut");
        createObject(1, 2,100, 200, 100, 100, "AdventureTime/image/guard.png", "Look", "Talk", "Attack", "lookGuard", "talkGuard", "attackGuard");
        createObject(1, 3,270, 210, 60, 85, "AdventureTime/image/barrel.png", "Look", "Talk", "Open", "lookChest", "talkChest", "searchChest");

        createArrowButton(1, 650, 150, 50, 50, "AdventureTime/image/rightarrow.png", "goScene2");
        bgPanel[1].add(bgLabel[1]);

        //Scene 2 (cave)
        createBackground(2,"AdventureTime/image/cave.png");
        createObject(2, 1,250, 20, 100, 200, "AdventureTime/image/blank.png", "Look", "Talk", "Enter", "lookCave", "talkCave", "enterCave");
        createObject(2, 2,610, 260, 50, 100, "AdventureTime/image/lampu.png", "Look", "Talk", "Take", "lookRoot", "talkRoot", "searchRoot");
        createArrowButton(2, 0, 150, 50, 50, "AdventureTime/image/leftarrow.png", "goScene1");
        bgPanel[2].add(bgLabel[2]);

        //Scene 3 (giant)
        createBackground(3, "AdventureTime/image/incave.jpeg");
        createObject(3,1,250,50,250,320,"AdventureTime/image/giant.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
        createArrowButton(3, 0, 150, 50, 50, "AdventureTime/image/leftArrow.png", "goScene2");
        bgPanel[3].add(bgLabel[3]);

        //Scene 4 (mountain)
        createBackground(4, "AdventureTime/image/gunung.png");
        createObject(4, 1,50, 100, 700, 180, "AdventureTime/image/blank.png", "Look", "Talk", "Climb", "lookMountain", "talkMountain", "climbMountain");
        createObject(4, 2,250, 300, 100, 50, "AdventureTime/image/rope.png", "Look", "Talk", "Take", "lookRope", "talkRope", "takeRope");
        createArrowButton(4, 0, 150, 50, 50, "AdventureTime/image/leftarrow.png", "goScene3");
        bgPanel[4].add(bgLabel[4]);

        //scene 5 (mutant)
        createBackground(5, "AdventureTime/image/topMountain.jpg");
        createObject(5,1,250,50,250,320,"AdventureTime/image/mutant.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");
        createArrowButton(5, 0, 150, 50, 50, "AdventureTime/image/leftArrow.png", "goScene4");
        bgPanel[5].add(bgLabel[5]);

        // Scene 6 (forest)
        createBackground(6, "AdventureTime/image/forest.jpg");
        createObject(6, 1,400, 40, 100, 200, "AdventureTime/image/blank.png", "Look", "Talk", "Enter", "lookForest", "talkForest", "enterForest");
        createObject(6, 2,250, 20, 100, 100, "AdventureTime/image/blank.png", "Look", "Talk", "Search", "lookTree", "talkTree", "searchTree");
        createObject(6, 3,400, 250, 90, 60, "AdventureTime/image/dirt.png", "Look", "Talk", "Dig", "lookDirt", "talkDirt", "digDirt");
        createArrowButton(6, 0, 150, 50, 50, "AdventureTime/image/leftArrow.png", "goScene5");

        bgPanel[6].add(bgLabel[6]);

        //Scene 7 (beast)
        createBackground(7, "AdventureTime/image/forestmonster.jpg");
        createObject(7,1,250,40,250,320,"AdventureTime/image/beast.png","Look","Talk","Attack","lookMonster3","talkMonster3","attackMonster3");
        createArrowButton(7, 0, 150, 50, 50, "AdventureTime/image/leftArrow.png", "goScene6");

        bgPanel[7].add(bgLabel[7]);
    }
}

