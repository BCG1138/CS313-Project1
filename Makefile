JFLAGS = -g
JC = javac
JPACKAGEFLAGS = -d ./gui

default: GUI.class server.class client.class

GUI.class: src/gui/GUI.java
	$(JC) $(JFLAGS) $(JPACKAGEFLAGS) src/gui/GUI.java
server.class: src/server.java
	$(JC) $(JFLAGS) src/server.java
client.class: src/client.java
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf *.class
