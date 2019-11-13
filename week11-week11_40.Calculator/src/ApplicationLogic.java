public class ApplicationLogic {
    private int result;

    public void plus(int value) {
        this.result += value;
    }

    public void minus(int value) {
        this.result -= value;
    }

    public void reset() {
        this.result = 0;
    }

    public int result() {
        return this.result;
    }
}