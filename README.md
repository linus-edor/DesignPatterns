# DesignPatterns

Simple reference implementations of various design patterns using java.

1. The factory pattern.
A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but
 let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.
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

Builder pattern solves the issue with large number of optional parameters and inconsistent
 state by providing a way to build the object step-by-step and provide a method that will actually return the final Object.
 
 When to Use Builder Pattern:
When the process involved in creating an object is extremely complex, with lots of mandatory and optional parameters
When an increase in the number of constructor parameters leads to a large list of constructors
When client expects different representations for the object that's constructed
 
6. The prototype pattern 
Prototype is a creational design pattern that allows cloning objects,
even complex ones, without coupling to their specific classes.
All prototype classes should have a common interface that makes it 
possible to copy objects even if their concrete classes are unknown. 
Prototype objects can produce full copies since objects of the same 
class can access each other’s private fields.This pattern is used when
creation of object directly is costly. For example, an object is to be 
created after a costly database operation. We can cache the object, 
returns its clone on next request and update the 
database as and when needed thus reducing database calls.
The Prototype pattern is available in Java out of the box with a Cloneable interface.

 