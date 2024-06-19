# JavaPropertyLint
A java cli to syntax-check java propertyfiles

# About:
This Java CLI application takes a file path as an argument and attempts to load the file
 using the standard java-class [java.util.Properties](https://www.google.com/search?q=java.util.Properties+documentation&tbs=qdr:y2)

 If it thinks the file is a valid Java properties file, the application exits with status code 0,
 otherwise, it prints the first error it finds to standard output and exits with status code 1 and a java error

 It's not very sofisticated so it exits on the first error it finds

 It only detects syntax errors and there is no guarantee that it finds all errors, but if it
 reports an error there probably is one.



## Compiling the Java Source File
Make sure you have `java` and `openjdk` installed
```bash
javac JavaPropertyLint.java
jar cfm JavaPropertyLint.jar MANIFEST.MF JavaPropertyLint.class
```
## Example usage

### valid file

```bash
pmopmo@wsl2 ~/work/lint/JavaPropertyLint
$ java -jar JavaPropertyLint.jar dummy.config.properties

pmopmo@wsl2 ~/work/lint/JavaPropertyLint
$ echo $?
0
```
### invalid file

```bash
pmopmo@wsl2 ~/work/lint/JavaPropertyLint
$ java -jar JavaPropertyLint.jar dummy.invalid.config.properties
Exception in thread "main" java.lang.IllegalArgumentException: Malformed \uxxxx encoding.
        at java.base/java.util.Properties.loadConvert(Properties.java:663)
        at java.base/java.util.Properties.load0(Properties.java:457)
        at java.base/java.util.Properties.load(Properties.java:409)
        at JavaPropertyLint.main(JavaPropertyLint.java:27)

pmopmo@wsl2 ~/work/lint/JavaPropertyLint
$ echo $?
1
```
