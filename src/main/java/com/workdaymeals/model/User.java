package com.workdaymeals.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.sql.Timestamp;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
public class User {
//    @NonNull
    private long uuid;
//    @NonNull
    private String username;
//    @NonNull
    @ColumnName("first_name")
    private String firstName;
//    @NonNull
    @ColumnName("last_name")
    private String lastName;
    private String nickname;
//    @NonNull
    private String password;
//    @NonNull
    private String email;
//    @NonNull
    @ColumnName("email_bind")
    private Boolean emailBind;
//    @NonNull
    private String mobile;
//    @NonNull
    @ColumnName("mobile_bind")
    private Boolean mobileBind;
    private String avatar;
    private String sex;
    private String registerIp;
//    @NonNull
    @ColumnName("create_time")
    private Timestamp createTime;
//    @NonNull
    @ColumnName("update_time")
    private Timestamp updateTime;
//    @NonNull
    @ColumnName("last_login_time")
    private Timestamp lastLoginTime;
    @ColumnName("last_login_ip")
    private long lastLoginIp;
//    @NonNull
    // status?0-banned?1-active?2-pending activate
    private long status;
//    @NonNull
    @ColumnName("is_delete")
    private Boolean isDelete;
    // 0-not audit; 1-auditing; 2-pass; 3-reject
    @ColumnName("exam_status")
    private long examStatus;
    private String area;
    @ColumnName("zip_code")
    private String zipCode;
    @ColumnName("deliver_address_id")
    private String deliverAddressId;
}