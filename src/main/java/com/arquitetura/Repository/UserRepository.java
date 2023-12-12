package com.arquitetura.Repository;

import com.arquitetura.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByName(String name);
    boolean existsById(Integer id);

    User findUserByEmail(String email);
}
