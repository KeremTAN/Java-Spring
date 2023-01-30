# JAVA Spring
<!-- Lists -->
* [Spring Framework](#springframework)
    * [The brief reasons why the Spring Framework is so popular and used are;](#why)
        * [Plain Old Java Object(POJO) in Briefly](#pojo)
        * [Inversion of Control(IoC) in Briefly](#ioc)
        * [Spring's IoC Container in Briefly](#sioc)
        * [Dependency Injection(DI) in Briefly](#di)
            1. [Constructor Dependency Injection](#dic)
            2. [Property(or Setter) Dependency Injection](#dip)
            3. [Interface(or Method) Dependency Injection](#dii)
            4. [[Bonus] Field Dependency Injection](#dif)
* [Spring Boot](#springboot)
    * [Spring Boot Layered Architecture](#sbla)
        * [Presentation Layer](#pl)
        * [Business Layer](#bl)
        * [Persistence Layer](#pla)
    * [Entity Objects](#eo)
* [Application Programming Interface(API)](#api)
* [Representational State Transfer(REST)](#rest)
    * [REST API](#restapi)
* [Challenge Project](#chpr)

<a name="springframework"></a>
## Spring Framework

&nbsp;  **Spring Framework** is an open source application framework which is leightweight has been designed by **Rod Johnson** and first version released in 2003.

&nbsp;  **The purpose of Spring Framework** is to enable easy, fast and reliable development of any robust and large-scale Java application. Additionally, it provides a bunch of different extensions that can be used to build all kinds of large-scale applications on Java EE (Java Enterprise Edition). Therefore, it is one of the most preferred frameworks in most enterprise Java applications.

&nbsp;  **The reason for the emergence of the Spring Framework** is that Java EE (new name Jakarta EE), which was widely used before the Spring Framework, has a very complex application development environment and a deep Java EE learning requirement due to this complexity. The fact that these requirements also increase the management cost of the applications has ensured that the Spring Framework has been kept in a short time against to Java EE.

<a name="why"></a>
### The brief reasons why the Spring Framework is so popular and used are;
 * It uses POJO(Plain Old Java Object), don’t need an enterprise container like an application server.
 * It's is Inversion of Control (IoC) and Dependency Injection (DI) features provide the foundation for a wide-ranging set of features and functionality.
 * It provides a great level of modularity.
 * Well-Designed Web Framework.
 * Spring application code tends to be very easy to make test cases for various testings.
 * Middle-tier objects can be easily organized.

<a name="pojo"></a>

### Plain Old Java Object(POJO) in Briefly
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

```java
public class Human{
    private String name; 
    private String lastName;  
    private int age;

    public String getName() {  return name;  } 
    public void setName(String name) {  this.name = name;  } 
    public String getlastName() {   return lastName;  }  
    public void setLastName(String lastName) {   this.lastName = lastName;  }
    public int getage() {  return age;  }
    public void setAge(int age) {  this.age = age;  }
}
```
---------------------------------

<a name="ioc"></a>

### Inversion of Control(IoC) in Briefly </br>
When a class uses another class, the class controls the another class.</br>
For example, the save behavior of an object calls the save behavior of another object which is a component of the object which is created within itself in some situations. </br>
In some cases, we want to take that control back into our own hands. </br>
This is the inversion of control paradigm.</br>
There are different solutions to do Inversion of Control.</br>
However, the most common way to do IoC is usually to inject another object component inside the object by injecting it from outside instead of rendering it inside the object. </br>
In this way, we can set the save behavior of any desired object wanted to use the save behavior of the object.</br>
That is called Dependency Injection principle.</br>
Other ideas for implementing the IoC paradigm apart from Dependency Injection are Strategy Design Pattern, Service Lacator Design Pattern and Factory Design Pattern. </br>

<a name="sioc"></a>

### Spring's IoC Container in Briefly
Some of classes are used to carry data, while some of classes are used for their functionality. </br>
It is usually sufficient for us to generate only unique an object from the classes we use for their functionality (in this way, the object generation design is called Singleton Design Pattern). </br>
IoC container is a kind of memory space in Spring. </br>
Singleton objects whose functionality we want to use over and over again are placed in the IoC Container. </br>
When the objects placed in the IoC Container are desired to be used, a reference is assigned to the relevant field with the Dependency Injection principle.</br>
In this way, the objects that we want to use for their functionality are not constantly reproduced. </br>
The @Autowired annotation is usually used for the Dependency Injection method in Spring. With the @Autowired annotation, the address of the required object is taken from the memory and a reference is assigned to the required field. </br>

<a name="di"></a>

### Dependency Injection(DI) in Briefly </br>
Dependency Injection is that needed object(s) inject to the dependent object when an object is dependent on another object(s). </br>
The main purpose of using DI principle is that needed object(s) can changed without changing dependent object when the needed object(s) to be changed. </br>
Likewise, when a change is made in the needed object(s), it is to prevent it from directly affecting dependent object. </br>
Dependency Injection must take the control of the creating and etc. of needed object(s) for being able to do these. </br>
This means that DI uses the IoC paradigsm.</br>

### Injection can be done in 3 different ways in Dependency Injection
<a name="dic"></a>

 * **Constructor Dependency Injection:** Needed class is provided through the dependency class' constructor. </br>

 ```java
public class Controller{
    private IServices service;
    public Controller(IServices service) {
        this.service=service;
    }
}
```
 --------------------------------- 
<a name="dip"></a>

 * **Property(or Setter) Dependency Injection:** The injector supplies the needed object(s) through a public property of the dependency class. </br>

 ```java
public class Controller{
    private IServices service;

    public Controller() {}

    public IServices getService() {
        return this.service;
    }
    public void setService(IServices service) { 
        this.service=service
    }
}
```
 --------------------------------- 
<a name="dii"></a>

 * **Interface(or Method) Dependency Injection:** Provides a method that will pass the transmission of the needed object(s) to any dependent class.
Dependent classes must implement the interface which have the setter method of the object(s) they need.</br>

 ```java
public interface IServicesDependency{
    void setDependecy(IServices service);
}
public class Controller implements IServicesDependency{
    private IServices service;

    public Controller() {}

    @Override
    public void setDependecy(IServices service) {
        this.service=service;
    }
}
```
 ---------------------------------
<a name="dif"></a>

 * **[Bonus] Field Dependency Injection:** Field Injection is a DI technique made thanks to the @Autowired annotation in Spring.
In fact, Field Injection was mentioned indirectly while explaining the IoC Container.
Dependent object takes the memory address of the needed object that already exists in the IoC Container and assigns the reference address to  related field belong to dependent object thanks to @Autowired annotation.</br>

```java
public class Controller{
    @Autowired
    private IServices service;
    public Controller() {}
}
```
 --------------------------------- 
<a name="springboot"></a>

## Spring Boot
&nbsp; The main difference between Spring Framework and Spring Boot is that Spring Framework is a library and Spring Boot is a tool.
Spring Boot makes it faster and easier to develop applications with the Spring Framework. </br></br>
A few features of Spring Boot that make it faster and easier 
 * Creates stand-alone applications.
 * SB comes with Tomcat, Jetty or Undertow embedded.
 * SB does not need XML configuration.
 * SB aims to reduce LOC (Lines of Code).
 * SB is easy to start.
 * Customization and management is simple.
 
 <a name="sbla"></a>

 ### Spring Boot Layered Architecture
&nbsp; This is used architectural structure in Spring Boot.
In layered artichecture, classes are divided into certain groups/layers and each divided group/layer has its own task.
The reason why the file structures are arranged in this way is that the reusability, maintainability and debugability of the projects(especially the complex ones) can be controlled and updated in a right way. </br>

<a name="pl"></a>

The first of these layers is the **Presentation Layer** </br>
&nbsp; The Presentation Layer communicates with the client. The **@RestController** or **@Controller** annotations are used to indicate that the classes in the Presentation Layer belong to that layer. In this layer, requests(data) from the client are transferred to the next layer(Business Layer) via Database Transfer Objects(DTO) or data which is came from the Business Layer is returned to the client. </br>

<a name="bl"></a>

The second of these layers is the **Business Layer** </br>
&nbsp; The Business Layer is the layer where the desired work is done. For example, calculating the discount of the price of the products in the cart, etc. in an e-commerce application.
The **@Service** anonotation is used to indicate that the classes in the Business Layer belong to this layer.
The desired solution is produced with the data transferred to it from the Presentation Layer via DTO in the Business layer. If the produced solution is needed to be returned directly to the client, it is returned to the Presentation layer with DTO in this layer. If the produced solution is needed to be saved in the database, it is transferred to the next layer (Persistence Layer) with Entity objects from this layer. </br>

<a name="pla"></a>

The third of these layers is the **Persistence Layer** </br>
&nbsp; Persistence Layer communicates with the Database Layer. Hollow interfaces instead of classes are defined in this layer. Interfaces are defined with **@Repository** annotation in this layer. Spring makes the necessary implementations for the interfaces when it sees **@Repository** annotation and makes its interfaces with Repository annotation ready for use. Entity objects from the Business Layer are sent to the Database Layer or the data requested from the Database Layer are sent to the Business Layer as Entity objects in this layer. </br>
Persistence Layer and Presentation Layer cannot communicate directly with each other! </br>

<a name="eo"></a>

**Entity Objects** </br>
&nbsp; Entity objects are defined with **@Entity** annotation. An Entity class corresponds to a table in database.  For example, an AdminEntity class corresponds to the Admin table in the database. Fields defined with special annotations in Entity classes are created as columns in the database and the values of these fields are added/deleted or etc. to the relevant columns. </br>

<a name="api"></a>
 
## Application Programming Interface(API)
&nbsp;  APIs allow the functions of one application to be used in another application.
In this way, applications can be run that are independent of each other in an integrated way.
In this respect, the APIs are like a puzzle.
Different platforms can connected and meet their needs using their APIs and services.
This means that APIs allows services and products to communicate with each other and leverage each other's data and functionality through a documented interface. </br>

A few advantages of APIs
 * Centralizing different platforms in one panel.
 * Scattered and large structures can be combined and managed.
 * APIs makes sharing and distributing content easier.
 * APIs enables the most used content and services to be customizable.
 * Contents can be automatically broadcast for each channel.
 * APIs makes service delivery more flexible.
 * Different versions of the same application can be developed on many different devices thanks to APIs.

<a name="rest"></a>

## Representational State Transfer(REST) 
REST is an architecture that enables lightweight and easy Clint-Server communication with HTTP. </br>
Roy Fielding developed this architecture as a doctoral thesis in the 2000s.</br>
REST allows communication with a variable URL rather than a constant URL as in Simple Object Access Protocol (SOAP).</br>
If you want to get information from the http://theserver/example web address in SOAP, the relevant method should be run on this address.</br>
For example; GetUsers method</br>
If you want to get information in Rest, you can directly access the related method with the variable web address logic.</br>
For example; http://theserver/example/GetUser or http://theserver/example/GetUser/8.</br>

<a name="restapi"></a>

### REST API
&nbsp; A REST API is an API that conforms to the design principles or representative state transfer architecture style of REST.
REST APIs are sometimes called RESTful APIs.
REST APIs is used to get information from a web service or to provide information to a website.
All communications over the REST API use HTTP request only. </br>

&nbsp; Working paradigm of Rest APIs A request is sent to the server by the client as HTTP POST, GET, PUT, PATCH, DELETE and etc. method were in the form of a web URL. These correspond to create, read, update and delete (or CRUD) operations respectively. After the server receives the request, it sends a like HTML, XML, Image, JSON or etc. recource to the client.</br>

**POST** is mostly used to create new record. Returns HTTP status 201 when successfully created. </br>

**GET** is used to read/get the representation of a record. It returns HTTP status 200 (OK) when secure. It usually returns a status of HTTP 404 (NOT FOUND) or  HTTP 400 (BAD REQUEST) when the event of an error. </br>

**PUT** is used to update but If the record ID is chosen by the client rather than the server, it can also be used to create a record.
On a successful update, it returns an HTTP status of 200 (or 204 if not returning any content in the body). PUT returns HTTP status 201 on successful a record creation If it is used to create a record. </br>

**PATCH** is used to modify. PATCH request should only contain changes to the record. It should not the entire record.
This is similar to PUT but the body contains a set of instructions that explain how a record currently on the server must be modified to produce a new version.
Therefore, PATCH body must not be just a modified part of the record but it must be in some kind of patch language like JSON Patch or XML Patch. </br>

**DELETE** is used by the URI to delete an identified record. It returns a 200 (OK) HTTP status on successful a record deletion.


<a name="chpr"></a>

## Challenge Project

 &nbsp; I have developed a Rest API where you can see the stock market share prices of companies which are done in the Challenge Project module. I got stock markets information from https://www.alphavantage.co/documentation/. </br>
Here is an example json object related to the data provided by this api;
```json
{
    "Meta Data": {
        "1. Information": "Daily Time Series with Splits and Dividend Events",
        "2. Symbol": "IBM",
        "3. Last Refreshed": "2023-01-27",
        "4. Output Size": "Compact",
        "5. Time Zone": "US/Eastern"
    },
    "Time Series (Daily)": {
        "2023-01-27": {
            "1. open": "134.44",
            "2. high": "135.488",
            "3. low": "133.7701",
            "4. close": "134.39",
            "5. adjusted close": "134.39",
            "6. volume": "8143146",
            "7. dividend amount": "0.0000",
            "8. split coefficient": "1.0"
        },
        ...
    }
}
```

&nbsp; I first populated my own database using Alphavantage's API. The h2 database is currently used as the database. If you want to use the Postgresql database, you can remove the comment lines in the **application.properties** section and add the h2 database settings to the comment line.
If the postgresql database is not installed on your computer, you can go to the **'src/main/recources'** directory and run the
```bash
docker-compose -f docker-compose.yml up -d
```
command to pull the postgresql image to your own computer.

&nbsp; You can see stock prices by making date and company code based requests to this Rest API with Postman. You can go to the **'src/main/recources/PostmanCollection'** directory and import the json file there to your Postman and use the collections I have already prepared.
An image from the Collections of Postman; </br>
![UML]()

An output example from the Challenge Project;
```json
{
    "date": "2023-01-27",
    "symbol": "IBM",
    "1. open": "134.44",
    "2. high": "135.488",
    "3. low": "133.7701",
    "4. close": "134.39",
    "5. adjusted close": "134.39",
    "6. volume": "8143146"
}
```
