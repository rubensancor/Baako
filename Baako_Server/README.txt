Maven Instructions
==================
0. This command initializes the database: *mysql -uroot < create-messagesdb.sql*. If you set-up a password for the root user, then the command should be: *mysql -uroot -p < create-messagesdb.sql*

1. Run the command *mvn clean compile*. This builds everything and enhances the classes.

2. Run the command *mvn datanucleus:schema-create*. This creates the schema for the tutorial.

3. Run the command *mvn exec:java -Pserver*. This runs the server-side.

4. Run the command *mvn exec:java -Pclient*. This runs the client-side.

5. Run the command *mvn datanucleus:schema-delete*. This deletes the schema for the tutorial