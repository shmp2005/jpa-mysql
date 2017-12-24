package com.zhongba01.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    /**
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    User findById(long id);
}
