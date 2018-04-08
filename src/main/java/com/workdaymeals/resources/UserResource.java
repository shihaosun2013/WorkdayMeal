package com.workdaymeals.resources;

import com.codahale.metrics.annotation.Timed;
import com.workdaymeals.model.User;
import com.workdaymeals.persistence.UserDao;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.google.inject.Inject;
import org.jdbi.v3.core.Jdbi;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Singleton
@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__({@Inject}))
public class UserResource {

    private final Jdbi jdbi;

    @GET
    @Timed
    @Path("/get/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("username") String username) {
        return jdbi.withExtension(UserDao.class, dao -> { return dao.getUserByUserName(username); });
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return jdbi.withExtension(UserDao.class, dao -> {   return dao.listUsers(); });
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public void addUser(User person) {
        jdbi.useExtension(UserDao.class, dao -> {dao.insert(person); });
    }
}
