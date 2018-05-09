package com.workdaymeals.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.workdaymeals.config.WorkdayMealsConfig;
import com.workdaymeals.module.WorkdayMealsModule;
import com.workdaymeals.resources.rest.GuestResource;
import com.workdaymeals.resources.rest.UserResource;
import com.workdaymeals.resources.web.WebResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkdayMealsApp extends Application<WorkdayMealsConfig> {

    public static void main(String[] args) throws Exception {
        new WorkdayMealsApp().run(args);
    }

    @Override
    public void run(WorkdayMealsConfig config, Environment env) {
        Injector injector = Guice.createInjector(getModules(config, env));
        env.jersey().register(injector.getInstance(UserResource.class));
        env.jersey().register(injector.getInstance(GuestResource.class));
        env.jersey().register(injector.getInstance(WebResource.class));
//        env.jersey().register(new BasicAuthProvider<>(new ExampleAuthenticator(), "SECURITY REALM"));

/*        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(env, config.getDataSourceFactory(), "mysql");
        jdbi.installPlugin(new SqlObjectPlugin());*/

    }

    @Override
    public void initialize(Bootstrap<WorkdayMealsConfig> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/assets/css", null, "assets/css"));
        bootstrap.addBundle(new AssetsBundle("/assets/img", "/assets/img", null, "assets/img"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/assets/js", null, "assets/js"));

        bootstrap.addBundle(new ViewBundle<WorkdayMealsConfig>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(WorkdayMealsConfig config) {
                return config.getViewConfig();
            }
        });
    }

    private List<Module> getModules(WorkdayMealsConfig config, Environment env) {
        List<Module> modules = new ArrayList<Module>();
        modules.add(new WorkdayMealsModule(config, env));
        return modules;
    }
}