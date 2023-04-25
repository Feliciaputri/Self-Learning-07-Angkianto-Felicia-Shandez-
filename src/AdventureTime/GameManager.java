package AdventureTime;

import java.net.URL;

public class GameManager{
    public ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public Player player = new Player(this);

    //SceneChanger
    private SceneChanger sChanger = new SceneChanger(this);

    public SceneChanger getsChanger() {
        return sChanger;
    }

    private BattleManager bm = new BattleManager(this);
    public BattleManager getsbm() {
        return bm;
    }
    public Monster giant =  new Giant();
    public Monster mutant = new Mutant();
    public Monster beast = new Beast();
    public Music music = new Music();
    public SE se = new SE();
    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    public Event03 ev3 = new Event03(this);
    public Event04 ev4 = new Event04(this);
    public Event05 ev5 = new Event05(this);
    public Event06 ev6 = new Event06(this);
    public Event07 ev7 = new Event07(this);

    public URL fieldMusic  = getClass().getClassLoader().getResource("AdventureTime//music//home.wav");
    public URL fieldMusic2  = getClass().getClassLoader().getResource("AdventureTime//music//adventure2.wav");
    public URL battleMusic  = getClass().getClassLoader().getResource("AdventureTime//music//battle1.wav");
    public URL deathSound  = getClass().getClassLoader().getResource("AdventureTime//music//playerdeath.wav");
    public URL hitSound  = getClass().getClassLoader().getResource("AdventureTime//music//hit.wav");
    public URL healSound  = getClass().getClassLoader().getResource("AdventureTime//music//heal.wav");
    public URL monster01  = getClass().getClassLoader().getResource("AdventureTime//music//monster1.wav");
    public URL monster02  = getClass().getClassLoader().getResource("AdventureTime//music//monster2.wav");
    public URL monster03  = getClass().getClassLoader().getResource("AdventureTime//music//monster3.wav");
    public URL guard01  = getClass().getClassLoader().getResource("AdventureTime//music//guard01.wav");
    public URL guard02  = getClass().getClassLoader().getResource("AdventureTime//music//guard02.wav");
    public URL guard03  = getClass().getClassLoader().getResource("AdventureTime//music//guard03.wav");
    public URL guard04  = getClass().getClassLoader().getResource("AdventureTime//music//guard04.wav");
    public URL guard05  = getClass().getClassLoader().getResource("AdventureTime//music//guard05.wav");
    public URL guard06  = getClass().getClassLoader().getResource("AdventureTime//music//guard06.wav");
    public URL awesome  = getClass().getClassLoader().getResource("AdventureTime//music//levelpassed2.wav");
    public URL chestopen  = getClass().getClassLoader().getResource("AdventureTime//music//collect.wav");
    public URL enter  = getClass().getClassLoader().getResource("AdventureTime//music//enter.wav");

    public URL currentMusic;

    public static void main(String[] args) {
        new GameManager();
    }

    public GameManager() {
        currentMusic = fieldMusic;
        playMusic(currentMusic);

        player.setPlayerDefaultStatus();
        sChanger.titlecreen();
    }

    public void playSE(URL url){

        se.setFile(url);
        se.play(url);
    }

    public void playMusic(URL url) {
        music.setFile(url);
        music.play(url);
        music.loop(url);
    }

    public void stopMusic(URL url) {
        music.stop(url);
    }

}
