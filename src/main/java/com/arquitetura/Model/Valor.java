package com.arquitetura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity(name = "table_valores")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Valor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Float valorFinal;
    @Column
    private Integer quantParcelas;
    @Column
    private Float ValorFaltante;
    @Column
    private Float ValorRecebido;
}
