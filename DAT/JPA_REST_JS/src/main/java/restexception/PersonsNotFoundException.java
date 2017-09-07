package restexception;

public class PersonsNotFoundException extends Exception
{
    public PersonsNotFoundException()
    {
    }

    public PersonsNotFoundException(String msg)
    {
        super(msg);
    }
}