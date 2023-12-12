package com.arquitetura.DTO;

import com.arquitetura.Model.Address;
import com.arquitetura.Model.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class UserDTO {
    private Integer id;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 8, max =10)
    private String senha;
    @NotNull
    @Email(message = "{email.invalid}")
    private String email;
    private Integer fone;
    private AddressDTO address;

}
