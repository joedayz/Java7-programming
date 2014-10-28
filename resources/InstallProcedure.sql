# Replace the location of the JAR file as appropriate
CALL SQLJ.remove_jar ('PUBLIC.DerbyStoredProcedure', 0);
CALL SQLJ.install_jar ('D:\temp\DerbyStoredProcedure.jar', 'PUBLIC.DerbyStoredProcedure', 0);
CALL syscs_util.syscs_set_database_property('derby.database.classpath', 'PUBLIC.DerbyStoredProcedure');
