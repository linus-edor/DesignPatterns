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

7. Chain of Responsibility is a behavioral design pattern that lets you pass requests
 along a chain of handlers. Upon receiving a request, each handler decides either to
 process the request or to pass it to the next handler in the chain. 
 ..... https://refactoring.guru/design-patterns/chain-of-responsibility
 Like many other behavioral design patterns, the Chain of Responsibility relies on 
 transforming particular behaviors into stand-alone objects called handlers. 
 In addition to processing a request, handlers pass the request further along the chain. 
 The request travels along the chain until all handlers have had a chance to process it.
 A handler can decide not to pass the request further down the chain and effectively stop any 
 further processing. 
 For instance, when a user clicks a button, the event propagates through the chain of GUI
 elements that starts with the button, goes along its containers (like forms or panels), and 
 ends up with the main application window. 
 in essence, it's a design that let's a request pass through a chain of handlers each of which 
 checks the state of the request and decide if they should process it or forward to the next handler
 in the chain or send a response back to the caller.
 STRUCTURE:
 Handler interface --> BaseHandler --> Concrete Handlers
 APPLICABILITY
 Use the Chain of Responsibility pattern when your program is expected to process different kinds of requests
 in various ways, but the exact types of requests and their sequences are unknown beforehand.
 Use the pattern when it’s essential to execute several handlers in a particular order.
 Use the CoR pattern when the set of handlers and their order are supposed to change at runtime.
 
 8. The adapter design pattern is a structural design pattern that allows two unrelated/uncommon 
 interfaces to work together. In other words, the adapter pattern makes two incompatible interfaces
  compatible without changing their existing code.
 Interfaces may be incompatible, but the inner functionality should match the requirement.
The adapter pattern is often used to make existing classes work with others without modifying their source code.
Adapter patterns use a single class (the adapter class) to join functionalities of independent or incompatible interfaces/classes.
The adapter pattern also is known as the wrapper, an alternative naming shared with the decorator design pattern.
This pattern converts the (incompatible) interface of a class (the adaptee) into another interface (the target) that clients require.
The adapter pattern also lets classes work together, which, otherwise, couldn't have worked, because of the incompatible interfaces.     
Object Adapter Pattern
In this approach, we will use the Java composition, and our adapter contains the source object. 
The composition is used as a reference to the wrapped class within the adapter.
Class Adapter Pattern
In this approach, we use the Java Inheritance and extend the source class. 
Two Ways Adapter
The two-ways adapters are adapters that implement both interfaces of the target and adaptee. 
The adapted object can be used as the target in new systems dealing with target classes or as
 the adaptee in other systems dealing with the adaptee classes.
https://dzone.com/articles/adapter-design-pattern-in-java
Check on adapter vs Decorator
Applicability
Use the Adapter class when you want to use some existing class, but its interface isn’t compatible
 with the rest of your code.
The Adapter pattern lets you create a middle-layer class that serves as a translator between your 
code and a legacy class, a 3rd-party class or any other class with a weird interface.
Use the pattern when you want to reuse several existing subclasses that lack some common
functionality that can’t be added to the superclass.
You could extend each subclass and put the missing functionality into new child classes. 
However, you’ll need to duplicate the code across all of these new classes, which smells 
really bad.

9. Command pattern is a behavioral design pattern which is useful to abstract 
   business logic into discrete actions which we call commands. This command 
   object helps in loose coupling between two classes where one class (invoker) 
   shall call a method on other class (receiver) to perform a business operation.
   
   In object-oriented programming, the command pattern is a behavioral design 
   pattern in which an object is used to encapsulate all information needed to 
   perform an action, a business operation or trigger an event e.g. method name, 
   receiver object reference and method parameter values, if any. This object is 
   called command.
   The similar approach is adapted into chain of responsibility pattern as well. 
   Only difference is that in command there is one request handler, and in chain 
   of responsibility there can be many handlers for single request object.




























 