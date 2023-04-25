package AdventureTime;

public class Event07 {
    private GameManager gm;
    public Event07(GameManager gm) {
        this.gm = gm;
    }

    public void lookMonster() {

        if(gm.player.isDefeatbeast() == true) {
            gm.ui.setMessageText("The monster is dead...");
        }
        else {
            gm.ui.setMessageText("It's a monster!");
        }
    }
    public void talkMonster() {

        if(gm.player.isDefeatbeast() == true) {
            gm.ui.setMessageText("Monster: .......");
        }
        else {
            gm.ui.setMessageText("Monster: HOW DARE YOU ATTACK ME!!");
            gm.playSE(gm.monster03);
        }
    }

    public void attackMonster(String diff) {
        gm.ui.changeimage(7,1,250,40,330,320,"AdventureTime/image/beastatk.png","Look","Talk","Attack","lookMonster3","talkMonster3","attackMonster3");

        if(gm.player.isDefeatbeast() == true) {
            gm.ui.changeimage(7,1,250,40,300,300,"AdventureTime/image/grave.png","Look","Talk","Attack","lookMonster3","talkMonster3","attackMonster3");
            gm.ui.setMessageText("The Beast is already dead...");
        }
        else {
            gm.getsbm().setDiff(diff);
            gm.getsbm().setMonster(gm.beast);
        }
    }
}
