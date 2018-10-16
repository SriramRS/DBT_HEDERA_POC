package com.dbt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbt.model.ClaimVO;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimVO, Long> {

	@Query("SELECT c FROM claim c where c.status =:status") 
    List<ClaimVO> findAllByStaus(@Param("status") String status);
}
