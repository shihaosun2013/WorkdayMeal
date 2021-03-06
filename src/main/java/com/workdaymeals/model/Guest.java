package com.workdaymeals.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
public class Guest {
    private long uuid;
    @ColumnName("deliver_address_id")
    private String deliverAddressId;
}
