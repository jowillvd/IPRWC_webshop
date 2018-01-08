package nl.hsleiden.service;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import nl.hsleiden.model.Gebruiker;

/**
 *
 * @author Peter van Vliet
 * @param <T>
 */
public class BaseService<T>
{
    public T requireResult(T model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }
        
        return model;
    }
    
    public void assertSelf(Gebruiker user1, Gebruiker user2)
    {
        if (!user1.equals(user2))
        {
            throw new ForbiddenException();
        }
    }
}
