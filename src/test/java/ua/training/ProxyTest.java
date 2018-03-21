package ua.training;

import org.junit.*;
import ua.training.entities.Car;
import ua.training.entities.Vehicle;
import ua.training.proxy.DynamicProxyHandler;

import java.lang.reflect.Proxy;


public class ProxyTest {
    @Test(expected = Throwable.class)
    public void testProxy(){
        Car mCar = new Car("Mercedes", 500, 10);
        Vehicle car = (Vehicle) Proxy.newProxyInstance(Car.class.getClassLoader(),
                new Class[] {Vehicle.class},
                new DynamicProxyHandler(mCar));
        car.setBrand("Ferrari");
    }
}
