package com.lojaaviamentos.aviamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaaviamentos.aviamentos.domain.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
