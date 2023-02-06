package com.afpa.operationservice.repositories;


import com.afpa.operationservice.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
