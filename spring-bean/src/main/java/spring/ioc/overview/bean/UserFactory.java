package spring.ioc.overview.bean;

import spring.ioc.overview.dependency.dimain.User;

public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
