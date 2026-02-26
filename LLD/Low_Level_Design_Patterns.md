# Behavioural Design Pattern

##  1. Memento Design Pattern

The Memento Design Pattern is a behavioral design pattern used to save and restore an object’s previous state without violating **encapsulation** and **Single Responsibility Principle (SRP)**.

Example: Text Editor's Undo Functionallity

- BAD Code example:
    ```java

    public class TextEditor {
        private String content;

        public void write(String text) {
            this.content = text;
        }

        public String getContent() {
            return this.content;
        }
    }


    /**
     * Here If we introduce feature of state management then it will voilate SRP
     * As state management is not the responsibility of our TextEditor
     * 
     */

    ```

### How Memento Design Pattern Help here?

#### Components of Memento Design Patern
- **Originator**: The object whose state need to be saved.
- **Memento**: Captures and stores the internal state of the originator.
- **Caretaker**: Manages and stores the mementos without modifying them.

### Implementation of Undo in Text Editor Using Memento Design Pattern

#### TextEditor Class
This is our **originator**.
```java
public class TextEditor {
    private String content;

    public void write(String text) {
        this.content = text;
    }

    public String getContent() {
        return this.content;
    }
    public EditorMomento save() {
        return new EditorMomento(content);
    }

    public void restore(EditorMomento momento) {
        this.content = momento.getContent();
    }
}
```

#### EditorMemento Class

```java
public class EditorMomento {
    private final String content;

    public EditorMomento(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}

```

#### Caretacker Class [History Class]
It stores and manages the internal states of TextEditor class.
```java
public class History {
    private final Stack<EditorMomento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if(!history.isEmpty()) {
            history.pop();
            editor.restore(history.peek());
        }
    }
}
```

#### Driver Class [Main Class]

```java
public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello WOrld");

        history.saveState(editor);

        editor.write("Hello All");
        history.saveState(editor);

        System.out.println(editor.getContent());

        history.undo(editor);
        System.out.println(editor.getContent());
    }
}
```

## 2. Observer Design Pattern
#### AKA -> PUB - SUB Design Pattern

The Observer design pattern is a behavioral design pattern that establishes a one-to-many dependency, allowing objects (Observers/subscribers) to automatically receive notifications and updates when another object (Subject/publisher/observable) changes its state, promoting loose coupling and efficient event handling without constant polling

### Example:
Let's say we have a weather station in the city and we need to transmit the weather data to all the people having certain type of device. In this case **Observer Design Pattern** will come into picture.


### Code Example

#### We have following components here for Weather Station System
- **Weather Station**: Has sensor for tamprature and transmit the data to all the devices that has subscribed to it.
- **Device**: Devices are responsible for displaying the info sent by Weather Station.

```
<<Subject>> [Interface]
Weather station will implements Subject

<<Device>> [Interface]
Mobile, Display, Tab will implement Device
```

```java
public interface Subject {
    void attach(Device o);
    void detach(Device o);
    void notifyUpdate(String message);
}
```

```java
public class WeatherStation implements Subject {

    List<Device> devices = new ArrayList<>();

    @Override
    public void attach(Device o) {
        devices.add(o);
    }

    @Override
    public void detach(Device o) {
        devices.remove(o);
    }

    @Override
    public void notifyUpdate(String message) {
        for(Device d: devices) {
            d.displayMessage(message);
        }
    }    
}
```

```java
public interface Device {
    public void displayMessage(String message);
}
```

```java
public class Mobile implements Device{

    @Override
    public void displayMessage(String message) {
        System.out.println("Mobile -> " + message);
    }
}
```

```java
public class Screen implements Device{

    @Override
    public void displayMessage(String message) {
        System.out.println("SCREEN -> " + message);
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Mobile mobile = new Mobile();

        station.attach(mobile);
        station.attach(new Screen());

        station.notifyUpdate("Update 1");

        station.detach(mobile);

        station.notifyUpdate("Update 2");
    }
}
```

