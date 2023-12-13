package com.arquitetura.Controlle;

import com.arquitetura.DTO.AddressDTO;
import com.arquitetura.Exception.BusinessException;
import com.arquitetura.Model.Address;
import com.arquitetura.Service.AddressService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private ModelMapper modelMapper;

    public AddressService getService() {
        return this.addressService;
    }

    @GetMapping(value = "/{id}", produces = "Application/json")
    public ResponseEntity<AddressDTO> findById(@PathVariable(value = "id") Integer id) throws BusinessException {
        AddressDTO addressDTO = modelMapper.map(getService().getById(id), AddressDTO.class);

        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity< AddressDTO> create(@RequestBody @Valid AddressDTO dto) throws BusinessException {
        Address entity = modelMapper.map(dto, Address.class);
        entity = addressService.create(entity);
        AddressDTO addressDTO =  modelMapper.map(entity,AddressDTO.class);
        return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}", produces = "Application/json")
    public ResponseEntity<AddressDTO> update(@Valid
                                          @PathVariable("id") Integer id,
                                          @RequestBody AddressDTO dto) throws BusinessException {
        Address entity = modelMapper.map(dto, Address.class);
        entity = addressService.update(id, entity);
        AddressDTO addressDTO = modelMapper.map(entity, AddressDTO.class);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) throws BusinessException {
        addressService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
