# DesignPatterns

Simple reference implementations of various design patterns using java.

1. The factory pattern.
A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.
The Factory Method Pattern is also known as Virtual Constructor.

2. Singleton Pattern says that just"define a class that has only one instance and provides a global point of access to it".

3. Abstract Factory Pattern says that just define an interface or abstract class for creating families of related (or dependent) objects but without specifying their concrete sub-classes.That means Abstract Factory lets a class return a factory of classes. So, this is the reason that Abstract Factory Pattern is one level higher than the Factory Pattern. 

4. Prototype pattern says clone an existing object instead of creating new one and can also be customized as per the requirement. A possible real world application might be say, when you need to create a spreadsheet containing many cells. Rather than set the style for each newly created cell to override the default stylings, you'd use a Prototype pattern to create a template cell, and clone that cell when creating new cells.

5. Builder pattern. 
Was introduced to solve some of the problems with Factory and Abstract Factory design patterns when the Object contains a lot of attributes.

There are three major issues with Factory and Abstract Factory design patterns when the Object contains a lot of attributes.

i. Too Many arguments to pass from client program to the Factory class that can be error prone because most of the time, the type of arguments are same and from client side its hard to maintain the order of the argument.
ii. Some of the parameters might be optional but in Factory pattern, we are forced to send all the parameters and optional parameters need to send as NULL.
iii. If the object is heavy and its creation is complex, then all that complexity will be part of Factory classes that is confusing.
