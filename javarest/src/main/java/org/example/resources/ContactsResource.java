package org.example.resources;

import org.example.dao.ContactDaoDb;
import org.example.domain.Contact;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Produces(MediaType.APPLICATION_JSON)
@Path("/contacts")
public class ContactsResource {

    @Inject
    private ContactDaoDb dao;

    @GET
    public Response getAll() {
        return Response.ok(dao.getAll()).build();
    }

    @POST
    public Response create(Contact c) {
        dao.create(c);
        return Response.ok().build();
    }

    @GET
    @Path("{id}")
    public Response getContact(@PathParam("id") Long id) {
        Contact c = dao.findById(id);

        return Response.ok(c).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Contact c) {
        Contact updateContact = dao.findById(id);

        updateContact.setFirstName(c.getFirstName());
        updateContact.setSurname(c.getSurname());
        updateContact.setEmail(c.getEmail());
        dao.update(updateContact);

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Contact getContact = dao.findById(id);

        dao.delete(getContact);

        return Response.ok().build();
    }
}
