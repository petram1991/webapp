package org.example.resources;

import org.example.dao.IContactDao;
import org.example.domain.Contact;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Produces(MediaType.APPLICATION_JSON)
@Path("/contacts")
public class ContactsResource {

    @Inject
    private IContactDao dao;

    @GET
    public Collection<Contact> getAll(@QueryParam("q") String q) {
        return q == null ? dao.getAll() : dao.get(q);
    }

    @POST
    public  Contact post(Contact c){
    dao.add(c);
        return c;
    }
}
