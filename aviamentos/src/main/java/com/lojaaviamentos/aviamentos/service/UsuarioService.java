package com.lojaaviamentos.aviamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaaviamentos.aviamentos.domain.Usuario;
import com.lojaaviamentos.aviamentos.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repo;


    public List<Usuario> listAll() {
        return repo.findAll();
    }

    public void save(Usuario p) {
        repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
