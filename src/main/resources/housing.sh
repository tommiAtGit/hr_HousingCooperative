#!/bin/sh
mysqladmin -u root --password=Tommijgqb#19 create housingdb
mysql -u root --password=Tommijgqb#19 housingdb < ./HousingCooperative.sql
mysqlshow -u root --password=Tommijgqb#19
mysqlshow -u root --password=Tommijgqb#19 housingdb