### Benifits of Observer Design Pattern:
1. **Loose Coupling**: Weather station do not need to know about the observer class it just notify all.
2. **Scalability**: New Observers can be added with minimum effors Open close principle.
3. **Flexibility**: We can add and remove observers dynamically.


### Observer Design Pattern Use Cases:
1. Event Listener.
2. Stock Price Monitoring.
3. News Publishing system.
4. Social Media Notification.
5. Looging System.

## Strategy Design Pattern

Lets understand with an example of a **Payment Service**.
In our Payment Service we have option of paying via multiple channels like Credit Card, Debit Card, UPI etc.
If we simply want to implement the system then the system will look like:

```java
public class PaymentSystem {
    public void makePayment(String paymentMethod) {
        if(paymentMethod.equals("CREDIT_CARD")) {
            System.out.println("Making Payment By Credit Card");
        }
        else if(paymentMethod.equals("DEBIT_CARD")) {
            System.out.println("Making payment via Debit Card");
        }
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        PaymentSystem paymentSystem = new PaymentSystem();

        paymentSystem.makePayment("CREDIT_CARD");
        paymentSystem.makePayment("DEBIT_CARD");
    }
}
```

Now let's say I need to add new Payment Method UPI then I have to make change in the ```makePayment()``` method. Here we are modifying existing code which was already tested, hence we are not respecting **Open Close Principle**.

### Lets solve all the issues with Strategy Design Pattern

```
 _____________________                    _________________
| <<PaymentStrategy>> |                  | Payment System  |
|---------------------| ---------------<>|-----------------|
|+ void makePayment() |                  |
|_____________________|
```

PaymentStrategy Interface which will be implemented by various Payment Channels.
```java
public interface PaymentStrategy {
    public void makePayment();
}
```

PaymentService is responsible for Processing Payment
```java
public class PaymentService {
    public PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment() {
        strategy.makePayment();
    }
}
```

```java
public class DebitCardStrategy implements PaymentStrategy{
    @Override
    public void makePayment() {
        System.out.println("Making Payment Via Debit Card...");
    }
}
```

```java
public class CreditCardStrategy implements PaymentStrategy{

    @Override
    public void makePayment() {
        System.out.println("Making Payment Via Credit Card...");
    }
    
}
```

```java
public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        // service.setStrategy(new CreditCardStrategy());
        service.setStrategy(new DebitCardStrategy());

        service.processPayment();
    }
}
```

All the problems that we have seen earlier have been fixed using strategy Design Pattern.


## Command Design Pattern

Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

![alt text](image.png)
[Different commands are implementing Command interface]
![alt text](image-1.png)

Let's create a text editor where we have different types of buttons like ```bold```, ```italic```, ```underlined``` etc.

```java

class TextEditor {
    public void boldText() {
        System.out.println("Bold Text...");
    }

    public void underLinedText() {
        System.out.println("Underlined Text...");
    }
}

// UI Button
class BoldButton {
    private TextEditor editor;

    public BoldButton(TextEditor editor) {
        this.editor = editor;
    }

    public void click() {
        editor.boldText();
    }
}

class UnderlinedButton {
    private TextEditor editor;

    public UnderlinedButton(TextEditor editor) {
        this.editor = editor;
    }

    public void click() {
        editor.underLinedText();
    }
}

public class WithoutCommandPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        BoldButton boldButton = new BoldButton(editor);

        boldButton.click();
    }
}

```

Here the button is tightly coupled with the ```TextEditor``` class. We want loose coupling here, for that command design pattern will help.

```java
// Command interface
interface Command {
    void execute();
}

// Concrete classes for Commands
class BoldCommand implements Command {

    private TextEditor editor;

    public BoldCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.boldText();
    }
    
}

class TextEditor {
    public void boldText() {
        System.out.println("Bold Text...");
    }

    public void underLinedText() {
        System.out.println("Underlined Text...");
    }
}

// Button Class
class Button {
    private Command command;

    public void setCommandn(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}


public class WithCommandDesignPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        Button button = new Button();

        BoldCommand boldCommand = new BoldCommand(editor);

        button.setCommandn(boldCommand);

        button.click();
        
    }
}
```

