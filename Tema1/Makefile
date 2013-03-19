all: build

build:
	find ./src/ -name "*.java" -print | xargs javac -d ./bin
	javac CompareOutputs.java
clean:
	rm -rf ./bin/*.class
	rm -rf CompareOutputs.class
