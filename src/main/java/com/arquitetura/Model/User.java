package com.arquitetura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity(name = "table_users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private Integer fone;
    @Column(name = "email", unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "Endereco_id",referencedColumnName = "id")
    private Address address;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
