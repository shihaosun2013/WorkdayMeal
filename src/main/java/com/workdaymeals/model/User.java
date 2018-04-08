package com.workdaymeals.model;

import lombok.*;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.beans.ConstructorProperties;
import java.sql.Timestamp;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
public class User {
    @NonNull
    private long uuid;
    @NonNull
    private String username;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String nickname;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String emailBind;
    @NonNull
    private String mobile;
    @NonNull
    private String mobileBind;
    private String avatar;
    private String sex;
    private String registerIp;
    @NonNull
    private Timestamp createTime;
    @NonNull
    private Timestamp updateTime;
    @NonNull
    private Timestamp lastLoginTime;
    private long lastLoginIp;
    @NonNull
    // status?0-banned?1-active?2-pending activate
    private long status;
    @NonNull
    private long isDelete;
    // 0-not audit; 1-auditing; 2-pass; 3-reject
    private long examStatus;
    private String area;
    private String zipCode;
    private String deliverAddressId;
}