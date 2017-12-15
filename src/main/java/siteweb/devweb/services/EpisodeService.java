package siteweb.devweb.services;


import java.util.List;



import siteweb.devweb.dao.impl.EpisodeDaoImpl;
import siteweb.devweb.dao.impl.PersonnageDaoImpl;
import siteweb.devweb.daos.EpisodeDao;
import siteweb.devweb.daos.PersonnageDao;
import siteweb.devweb.models.Episode;
import siteweb.devweb.models.Personage;

public class EpisodeService {
    private EpisodeDao episodeDao= new EpisodeDaoImpl();
    private PersonnageDao personnageDao=new PersonnageDaoImpl();
    private static class EpisodeServiceHolder{
        private static EpisodeService instance=new EpisodeService();
    }

    public static EpisodeService getInstance(){
        return EpisodeServiceHolder.instance;
    }

    private EpisodeService(){
    }

    public List<Episode> listEpisodes(Personage personnage){
        return episodeDao.listEpisodes(personnage);
    }

    public Episode addEpisode(String titre,int parution,
                              String personnage, int avis){
        Personage newPersonnage = personnageDao.getPersonnageWithName(personnage);
        int newPersonnage_id =newPersonnage.getPersonnage_id();
        Episode newEpisode= new Episode(null, parution, avis, "mock", newPersonnage_id);
        return episodeDao.addEpisode(newEpisode);

    }
    public Episode getEpisode(Integer id){
        return episodeDao.getEpisode(id);
    }

    public Integer deleteEpisode(Integer episode_id)
    {
        return episodeDao.deleteEpisode(episode_id);
    }

    public List<Episode> listDerniersEpisodesAjoutés()
    {
        return episodeDao.listeDerniersEpisodesAjoutés();
    }

    public List<Episode> episodesMieuxNotés()
    {
        return episodeDao.episodesMieuxNotés();
    }

    public Integer modifierEpisodes(Integer id,String titre,Integer parution, Integer avis){
        return episodeDao.modifierEpisode(id,titre,parution,avis);
    }

}
