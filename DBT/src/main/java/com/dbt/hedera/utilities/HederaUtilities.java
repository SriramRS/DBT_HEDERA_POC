package com.dbt.hedera.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.codehaus.plexus.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dbt.dao.HederaRepository;
import com.dbt.hedera.account.AccountCreate;
import com.dbt.hedera.account.AccountSend;
import com.dbt.model.ConfigEnum;
import com.dbt.model.HederaConfig;
import com.dbt.model.HederaConfigPrky;
//import com.hedera.account.AccountCreate;
import com.hedera.sdk.account.HederaAccount;
import com.hedera.sdk.common.HederaAccountID;
import com.hedera.sdk.common.HederaDuration;
import com.hedera.sdk.common.HederaTransactionAndQueryDefaults;
import com.hedera.sdk.common.HederaTransactionID;
import com.hedera.sdk.common.HederaTransactionRecord;
import com.hedera.sdk.common.HederaKey.KeyType;
import com.hedera.sdk.cryptography.HederaCryptoKeyPair;
import com.hedera.sdk.node.HederaNode;

import edu.emory.mathcs.backport.java.util.Collections;

public class HederaUtilities {
	
	//final Logger logger = LoggerFactory.getLogger(HederaUtilities.class);
	public static HederaAccount fromAccount ;

	public static HederaAccount toAccount;
	
	public static Map<String , HederaConfig > mapconfig=Collections.synchronizedMap(new HashMap<>());


	public static String nodeAddress = "";
	public static int nodePort = 0;

	public static long nodeAccountShard = 0;
	public static long nodeAccountRealm = 0;
	public static long nodeAccountNum = 0;
	
	public static String pubKey = "";
	public static String privKey = "";
	
	public static long payAccountShard = 0;
	public static long payAccountRealm = 0;
	public static long payAccountNum = 0;

