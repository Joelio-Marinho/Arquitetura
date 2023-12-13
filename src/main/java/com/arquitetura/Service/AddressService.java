package com.arquitetura.Service;

import com.arquitetura.Exception.BusinessException;
import com.arquitetura.Model.Address;
import com.arquitetura.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address getById(Integer id) throws BusinessException {
        Optional<Address> departamento = this.repository.findById(id);
        return departamento.orElseThrow(()-> new BusinessException("Endereço não existe", new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public Address create(Address address) throws BusinessException {
        if (repository.existsByCepAndStreet(address.getCep(), address.getStreet())){
            throw new BusinessException("address.exist",new ResponseStatusException(HttpStatus.BAD_REQUEST));
        }
        return  repository.save(address);
    }
    public Address update (Integer id, Address address) throws BusinessException {
        if(!repository.existsById(id)){
            throw new BusinessException("address.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        Address addressUpdate = getById(id);
        addressUpdate.setCity(address.getCity());
        addressUpdate.setState(address.getState());
        addressUpdate.setStreet(address.getStreet());
        return repository.save(addressUpdate);
    }
    public void delete(Integer id) throws BusinessException {
        if(!repository.existsById(id)){
            throw new BusinessException("address.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        Address addressDelete = getById(id);
        repository.delete(addressDelete);
    }
}
