package AdventureTime;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BattleManager {

    private GameManager gm;
    private Monster monster;
    private Random randomDie = new Random();
    private String diff;

    public BattleManager(GameManager gm) {
        this.gm = gm;
    }
    public void resetMonsterLife(Monster mons) {
        mons.monsterLife = mons.monsterMaxLife;
    }

    public void setMonster(Monster mons){
        monster = mons;
        attack(monster);
    }

    public void setDiff(String diff){
        this.diff = diff;
    }

    public void attack(Monster monster) {
        int playerDamage = randomDie.nextInt(gm.player.getPlayerAttack()) - monster.monsterDefense;

        if(playerDamage < 0) {
            playerDamage = 0;
        }
        gm.ui.setMessageText("");
        gm.ui.addMessageText("You attack the " + monster.monsterName + " and give " + playerDamage + " damage!");
        monster.monsterLife -= playerDamage;
        if(monster.monsterLife<1) {
            gm.ui.addMessageText("\n" + monster.monsterName+ " life : 0\n");
            win();
            if(monster == gm.giant && diff.equals("easy")){
                gm.ui.changeimage(3,1,250,40,300,300,"AdventureTime/image/grave.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");
                gm.ui.setMessageText("Congratz\nYou've defeated the monster");
                gm.getsChanger().showEndScreen(3);
                gm.ui.getRestartButton().setVisible(true);
                gm.ui.getRestartButton().setText("Click here to restart");
            }

            if(monster == gm.mutant && diff.equals("medium")){
                gm.ui.setMessageText("Congratz\nYou've defeated the monster");
                gm.getsChanger().showEndScreen(5);
                gm.ui.getRestartButton().setVisible(true);
                gm.ui.getRestartButton().setText("Click here to restart");
            }

            if(monster == gm.beast && diff.equals("hard")){
                gm.ui.setMessageText("Congratz\nYou've defeated the monster");
                gm.getsChanger().showEndScreen(7);
                gm.ui.getRestartButton().setVisible(true);
                gm.ui.getRestartButton().setText("Click here to restart");
            }

            if(monster == gm.giant && diff.equals("medium") || diff.equals("hard")){
                gm.ui.changeimage(3,1,250,40,300,300,"AdventureTime/image/grave.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
                gm.ui.createArrowButton(3, 650, 150, 50, 50, "AdventureTime/image/rightArrow.png", "goScene4");
                gm.ui.getBgPanel()[3].add(gm.ui.getBgLabel()[3]);
                gm.playSE(gm.awesome);
                gm.getsChanger().showScreen4();
            }

            if(monster == gm.mutant && diff.equals("hard")){
                gm.ui.changeimage(5,1,250,40,300,300,"AdventureTime/image/grave.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");
                gm.ui.createArrowButton(5, 650, 150, 50, 50, "AdventureTime/image/rightArrow.png", "goScene6");
                gm.ui.getBgPanel()[5].add(gm.ui.getBgLabel()[5]);
                gm.playSE(gm.awesome);
                gm.playSE(gm.awesome);
                gm.getsChanger().showScreen6();
            }

            if(monster == gm.beast){
                gm.ui.changeimage(7,1,250,40,300,300,"AdventureTime/image/grave.png","Look","Talk","Attack","lookMonster3","talkMonster3","attackMonster3");
            }

        }
        else {
            int monsterDamage = randomDie.nextInt(monster.monsterAttack) - gm.player.getPlayerDefense();
            if(monsterDamage < 0) {
                monsterDamage = 0;
            }
            gm.player.setPlayerLife(gm.player.getPlayerLife() - monsterDamage);
            gm.ui.addMessageText("\nThe " + monster.monsterName + " attacks you and give " + monsterDamage + " damage!\n");
            gm.ui.addMessageText("\n" + monster.monsterName+ " life : " + monster.monsterLife + "\n");
            if(gm.player.getPlayerLife() < 1) {
                gm.player.setPlayerLife(0);
                gm.player.updatePlayerStatus();
                lose();
            }
            else {
                gm.player.updatePlayerStatus();
            }
        }
        gm.playSE(gm.hitSound);
    }
    public void win() {
//        System.out.println("WIN!!!");
        gm.ui.addMessageText("\nYou have defeated the monster!\n");

        if(monster == gm.giant) {
            gm.player.setDefeatgiant(true);
            gm.stopMusic(gm.currentMusic);
        }
        else if(monster == gm.mutant){
            gm.player.setDefeatmutant(true);
            gm.stopMusic(gm.currentMusic);
        }else if(monster == gm.beast){
            gm.player.setDefeatbeast(true);
            gm.stopMusic(gm.currentMusic);
        }
    }
    public void lose() {
//        System.out.println("LOSE!!!");
        gm.ui.addMessageText("You died!!");
        if(monster== gm.giant) {
            gm.getsChanger().showGameOverScreen(3);
        }
        else if(monster == gm.mutant){
            gm.getsChanger().showGameOverScreen(5);
        }
        else if(monster == gm.beast){
            gm.getsChanger().showGameOverScreen(7);
        }

    }
}
