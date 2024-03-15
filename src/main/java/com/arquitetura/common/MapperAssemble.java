package com.arquitetura.common;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MapperAssemble {
    private ModelMapper modelMapper;

    public <M> M toModel(Object dto, Class<M> model) {
        return modelMapper.map(dto, model);
    }

    public <T> T toDto(Object model, Class<T> dto) {
        return modelMapper.map(model, dto);
    }
}
