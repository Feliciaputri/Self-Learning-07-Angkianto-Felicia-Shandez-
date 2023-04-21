package AdventureTime;

public class Event04 {
    private GameManager gm;
    public Event04(GameManager gm) {
        this.gm = gm;
    }

    public void lookMountain() {
        gm.ui.setMessageText("It's a mountain!");
    }

    public void talkMountain() {
        gm.ui.setMessageText("....");
    }

    public void climbMountain() {
        if(gm.player.getHasRope() == 0) {
            gm.ui.setMessageText("It's too high to climb.");
        } else {
            gm.getsChanger().showScreen5();
            gm.playSE(gm.enter);
        }
    }

    public void lookRope() {
        gm.ui.setMessageText("There's something here");
    }

    public void talkRope() {
        gm.ui.setMessageText("I cannot talk with you.");
    }

    public void takeRope() {
        if(gm.player.getHasRope() == 0) {
            gm.playSE(gm.chestopen);
            gm.ui.changeimage(4, 2,250, 300, 100, 50, "AdventureTime/image/blank.png", "Look", "Talk", "Take", "lookRope", "talkRope", "takeRope");
            gm.ui.setMessageText("You find a rope");
            gm.player.setHasRope(1);
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.setMessageText("You didn't find anything");
        }
    }
}