#### Command Design Pattern in Java
Usage examples: The Command pattern is pretty common in Java code. Most often it’s used as an alternative for callbacks to parameterizing UI elements with actions. It’s also used for queueing tasks, tracking operations history, etc.

Here are some examples of Commands in core Java libraries:
- All implementations of java.lang.Runnable
- All implementations of javax.swing.Action


## Template Method Pattern

Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

![](image-2.png)

### Example of Template Method Pattern
Let's say we want to design a file parser system, where we need to parse csv, excel, doc & json.

Think about the steps of the parsing:
- Open file
- Parse file
- Close file

Here ```Open and Close file``` both are common for every file parser, so we can put it to template.

```java
class CSVParser {
    public void parse() {
        openFile();
        
        // csvSpecificParsingLogin();
        System.out.println("Parsing CSV file...");

        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file...");
    }

    private void closeFile() {
        System.out.println("Close file...");
    }
}

class JSONParser {
    public void parse() {
        openFile();
        
        // jsonSpecificParsingLogin();
        System.out.println("Parsing JSON file...");

        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file...");
    }

    private void closeFile() {
        System.out.println("Close file...");
    }
}


public class FileParser {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        csvParser.parse();

        JSONParser jsonParser = new JSONParser();
        jsonParser.parse();
    }
    
}
```

Till now we do not know Template Pattern, 
If we look closely `fileOpen()` and `fileClose()` function's implementation is getting duplicated.

We have a principle in Software Engineering that `Do Not Repeat Your Self (DRY)`. Here DRY is not getting followed.

### How do we fix this 🤔?

Answer is `Template Design Pattern ✨`

We will have a abstract class called ``FileParser``, there we will provide the implementation of the methods `fileOpen()` and `fileClose()`. The `fileParse()` method will be `abstract`. All class like CSVParser, DocParser will implement the abstract method as per their needs.


```java
abstract class FileParser {

    public final void parse() {
        fileOpen();
        parseFile();
        fileClose();
    }

    public void fileOpen() {
        System.out.println("FIle Opened...");
    }

    public abstract void parseFile();

    public void fileClose() {
        System.out.println("File Closed...");
    }
}

class CsvParser extends FileParser {

    @Override
    public void parseFile() {
        System.out.println("Parsing CSV....");
    }
    
}

class JsonParser extends FileParser {

    @Override
    public void parseFile() {
        System.out.println("Parsing JSON....");
    }
    
}

public class FileParserGood {
    public static void main(String[] args) {
        FileParser csvParser = new CsvParser();
        FileParser jsonParser = new JsonParser();

        csvParser.parse();
        jsonParser.parse();
    }
    
}

```

## Iterator Design Pattern
Iterator is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

Example:
Lets say we have a Book class and a BookCOllection class, where we store the books in a list, and a client where we iterate over the books and display.

Initially it was a list, but the maintainer changed it to a Set then everywhere we have to change because the iteration logic will break because for set it's different.

Code:

```java
public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book { Title =  '" + this.title + "'}"; 
    }
}
```

```java
public class BookCollection {
    
    private List<Book> books = new ArrayList<>();

    public void addBood(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return this.books;
    }
}
```

```java
public class BadClient {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        collection.addBood(new Book("Java"));
        collection.addBood(new Book("C++"));
        collection.addBood(new Book("Go"));

        for(int i = 0; i < collection.getBooks().size(); i++) {
            System.out.println(collection.getBooks().get(i));
        }
    }
}
/*
* If we change the collection from List to Set then this code will break.
*/
```
### Lets fix this using Iterator Design Pattern ✨

