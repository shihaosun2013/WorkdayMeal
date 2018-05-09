package com.workdaymeals.views;

import com.workdaymeals.model.User;
import lombok.Builder;


public class IndexView extends BaseView {
    private final User user;
    @Builder
    protected IndexView(User user) {
        super("index.ftl");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
