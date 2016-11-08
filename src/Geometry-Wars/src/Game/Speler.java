package Game;

/**
 * Created by Yentl-PC on 8/11/2016.
 */
public class Speler {
    //region Instance Variables
    private int spelernr;
    private String gebruikersnaam;
    private String wachtwoord;
    private String email;
    private int level = 1;
    private int experience = 0;
    private String profielfoto = "";
    private int rank = 0;
    private int nuggets = 0;
    private int gnuggets = 0;
    private int hp = 100;
    private int kracht = 10;
    //endregion

    //region Constructors

    public Speler(int spelernr, String gebruikersnaam, String wachtwoord, String email){
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.email = email;
    }

    public Speler(){
        this.spelernr = 0;
        this.gebruikersnaam = "Placeholder";
        this.wachtwoord = "Placeholder";
        this.email = "Placeholder@placeholder.com";
    }

    //endregion

    //region Properties

    public void setProfielfoto(String profielfoto) {
        this.profielfoto = profielfoto;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    //endregion

    //region Behaviour

    public void levelUp() {
        this.level += 1;
    }

    public void experienceUp(int amount) {
        this.experience += amount;
    }

    public void addNuggets(int amount) {
        this.nuggets += amount;
    }

    public void addGNuggets(int amount) {
        this.gnuggets += amount;
    }

    public void addKracht(int amount) {
        this.kracht += amount;
    }

    public void addHp(int amount) {
        this.hp += amount;
    }

    //endregion
}