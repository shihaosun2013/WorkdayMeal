package com.workdaymeals.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
public class Test {
    private int id;
    private String name;
}
