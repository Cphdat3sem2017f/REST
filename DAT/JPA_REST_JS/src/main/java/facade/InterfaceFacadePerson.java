package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface InterfaceFacadePerson
{
    public void addEntityManagerFactory(EntityManagerFactory emf);        
    public EntityManager getEntityManager();
    public Person addPerson(Person p);
    public Person deletePerson(Long id);
    public Person getPerson(Long id);
    public List<Person> getPersons();
    public Person editPerson(Person p);
}
