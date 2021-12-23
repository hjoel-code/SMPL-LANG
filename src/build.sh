javac -classpath ".:/usr/share/java/cup.jar" smpl/*/*.java
javac -classpath ".:/usr/share/java/cup.jar" smpl/lang/*/*.java
java -classpath ".:/usr/share/java/cup.jar" smpl.sys.SMPLRepl
# java -classpath ".:/usr/share/java/cup.jar" smpl.sys.SMPLRepl ../examples/test-primitives.smpl
# java -classpath ".:/usr/share/java/cup.jar" smpl.sys.SMPLRepl ../examples/if-test.smpl
