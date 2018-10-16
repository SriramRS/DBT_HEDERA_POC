package com.dbt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbt.model.ClaimVO;
import com.dbt.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