```java
public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book { Title =  '" + this.title + "'}"; 
    }
}
```

```java
public class BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBood(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public Iterator<Book> createIterator() {
        return new BookIterator(this.books);
    }

    // Another class
    private class BookIterator implements Iterator<Book> {
        private List<Book> books;

        private int position = 0;

        public BookIterator(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return position < this.books.size();
        }

        @Override
        public Book next() {
            return books.get(position++);
        }
    }
}
```

```java
public class GoodClient {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        collection.addBood(new Book("Java"));
        collection.addBood(new Book("C++"));
        collection.addBood(new Book("Go"));

        Iterator<Book> bookItr = collection.createIterator();

        while (bookItr.hasNext()) {
            System.out.println(bookItr.next());
        }
    }
}
```

Here best part is client don't have to worry about the iteration logic, it's handled in clooection itself.

### Pros
- Single Responsibility Principle. You can clean up the client code and the collections by extracting bulky traversal algorithms into separate classes.
 
 - Open/Closed Principle. You can implement new types of collections and iterators and pass them to existing code without breaking anything.
 
 - You can iterate over the same collection in parallel because each iterator object contains its own iteration state.
 
 - For the same reason, you can delay an iteration and continue it when needed.


 ## State Pattern

We are creating a module for direction of map application, where we have to share the ETA based on different transport mode such as `CYCLE`, `CAR`, `WALKING` etc.

Without State Pattern Code:

```java
enum TransporationMode {
    WALKING, CAR, TRAIN
}

public class DirectionServiceBad {
    private TransporationMode mode;

    public DirectionServiceBad(TransporationMode mode) {
        this.mode = mode;
    }

    public void setMode(TransporationMode mode) {
        this.mode = mode;
    }

    // Method to calculate ETA
    public int getETA() {
        switch (mode) {
            case WALKING:
                System.out.println("Calculating ETA walking...");
                return 10;
            case CAR:
                System.out.println("Calculating ETA walking...");
                return 5;
            default:
                throw new IllegalArgumentException("Unknown Mode");
        }
    }

    public String getDirection() {
        switch (mode) {
            case WALKING:
                return "Directions for Walking: Head to north 500m";
            case CAR:
                return "Directions for  Car: Use highway 99";
            default:
                return "No direction";
        }
    }
    
}
```

Here let's say tomorrow I want to add new mode like flight then I have to modify the `TransporationMode` enum, also add new case in the `getDirection()` and `getETA()` methods of `DirectionServiceBad`. Which not following 
- Open/ Close principle.
- Tight coupling also there, and too many switch case will make the code base harder to maintain.

### Solution is State Design Pattern

#### Structure of State Pattern:

- Context: Holds the reference to the current state.
- State: Interface for state-specific behaviour.
- Concrete State: Specific implementations of the state interface that represent a particular state of the context object.

```java
public interface TransportationMode {
    int calculateETA();
    String getDirection();
}
```

```java
public class Walking implements TransportationMode{

    @Override
    public int calculateETA() {
        System.out.println("Calculating ETA for Walking...");
        return 100;
    }

    @Override
    public String getDirection() {
        return "Direction - [Walking]: - Go staraight";
    }
    
}
```

```java
public class Car implements TransportationMode{

    @Override
    public int calculateETA() {
        System.out.println("Calculating ETA for Car...");
        return 50;
    }

    @Override
    public String getDirection() {
        return "Direction - [Car]: - Go staraight";
    } 
}
```

```java
public class DirectionService {
    TransportationMode transportationMode;

    public DirectionService(TransportationMode mode) {
        this.transportationMode = mode;
    }

    public int getEta() {
        return transportationMode.calculateETA();
    }

    public String getDirection() {
        return transportationMode.getDirection();
    }
}
```

```java
public class GoodClient {
    public static void main(String[] args) {
        DirectionService service = new DirectionService(new Car());

        service.getDirection();

        service.getEta();
    }
}
```

