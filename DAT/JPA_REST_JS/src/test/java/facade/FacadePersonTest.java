package facade;

import entity.Person;
import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FacadePersonTest
{
    private EntityManagerFactory emf;
    private FacadePerson fp;
    private String PU = "PU_DERBY";
    
    public FacadePersonTest()
    {
        fp = new FacadePerson();
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        System.out.println("SetUp");
        emf = Persistence.createEntityManagerFactory(PU);
        fp.addEntityManagerFactory(emf);
        
        fp.addPerson(new Person("Dan", "Mark", 7654332));
        fp.addPerson(new Person("Kaj", "Olsen", 3456543));
        fp.addPerson(new Person("Jens", "Madsen", 8585888));
    }
    
    @After
    public void tearDown()
    {
        System.out.println("TearDown");
        emf.close();
        HashMap<String, Object> puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema(PU, puproperties);
        Persistence.generateSchema(PU, new HashMap());
    }

    @Test
    public void testGetPerson()
    {
        System.out.println("getPerson");
        Person expResult = new Person("Dan", "Mark", 76543321);
        Person result = fp.getPerson(1l);
        assertEquals(expResult.getFirstName(), result.getFirstName());
    }

    @Test
    public void testGetPersons()
    {
        System.out.println("getPerson");
        Person expResult = new Person("Dan", "Mark", 76543321);
        Person result = fp.getPerson(1l);
        assertEquals(expResult.getFirstName(), result.getFirstName());
    }
    
    @Test
    public void testAddPerson()
    {
        System.out.println("addPerson");
        Person expResult = new Person("Ole", "Larsen", 76543321);
        Person result = fp.addPerson(new Person("Ole", "Larsen", 76543321));
        assertEquals(4, fp.getPersons().size());
    }
    
    @Test
    public void testDeletePerson()
    {
        System.out.println("deletePerson");
        fp.deletePerson(2l);
        assertEquals(2, fp.getPersons().size());
    }
}