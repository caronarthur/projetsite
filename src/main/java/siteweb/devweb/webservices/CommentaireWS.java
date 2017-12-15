package siteweb.devweb.webservices;

import com.google.gson.Gson;
import siteweb.devweb.services.CommentaireService;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;




@Path("/commentaire")
public class CommentaireWS {

    @Path("/add")
    @POST
    public Response addEpisode(@FormParam("user") String user, @FormParam("email") String email, @FormParam("message") String message) {
        try {
            Gson jsonParser = new Gson();
            return Response.status(200).entity(jsonParser.toJson(CommentaireService.getInstance().addCommentaire(user,email,message))).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