## Mediator Design Pattern

Example:
Let's build a chat application's group chat module, where when a user sends a message it has to transmitted to every other users in the chat room. If the sending technique is one to one then there will be a complex web of communication with the growing users. There will be need of `O(n^2)` complexity.

### Bad code example:

```java
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void sendMessage(String msg, User recipient) {
        System.out.println(this.name + " Sending message to - "+ recipient.name);
    }
}

public class WithoutMediatorDesignPattern {
    public static void main(String[] args) {
        User suman = new User("Suman");
        User payel = new User("Payel");
        User poli = new User("Poli");

        suman.sendMessage("Hi", poli);
        poli.sendMessage("Hiiiiiiiiii!", suman);

        payel.sendMessage("Hello!", suman);
    }
}

```

The main problem here is every time a message need to be sent to other n - 1 user. And every participant has to be aware of other abd it's their responsibility to make sure to send the message to every other participants in the gtoup vhat.

### Solution: Using mediator design pattern 🫰

If we build same thing using mediator design pattern then there will be a group chat mediator who will be responsible to send messages to other n - 1 participants.

```java
class ChatUser {
    private String name;

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void recieveMessage(String msg, ChatUser sender) {
        System.out.println(sender.name+ " Sayes to - "+ this.name + " : " + msg);
    }
}

interface ChatMediator {

    void sendMessage(String msg, ChatUser user);

    void addUser(ChatUser user);
}

class ChatRoom implements ChatMediator {

    private List<ChatUser> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, ChatUser sender) {
        for(ChatUser user: this.users) {
            if(user.equals(sender)) continue;
            user.recieveMessage(msg, sender);
        }
    }

    @Override
    public void addUser(ChatUser user) {
        users.add(user);
    }
    
}

public class WithMediatorClient {

    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        ChatUser suman = new ChatUser("Suman");
        ChatUser payel = new ChatUser("Payel");
        ChatUser poli = new ChatUser("Poli");

        chatRoom.addUser(suman);
        chatRoom.addUser(payel);
        chatRoom.addUser(poli);

        chatRoom.sendMessage("Hiiiii", suman);
    }
}
```

### Mediator Pattern Benefits

- Reduced Complexity: Centralizes the communication, reducing dependency between the objects.
- Loose Coupling: Objects do not have to worry about the existance of other objects, it is managed by the mediator, here it is Chat Room.
- Signle responsibility: The mediator handles the complex logics of communication, allowing the objects to focus on their own behaviours.
- Centralized control: Changes of communication rules can be handled without effecting the participants.


### Use Cases

- Airport ATC.
- GUI component co-ordination.
- Workflow system.
- Chat system.


# Creational Design Patterns

## Purpose
Creational design patterns are focused on object creation mechanisms, aiming to optimize the creation process with ensuring flexibility.

## Goal
They abstract the instantion process to make system more flexible and resuable

## Problem they solve
Prevent tight coupling between code and object creation logic, symplifying the management of new object creation, specially in complex systems.

### Singleton Design Pattern

In some cases we want only one instance of a class to be created throughout the applications life-cycle, module like: Logger, database connections, setting config etc.

If multiple instance are created then it may lead to:
- Inconsistent state.
- Resource conflict.

```java
public class AppSettings {
    private String databaseUrl;

    private String apiKey;

    public AppSettings() {
        this.databaseUrl = "jdbc://okey";
        this.apiKey = "whjd23ry293ruf2io3huwegydgewidhwhede9==";
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getApiKey() {
        return this.apiKey;
    }
}
```

```java
public class BadClient {
    public static void main(String[] args) {
        AppSettings appSettings = new AppSettings();

        AppSettings appSettingsCopy = new AppSettings();

        System.out.println(appSettings.getApiKey());
        System.out.println(appSettingsCopy.getApiKey());

        // Here we are creating multiple instances of the class AppSettings
        // But ideally only one object should be created
        // This is leading to wastage of resources
    }
}
```

