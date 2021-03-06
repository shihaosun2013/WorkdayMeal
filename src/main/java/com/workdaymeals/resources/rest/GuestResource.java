package com.workdaymeals.resources.rest;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.workdaymeals.model.Guest;
import com.workdaymeals.persistence.GuestDao;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/guest")
@Singleton
@Slf4j
//@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__({@Inject}))
public class GuestResource {

    private final Jdbi jdbi;

    @Inject
    public GuestResource(@Named("jdbi") Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guest> getGuests() {
        return jdbi.withExtension(GuestDao.class, dao -> {
            return dao.listGuests();
        });
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addUser(Guest guest) {
        jdbi.useExtension(GuestDao.class, dao -> {
            dao.insert(guest);
        });
        return "Success!";
    }

    @POST
    @Timed
    @Path("/post")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addUserId(Guest guest) {
        jdbi.useExtension(GuestDao.class, dao -> {
            dao.insertId(guest);
        });
        return "Success!";
    }

}
