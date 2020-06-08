--create user
ALTER SESSION SET container = xepdb1;
CREATE USER shc IDENTIFIED BY admin;
GRANT ALL PRIVILEGES TO shc;
SELECT sys_context('USERENV', 'CON_NAME') FROM dual;