package hu.bme.aut.jegyzokonyv.data;

import com.orm.SugarRecord;

public class Player extends SugarRecord<Player> {
    private String name;
    private int number;
    private long team_id;
    private boolean attack=false;
    private boolean defense=false;
    private int buttonId;

    public Player() {

    }

    Player(String name, int number) {
        this.name = name;
        this.number = number;
    }


    public String getName() {
        return name;
    }


    public int getNumber() {
        return number;
    }


    public long getTeam_id() {
        return team_id;
    }

    void setTeam_id(long team_id) {
        this.team_id = team_id;
    }


    int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public void setAttack(boolean attack) {
        this.defense = false;
        this.attack = attack;
    }

    public void setDefense(boolean defense) {
        this.attack = false;
        this.defense = defense;
    }

    public int getActive() {
        if (this.attack) return 1;
        if (this.defense) return 2;
        return 0;
    }

}
