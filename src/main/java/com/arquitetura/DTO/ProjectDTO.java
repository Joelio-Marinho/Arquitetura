package com.arquitetura.DTO;


import com.arquitetura.Model.Cliente;
import com.arquitetura.Model.Enum.ProjectAprovacao;
import com.arquitetura.Model.Enum.ProjectStatus;
import com.arquitetura.Model.Valor;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ProjectDTO {

    private Integer id;
    @NotEmpty
    @NotNull
    private Cliente cliente;
    private ProjectAprovacao aprovacao;
    @NotEmpty
    @Size(min = 4, max = 50)
    private String name;
    private Date dataInicial;
    private Date DateFinal;
    @NotEmpty
    private Valor valor;
    private ProjectStatus finalizado;
}
