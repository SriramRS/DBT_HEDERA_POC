package com.dbt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbt.model.HederaConfig;


@Repository
public interface HederaRepository extends JpaRepository<HederaConfig, Long> {


}
