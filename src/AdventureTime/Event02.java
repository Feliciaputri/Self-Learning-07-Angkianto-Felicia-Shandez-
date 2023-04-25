package AdventureTime;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Event02 {
    private GameManager gm;
    public Event02(GameManager gm) {
        this.gm = gm;
    }

    public void lookCave() {
        gm.ui.setMessageText("It's a cave!");
    }

    public void talkCave() {
        gm.ui.setMessageText("You hear something from inside. But you don't know what is that");
    }

    public void enterCave() {
        if(gm.player.getHasLantern() == 0) {
            gm.ui.setMessageText("It's too dark to enter.");
        } else {
            gm.getsChanger().showScreen3();
            gm.playSE(gm.enter);
        }
    }

    public void lookRoot() {
        gm.ui.setMessageText("There's something here");
    }

    public void talkRoot() {
        gm.ui.setMessageText("Root : I don't want say anything with you.");
    }

    public void searchRoot() {
        if(gm.player.getHasLantern() == 0) {
            gm.playSE(gm.chestopen);
            gm.ui.setMessageText("You find a lantern");
            gm.player.setHasLantern(1);
            gm.ui.changeimage(2, 2,610, 260, 50, 100, "AdventureTime/image/blank.png", "Look", "Talk", "Take", "lookRoot", "talkRoot", "searchRoot");
            gm.ui.getBgPanel()[2].add(gm.ui.getBgLabel()[2]);
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.setMessageText("You didn't find anything");
        }
    }
}

