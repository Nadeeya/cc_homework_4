//bad code  

//Chapter 6 OBJECTS AND DATA STRUCTURES

//Data abstraction
//def:providing abstract interfaces (abstract ways) that allow its users to manipulate the data,
//without having to know its implementation.
//This is not abstraction:

public class Rectangle{
    private double width;
    private double height;

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }
}

//This is also not abstraction:
public interface vehicle {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();

}

//The law of Demeter:
//should not know about the inner details of the objects it manipulates.
//software should not have the knowledge of the internal working of other objects or components.
//Train wrecks:
//code that violate the Law of Demeter:

public void showData(Car car){
    printStreet(car.getOwner().getAddress().getStreet());
}

//it violates the law because the method received the parameter car, so all method calls on this object are allowed.
//But, calling any methods (in this case getAddress() and getStreet()) on the object returned by getOwner() is not allowed. 

//CHAPTER 7 ERROR HANDLING 
//use exceptions rather than return codes

public class DeviceController {
 //..
    public void sendShutDown() {
    DeviceHandle handle = getHandle(DEV1);
    // Check the state of the device
    if (handle != DeviceHandle.INVALID) {
        // Save the device status to the record field
        retrieveDeviceRecord(handle);
        // If not suspended, shut down
        if (record.getStatus() != DEVICE_SUSPENDED) {
            pauseDevice(handle);
            clearDeviceWorkQueue(handle);
            closeDevice(handle);
        } else {
            logger.log("Device suspended. Unable to shut down");
         }
    } else {
        logger.log("Invalid handle for: " + DEV1.toString());
    }
 }
 //...
}

//DONT RETURN NULL

 public void registerItem(Item item) {
    if (item != null) {
        ItemRegistry registry = peristentStore.getItemRegistry();
        if (registry != null) {
            Item existing = registry.getItem(item.getID());
            if (existing.getBillingPeriod().hasRetailOwner()) {
                existing.register(item);
            }
        }
    }
 }


List<Employee> employees = getEmployees();
    if (employees != null) {
        for(Employee e : employees) {
            totalPay += e.getPay();
        }
    }

//dont pass null
public class MetricsCalculator
{
    public double xProjection(Point p1, Point p2) {
        return (p2.x – p1.x) * 1.5;
    }

}

//CHAPTER 8 BOUNDARIES

//using third-party code

Map sensors = new HashMap();
//when other part of the code needs to access the sensor, you see this code:
Sensor s = (Sensor)sensors.get(sensorId );

Map<Sensor> sensors = new HashMap<Sensor>();  
Sensor s = sensors.get(sensorId );

//learning log4j

@Test
public void testLogCreate() {
    Logger logger = Logger.getLogger("MyLogger");
    logger.info("hello");
}

@Test
    public void testLogAddAppender() {
        Logger logger = Logger.getLogger("MyLogger");
        ConsoleAppender appender = new ConsoleAppender();
        logger.addAppender(appender);
        logger.info("hello");
    }


@Test
public void testLogAddAppender() {
    Logger logger = Logger.getLogger("MyLogger");
    logger.removeAllAppenders();
    logger.addAppender(new ConsoleAppender(
    new PatternLayout("%p %t %m%n"),
    ConsoleAppender.SYSTEM_OUT));
    logger.info("hello");
}

