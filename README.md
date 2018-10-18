## About DBT
This application is about Direct Benefit Transfer in Fertilizers based on Hedera Hash graph platform. Beneficiary gets the subsidized amount direct to their account minimizing the intermediary and existing flaws present in the system. 
## Flow
•	Retailer get the farmer data based on its digital identity in system, and can create sale order Transaction and submit it to the Fertilizer Manufacturer. The subsidized amount should be retrieve from smart contracts which will take unit price, fertilizer code, and quantity as input. 
•	Fertilizer Manufacturer needs create the claim based on the sale order transaction by Retailer and needs to submit it to government. This transaction needs to go through Hedera Consensus and should get store in Smart Contracts which can be retrieve letter in time.
•	Government needs to approve the claim based on its verification and needs to transfer the crypto to the Fertilizers Manufacture. This crypto transfer should use the Hedera Account feature.

## Technical challenge 
•	At hackathon, we were able to deploy and call smart contract for their provided example only but not for other customized one as there was issue with smart contract in Hackathon on Hedera end (ex. fail_invalid), so we persisted the sale order transaction in DB only . 
•	The subsidized which we should get from smart contract is time being done on UI side, but once Hedera side smart contracts issue resolved, this need to be done from SM. You can find the bytecode and ABI created for it in main/resources/DBT_SM.bin and main/java/com/dbt/hedera/contracts/ContractCreate.java  respectively.

## Scope and Assumptions:
•	Registration of Farmers/Retailers and Fertilizers companies into DBT system are considered out of scope. Minimum required information is added in DB (ex. you need to load customer details in t_dbt_customer table before starting application).
•	Integration with external system like SHC for soil data and verification of identification details from national id system is out of scope for now(hackathon).
•	Integration to send SMS into registered mobile or OTP validation through OTP server is out of scope.


## Environment Set-up
## Pre-requisites
•	JDK: 10.0.x
•	Maven: 3.5.x
•	Spring Boot
•	MySQL
•	JPA, Hibernate
•	Hedera Hashgraph JAVA SDK Jar (you can follow a steps given on https://github.com/hashgraph/hedera-sdk-java to generate it)
•	Hedera Hashgraph node access (this can be provided by Hedera team)
•	Angular CLI: 1.6.3

## Installing application
## Hedera :
Please check you have a Hedera node and funding (paying) account set up before running this application. You can get this information from Hedera Team and you need to put this configuration in node.properties file.

## Java :
Run a command mvn install, and you will get a executable jar from it. You can run this jar by command java –jar path/jarname.jar. It will start embedded tomcat server and you can access application through UI layer now.

## UI :
•	Development server
Run ng serve for a dev server. Navigate to http://localhost:4200/. The app will automatically reload if you change any of the source files.
•	Code scaffolding
Run ng generate component component-name to generate a new component. You can also use ng generate directive|pipe|service|class|guard|interface|enum|module.
•	Build
Run ng build to build the project. The build artifacts will be stored in the dist/ directory. Use the -prod flag for a production build.



You can find more details about this project on below link
https://hederahackathonplatform.bemyapp.com


