package AdventureTime;

public class Event01 {
    private GameManager gm;
    public Event01(GameManager gm){
        this.gm = gm;
    }

    public void lookHut(){
        gm.ui.setMessageText("Your house is here");
    }

    public void talkHut(){
        gm.ui.setMessageText("House can't talk to you");
    }

    public void restHut(){
        if(gm.aHandler.getDiff().equals("easy")) {
            if(gm.player.isDefeatgiant() == true) {
                gm.getsChanger().showEndScreen(1);
            }
        }else if (gm.aHandler.getDiff().equals("medium")) {
            if(gm.player.isDefeatgiant() == true && gm.player.isDefeatmutant() ==true) {
                gm.getsChanger().showEndScreen(1);
            }
        }else if (gm.aHandler.getDiff().equals("hard")) {
            if(gm.player.isDefeatgiant() == true && gm.player.isDefeatmutant() ==true && gm.player.isDefeatbeast() == true) {
                gm.getsChanger().showEndScreen(1);
            }
        }

        if(gm.player.getPlayerLife() != gm.player.getPlayerMaxLife()) {
            gm.ui.setMessageText("You rest at the house.\n(Your life has recovered)");
            gm.player.setPlayerLife(gm.player.getPlayerLife() + 1);
            gm.player.updatePlayerStatus();

            gm.playSE(gm.healSound);
        }
        else {
            gm.ui.setMessageText("Your life is full.");
        }

    }

    public void lookGuard(){
        gm.ui.setMessageText("A guard is standing in front of you");
    }

    public void talkGuard(){
        if(gm.player.getHasSword() == 0){
            gm.ui.setMessageText("Guard : Don't go any further without a weapon!\nYou should check the barrels over there!");
            gm.playSE(gm.guard01);
        }else{
            gm.ui.setMessageText("Guard : Go defeat the monsters!");
            gm.playSE(gm.guard06);
        }
    }

    public void attackGuard(){
        if(gm.player.getHasShield() == 0){
            if(gm.player.getHasSword() == 0){
                if(gm.player.getPlayerLife() != 1){
                    gm.ui.setMessageText("Guard : Hey don't hurt me!\nThe guard hits you back");
                    gm.playSE(gm.hitSound);
                    gm.playSE(gm.guard02);
                    gm.player.setPlayerLife(gm.player.getPlayerLife() - 1);
                }
                else if(gm.player.getPlayerLife() ==1){
                    gm.ui.setMessageText("Guard : You shouldn't have mess with me!");
                    gm.playSE(gm.guard03);
                    gm.playSE(gm.hitSound);
                    gm.player.setPlayerLife(gm.player.getPlayerLife() - 1);
                    gm.getsChanger().showGameOverScreen(1);
                }
            }
            else if(gm.player.getHasSword()==1){
                gm.playSE(gm.deathSound);
                gm.ui.setMessageText("Guard : Oh, no!\nYou've defeated the Guard");
                gm.ui.addMessageText("\nYou got shield\nYour resistance increases by 1");
                gm.playSE(gm.guard04);
                gm.playSE(gm.chestopen);
                gm.player.setHasShield(1);
            }
            gm.player.updatePlayerStatus();
        }
        else {
            gm.ui.setMessageText("Guard : Do not bother me!");
            gm.playSE(gm.guard05);
        }
    }

    public void lookBarrel(){
        gm.ui.setMessageText("A barrel is on the ground");
    }

    public void talkBarrel(){
        gm.ui.setMessageText("You talk to the barrel but it says nothing");
    }

    public void searchBarrel(){
        if(gm.player.getHasSword() == 0) {
            gm.ui.setMessageText("You open the barrel and find a sword!");
            gm.ui.addMessageText("\nYour strength increases by 3");
            gm.player.setHasSword(1);
            gm.playSE(gm.chestopen);
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.setMessageText("You didn't find anything");
        }
    }
}
