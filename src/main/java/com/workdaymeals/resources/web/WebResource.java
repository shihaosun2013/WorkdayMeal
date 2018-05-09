package com.workdaymeals.resources.web;

import com.google.inject.Inject;
import com.workdaymeals.persistence.UserDao;
import com.workdaymeals.views.IndexView;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/web")
@Singleton
@Produces(MediaType.TEXT_HTML)
@Slf4j
public class WebResource {
    private UserDao userDao;

    @Inject
    public WebResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    public IndexView index() {
        return IndexView.builder().user(userDao.getUserByUserName("happyshihao")).build();
    }
}
