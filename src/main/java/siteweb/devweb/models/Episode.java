package siteweb.devweb.models;

import siteweb.devweb.daos.EpisodeDao;

import java.util.List;

public class Episode{
    private Integer episode_id;
    private int parution,avis,personnage_id;
    private String titre,resume;


    public Episode(Integer episode_id, int parution, int avis, String resume, int personnage_id){
        this.episode_id= episode_id;

        this.titre=titre;
        this.resume=resume;
        this.parution=parution;
        this.avis=avis;
        this.personnage_id= personnage_id;

    }


    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(Integer episode_id) {
        this.episode_id = episode_id;
    }

    public int getParution() {
        return parution;
    }

    public void setParution(int parution) {
        this.parution = parution;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPersonnage_id()
    {
        return personnage_id;
    }

    public void setPersonnage_id(int personnage_id)
    {
        this.personnage_id = personnage_id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis=avis;
    }

}
