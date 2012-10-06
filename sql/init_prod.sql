drop database if exists muster_prod;
create database muster_prod;
grant all on muster_prod.* to 'gvamos'@'localhost' identified by '';
grant all on muster_prod.* to 'tomcat'@'localhost' identified by '';
grant all on muster_prod.* to 'test'@'localhost' identified by '';
grant all on muster_prod.* to 'util'@'localhost' identified by '';
flush privileges;
