package com.arquitetura.Repository;

import com.arquitetura.Model.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorRepository  extends JpaRepository<Valor, Integer> {
}
