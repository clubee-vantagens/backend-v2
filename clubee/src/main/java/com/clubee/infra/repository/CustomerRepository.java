package com.clubee.infra.repository;

import com.clubee.domain.entity.Customer;
import com.clubee.domain.vo.CPF;
import com.clubee.domain.vo.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByEmail(Email email);
    boolean existsByEmail(Email email);
    boolean existsByCpf(CPF cpf);
}
