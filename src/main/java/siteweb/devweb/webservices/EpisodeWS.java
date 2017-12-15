package siteweb.devweb.webservices;

import javax.ws.rs.FormParam;
import com.google.gson.Gson;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import siteweb.devweb.models.Episode;
import siteweb.devweb.services.EpisodeService;


@Path("/episode")
public class EpisodeWS {

    @Path("")
    @POST
    public javax.ws.rs.core.Response deleteEpisode(@FormParam("id") Integer episode_id) {
        try {
            Gson jsonParser = new Gson();
            return javax.ws.rs.core.Response.status(200).entity(jsonParser.toJson(EpisodeService.getInstance().deleteEpisode(episode_id)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Path("/add")
    @POST
    public javax.ws.rs.core.Response addEpisode(@FormParam("titre") String titre, @FormParam("parution") int parution,
                                                @FormParam("personnage") String personnage, @FormParam("avis") int avis) {
        try {
            Gson jsonParser = new Gson();
            return javax.ws.rs.core.Response.status(200).entity(jsonParser.toJson(EpisodeService.getInstance().addEpisode(titre,parution,personnage, avis)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Path("modifier")
    @POST
    public javax.ws.rs.core.Response modifierEpisode(@FormParam("episode_id") Integer episode_id, @FormParam("titre") String titre, @FormParam("parution") int parution,
                                                     @FormParam("avis") int avis) {
        try {
            Gson jsonParser = new Gson();
            return javax.ws.rs.core.Response.status(200).entity(jsonParser.toJson(EpisodeService.getInstance().modifierEpisodes(episode_id,titre,parution,avis)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
