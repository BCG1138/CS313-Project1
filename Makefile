JFLAGS = -g -d ./bin
JC = javac

default: GUI.class server.class client.class

GUI.class: src/GUI.java
	$(JC) $(JFLAGS) src/gui/GUI.java
server.class: src/server.java
	$(JC) $(JFLAGS) src/server.java
client.class: src/client.java src/GUI.class
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf bin
