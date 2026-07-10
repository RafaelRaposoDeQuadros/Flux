package com.flux.backend.empresa.repository;

import com.flux.backend.empresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    boolean existsByEmail(String email);
}
