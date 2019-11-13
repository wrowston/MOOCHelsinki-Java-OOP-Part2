package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume = 0;

    public BulkTank() {
        this.capacity = 2000.0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getVolume() {
        return this.volume;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }

    public void addToTank(double amount) {
        if (this.howMuchFreeSpace() > amount) {
            this.volume += amount;
        } else {
            this.volume = this.capacity;
        }
    }

    public double getFromTank(double amount) {
        if (this.volume >= amount) {
            return this.volume -= amount;
        }
        return this.volume = 0;
    }

    @Override
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
