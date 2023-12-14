package com.arquitetura.Service;

import com.arquitetura.DTO.UserDTO;
import com.arquitetura.Exception.BusinessException;
import com.arquitetura.Model.Address;
import com.arquitetura.Model.User;
import com.arquitetura.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getById(Integer id) throws BusinessException{
      Optional<User> departamento = this.repository.findById(id);
      return departamento.orElseThrow(()-> new BusinessException("Usuario não existe", new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  public User create(User user) throws BusinessException {
      if (repository.existsByName(user.getUsername())){
          throw new BusinessException("pessoa.exist",new ResponseStatusException(HttpStatus.BAD_REQUEST));
      }
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      return  repository.save(user);
  }
  public User update (Integer id, User user) throws BusinessException {
      if(!repository.existsById(id)){
          throw new BusinessException("pessoa.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
      }
      User userUpdate = getById(id);
      if(user.getAddress()!=null){
          userUpdate.setAddress(modelMapper.map(user.getAddress(), Address.class));
      }
      userUpdate.setFone(user.getFone());
      userUpdate.setUsername(user.getUsername());
      userUpdate.setEmail(user.getEmail());
      userUpdate.setPassword(user.getPassword());
      return repository.save(userUpdate);
  }
  public void delete(Integer id) throws BusinessException {
      if(!repository.existsById(id)){
          throw new BusinessException("pessoa.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
      }
      User userDelete = getById(id);
      repository.delete(userDelete);
  }
}
