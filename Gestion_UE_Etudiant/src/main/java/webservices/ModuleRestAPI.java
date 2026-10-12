package webservices;

import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import entities.Module;

@Path("/module")
public class ModuleRestAPI {

    static ModuleBusiness helper = new ModuleBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules() {
        return Response.status(200)
                .entity(helper.getAllModules())
                .build();
    }
    @Path("/new")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createModule(Module module) {
        if (helper.addModule(module)) {
            return Response.status(201).entity("ok").build();
        } else {
            return Response.status(400).entity("error").build();
        }
    }
    @Path("/matricule/{matricule}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByMatricule(
            @PathParam("matricule") String matricule) {

        Module module = helper.getModuleByMatricule(matricule);

        if (module != null) {
            return Response.status(200)
                    .entity(module)
                    .build();
        } else {
            return Response.status(404)
                    .entity("Module non trouvé")
                    .build();
        }
    }
    @Path("/type/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModulesByType(
            @PathParam("type") Module.TypeModule type) {

        return Response.status(200).entity(helper.getModulesByType(type)).build();
    }
    @Path("/update/{matricule}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateModule(
            @PathParam("matricule") String matricule,
            Module module) {

        if (helper.updateModule(matricule, module)) {
            return Response.status(200)
                    .entity("Module modifié avec succès")
                    .build();
        } else {
            return Response.status(404)
                    .entity("Module non trouvé")
                    .build();
        }
    }

}