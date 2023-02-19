JFLAGS = -cp ./bin -g -d ./bin
JC = javac

default: messageUtils gui server client
gui: gui
client: messageUtils gui client
server: messageUtils server

messageUtils: src/messageUtils
	$(JC) $(JFLAGS) src/messageUtils/*.java
gui: src/gui
	$(JC) $(JFLAGS) src/gui/*.java
server: src/server.java
	$(JC) $(JFLAGS) src/server.java
client: bin/gui src/client.java
	$(JC) $(JFLAGS) src/client.java

clean:
	rm -rf bin