### Good code
```java
public class AppSettings {
    private String databaseUrl;

    private String apiKey;

    // Create Instance of Self
    private static AppSettings instance;

    private AppSettings() {
        this.databaseUrl = "jdbc://okey";
        this.apiKey = "whjd23ry293ruf2io3huwegydgewidhwhede9==";
    }

    public static AppSettings getInstance() {
        if(instance != null) {
            return instance;
        }
        instance = new AppSettings();
        return instance;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getApiKey() {
        return this.apiKey;
    }
}
```

```java
public class GoodClient {
    public static void main(String[] args) {
        AppSettings setting1 = AppSettings.getInstance();
        AppSettings setting2 = AppSettings.getInstance();

        System.out.println(setting1.equals(setting2));
    }
}
```

Here we have single instance, we have ensured signle object creation of the AppSettings class using `Singleton` design pattern.

## Factory Pattern

Factory design pattern helps centralize the creation logic and deligate the responsibility of creating object to factory classes, which decides the specific class to instantiate. This helps in obeying open close principle.

```java
public interface Transport {
    void deliver();
}
```

```java
public class Bike implements Transport{
    @Override
    public void deliver() {
        System.out.println("Deliver By Bike");
    }
}
```

```java
public class Car implements Transport{

    @Override
    public void deliver() {
        System.out.println("Deliver By Car");
    }
}
```

```java
public class TransportFactory {
    public static Transport createTransport(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();      
            default:
                throw new  IllegalArgumentException();
        }
    }
}
```

```java
public class GoodClient {
    public static void main(String[] args) {
        Transport vehicle = TransportFactory.createTransport("car");

        vehicle.deliver();
    }
}
```

The biggest advantage here are:
- New vehicle can be added without modifying the client `[Open/Close Principle]`
- Client and creation logic is completely decopupled.

Real World use cases:
- GUI Framework.
- Database connectivity.
- Document convertion logic.

## Abstract Factory

### Problem Statement
We are building an application, which has different theme based on the OS. Windows theme has it's own button, pointer, scroll-bars etc, same way MacOS also have it's own button, pointer, scroll-bar. Challange is to make an architeture that allows switching between the themes without changing the client code.

```java
// Windows UI components
class WindowsButton {
    public  void render() {
        System.out.println("Rendering windows UI button...");
    }
}

class WindowsScrollBar {
    public  void render() {
        System.out.println("Rendering windows Scroll Bar...");
    }
}

// Mac UI components
class MacButton {
    public  void render() {
        System.out.println("Rendering MAC UI button...");
    }
}

class MacScrollBar {
    public  void render() {
        System.out.println("Rendering MAC Scroll Bar...");
    }
}

public class ApplicationBad {
    public static void main(String[] args) {
        // Windows UI
        WindowsButton button = new WindowsButton();
        WindowsScrollBar scrollBar = new WindowsScrollBar();

        button.render();
        scrollBar.render();

    }
}
```
Here the biggest problem is tight coupling. The client is directly dependent on the concrete classes, which is not solving our purpose.
For Mac UI we have to modify the client.

### Solution is Abstract Factory Pattern

Provides an interface for creating families of related objects without specefing their concrete classes.

#### Structure
- Abstract Factory: Interface for creating the abstract products.
- Concrete Factory: Implements the abstract factory and created the concertr profucts.

