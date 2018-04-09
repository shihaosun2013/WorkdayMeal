package com.workdaymeals.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.workdaymeals.config.WorkdayMealsConfig;
import com.workdaymeals.module.WorkdayMealsModule;
import com.workdaymeals.resources.GuestResource;
import com.workdaymeals.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;

public class WorkdayMealsApp extends Application<WorkdayMealsConfig> {

    public static void main(String[] args) throws Exception {
        new WorkdayMealsApp().run(args);
    }

    @Override
    public void run(WorkdayMealsConfig config, Environment env) {
        Injector injector = Guice.createInjector(getModules(config, env));
        env.jersey().register(injector.getInstance(UserResource.class));
        env.jersey().register(injector.getInstance(GuestResource.class));

/*        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(env, config.getDataSourceFactory(), "mysql");
        jdbi.installPlugin(new SqlObjectPlugin());*/

    }

    private List<Module> getModules(WorkdayMealsConfig config, Environment env) {
        List<Module> modules = new ArrayList<Module>();
        modules.add(new WorkdayMealsModule(config, env));
        return modules;
    }
}