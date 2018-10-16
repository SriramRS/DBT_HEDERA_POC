package com.dbt.hedera.utilities;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbt.dao.HederaRepository;
import com.dbt.model.HederaConfig;

@Component
public class HederaHelper {

	
	@Autowired
	HederaRepository  hederaRepository;
	
	private HederaUtilities utilities =new HederaUtilities();
	
	
	public void loadHederaConfig() {
		try {
			List<HederaConfig> list=hederaRepository.findAll();
			if(null!=list && !list.isEmpty()) {

				for(HederaConfig config:list) {
					if (config.getType().equalsIgnoreCase("manufacture")) {
						utilities.mapconfig.put(config.getType(), config);
					}else if (config.getType().equalsIgnoreCase("government")) {
						utilities.mapconfig.put(config.getType(), config);

					}else if (config.getType().equalsIgnoreCase("fundingnode")) {
						utilities.mapconfig.put(config.getType(), config);

					}
				}
				
				
			}else {
				utilities.mapconfig.put("manufacture",utilities.setupHederaStartupConfig("manufacture",null));
				utilities.mapconfig.put("govertment",utilities.setupHederaStartupConfig("government",null));
				utilities.mapconfig.put("fundingnode",utilities.setupHederaStartupConfig("fundingnode",null));
				
				for (Map.Entry<String,HederaConfig> entry : utilities.mapconfig.entrySet())  {
					hederaRepository.save(entry.getValue())	;
				}   
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	public long getAccountBal(String type) {
		long bal=0l;
		try {
			 bal=utilities.getAccountBal(type);
			return bal;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bal;
		
	}
	
	public void transferCrypto(long amt) {
	
		try {
			 utilities.transferCrypto(amt);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	
}
