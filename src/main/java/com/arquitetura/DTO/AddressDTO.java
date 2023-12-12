package com.arquitetura.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String Street;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String city;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String state;
}
