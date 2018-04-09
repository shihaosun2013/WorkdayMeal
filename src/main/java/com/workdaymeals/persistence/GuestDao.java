package com.workdaymeals.persistence;

import com.workdaymeals.model.Guest;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface GuestDao {

    @SqlUpdate("INSERT INTO guest values (:uuid, :deliverAddressId)")
    void insert(@BindBean Guest guest);

    @SqlUpdate("INSERT INTO guest(uuid) values (:uuid)")
    void insertId(@BindBean Guest guest);

    @SqlQuery("SELECT * FROM guest")
    @RegisterConstructorMapper(Guest.class)
    List<Guest> listGuests();

}