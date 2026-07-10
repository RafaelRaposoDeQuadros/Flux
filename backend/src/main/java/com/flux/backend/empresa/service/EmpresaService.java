package com.flux.backend.empresa.service;


import com.flux.backend.empresa.dto.CreateEmpresaRequest;
import com.flux.backend.empresa.dto.EmpresaResponse;
import com.flux.backend.empresa.entity.Empresa;
import com.flux.backend.empresa.enums.EmpresaStatus;
import com.flux.backend.empresa.repository.EmpresaRepository;
import com.flux.backend.shared.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public EmpresaResponse create(CreateEmpresaRequest request){
        if (repository.existsByEmail(request.getEmail())) {
            throw new BusinessException(
                "Já existe uma empresa cadastrada com este e-mail."
            );
        }
        Empresa empresa = new Empresa(null,request.getName(),request.getEmail(), EmpresaStatus.ACTIVE, Instant.now());
        Empresa savedEmpresa = repository.save(empresa);
        return new EmpresaResponse(savedEmpresa);
    }
}
