package AdventureTime;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SceneChanger {
    private GameManager gm;
    public SceneChanger(GameManager gm){
        this.gm =  gm;
    }

    public void easy(){
        showHome1();
    }

    public void medium(){
        showHome1();
    }

    public void hard(){
        showHome1();
    }

    public void titlecreen(){
        gm.ui.getBgPanel()[0].setVisible(true);
        gm.ui.getBgPanel()[1].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(false);
        gm.ui.setMessageText("Choose Mode");
    }

    public void showHome1(){
        gm.ui.getBgPanel()[0].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(false);
        gm.ui.getBgPanel()[1].setVisible(true);
        gm.ui.setMessageText("Let's defeat the Demon Lord");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.fieldMusic;
        gm.playMusic(gm.currentMusic);

        gm.getsbm().resetMonsterLife(gm.giant);
        gm.getsbm().resetMonsterLife(gm.mutant);
        gm.getsbm().resetMonsterLife(gm.beast);
    }
    public void showScreen2(){
        gm.ui.getBgPanel()[1].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(true);
        gm.ui.setMessageText("this is a cave!");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.fieldMusic2;
        gm.playMusic(gm.currentMusic);
    }

    public void showScreen3() {
        gm.ui.getBgPanel()[1].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(true);

        gm.stopMusic(gm.currentMusic);
        if(gm.player.isDefeatgiant() == false) {
            gm.ui.setMessageText("OMG! the cave is inhabited by a Giant!!!\n");
            gm.ui.addMessageText(gm.giant.monsterName+ " life : " + gm.giant.monsterLife + "\n");
            gm.currentMusic = gm.battleMusic;
            gm.playMusic(gm.currentMusic);
        }
        else {
            gm.ui.setMessageText("");
        }
    }

    public void showScreen4() {
        gm.ui.getBgPanel()[1].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(true);

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.fieldMusic2;
        gm.playMusic(gm.currentMusic);
    }

    public void showScreen5() {
        gm.ui.getBgPanel()[1].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(true);

        gm.stopMusic(gm.currentMusic);
        if(gm.player.isDefeatmutant() == false) {
            gm.ui.setMessageText("OMG! the mountain is inhabited by a Mutant!!!\n");
            gm.ui.addMessageText(gm.mutant.monsterName+ " life : " + gm.mutant.monsterLife + "\n");
            gm.currentMusic = gm.battleMusic;
            gm.playMusic(gm.currentMusic);
        }
        else {
            gm.ui.setMessageText("");
        }
    }

    public void showScreen6() {
        gm.ui.getBgPanel()[1].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(true);
        gm.ui.setMessageText("You've arrived at the forest.\nIt's dark inside");

        gm.stopMusic(gm.currentMusic);
        gm.currentMusic = gm.fieldMusic2;
        gm.playMusic(gm.currentMusic);
    }

    public void showScreen7() {
        gm.ui.getBgPanel()[1].setVisible(false);
        gm.ui.getBgPanel()[2].setVisible(false);
        gm.ui.getBgPanel()[3].setVisible(false);
        gm.ui.getBgPanel()[4].setVisible(false);
        gm.ui.getBgPanel()[5].setVisible(false);
        gm.ui.getBgPanel()[6].setVisible(false);
        gm.ui.getBgPanel()[7].setVisible(true);
        gm.ui.setMessageText("A scary beast live inside!");

        gm.stopMusic(gm.currentMusic);
        if(gm.player.isDefeatbeast() == false) {
            gm.ui.setMessageText("OMG! the forest is inhabited by a Beast!!!\n");
            gm.ui.addMessageText(gm.beast.monsterName+ " life : " + gm.beast.monsterLife + "\n");
            gm.currentMusic = gm.battleMusic;
            gm.playMusic(gm.currentMusic);
        }
        else {
            gm.ui.setMessageText("");
        }
    }

    public void showGameOverScreen(int currentBgNum){
        gm.stopMusic(gm.currentMusic);
        gm.playSE(gm.deathSound);
        gm.ui.getBgPanel()[currentBgNum].setVisible(false);
        gm.ui.getTitlelabel().setVisible(true);
        gm.ui.changeimage(2, 2,610, 260, 50, 100, "AdventureTime/image/lampu.png", "Look", "Talk", "Take", "lookRoot", "talkRoot", "searchRoot");
        gm.ui.changeimage(4, 2,250, 300, 100, 50, "AdventureTime/image/rope.png", "Look", "Talk", "Take", "lookRope", "talkRope", "takeRope");
        gm.ui.changeimage(3,1,250,50,250,320,"AdventureTime/image/giant.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
        gm.ui.changeimage(5,1,250,50,250,320,"AdventureTime/image/mutant.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");
        gm.ui.changeimage(7,1,250,40,250,320,"AdventureTime/image/beast.png","Look","Talk","Attack", "LookMonster3", "talkMonster3", "attackMonster3");
        gm.ui.getTitlelabel().setText("YOU DIED");
        gm.ui.getRestartButton().setVisible(true);
        gm.ui.getRestartButton().setText("Click here to restart");
    }

    public void exitGameOverScreen(){
        gm.ui.getTitlelabel().setVisible(false);
        gm.ui.getRestartButton().setVisible(false);
//        gm.bm.resetMonsterLife(gm.giant);
//        gm.bm.resetMonsterLife(gm.mutant);
        gm.player.setPlayerDefaultStatus();
    }

    public void showEndScreen(int currentBgNum) {

        gm.ui.getBgPanel()[currentBgNum].setVisible(false);
        gm.ui.getTitlelabel().setVisible(true);
        gm.playSE(gm.awesome);
        gm.ui.changeimage(2, 2,610, 260, 50, 100, "AdventureTime/image/lampu.png", "Look", "Talk", "Take", "lookRoot", "talkRoot", "searchRoot");
        gm.ui.changeimage(4, 2,250, 300, 100, 50, "AdventureTime/image/rope.png", "Look", "Talk", "Take", "lookRope", "talkRope", "takeRope");
        gm.ui.changeimage(3,1,250,50,250,320,"AdventureTime/image/giant.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
        gm.ui.changeimage(5,1,250,50,250,320,"AdventureTime/image/mutant.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");
        gm.ui.changeimage(7,1,250,40,250,320,"AdventureTime/image/beast.png","Look","Talk","Attack", "LookMonster3", "talkMonster3", "attackMonster3");
        gm.ui.getTitlelabel().setText("Congratz!");
        gm.ui.setMessageText("You have completed the Awesome Quest III!\nThanks for playing!");
//		gm.ui.getRestartButton().setVisible(true);

//       gm.stopMusic(gm.fieldMusic);
    }
}
