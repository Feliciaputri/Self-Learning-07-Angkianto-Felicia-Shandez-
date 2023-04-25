package AdventureTime;

public class Player {
    GameManager gm;

    private int playerMaxLife;
    private int playerLife;
    private int playerStrength = 3;
    private int playerEndurance = 1;
    private int playerAttack;
    private int playerDefense;
    private int hasSword;
    private int hasShield;
    private int hasLantern;
    private int hasRope;
    private int hasApple;
    private int hasBow;
    private int weaponPower;
    private int shieldPower;
    private int bowPower;
    private String diff;

    private boolean defeatgiant = false;
    private boolean defeatmutant = false;
    private boolean defeatbeast = false;

    public int getPlayerMaxLife() {
        return playerMaxLife;
    }

    public int getPlayerLife() {
        return playerLife;
    }

    public void setPlayerLife(int playerLife) {
        this.playerLife = playerLife;
    }

    public int getPlayerAttack() {
        return playerAttack;
    }

    public int getPlayerDefense() {
        return playerDefense;
    }

    public int getHasSword() {
        return hasSword;
    }

    public void setHasSword(int hasSword) {
        this.hasSword = hasSword;
    }

    public int getHasShield() {
        return hasShield;
    }

    public void setHasShield(int hasShield) {
        this.hasShield = hasShield;
    }

    public int getHasLantern() {
        return hasLantern;
    }

    public void setHasLantern(int hasLantern) {
        this.hasLantern = hasLantern;
    }

    public int getHasRope() {
        return hasRope;
    }

    public void setHasRope(int hasRope) {
        this.hasRope = hasRope;
    }

    public int getHasApple() {
        return hasApple;
    }

    public void setHasApple(int hasApple) {
        this.hasApple = hasApple;
    }

    public int getHasBow() {
        return hasBow;
    }

    public void setHasBow(int hasBow) {
        this.hasBow = hasBow;
    }

    public boolean isDefeatgiant() {
        return defeatgiant;
    }

    public void setDefeatgiant(boolean defeatgiant) {
        this.defeatgiant = defeatgiant;
    }

    public boolean isDefeatmutant() {
        return defeatmutant;
    }

    public void setDefeatmutant(boolean defeatmutant) {
        this.defeatmutant = defeatmutant;
    }

    public boolean isDefeatbeast() {
        return defeatbeast;
    }

    public void setDefeatbeast(boolean defeatbeast) {
        this.defeatbeast = defeatbeast;
    }

    public Player(GameManager gm) {
        this.gm = gm;
    }

    public void setPlayerDefaultStatus() {
        playerMaxLife = 5;
        playerLife = 3;
        playerStrength = 3;
        playerEndurance = 1;
        hasSword = 0;
        hasShield = 0;
        hasLantern = 0;
        hasRope = 0;
        hasApple = 0;
        hasBow = 0;
        weaponPower=0;
        shieldPower=0;
        bowPower = 0;
        defeatgiant = false;
        defeatmutant = false;
        defeatbeast = false;

        gm.getsbm().resetMonsterLife(gm.giant);
        gm.ui.changeimage(3,1,250,50,250,320,"AdventureTime/image/giant.png","Look","Talk","Attack","lookMonster","talkMonster","attackMonster");
        gm.getsbm().resetMonsterLife(gm.mutant);
        gm.ui.changeimage(5,1,250,50,250,320,"AdventureTime/image/mutant.png","Look","Talk","Attack","lookMonster2","talkMonster2","attackMonster2");
        gm.getsbm().resetMonsterLife(gm.beast);
        gm.ui.changeimage(7,1,250,40,250,320,"AdventureTime/image/beast.png","Look","Talk","Attack", "LookMonster3", "talkMonster3", "attackMonster3");
        updatePlayerStatus();
    }

    public void updatePlayerStatus() {
        // Remove all life icon
        int i = 1;
        while(i < 6) {
            gm.ui.getLifeLabel()[i].setVisible(false);
            i++;
        }

        int lifeCount = playerLife;
        while(lifeCount != 0) {
            gm.ui.getLifeLabel()[lifeCount].setVisible(true);
            lifeCount--;
        }

        playerAttack = playerStrength + weaponPower + bowPower;
        playerDefense = playerEndurance + shieldPower;

        // Check Player Items

        if(hasSword == 0) {
            gm.ui.swordLabel.setVisible(false);
        }

        if(hasSword == 1) {
            gm.player.weaponPower=3;
            gm.ui.swordLabel.setVisible(true);
        }

        if(hasShield == 0) {
            gm.ui.shieldLabel.setVisible(false);
        }

        if(hasShield == 1) {
            gm.player.shieldPower=1;
            gm.ui.shieldLabel.setVisible(true);
        }

        if(hasLantern == 0) {
            gm.ui.lanternLabel.setVisible(false);
        }

        if(hasLantern == 1) {
            gm.player.shieldPower=1;
            gm.ui.lanternLabel.setVisible(true);
        }

        if(hasRope == 0) {
            gm.ui.ropeLabel.setVisible(false);
        }

        if(hasRope == 1) {
            gm.player.shieldPower=1;
            gm.ui.ropeLabel.setVisible(true);
        }

        if(hasApple == 0) {
            gm.ui.applelabel.setVisible(false);
        }

        if(hasApple == 1) {
            gm.ui.applelabel.setVisible(true);
        }

        if(hasBow == 0) {
            gm.ui.bowlabel.setVisible(false);
        }

        if(hasBow == 1) {
            gm.player.bowPower = 4;
            gm.ui.bowlabel.setVisible(true);
        }

    }

}
