package com.autobots.automanager.repositorios;

import com.autobots.automanager.entidades.Credencial;
import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepositorio extends JpaRepository<Credencial, Long> {
}
