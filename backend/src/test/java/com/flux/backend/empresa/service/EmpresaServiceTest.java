package com.flux.backend.empresa.service;

import com.flux.backend.empresa.dto.CreateEmpresaRequest;
import com.flux.backend.empresa.dto.EmpresaResponse;
import com.flux.backend.empresa.entity.Empresa;
import com.flux.backend.empresa.enums.EmpresaStatus;
import com.flux.backend.shared.exception.BusinessException;
import com.flux.backend.shared.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.flux.backend.empresa.repository.EmpresaRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {

    @Mock
    private EmpresaRepository repository;

    @InjectMocks
    private EmpresaService service;

    @Test
    void shouldCreateEmpresaWhenEmailDoesNotExist() {

        CreateEmpresaRequest request = new CreateEmpresaRequest();
        request.setName("Barbearia Alpha");
        request.setEmail("contato@alpha.com");

        Empresa savedEmpresa = new Empresa(
            1L,
            "Barbearia Alpha",
            "contato@alpha.com",
            EmpresaStatus.ACTIVE,
            Instant.now()
        );

        when(repository.existsByEmail(request.getEmail()))
            .thenReturn(false);

        when(repository.save(any(Empresa.class)))
            .thenReturn(savedEmpresa);

        EmpresaResponse response = service.create(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Barbearia Alpha", response.getName());
        assertEquals("contato@alpha.com", response.getEmail());
        assertEquals(EmpresaStatus.ACTIVE, response.getStatus());

        verify(repository).existsByEmail(request.getEmail());
        verify(repository).save(any(Empresa.class));
    }

    @Test
    void shouldThrowBusinessExceptionWhenEmailAlreadyExists() {

        CreateEmpresaRequest request = new CreateEmpresaRequest();
        request.setName("Barbearia Alpha");
        request.setEmail("contato@alpha.com");

        when(repository.existsByEmail(request.getEmail()))
            .thenReturn(true);

        BusinessException exception = assertThrows(
            BusinessException.class,
            () -> service.create(request)
        );

        assertEquals(
            "Já existe uma empresa cadastrada com este e-mail.",
            exception.getMessage()
        );

        verify(repository).existsByEmail(request.getEmail());
        verify(repository, never()).save(any(Empresa.class));
    }

    @Test
    void shouldReturnEmpresaWhenIdExists(){
        Long id = 1L;
        Instant createdAt = Instant.now();

        Empresa empresa = new Empresa(id
        ,"Flux"
        ,"flux@gmail.com"
        ,EmpresaStatus.ACTIVE
        ,createdAt);

        when(repository.findById(id))
            .thenReturn(Optional.of(empresa));

        EmpresaResponse response = service.findById(id);

        assertNotNull(response);
        assertEquals(id, response.getId());
        assertEquals("Flux", response.getName());
        assertEquals("flux@gmail.com", response.getEmail());
        assertEquals(EmpresaStatus.ACTIVE, response.getStatus());
        assertEquals(createdAt, response.getCreatedAt());

        verify(repository).findById(id);

    }
    @Test
    void shouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
        Long id = 999L;

        when(repository.findById(id))
            .thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
            ResourceNotFoundException.class,
            () -> service.findById(id)
        );

        assertEquals(
            "Recurso não encontrado. Id: " + id,
            exception.getMessage()
        );

        verify(repository).findById(id);
    }

    @Test
    void shouldReturnListOfEmpresasWhenCompaniesExist(){

        Instant createdAt = Instant.now();

        Empresa empresa1 = new Empresa(
            1L,
            "Empresa A",
            "empresa.a@email.com",
            EmpresaStatus.ACTIVE,
            createdAt
        );

        Empresa empresa2 = new Empresa(
            2L,
            "Empresa B",
            "empresa.b@email.com",
            EmpresaStatus.INACTIVE,
            createdAt
        );

        when(repository.findAll())
            .thenReturn(List.of(empresa1,empresa2));

        List<EmpresaResponse> response = service.findAll();

        assertEquals(1L, response.get(0).getId());
        assertEquals("Empresa A", response.get(0).getName());
        assertEquals("empresa.a@email.com", response.get(0).getEmail());
        assertEquals(EmpresaStatus.ACTIVE, response.get(0).getStatus());

        assertEquals(2L, response.get(1).getId());
        assertEquals("Empresa B", response.get(1).getName());
        assertEquals("empresa.b@email.com", response.get(1).getEmail());
        assertEquals(EmpresaStatus.INACTIVE, response.get(1).getStatus());

        verify(repository).findAll();
    }

    @Test
    void shouldReturnEmptyListWhenNoEmpresasExist() {
        when(repository.findAll())
            .thenReturn(List.of());

        List<EmpresaResponse> response = service.findAll();

        assertNotNull(response);
        assertTrue(response.isEmpty());

        verify(repository).findAll();
    }
}
