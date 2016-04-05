#!/bin/bash

#java -cp external_jars/json-simple-1.1.1.jar:external_jars/junit-4.12.jar:/home/worker2/my_coding_challenge/InsightData_coding_challenge/src/ org.junit.runner.JUnitCore Coding_Challenge.AverageDegreeTests

javac -g  -cp ../src/json-simple-1.1.1.jar:../src/junit-4.12.jar ../src/Coding_Challenge/*.java
java -cp ../src/json-simple-1.1.1.jar:../src/hamcrest-core-1.3.jar:../src/:../src/junit-4.12.jar org.junit.runner.JUnitCore  Coding_Challenge.AverageDegreeTests
