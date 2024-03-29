package com.arquitetura.Service;

import com.arquitetura.DTO.UserDTO;
import com.arquitetura.Exception.BusinessException;
import com.arquitetura.Model.Address;
import com.arquitetura.Model.Enum.Role;
import com.arquitetura.Model.User;
import com.arquitetura.Repository.UserRepository;
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

  public User getById(Integer id) throws BusinessException{
      Optional<User> departamento = this.repository.findById(id);
      return departamento.orElseThrow(()-> new BusinessException("Usuario não existe", new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }

  public User create(User user) throws BusinessException {
      if (repository.existsByName(user.getName())){
          throw new BusinessException("pessoa.exist",new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
      }
      if(user.getRole().equals(Role.ADMIN)){
          String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
          user.setPassword(encryptedPassword);
          return  repository.save(user);
      }
      throw new BusinessException("pessoa.is.not.created",new ResponseStatusException(HttpStatus.BAD_REQUEST));
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
      userUpdate.setName(user.getName());
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
