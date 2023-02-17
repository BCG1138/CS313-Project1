JFLAGS = -g
JC = javac
JPACKAGEFLAGS = -d ./src

default: GUI.class server.class client.class

GUI.class: src/GUI.java
	$(JC) $(JFLAGS) $(JPACKAGEFLAGS) src/GUI.java
server.class: src/server.java
	$(JC) $(JFLAGS) src/server.java
client.class: src/client.java
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf src/Client.class
	rm -rf src/server.class
	rm -rf src/gui
