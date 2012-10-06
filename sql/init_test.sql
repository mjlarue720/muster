drop database if exists muster_test;
create database muster_test;
grant all on muster_test.* to 'gvamos'@'localhost' identified by '';
grant all on muster_test.* to 'tomcat'@'localhost' identified by '';
grant all on muster_test.* to 'test'@'localhost' identified by '';
grant all on muster_test.* to 'util'@'localhost' identified by '';
flush privileges;
