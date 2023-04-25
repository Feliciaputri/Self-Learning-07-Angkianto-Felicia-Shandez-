package AdventureTime;

public class Event03 {

    private GameManager gm;

    public Event03(GameManager gm) {
        this.gm = gm;
    }

    public void lookMonster() {

        if(gm.player.isDefeatgiant() == true) {
            gm.ui.setMessageText("The monster is dead...");
        }
        else {
            gm.ui.setMessageText("It's a monster!");
        }
    }
    public void talkMonster() {
        if(gm.player.isDefeatgiant() == true) {
            gm.ui.setMessageText("Monster: .......");
        }
        else {
            gm.ui.setMessageText("Monster: HOW DARE YOU ATTACK ME!");
            gm.playSE(gm.monster01);
        }
    }

    public void attackMonster(String diff) {
        gm.ui.changeimage(3,1,250,50,320,330,"AdventureTime/image/Giantatk.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
        if(gm.player.isDefeatgiant() == true) {
            gm.ui.changeimage(3,1,250,40,300,300,"AdventureTime/image/grave.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
            gm.ui.setMessageText("The Giant is already dead...");
        }
        else {
            gm.getsbm().setDiff(diff);
            gm.getsbm().setMonster(gm.giant);
        }
    }
}
