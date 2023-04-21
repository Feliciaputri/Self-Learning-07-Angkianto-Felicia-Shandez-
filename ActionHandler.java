package AdventureTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    private GameManager gm;
    private String diff;

    public String getDiff() {
        return diff;
    }

    public  ActionHandler(GameManager gm){
        this.gm = gm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();
        switch (yourChoice){
            case "lookHut" : gm.ev1.lookHut(); break;
            case "talkHut" : gm.ev1.talkHut(); break;
            case "restHut" : gm.ev1.restHut(); break;
            case "lookGuard" : gm.ev1.lookGuard(); break;
            case "talkGuard" : gm.ev1.talkGuard(); break;
            case "attackGuard" : gm.ev1.attackGuard(); break;
            case "lookChest" : gm.ev1.lookChest(); break;
            case "talkChest" : gm.ev1.talkChest(); break;
            case "searchChest" : gm.ev1.searchChest(); break;


            case "lookCave" : gm.ev2.lookCave();break;
            case "talkCave" : gm.ev2.talkCave();break;
            case "enterCave" : gm.ev2.enterCave();break;
            case "lookRoot" : gm.ev2.lookRoot();break;
            case "talkRoot" : gm.ev2.talkRoot();break;
            case "searchRoot" : gm.ev2.searchRoot();break;

            case "lookMountain" : gm.ev4.lookMountain(); break;
            case "talkMountain" : gm.ev4.talkMountain(); break;
            case "climbMountain" : gm.ev4.climbMountain(); break;

            case "lookRope" : gm.ev4.lookRope(); break;
            case "talkRope" : gm.ev4.talkRope(); break;
            case "takeRope" : gm.ev4.takeRope(); break;

            case "lookForest": gm.ev6.lookForest();break;
            case "talkForest": gm.ev6.talkForest();break;
            case "enterForest": gm.ev6.enterForest();break;

            case "lookTree": gm.ev6.lookTree();break;
            case "talkTree": gm.ev6.talkTree();break;
            case "searchTree": gm.ev6.searchTree();break;

            case "lookDirt": gm.ev6.lookDirt();break;
            case "talkDirt": gm.ev6.talkDirt();break;
            case "digDirt": gm.ev6.digDirt();break;

            case "goHome": gm.getsChanger().showHome1(); break;
            case "goTitle": gm.getsChanger().titlecreen(); break;

            case "easy" :
                diff = "easy";
                gm.getsChanger().easy();
                break;
            case "medium" :
                diff = "medium";
                gm.getsChanger().medium();
                break;
            case "hard" :
                diff = "hard";
                gm.getsChanger().hard();
            break;

            case "lookMonster": gm.ev3.lookMonster();break;
            case "talkMonster": gm.ev3.talkMonster();break;
            case "attackMonster": gm.ev3.attackMonster(diff);break;

            case "lookMonster2": gm.ev5.lookMonster();break;
            case "talkMonster2": gm.ev5.talkMonster();break;
            case "attackMonster2": gm.ev5.attackMonster(diff);break;

            case "lookMonster3": gm.ev7.lookMonster();break;
            case "talkMonster3": gm.ev7.talkMonster();break;
            case "attackMonster3": gm.ev7.attackMonster(diff);break;

            case "goScene1": gm.getsChanger().showHome1(); break;
            case "goScene2": gm.getsChanger().showScreen2();  break;
            case "goScene3" : gm.getsChanger().showScreen3(); break;
            case "goScene4" : gm.getsChanger().showScreen4(); break;
            case "goScene5" : gm.getsChanger().showScreen5(); break;
            case "goScene6" : gm.getsChanger().showScreen6(); break;
            case "restart": gm.getsChanger().exitGameOverScreen();gm.player.setPlayerDefaultStatus(); gm.getsChanger().titlecreen();break;
        }
    }
}
