package Game;

/**
 * Created by Yentl-PC on 8/11/2016.
 */
public class Vijand {
    //region Instance Variables

    private int nr;
    private String naam;
    private String beschrijving;
    private int hp = 100;
    private int kracht = 10;
    private String uiterlijk;
    private int experience = 100;
    private int score = 1000;

    //endregion

    //region Constructors

    public Vijand (int nr, String naam, String beschrijving, int hp, int kracht, String uiterlijk, int experience, int score){
        this.nr = nr;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.hp = hp;
        this.kracht = kracht;
        this.uiterlijk = uiterlijk;
        this.experience = experience;
        this.score = score;
    }

    public Vijand () {
        this.nr = 0;
        this.naam = "Placeholder";
        this.beschrijving = "Placeholder";
        this.uiterlijk = "Vierkant";
    }

    //endregion
}