	static{
		
		
	}
	public static void getNodeDetails() {

		// load application properties
		Properties applicationProperties = new Properties();
		InputStream propertiesInputStream = null;
	
		
		try {

			propertiesInputStream = new FileInputStream("node.properties");

			// load a properties file
			applicationProperties.load(propertiesInputStream);

			// get the property value and print it out
			nodeAddress = applicationProperties.getProperty("nodeaddress");
			nodePort = Integer.parseInt(applicationProperties.getProperty("nodeport"));

			nodeAccountShard = Long.parseLong(applicationProperties.getProperty("nodeAccountShard"));
			nodeAccountRealm = Long.parseLong(applicationProperties.getProperty("nodeAccountRealm"));
			nodeAccountNum = Long.parseLong(applicationProperties.getProperty("nodeAccountNum"));
			
			pubKey = applicationProperties.getProperty("pubkey");
			privKey = applicationProperties.getProperty("privkey");
			
			payAccountShard = Long.parseLong(applicationProperties.getProperty("payingAccountShard"));
			payAccountRealm = Long.parseLong(applicationProperties.getProperty("payingAccountRealm"));
			payAccountNum = Long.parseLong(applicationProperties.getProperty("payingAccountNum"));

		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		} finally {
			if (propertiesInputStream != null) {
				try {
					propertiesInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static HederaTransactionAndQueryDefaults getTxQueryDefaults() {
		// Get node details 
		HederaUtilities.getNodeDetails();
		
		// setup node account ID
		HederaAccountID nodeAccountID = new HederaAccountID(HederaUtilities.nodeAccountShard, HederaUtilities.nodeAccountRealm, HederaUtilities.nodeAccountNum);
		// setup node
		HederaNode node = new HederaNode(HederaUtilities.nodeAddress, HederaUtilities.nodePort, nodeAccountID);
		
		// setup paying account
		HederaAccountID payingAccountID = new HederaAccountID(HederaUtilities.payAccountShard, HederaUtilities.payAccountRealm, HederaUtilities.payAccountNum);
		
		// setup paying keypair
		HederaCryptoKeyPair payingKeyPair = new HederaCryptoKeyPair(KeyType.ED25519, HederaUtilities.pubKey, HederaUtilities.privKey);
		
		// setup a set of defaults for query and transactions
		HederaTransactionAndQueryDefaults txQueryDefaults = new HederaTransactionAndQueryDefaults();
		
		txQueryDefaults.memo = "Demo memo";
		txQueryDefaults.node = node;
		txQueryDefaults.payingAccountID = payingAccountID;
		txQueryDefaults.payingKeyPair = payingKeyPair;
		txQueryDefaults.transactionValidDuration = new HederaDuration(120, 0);
		
		return txQueryDefaults;
	}
	
	public static HederaConfig setupHederaStartupConfig(String type,HederaAccount account) throws Exception {
		    HederaTransactionAndQueryDefaults trnsDefaults =getTxQueryDefaults() ;	
		    account = new HederaAccount();
			account.txQueryDefaults = trnsDefaults;
			HederaCryptoKeyPair newAccountKey = new HederaCryptoKeyPair(KeyType.ED25519);
			account = AccountCreate.create(account, newAccountKey,500000);
			if (account == null) {
				System.out.println("*******************************************");
				System.out.println("FIRST ACCOUNT CREATE FAILED");
				System.out.println("*******************************************");
				throw new Exception("Account create failure");
			} else {
			}
			if (account != null) {
				// the paying account is now the new account
				trnsDefaults.payingAccountID = account.getHederaAccountID();
				trnsDefaults.payingKeyPair = newAccountKey;
			}
			HederaConfig config=new HederaConfig();
			HederaConfigPrky configkey=new HederaConfigPrky();
			configkey.setAccNum(account.getHederaAccountID().accountNum);
			configkey.setRealm(account.getHederaAccountID().realmNum);
			configkey.setShard(account.getHederaAccountID().shardNum);
			config.setPubKey(newAccountKey.getPublicKey());
			config.setPriKey(newAccountKey.getSecretKey());
			config.setNano(account.hederaTransactionID.transactionValidStart.seconds());
			config.setNano(account.hederaTransactionID.transactionValidStart.nanos());
			config.setType(type);
			config.setPrKy(configkey);
			if(type.equalsIgnoreCase("manufacture")) {
				toAccount=account;
				
			}else if (type.equalsIgnoreCase("government")) {
				fromAccount=account;
			}
			
			return config;
			
	}
	
	  public static void transferCrypto(long amt) throws InterruptedException {
		  
	   if(null!=toAccount && null!=fromAccount)  {  
		    AccountSend.send(fromAccount, toAccount, amt);
		  }else {
			  System.out.println("either of the  account  not exist ");
		  }
		
	  }
	  
	  public static long getAccountBal(String type) throws Exception {
		  
		  HederaAccount account=null;
		  if(type.equalsIgnoreCase("manufacture")) {
			  account=checkAndLoadAccount(toAccount,type);

				
			}else if (type.equalsIgnoreCase("government")) {
				account=checkAndLoadAccount(fromAccount,type);
			}
		   return account.getBalance();
			
	  }
	  
	 private static HederaAccount checkAndLoadAccount(HederaAccount account,String type) throws Exception {
		 HederaAccount newAccount=null;
		 if (null!=account ) {
			 return account;
		  }
		  else {
			  HederaConfig config =mapconfig.get(type);
			  if(null==config) {
				  setupHederaStartupConfig(type,newAccount);
			  }
			  newAccount=new HederaAccount(config.getPrKy().getShard(),config.getPrKy().getRealm(),config.getPrKy().getAccNum());
			  HederaCryptoKeyPair payingKeyPair = new HederaCryptoKeyPair(KeyType.ED25519,config.getPubKey(),config.getPriKey());
			  newAccount.txQueryDefaults.payingAccountID=newAccount.getHederaAccountID();
			  newAccount.txQueryDefaults.payingKeyPair=payingKeyPair;
			  return newAccount;
		  }
	  }

}
