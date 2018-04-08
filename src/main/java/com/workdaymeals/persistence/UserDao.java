package com.workdaymeals.persistence;

import com.workdaymeals.model.User;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface UserDao {


    @SqlUpdate("INSERT INTO `user` (username, first_name, last_name, password, email, email_bind, mobile, mobile_bind, create_time, update_time, last_login_time, status, is_delete)\n" +
            "VALUES ('happyshihao','shihao', 'shihao', 'afafadfa', 'shihaosun.usc@gmail.com', 1, '2133998198', 0,  now(), now(), now(), 1, 0)s")
    void insert(@BindBean User user);

    @SqlQuery("SELECT * FROM user")
    @RegisterConstructorMapper(User.class)
    List<User> listUsers();

    @SqlQuery("SELECT * FROM user WHERE username = :username")
    @RegisterConstructorMapper(User.class)
    User getUserByUserName(String username);
}