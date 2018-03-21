package ua.training.entities;

import ua.training.annotation.Collect;

import java.io.Serializable;

import static ua.training.entities.PowerMeasurementType.HORSEPOWER;

public class Car implements Serializable, Cloneable, Vehicle{

    private static final long serialVersionUID = -2089836909067855309L;

    private String brand;
    private double enginePower;
    private int cylinderCount;
    private PowerMeasurementType measurementType = HORSEPOWER;

    private static final double KILOWATT_IN_HOURSEPOWER = 0.735499;
    private static final double HOURSEPOWER_IN_KILOWATT = 1.35962;

    public Car(String brand, double enginePower, int cylinderCount) {
        this.brand = brand;
        this.enginePower = enginePower;
        this.cylinderCount = cylinderCount;
    }

    public Car(String brand, double enginePower, int cylinderCount, PowerMeasurementType measurementType) {
        this(brand, enginePower, cylinderCount);
        this.measurementType = measurementType;
    }

    public void setMeasurementType(PowerMeasurementType measurementType) {
        if(this.measurementType == measurementType)
            return;
        enginePower = measurementType == HORSEPOWER ? enginePower * HOURSEPOWER_IN_KILOWATT :
                enginePower * KILOWATT_IN_HOURSEPOWER;
        this.measurementType = measurementType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public void setCylinderCount(int cylinderCount) {
        this.cylinderCount = cylinderCount;
    }

    @Collect
    public String getBrand() {
        return brand;
    }

    @Collect
    public double getEnginePower() {
        return enginePower;
    }

    @Collect
    public int getCylinderCount() {
        return cylinderCount;
    }

    @Collect
    public PowerMeasurementType getMeasurementType() { return measurementType; }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", cylinderCount=" + cylinderCount +
                ", enginePower=" + enginePower +
                " " + measurementType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.enginePower, enginePower) != 0) return false;
        if (cylinderCount != car.cylinderCount) return false;
        return (brand != null ? brand.equals(car.brand) : car.brand == null) && measurementType == car.measurementType;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        temp = Double.doubleToLongBits(enginePower);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cylinderCount;
        result = 31 * result + (measurementType != null ? measurementType.hashCode() : 0);
        return result;
    }

    @Override
    public Car clone() { return new Car(brand, enginePower, cylinderCount, measurementType); }
}
