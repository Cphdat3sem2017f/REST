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

    public void addEntityManagerFactory(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public Person getPerson(Long id)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            Person p = em.find(Person.class, id);
            return em.find(Person.class, id);    
        }
        finally
        {
            em.close();
        }
    }
    
    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            return em.createQuery("SELECT p FROM Person p").getResultList();
        }
        finally
        {
            em.close();
        }
    }
    
    public Person addPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return person;
        }
        finally
        {
            em.close();
        }
    }
    
    public Person editPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, person.getId());
            if(p != null)
            {
                p = person;
                em.merge(p);
                em.getTransaction().commit();
                return p;
            }
        }
        finally
        {
            em.close();
        }  
        
        return null;
    }
    
    public Person deletePerson(Long id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
}