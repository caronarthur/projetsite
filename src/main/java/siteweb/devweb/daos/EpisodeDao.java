package siteweb.devweb.daos;

import java.util.List;


import siteweb.devweb.models.Episode;
import siteweb.devweb.models.Personage;

public interface EpisodeDao {
    List<Episode> listEpisodes(Personage personnage);
    public Episode getEpisode(Integer id);
    public Episode addEpisode(Episode episode);
    public Integer deleteEpisode(Integer episode_id);
    public List<Episode> listeDerniersEpisodesAjoutés();
    public List<Episode> episodesMieuxNotés();
    public Integer modifierEpisode(Integer id, String titre, Integer parution, Integer avis);
    
}

