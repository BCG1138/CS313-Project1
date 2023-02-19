JFLAGS = -cp ./bin -g -d ./bin
JC = javac

default: message.class GUI.class server.class client.class
gui: GUI.class
client: message.class GUI.class client.class
server: message.class server.class

message.class: src/messageUtils/messages.java
	$(JC) $(JFLAGS) src/messageUtils/message.java
	$(JC) $(JFLAGS) src/messageUtils/serialization.java
	$(JC) $(JFLAGS) src/messageUtils/request.java
GUI.class: src/gui/GUI.java
	$(JC) $(JFLAGS) src/gui/GUI.java
server.class: src/server.java
	$(JC) $(JFLAGS) src/server.java
client.class: bin/gui src/client.java
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf bin
