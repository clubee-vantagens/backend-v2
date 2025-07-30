package com.clubee.infra.database;

import com.clubee.infra.database.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;


public interface CustomerJPARepository extends JpaRepository<CustomerModel, UUID> {
    Optional<CustomerModel> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
