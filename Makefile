JFLAGS = -cp ./bin -g -d ./bin
JC = javac

default: message.class GUI.class server.class client.class
gui: GUI.class
client: message.class GUI.class client.class
server: message.class server.class

message.class: src/packages
	$(JC) $(JFLAGS) src/packages/messageUtils/message.java
	$(JC) $(JFLAGS) src/packages/messageUtils/serialization.java
GUI.class: src/packages/gui/GUI.java
	$(JC) $(JFLAGS) src/packages/gui/GUI.java
server.class: src/server.java
	$(JC) $(JFLAGS) src/server.java
client.class: bin/gui src/client.java
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf bin
