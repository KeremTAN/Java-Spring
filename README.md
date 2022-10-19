# Spring Framework

&nbsp;  **Spring Framework** is an open source application framework which is leightweight has been designed by **Rod Johnson** and first version released in 2003.

&nbsp;  **The purpose of Spring Framework** is to enable easy, fast and reliable development of any robust and large-scale Java application. Additionally, it provides a bunch of different extensions that can be used to build all kinds of large-scale applications on Java EE (Java Enterprise Edition). Therefore, it is one of the most preferred frameworks in most enterprise Java applications.

&nbsp;  **The reason for the emergence of the Spring Framework** is that Java EE (new name Jakarta EE), which was widely used before the Spring Framework, has a very complex application development environment and a deep Java EE learning requirement due to this complexity. The fact that these requirements also increase the management cost of the applications has ensured that the Spring Framework has been kept in a short time against to Java EE.


### The brief reasons why the Spring Framework is so popular and used are;
 * It uses POJO(Plain Old Java Object), don’t need an enterprise container like an application server.
 * It's is Inversion of Control (IoC) and Dependency Injection (DI) features provide the foundation for a wide-ranging set of features and functionality.
 * It provides a great level of modularity.
 * Well-Designed Web Framework.
 * Spring application code tends to be very easy to make test cases for various testings.
 * Middle-tier objects can be easily organized.
 
#### Plain Old Java Object(POJO) in Briefly
&nbsp; POJO is an ordinary object that is not subject to any special restrictions.
The POJO class does not have connections with another class, such as extends, implements.
POJO file does not require any special classpath. It increases the readability and reusability of a Java program.

Some Properties of POJO
 * The POJO class must be public.
 * It can have a public default constructor or arguments constructor.
 * POJO Classes can have any access modifies such as private, public, protected.
 * A POJO class should not extend predefined classes.
 * It should not implement prespecified interfaces.
 * It should not have any prespecified annotation.
 * All objects must have some public Getters and Setters to access the object values by other Java Programs.
 
 A Code Example of POJO </br>
--------------------------------- </br>
*public class Human{*  </br>
*private String name;*  
*private String lastName;*  
*private int age;* 

*public String getName() {  return name;  }*  
*public void setName(String name) {  this.name = name;  }*  
*public String getlastName() {   return lastName;  }*  
*public void setLastName(String lastName) {   this.lastName = lastName;  }*  
*public int getage() {  return age;  }*  
*public void setAge(int age) {  this.age = age;  }*
*}*</br>
--------------------------------- </br>

#### Inversion of Control(IoC) in Briefly </br>
When a class uses another class, the class controls the another class.</br>
For example, the save behavior of an object calls the save behavior of another object which is a component of the object which is created within itself in some situations. </br>
In some cases, we want to take that control back into our own hands. </br>
This is the inversion of control paradigm.</br>
There are different solutions to do Inversion of Control.</br>
However, the most common way to do IoC is usually to inject another object component inside the object by injecting it from outside instead of rendering it inside the object. </br>
In this way, we can set the save behavior of any desired object wanted to use the save behavior of the object.</br>
That is called Dependency Injection principle.</br>
Other ideas for implementing the IoC paradigm apart from Dependency Injection are Strategy Design Pattern, Service Lacator Design Pattern and Factory Design Pattern. </br>

#### Spring's IoC Container in Briefly
Some of classes are used to carry data, while some of classes are used for their functionality. </br>
It is usually sufficient for us to generate only unique an object from the classes we use for their functionality (in this way, the object generation design is called Singleton Design Pattern). </br>
IoC container is a kind of memory space in Spring. </br>
Singleton objects whose functionality we want to use over and over again are placed in the IoC Container. </br>
When the objects placed in the IoC Container are desired to be used, a reference is assigned to the relevant field with the Dependency Injection principle.</br>
In this way, the objects that we want to use for their functionality are not constantly reproduced. </br>
The @Autowired annotation is usually used for the Dependency Injection method in Spring. With the @Autowired annotation, the address of the required object is taken from the memory and a reference is assigned to the required field. </br>

#### Dependency Injection(DI) in Briefly </br>
Dependency Injection is the last of the principles of S.O.L.I.D. which is the objects needed inject to the dependent object when an object is dependent on another object or objects. </br>
The main purpose of using DI principle is that objects needed can changed without changing dependent object when the objects needed to be changed. </br>
Likewise, when a change is made in the objects needed, it is to prevent it from directly affecting dependent object. </br>
Dependency Injection must take  the control of the creating and etc. of objects needed for being able to do these. </br>
This means that DI uses the IoC paradigsm.</br>

##### Injection can be done in 3 different ways in Dependency Injection
 * **Constructor Injection:** Class needed is provided through the dependency class' constructor. </br>
 --------------------------------- </br>
*public class Controller{*  </br>
*private Service service;* </br>
*public Controller(Service service) {* </br>
&nbsp; *this.service=service; }*</br>
*}* </br>
--------------------------------- </br>

