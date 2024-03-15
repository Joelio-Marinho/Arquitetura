package com.arquitetura.Model;

import com.arquitetura.Model.Enum.ProjectAprovacao;
import com.arquitetura.Model.Enum.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;
@Data
@Entity(name= "table_projects")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Cliente",referencedColumnName = "id")
    private User Id_Cliente;

    @Column
    private ProjectAprovacao aprovacao;

    @Column
    private String name;

    @Column
    private OffsetDateTime dataInicial;

    @Column
    private OffsetDateTime DateFinal;

    @OneToOne
    @JoinColumn(name = "Id_Valor")
    private Valor valor;

    @Column
    private ProjectStatus finalizado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Endereço",referencedColumnName = "id")
    private Address Id_Endereço;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_User",referencedColumnName = "id")
    private User Id_User;

}
