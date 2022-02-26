#!/bin/sh
mysqladmin -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 drop hc_housingdb
mysqladmin -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 create hc_housingdb
mysql -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 hc_housingdb < ./HousingCooperative.sql
mysqlshow -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19
mysqlshow -h localhost -P 3306 --protocol=tcp -u root --password=Tommijgqb#19 hc_housingdb
