JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = GUI.java client.java server.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class