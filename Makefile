JFLAGS = -g
JC = javac
JVM = java

GUI:
        javac -d GUI.java
server:
        javac server.java
client: GUI.class
        javac client.java

clean:
        rm -f *.o