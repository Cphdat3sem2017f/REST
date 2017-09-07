package rest;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources)
    {
        resources.add(rest.RestPers.class);
        resources.add(rest.RestPerson.class);
        resources.add(restexception.NotFoundExceptionMapper.class);
        resources.add(restexception.PersonsNotFoundExceptionMapper.class);
        resources.add(restexception.RuntimeExceptionMapper.class);
    }
}
