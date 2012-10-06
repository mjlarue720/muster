drop database if exists muster_test;
create database muster_test;
grant all on muster_test.* to 'gvamos'@'localhost' identified by '';
grant all on muster_test.* to 'tomcat'@'localhost' identified by '';
grant all on muster_test.* to 'test'@'localhost' identified by '';
grant all on muster_test.* to 'util'@'localhost' identified by '';

drop database if exists muster_prod;
create database muster_prod;
grant all on muster_prod.* to 'gvamos'@'localhost' identified by '';
grant all on muster_prod.* to 'tomcat'@'localhost' identified by '';
grant all on muster_prod.* to 'test'@'localhost' identified by '';
grant all on muster_prod.* to 'util'@'localhost' identified by '';

drop database if exists muster_dev;
create database muster_dev;
grant all on muster_dev.* to 'gvamos'@'localhost' identified by '';
grant all on muster_dev.* to 'tomcat'@'localhost' identified by '';
grant all on muster_dev.* to 'test'@'localhost' identified by '';
grant all on muster_dev.* to 'util'@'localhost' identified by '';
flush privileges;

