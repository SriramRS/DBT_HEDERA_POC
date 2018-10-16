package com.dbt.hedera.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hedera.sdk.file.HederaFile;

public final class FileGetInfo {
	public static void getInfo(HederaFile file) {
		final Logger logger = LoggerFactory.getLogger(FileGetInfo.class);
		
		logger.info("");
		logger.info("FILE GET INFO");
		logger.info("");

		try {
			// get info for the file
			if (file.getInfo()) {
				logger.info("===>Got info");
			} else {
				logger.info("===>Getting info - precheck ERROR " + file.getPrecheckResult());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
