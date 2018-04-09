a profile description, a phone number, 3 event pictures or more, a complete address (street number, street)


Authentication:
http://javaeeeee.blogspot.com/2015/02/getting-started-with-dropwizard.html


 sudo /usr/local/mysql/support-files/mysql.server stop


 mvn liquibase:updateSQL
mvn liquibase:generateChangeLog
mvn liquibase:update

mvn liquibase:clearCheckSums
mvn liquibase:dropAll liquibase:update



Write code
Find you need a database change
Append new changeSet to db.changelog.xml
liquibase.bat update
Test code and database
Repeat 1-4 as necessary
Update local codebase from version control
liquibase.bat update to apply changes from other developers
Repeat 1-8 as necessary
Commit your code and db.changelog.xml to version control
When ready, update QA database with db.changelog.xml built up during development
When ready, update production database with db.changelog.xml built up during development


https://github.com/benjamin-bader/droptools/tree/master/dropwizard-jooq



List<UserJDBI> userNames = jdbi.withExtension(UserJDBIDao.class, dao -> {
            System.out.println(1123);
            dao.dropTable();
            dao.createTable();

            dao.insertPositional(0, "Alice");
            dao.insertPositional(1, "Bob");

            List<String> names = jdbi.withHandle(handle -> handle.createQuery("select name from user")
                    .mapTo(String.class)
                    .list());
            System.out.println(names);

            Handle handle = jdbi.open();
            Optional<String> name = handle.createQuery("select name from user where id = :id")
                    .bind("id", 1)
                    .mapTo(String.class)
                    .findFirst();

            System.out.println(name.get());
            dao.insertNamed(2, "Clarice");


            handle.registerRowMapper(ConstructorMapper.factory(UserJDBI.class));
            Set<UserJDBI> userSet = handle.createQuery("SELECT * FROM user ORDER BY id ASC")
                    .mapTo(UserJDBI.class)
                    .collect(Collectors.toSet());
            System.out.println(userSet);


//            handle.registerRowMapper(BeanMapper.factory(UserJDBI.class));
//            List<UserJDBI> users = handle
//                    .createQuery("select id, name from user")
//                    .mapToBean(UserJDBI.class)
//                    .list();
//
//            System.out.println(users.size());

            System.out.println(dao.findName(1).get());
            UserJDBI user = dao.getUser(1);

            System.out.println(dao.listUsers());
            return dao.listUsers();
        });



public List<User> getAll() {
        return ImmutableList.of(User.builder().userName("happyshihao").build());
    }

    public User getById(int id) {
        return User.builder().userName("happyshihao").build();
    }

    public String getCount() {
        return "7";
    }

    public void remove() {
    }

    public String save(User person) {
        return "Done";
    }


https://xvik.github.io/dropwizard-guicey/4.1.0/getting-started/




    @SqlUpdate("INSERT INTO user(id, name) VALUES (?, ?)")
    void insertPositional(int id, String name);

    @SqlUpdate("INSERT INTO user(id, name) VALUES (:id, :name)")
    void insertNamed(@Bind("id") int id, @Bind("name") String name);

    @SqlUpdate("INSERT INTO `user` (username, first_name, last_name, password, email, email_bind, mobile, mobile_bind, create_time, update_time, last_login_time, status, is_delete)\n" +
                "VALUES ('happycora','shihao', 'shihao', 'afafadfa', 'shihaosun.usc@gmail.com', 1, '2133998198', 0,  now(), now(), now(), 1, 0)")
        void insert(@BindBean User user);