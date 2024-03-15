package com.arquitetura.DTO;

import com.arquitetura.Model.Address;
import com.arquitetura.Model.Enum.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 8, max =10)
    private String password;

    private String fone;

    @NotNull
    @Email(message = "{email.invalid}")
    private String email;

    private Role role;

    private Address address;
}
