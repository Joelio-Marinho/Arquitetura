package com.arquitetura.Service;

import com.arquitetura.DTO.ClienteDTO;
import com.arquitetura.DTO.UserDTO;
import com.arquitetura.Exception.BusinessException;
import com.arquitetura.Model.Cliente;
import com.arquitetura.Repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Cliente getById(Integer id) throws BusinessException {
        Optional<Cliente> departamento = this.repository.findById(id);
        return departamento.orElseThrow(()-> new BusinessException("Cliente não existe", new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public Cliente created(ClienteDTO clienteDTO) throws BusinessException {
        Cliente entity = modelMapper.map(clienteDTO, Cliente.class);
        if (repository.existsByName(entity.getName())){
            throw new BusinessException("cliente.exist",new ResponseStatusException(HttpStatus.BAD_REQUEST));
        }
        return repository.save(entity);
    }
    public Cliente update (Integer id, UserDTO userDTO) throws BusinessException {
        Cliente entity = modelMapper.map(userDTO, Cliente.class);
        if(!repository.existsById(id)){
            throw new BusinessException("cliente.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        Cliente clienteUpdate = getById(id);
        clienteUpdate.setAddress(entity.getAddress());
        clienteUpdate.setTelefone(entity.getTelefone());
        clienteUpdate.setName(entity.getName());
        clienteUpdate.setEmail(entity.getEmail());
        return clienteUpdate;
    }

    public void delete(Integer id) throws BusinessException {
        if(!repository.existsById(id)){
            throw new BusinessException("cliente.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        Cliente clienteDelete = getById(id);
        repository.delete(clienteDelete);
    }

}
