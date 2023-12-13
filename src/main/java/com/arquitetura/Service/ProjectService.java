package com.arquitetura.Service;

import com.arquitetura.DTO.ProjectDTO;
import com.arquitetura.Exception.BusinessException;
import com.arquitetura.Model.Enum.ProjectAprovacao;
import com.arquitetura.Model.Enum.ProjectStatus;
import com.arquitetura.Model.Project;
import com.arquitetura.Repository.ProjectRepository;
import com.arquitetura.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class ProjectService {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectRepository ProjectRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Project getById(Integer id) throws BusinessException {
        Optional<Project> Project = this.ProjectRepository.findById(id);
        return Project.orElseThrow(()-> new BusinessException("Projeto não existe", new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    public Project create(ProjectDTO projectDTO) throws BusinessException {
        Project entity = modelMapper.map(projectDTO, Project.class);
        if (ProjectRepository.existsByName(entity.getName())){
            throw new BusinessException("pessoa.exist",new ResponseStatusException(HttpStatus.BAD_REQUEST));
        }
        entity.setFinalizado(ProjectStatus.PENDING);
        if(entity.getAprovacao()==null){
            entity.setAprovacao(ProjectAprovacao.PENDING);
        }

        return ProjectRepository.save(entity);
    }
    public Project update (Integer id, ProjectDTO projectDTO) throws BusinessException {
        Project entity = modelMapper.map(projectDTO, Project.class);
        if(!ProjectRepository.existsById(id)){
            throw new BusinessException("pessoa.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        Project projectUpdate = getById(id);

        projectUpdate.setName(entity.getName());

        return projectUpdate;
    }

    public void delete(Integer id) throws BusinessException {
        if(!ProjectRepository.existsById(id)){
            throw new BusinessException("pessoa.not.exist", new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        Project projectDelete = getById(id);
        ProjectRepository.delete(projectDelete);
    }
}
