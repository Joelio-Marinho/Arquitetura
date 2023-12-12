package com.arquitetura.Repository;

import com.arquitetura.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByName(String name);
    boolean existsById(Integer id);
}
