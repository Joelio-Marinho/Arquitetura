package com.arquitetura.Controller;

import com.arquitetura.DTO.AuthenticationDTO;
import com.arquitetura.DTO.LoginResponseDTO;
import com.arquitetura.Infra.Security.TokenService;
import com.arquitetura.Model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager AuthenticationManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity login (@RequestBody  @Valid AuthenticationDTO data){
        System.out.println(data);
        var  userNamePassword = new UsernamePasswordAuthenticationToken(data.name(),data.password());
        var auth = AuthenticationManager.authenticate(userNamePassword);
        var token = tokenService.generateToken((User)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
