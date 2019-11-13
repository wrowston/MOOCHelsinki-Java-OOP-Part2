package farmsimulator;

public class MilkingRobot {
    private BulkTank bulkTank = null;

    public BulkTank getBulkTank() {
        return bulkTank;
    }

    public void setBulkTank(BulkTank bulkTank) {
        this.bulkTank = bulkTank;
    }

    public void milk(Milkable milkable) {
        if (this.bulkTank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        this.bulkTank.addToTank(milkable.milk());
    }
}
