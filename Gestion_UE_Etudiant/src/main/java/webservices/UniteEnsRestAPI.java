package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/ue")
public class UniteEnsRestAPI {
    //helper:instance that will help this class to manipulate data :CRUD
    UniteEnseignementBusiness helper= new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //get List UEs
    public Response getListUEs(){
        return Response.status(200).entity(helper.getListeUE()).build();
    }
}
