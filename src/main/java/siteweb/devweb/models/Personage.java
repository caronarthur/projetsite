package siteweb.devweb.models;


public class Personage {
    private int personnage_id;
    private String personnage_name;

    public Personage(int personnage_id, String personnage_name){
        this.personnage_id=personnage_id;
        this.personnage_name=personnage_name;
    }

    public int getPersonnage_id() {
        return personnage_id;
    }

    public void setPersonnage_id(int personnage_id)
    {
        this.personnage_id = personnage_id;
    }

    public String getPersonnage_name()
    {
        return personnage_name;
    }

    public void setPersonnage_name(String genre_name) {
        this.personnage_name = genre_name;
    }


}
