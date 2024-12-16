# SAABClient

RUN INSTRUCTIONS:

FIRST STEP - start the server:

1. Save the server program files somewhere. (the files found in SAABServer). It must contain two files to function:
SAAB.jar
server.properties
2. Open command line and navigate to you SAAB.jar using 'cd [path-to-directory]/SAABServer'.
3. to start the server, type the following command. You should get this output if done correctly, and its waiting for a client to connect.
java –classpath SAAB.jar com.saabtech.server.SAABServer

[OUTPUT]	
Loading server config [path-to-directory]\SAABServer\server.properties... DONE!
Setting up server socket at port 5463 ... DONE!
Waiting for client to connect


	
SECOND STEP - start the client:

0. This approach uses maven to compile and run. In maven is not installed, do so first. Check by typing following command. you should recieve the current maven version in use, else go and install maven first!
mvn -v
1. download the SAABMapClient folder somewhere.
2. Open a new command line window and navigate to this folder using 'cd [path-to-directory]/SAABMapClient'
3. From this location, compile the code with the following command. A stack trace with "BUILD SUCCESS" should appear.
mvn compile
4. To run the code, the following command should be used. The GUI window should pop now.
mvn exec:java -Dexec.mainClass="com.saabtech.main.Main"
