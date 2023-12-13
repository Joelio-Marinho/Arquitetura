package com.arquitetura.DTO;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    private String street;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String city;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String state;

    @NotEmpty(message = "{address.cep}")
    @Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "{address.cep}")
    private String cep;
}
