JFLAGS = -g
JC = javac
JPACKAGEFLAGS = -d .

default: GUI.class server.class client.class

GUI.class: src/gui/GUI.java
	$(JC) $(JFLAGS) $(JPACKAGEFLAGS) src/GUI.java
server.class: src/server.java
	$(JC) $(JFLAGS) src/server.java
client.class: src/client.java
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf *.class
