# Introduction
This project explores options on how to avoid already compiled files to be overwritten by
aspectj-maven-plugin. Sometimes, we want to have ``aspectj-maven-plugin`` perform the weaving on already
compile files, and not go back to the source.

## How it works
Java files are compiled and placed in the ``target/unwoven-classes`` directory. After compilation, the
bytecode of ``Main.class`` is modified to replace the string ``Hello`` with ``Fubar``. Then weaving is
applied and final class files end-up in the usual place: ``target/classes``.

The aspect that is applied simply update the message displayed in the output with an uppercase version.

## Tests to perform
Execute the project.
```shell
./run.sh
```
You should see ``FUBAR!`` in the output.

## 1. Remove the exclusion of the source code
In ``pom.xml``, remove or comment out the ``<source/>`` tag. The output should be replaced with ``HELLO!``.

## 2. Do not force weaving
In ``pom.xml``, set ``forceAjcCompile`` to false. You should get a ``java.lang.ClassNotFoundException: org.example.Main``.
This is because weaving is not performed and ``target/classes`` doesn't contain any class because of that.
