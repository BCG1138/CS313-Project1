JFLAGS = -cp ./bin -g -d ./bin
JC = javac

default: GUI.class server.class client.class
gui: GUI.class
client: GUI.class client.class
server: server.class

GUI.class: src/gui/GUI.java
	$(JC) $(JFLAGS) src/gui/GUI.java
server.class: src/server.java
	$(JC) $(JFLAGS) src/server.java
client.class: bin/gui src/client.java
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf bin
