package restexception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorMessage
{
    private int code;
    private String message;
    private String description;
    private String stackTrace;
    
    public ErrorMessage(Throwable ex, int code, boolean debug)
    {
        this.code = code;
        this.message = ex.getMessage();
        
        if (debug)
        {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            this.stackTrace = sw.toString();
        }
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setMessage(String message)
    {
        this.message = message;
    } 
}