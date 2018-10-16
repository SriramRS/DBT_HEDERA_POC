package com.dbt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbt.model.ClaimVO;
import com.dbt.model.HederaConfig;
import com.hedera.sdk.account.HederaAccount;

@Repository
public interface AppConfigRepository extends JpaRepository<HederaConfig,String> {

}
