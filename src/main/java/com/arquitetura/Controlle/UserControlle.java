package com.arquitetura.Controlle;

import com.arquitetura.DTO.UserDTO;
import com.arquitetura.Exception.BusinessException;
import com.arquitetura.Model.User;
import com.arquitetura.Service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserControlle {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    public UserService getService() {
        return this.userService;
    }

    @GetMapping(value = "/{id}", produces = "Application/json")
    public ResponseEntity<UserDTO> findById(@PathVariable(value = "id") Integer id) throws BusinessException {
        UserDTO user = modelMapper.map(getService().getById(id), UserDTO.class);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity< UserDTO> create(@RequestBody @Valid UserDTO dto) throws BusinessException {
        User entity = modelMapper.map(dto, User.class);
        entity = userService.created(entity);
        UserDTO userDTO =  modelMapper.map(entity,UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}", produces = "Application/json")
    public ResponseEntity<UserDTO> update(@Valid
                                            @PathVariable("id") Integer id,
                                            @RequestBody UserDTO dto) throws BusinessException {
        User entity = modelMapper.map(dto, User.class);
        entity = userService.update(id, entity);
        UserDTO userDTO = modelMapper.map(entity, UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) throws BusinessException {
        userService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