```java
// Abstract Product Interface

interface Button {
    void render();
}

interface ScrollBar {
    void scroll();
}

// Windows UI components
class WindowsButton implements Button{
    public  void render() {
        System.out.println("Rendering windows UI button...");
    }
}

class WindowsScrollBar implements ScrollBar{
    public  void scroll() {
        System.out.println("Rendering windows Scroll Bar...");
    }
}

// Mac UI components
class MacButton implements Button{
    public  void render() {
        System.out.println("Rendering MAC UI button...");
    }
}

class MacScrollBar implements ScrollBar{
    public  void scroll() {
        System.out.println("Rendering MAC Scroll Bar...");
    }
}

interface UIFactory {
    public Button createButton();

    public ScrollBar createScrollBar();
}

class WindowsFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar();
    }
    
}

class MacFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacScrollBar();
    }
    
}



public class ApplicationGod{
    private Button button;

    private ScrollBar scrollBar;

    public ApplicationGod(UIFactory factory) {
        this.button = factory.createButton();
        this.scrollBar = factory.createScrollBar();
    }

    public void renderUI() {
        button.render();
        scrollBar.scroll();
    }
    public static void main(String[] args) {
        // Windows UI
        UIFactory factory = new WindowsFactory();
        ApplicationGod application = new ApplicationGod(factory);

        application.renderUI();

    }
}
```

## Builder Design Pattern

When a class have many parameters including required and optional parameters then maintaining the class and it's creation using constructor becomes extremely difficult. This issue can lead to:
- Long constructor Parameter list.
- Difficulity in understanding which values are optionsal or required.
- Lack of flexibility when it comes to setting only same value.

```java
public class House {
    private String foundation;
    private String Structure;
    private String roof;
    private int rooms;
    private int floors;
    private int swimmingPool;

    public House(String foundation) {
        this.foundation = foundation;
    }

    public House(String roof, int swimmingPool) {
        this.roof = roof;
        this.swimmingPool = swimmingPool;
    }
    
}
```

Here for different initialization we need different constructors, which will create dealing with constructors extremely difficult. Also some constructors combination are not allowed in Programming language, like:
```java
public House(String foundation) {
        this.foundation = foundation;
    }

    public House(String roof) {
        this.roof = roof;
    }
```

### Solution: Builder Design Pattern
```java
public class Car {
    // Required Parameters
    private String brand;
    private String model;

    // Optional Parameters
    private String description;
    private double price;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.description = builder.description;
        this.price = builder.price;
    }

    

    public static class Builder {
        // Required Parameters
        private String brand;
        private String model;

        // Optional Parameters
        private String description;
        private double price;

        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
```

## Prototype Design Pattern

Prototype design pattern is helpful for cloning of object. It makes delegates the cloning process to the object that's clone is needed to be created. An object that supports cloning is called a prototype.

Example: I have a board game, where we have different pieces with some specific colors. I need to save the progress of the game, so that If I want to go back previous checkpoiant then I should be able to go easily.
Here is the code:

```java
public class GamePiece {
    private String color;
    private int position;

    public GamePiece(String color, int position) {
        this.color = color;
        this.position = position;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public String getColor() {
        return this.color;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "{" + "color = " + color + " ," + "position = " + position + "}";
    }
}
```

```java
public class GameBoard {
    private List<GamePiece> pieces = new ArrayList<>();

    public void addPiece(GamePiece piece) {
        this.pieces.add(piece);
    }

    public List<GamePiece> getPieces() {
        return this.pieces;
    }

    public void showCurrentBoardState() {
        for(GamePiece p: pieces) {
            System.out.println(p);
        }
    }
}
```
In the client We are trying to copy the state of the game so that we can any time come back and restore the previous state of the game.
But there is a problem: what if I change the `GamePiece` class and add few more attributes, in this case every client need to change the logic of implementation. This will lead to so much code duplication and make modification to the `Piece` class harder, as it involves changing the cloning logic everywhere.
```java
public class GameClientWithoutPrototype {
    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
        gb.addPiece(new GamePiece("Red", 0));
        gb.addPiece(new GamePiece("Green", 1));

        gb.showCurrentBoardState();


        // Let's save the game 
        GameBoard checkPoint1 = new GameBoard();

        for(GamePiece gp: gb.getPieces()) {
            checkPoint1.addPiece(new GamePiece(gp.getColor(), gp.getPosition()));
        }

        checkPoint1.showCurrentBoardState();

    }
}
```
### Solution: Prototype Design Pattern
We will write the cloning logic in the class it self the delegate cloning process to the object, so that our developer changes the class, then cloning logic can also be changed there, which will save us from code duplication and extension of the classes functionality easier.

