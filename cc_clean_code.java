//CLEAN CODE
//Chapter 6 OBJECTS AND DATA STRUCTURES

//Data abstraction
//def:providing abstract interfaces (abstract ways) that allow its users to manipulate the data,
//without having to know its implementation.

//This is abstraction:
public interface vehicle{
    double getPercentFuelRemaining();
}

// DATA/OBJECT ANTI-STMMETRY:
/* Objects: hide their data (be private) and have functions to operate on that data.
Data Structures: show their data (be public) and have no functions.*/

//Code using Data Structure:

public class Square{
    public Point topLeft;
    public double side;
}

public class Rectangle{
    public Point topLeft;
    public double height;
    public double width;
}

public class Circle{
    public Point center;
    public double radius;
}

public class Geometry{
    public final double PI = 3.14159;

    public double area(Object shape) throws NoSuchShapeException {
        if (shape instanceof Square){
            Square s = (Square) shape;
            return s.side * s.side;
        }
        else if(shape instanceof Rectangle){
            Rectangle r = (Rectangle) shape;
            return r.height *r.width;
        }
        else if (shape instanceof Circle){
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        }
        throw new NoSuchShapeException();
    }
}
// code using OBJECT ORIENTED:
public interface Shape{
    public double area();
}
public class Square implements Shape{
    private Point topLeft;
    private double side;

    public double area(){
        return side * side;
    }
}

public class Rectangle implements Shape{
    private Point topLeft;
    private double height;
    private double width;

    public double area(){
        return height * width;
    }
}

public class Circle implements Shape{
    private Point center;
    private double radius;
    public final double PI = 3.14159;

    public double area(){
        return PI * radius * radius;
    }
}
//The law of Demeter:
//should not know about the inner details of the objects it manipulates.
//software should not have the knowledge of the internal working of other objects or components.

//example:

class MyClass{
    IService service;

    public Myclass(Iservice service){
        this.service = service;
    }

    public void myMethod(Param param){

        //1. O itself
        anotherMethod();

        //2. M's parameters
        param.method1();

        //3. Any objects created within m
        TempObject temp = =new TempObject();
        temp.doSomething();

        //4. O's direct component objects
        service.provideService();

    }
    private void anotherMethod(){
        //...
    }
}

//DATA TRANSFER OBJECT

public class Address {
    private String street;
    private String streetExtra;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String streetExtra, String city, String state, String zip){
        this.street = street;
        this.streetExtra = streetExtra;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet(){
        return street;
    }

    public String getStreetExtra(){
        return streetExtra;
    }

    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getZip(){
        return zip;
    }
}

//CHAPTER 7 ERROR HANDLING
//use exceptions rather than return codes

public class DeviceController {
// ...
    public void sendShutDown() {
        try {
            tryToShutDown();
        } catch (DeviceShutDownError e) {
            logger.log(e);
        }
    }
    private void tryToShutDown() throws DeviceShutDownError {
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);
        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }
    private DeviceHandle getHandle(DeviceID id) {
        //...
        throw new DeviceShutDownError("Invalid handle for: " + id.toString());
        //...
    }
 //...
}
//dont return null
List<Employee> employees = getEmployees();
for(Employee e : employees) {
    totalPay += e.getPay();
}

public class MetricsCalculator{
    public double xProjection(Point p1, Point p2) {
        if (p1 == null || p2 == null) {
            throw InvalidArgumentException(
            "Invalid argument for MetricsCalculator.xProjection");
        }
        return (p2.x – p1.x) * 1.5;
    }
}

//CHAPTER 8 BOUNDARIES

public class Sensors {
    private Map sensors = new HashMap();
    public Sensor getById(String id) {
        return (Sensor) sensors.get(id);
    }
//snip
}

//learning log4j

public class LogTest {
    private Logger logger;
    @Before
    public void initialize() {
        logger = Logger.getLogger("logger");
        logger.removeAllAppenders();
        Logger.getRootLogger().removeAllAppenders();
    }
    @Test
    public void basicLogger() {
        BasicConfigurator.configure();
        logger.info("basicLogger");
    }
    @Test
    public void addAppenderWithStream() {
        logger.addAppender(new ConsoleAppender(
        new PatternLayout("%p %t %m%n"),
        ConsoleAppender.SYSTEM_OUT));
        logger.info("addAppenderWithStream");
    }
    @Test
    public void addAppenderWithoutStream() {
        logger.addAppender(new ConsoleAppender(
        new PatternLayout("%p %t %m%n")));
        logger.info("addAppenderWithoutStream");
    }
}