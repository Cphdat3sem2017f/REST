package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FacadePerson implements InterfaceFacadePerson
{
    EntityManagerFactory emf;
    
    public FacadePerson()
    {
    }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    @Override
    public Person getPerson(Long id)
    {
        EntityManager em = emf.createEntityManager();
        
        Person p;
        
        try
        {
            p = em.find(Person.class, id);
        }
        finally
        {
            em.close();
        }
        
        return p;    
    }
    
    @Override
    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();
        
        List<Person> persons;
        
        try
        {
            persons = em.createQuery("SELECT p FROM Person p").getResultList();
        }
        finally
        {
            em.close();
        }
        
        return persons;
    }
    
    @Override
    public Person addPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
        
        return person;
    }
    
    @Override
    public Person editPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();

        Person p;
        
        try
        {
            em.getTransaction().begin();
            p = em.find(Person.class, person.getId());
            if(p != null)
            {
                p = person;
                em.merge(p);
                em.getTransaction().commit();
            }
        }
        finally
        {
            em.close();
        }  
        
        return p;
    }
    
    @Override
    public Person deletePerson(Long id)
    {
        EntityManager em = emf.createEntityManager();

        Person p;
        
        try
        {
            em.getTransaction().begin();
            p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
        
        return p;
    }
}