package com.workdaymeals.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.NonNull;

import javax.validation.Valid;
import java.util.Map;

public class WorkdayMealsConfig extends Configuration {
    @NonNull
    private String version;
    private Map<String, Map<String, String>> viewConfig;
    @Valid
    @NonNull
    private DataSourceFactory database = new DataSourceFactory();

    public Map<String, Map<String, String>> getViewConfig() {
        return viewConfig;
    }

    @JsonProperty
    public String getVersion() {
        return version;
    }

    @JsonProperty
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }
}