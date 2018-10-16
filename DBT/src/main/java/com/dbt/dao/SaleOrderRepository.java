package com.dbt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.dbt.model.SaleOrder;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long> {

	   @Query("SELECT saleOrder FROM t_dbt_sale_order saleOrder where saleOrder.manfId =:manfId") 
	    List<SaleOrder> findAllByManfId(@Param("manfId") String manfId);
}
