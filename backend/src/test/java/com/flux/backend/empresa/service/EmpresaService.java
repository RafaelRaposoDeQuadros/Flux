package com.flux.backend.empresa.service;


import com.flux.backend.empresa.dto.CreateEmpresaRequest;
import com.flux.backend.empresa.dto.EmpresaResponse;
import com.flux.backend.empresa.entity.Empresa;
import com.flux.backend.empresa.enums.EmpresaStatus;
import com.flux.backend.empresa.repository.EmpresaRepository;
import com.flux.backend.shared.exception.BusinessException;
import com.flux.backend.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository){
        this.repository = repository;
    }

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

    public EmpresaResponse findById(Long id){
        Optional<Empresa> obj = repository.findById(id);
        return new EmpresaResponse(obj.orElseThrow(()->new ResourceNotFoundException(id)));
    }
}
