drop database if exists muster_dev;
create database muster_dev;
grant all on muster_dev.* to 'gvamos'@'localhost' identified by '';
grant all on muster_dev.* to 'tomcat'@'localhost' identified by '';
grant all on muster_dev.* to 'test'@'localhost' identified by '';
grant all on muster_dev.* to 'util'@'localhost' identified by '';
flush privileges;
