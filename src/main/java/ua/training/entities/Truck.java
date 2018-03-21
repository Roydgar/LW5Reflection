package ua.training.entities;


import ua.training.annotation.Collect;

public class Truck extends Car{

    private static final long serialVersionUID = 7585841939159370168L;

    private double loadingCapacity;

    public Truck(String brand, double enginePower, int cylinderCount, double loadingCapacity){
        super(brand, enginePower, cylinderCount);
        this.loadingCapacity = loadingCapacity;
    }

    public Truck(String brand, double enginePower, int cylinderCount,
             double loadingCapacity, PowerMeasurementType measurementType) {
        super(brand, enginePower, cylinderCount, measurementType);
        this.loadingCapacity = loadingCapacity;
    }

    @Collect
    public double getLoadingCapacity() {
        return loadingCapacity;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Truck truck = (Truck) o;

        return Double.compare(truck.loadingCapacity, loadingCapacity) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(loadingCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "brand='" + getBrand() + '\'' +
                ", enginePower=" + getEnginePower() +
                " " + getMeasurementType() +
                ", cylinderCount=" + getCylinderCount() +
                ", loadingCapacity=" + loadingCapacity +
                '}';
    }

    @Override
    public Truck clone() { return new Truck(getBrand(), getEnginePower(), getCylinderCount(), loadingCapacity,
            getMeasurementType() ); }
}
