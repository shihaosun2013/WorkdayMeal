package com.workdaymeals.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.workdaymeals.model.User;
import com.workdaymeals.persistence.UserDao;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;

import javax.inject.Singleton;
import javax.ws.rs.*;
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
        return jdbi.withExtension(UserDao.class, dao -> {
            return dao.getUserByUserName(username);
        });
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return jdbi.withExtension(UserDao.class, dao -> {
            return dao.listUsers();
        });
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addUser(User user) {
        jdbi.useExtension(UserDao.class, dao -> {
            dao.insert(user);
        });
        return "Success!";
    }

    @PUT
    @Timed
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String updateUser(User user) {
        jdbi.useExtension(UserDao.class, dao -> {
            dao.update(user);
        });
        return "Success!";
    }
}
