package org.example.resources;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.dao.UserDao;
import org.example.domain.User;

import org.example.util.KeyGenerator;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import static java.time.LocalDateTime.now;


@Produces(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

    @Inject private UserDao dao;

    @Inject private KeyGenerator keyGenerator;

    @Context
    private UriInfo uriInfo;


    @GET
    public Response getAll() {
        return Response.ok(dao.getAll()).build();
    }

    @Path("/register")
    @POST
    public Response create(User user) {
        dao.create(user);
        return Response.ok().build();
    }

    @Path("/login")
    @POST
    public Response authenticateUser(User user){
        try {
            String username = user.getUsername();
            String password = user.getPassword();

            dao.authenticate(username, password);
            String token = issueToken(username);

            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        System.out.println("#### generating token for a key : " + jwtToken + " - " + key);
        return jwtToken;
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
