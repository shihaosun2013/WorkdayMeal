package com.workdaymeals.persistence;

import com.workdaymeals.model.User;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.BindFields;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDao {


    @SqlUpdate("INSERT INTO user(username, first_name, last_name, password, email, email_bind, mobile, mobile_bind, create_time, update_time, last_login_time, status, is_delete) " +
            "VALUES (:username, :firstName, :lastName', :password, :email, :emailBind, :mobile, :mobileBind, :createTime, :updateTime, :lastLoginTime, :status, :isDelete)")
    void insert(@BindFields User user);

    @SqlQuery("SELECT * FROM user")
    @RegisterConstructorMapper(User.class)
    List<User> listUsers();

    @SqlQuery("SELECT * FROM user WHERE username = :username")
    @RegisterConstructorMapper(User.class)
    User getUserByUserName(String username);
}