USE housingdb;
DROP TABLE IF EXISTS housing_cooperative;

CREATE TABLE housing_cooperative
(
	id          BINARY(16) NOT NULL,
	Name 		CHAR(80)    NOT NULL,
	Address		CHAR(50)    NOT NULL,
	PostNumber	CHAR(10)    NOT NULL,	
	City		CHAR(50)    NOT NULL,
    BankAccount CHAR(50)    NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

SELECT * FROM housing_cooperative;
INSERT INTO housing_cooperative(id,Name,Address,PostNumber,City,BankAccount)
  VALUES ("123-123-456","As Oy Jyv�skyl�n M�ntylehto","Koukonkuja 12","40420","Jyv�skyl�","FI02 2342 1234 12123");
