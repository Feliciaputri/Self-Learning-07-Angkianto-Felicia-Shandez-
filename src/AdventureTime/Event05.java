package AdventureTime;

public class Event05 {
    private GameManager gm;

    public Event05(GameManager gm) {
        this.gm = gm;
    }

    public void lookMonster() {

        if(gm.player.isDefeatmutant() ==true) {
            gm.ui.setMessageText("The monster is dead...");
        }
        else {
            gm.ui.setMessageText("It's a monster!");
        }
    }
    public void talkMonster() {

        if(gm.player.isDefeatmutant() ==true) {
            gm.ui.setMessageText("Monster: .......");
        }
        else {
            gm.ui.setMessageText("Monster: HOW DARE YOU ATTACK ME!");
            gm.playSE(gm.monster02);
        }
    }

    public void attackMonster(String diff) {
        gm.ui.changeimage(5,1,150,40,350,350,"AdventureTime/image/mutantatk.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");

        if(gm.player.isDefeatmutant() == true) {
            gm.ui.changeimage(5,1,250,40,300,300,"AdventureTime/image/grave.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");
            gm.ui.setMessageText("The mutant is already dead...");
        }
        else {
            gm.getsbm().setDiff(diff);
            gm.getsbm().setMonster(gm.mutant);
        }
    }
}
