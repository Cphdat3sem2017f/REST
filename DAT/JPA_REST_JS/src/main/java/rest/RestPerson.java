package rest;

import entity.Person;
import facade.FacadePerson;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import deploy.DeploymentConfiguration;
import java.util.List;
import restexception.PersonsNotFoundException;

@Path("person")
public class RestPerson
{
    private FacadePerson fp;
    private Gson gson;

    public RestPerson()
    {
        fp = new FacadePerson();
        fp.addEntityManagerFactory(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
        gson = new Gson();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public String getPersons() throws PersonsNotFoundException
    {
        List<Person> persons = fp.getPersons();
        
        if(persons.size() != 0)
        {
            return new Gson().toJson(persons);
        }
        else
        {
            throw new PersonsNotFoundException();
        }
    }
           
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getPerson(@PathParam("id") Long id)
    {
        Person p = fp.getPerson(id);
        if(p != null)
        {
            return new Gson().toJson(p);
        }
        
        return "{}";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postPerson(String content)
    {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        String PersonFirstName = "";
        String PersonLastName = "";
        int PersonPhoneNumber = 0;
    
        if(body.has("firstName"))
        {
            PersonFirstName = body.get("firstName").getAsString();
        }
        if(body.has("lastName"))
        {
            PersonLastName = body.get("lastName").getAsString();
        }
        if(body.has("phoneNumber"))
        {
            PersonPhoneNumber = body.get("phoneNumber").getAsInt();
        }       

        Person p = new Person(PersonFirstName, PersonLastName, PersonPhoneNumber);
        fp.addPerson(p);
        
        return new Gson().toJson(p);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putPerson(String content)
    {
        JsonObject body = new JsonParser().parse(content).getAsJsonObject();
        Person p = fp.getPerson(body.get("id").getAsLong());
        
        if(body.has("firstName"))
        {
            p.setFirstName(body.get("firstName").getAsString());
        }
        if(body.has("lastName"))
        {
            p.setLastName(body.get("lastName").getAsString());
        }
        if(body.has("phoneNumber"))
        {
            p.setPhoneNumber(body.get("phoneNumber").getAsInt());
        }       

        fp.editPerson(p);
        
        return new Gson().toJson(p);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String deletePerson(@PathParam("id") Long id)
    {
        Person p = fp.deletePerson(id);
        
        return new Gson().toJson(p);
    }
}