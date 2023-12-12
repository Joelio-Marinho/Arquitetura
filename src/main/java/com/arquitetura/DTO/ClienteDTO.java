package com.arquitetura.DTO;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ClienteDTO {
    private Integer id;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 9, max =11)
    private Integer telefone;
    @NotNull
    private String email;
    private AddressDTO address;
}
