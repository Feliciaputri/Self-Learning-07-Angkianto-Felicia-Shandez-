package AdventureTime;

public class Event06 {
    private GameManager gm;
    public Event06(GameManager gm) {
        this.gm = gm;
    }

    public void lookForest(){
        gm.ui.setMessageText("A dark forest.\nIt is said a powerful beast live inside..");
    }

    public void talkForest(){
        gm.ui.setMessageText("You only heard the sound of rustling leaves replying back.");
    }

    public void enterForest(){
        if(gm.player.getHasBow() == 1){
            gm.getsChanger().showScreen7();
        }else{
            gm.ui.setMessageText("Another weapon could be useful...");
        }

    }

    public void lookTree(){
        gm.ui.setMessageText("There are so many trees in the forest.\nThey seem to be apple trees");
    }

    public void talkTree(){
        gm.ui.setMessageText("Only the sound of wind can be heard");
    }

    public void searchTree(){
        if(gm.player.getHasApple() == 0 && (gm.player.getPlayerLife() != gm.player.getPlayerMaxLife())) {
            gm.ui.setMessageText("You pick an apple from the tree.\nIt tastes refreshing");
            gm.ui.addMessageText("\nYour life increases by 1");
            gm.player.setHasApple(1);
            gm.player.setPlayerLife(gm.player.getPlayerLife() + 1);
            gm.playSE(gm.healSound);
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.setMessageText("The trees seems upset..\nIt's better to not take any apples");
        }
    }

    public void lookDirt(){
        gm.ui.setMessageText("You see a small mount of dirt\nWhat could possibly be inside?");
    }

    public void talkDirt(){
        gm.ui.setMessageText("It looks back at you..\nAs if tempting you to look what's inside");
    }

    public void digDirt() {
        if (gm.player.getHasBow() == 0) {
            gm.ui.setMessageText("You find an old but strong bow.\nIt could be useful in battle");
            gm.ui.addMessageText("\nYour strength increases by 5");
            gm.player.setHasBow(1);
            gm.playSE(gm.chestopen);
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.setMessageText("You didn't find anything else");
        }
    }
}