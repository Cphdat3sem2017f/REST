package rest;

import entity.Person;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("person/person")
public class PersonResource
{
    @Context
    private UriInfo context;

    @Context
    HttpHeaders headers;

    public PersonResource()
    {
    }

    @Path("p")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson()
    {
        return "{\"STATUS\":\"GET\"}";
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content, @PathParam("id") int id, @DefaultValue("Worker") @QueryParam("job") String job)
    {
        System.out.println(content);
        System.out.println(id);
        System.out.println(job);

        System.out.println(context.getQueryParameters().toString());
        System.out.println(context.getQueryParameters().get("job"));

        System.out.println(headers.getMediaType());

        return "{\"MESSAGE\":\"PUT\"}";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(String content)
    {
        Person p = new Gson().fromJson(content, Person.class);
        
        System.out.println(p);
        System.out.println(p.getLastName());
        
        return new Gson().toJson(p);
    }
}