```java
public interface Prototype<T> {
    T clone();
}
```

```java
public class GamePiece implements Prototype<GamePiece>{
    private String color;
    private int position;

    public GamePiece(String color, int position) {
        this.color = color;
        this.position = position;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    public String getColor() {
        return this.color;
    }

    public int getPosition() {
        return this.position;
    }

    public GamePiece clonePiece() {
        return new GamePiece(this.color, this.position);
    }

    @Override
    public String toString() {
        return "{" + "color = " + color + " ," + "position = " + position + "}";
    }

    @Override
    public GamePiece clone() {
        return new GamePiece(color, position);
    }
}
```

```java
public class GameBoard implements Prototype<GameBoard> {
    private List<GamePiece> pieces = new ArrayList<>();

    public void addPiece(GamePiece piece) {
        this.pieces.add(piece);
    }

    public List<GamePiece> getPieces() {
        return this.pieces;
    }

    public void showCurrentBoardState() {
        for(GamePiece p: pieces) {
            System.out.println(p);
        }
    }

    @Override
    public GameBoard clone() {
        GameBoard newGameBoard = new GameBoard();
        for(GamePiece gp: pieces) {
            newGameBoard.addPiece(gp.clone());
        }
        return newGameBoard;
    }
}
```

```java
public class GameClientWithPrototype {
    public static void main(String[] args) {
        GameBoard gb = new GameBoard();
        gb.addPiece(new GamePiece("Red", 0));
        gb.addPiece(new GamePiece("Green", 1));

        gb.showCurrentBoardState();


        // Let's save the game 
        GameBoard checkPoint1 = new GameBoard();

        for(GamePiece gp: gb.getPieces()) {
            checkPoint1.addPiece(new GamePiece(gp.getColor(), gp.getPosition()));
        }

        checkPoint1.showCurrentBoardState();

    }
}
```

Here the cloning logic is being handled by the class itself reducing the scope of error while cloning. Also ensured Open/ Close principle.

# Structural Design Pattern


## Adapter Design Pattern
Adapter design pattern is a structural design pattern that allows the objects with incompatable intaerface to work togather.
Example: we have charging adapter.

Let's take an example of inhouse email service that will be replaced by third party email service say send grid.

```java
public interface NotificationService {
    void send(String to, String subject, String body);
}

```

```java
// Legacy code
public class EmailNotificationService implements NotificationService{
    public void send(String to, String subject, String body) {
        System.out.println("Sending = " + to);
        System.out.println("Subject = " + subject);
        System.out.println("Body = " + body);
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        emailService.send("sumandas@gamil.com", "Job - Software Engineer", "Job Description");

        // Use sendgrid service for email
        NotificationService newNotificationServivce = new SendGridAdapter(new SendGridSrvice());
        newNotificationServivce.send("payel@gmail.com", "Hi, Payel", "Message body");
    }
}
```

Now we want to use sendbox instead of our in-house notification service.
For that we need to use adapter design pattern because parameter expected by send-grid email is different.

```java
public class SendGridSrvice {
    public void sendEmil(String recipient, String title, String content) {
        System.out.println("Sending email via send grid to " + recipient);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}
```

```java
public class SendGridAdapter implements NotificationService{

    private SendGridSrvice sendGridSrvice;

    public SendGridAdapter(SendGridSrvice service) {
        this.sendGridSrvice = service;
    }

    @Override
    public void send(String to, String subject, String body) {
        // Adapter method - converts parametaers and call function of sendGrid
        sendGridSrvice.sendEmil(to, subject, body);
    }
}
```

### Benefits
- Resuability
- Flexibility
- Decoupling