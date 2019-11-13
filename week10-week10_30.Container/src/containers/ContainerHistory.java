package containers;

import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {
    private List<Double> containerHistory;

    public ContainerHistory() {
        this.containerHistory = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.containerHistory.add(situation);
    }

    public void reset() {
        this.containerHistory.clear();
    }

    public String toString() {
        return this.containerHistory.toString();
    }

    public double maxValue() {
        if (this.containerHistory.isEmpty()) {
            return 0;
        }

        double maxValue = this.containerHistory.get(0);
        for (double value : this.containerHistory) {
            if (value >= maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public double minValue() {
        if (this.containerHistory.isEmpty()) {
            return 0;
        }

        double minValue = this.containerHistory.get(0);
        for (double value : this.containerHistory) {
            if (value <= minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public double average() {
        if (this.containerHistory.isEmpty()) {
            return 0;
        }

        double sum = 0.0;
        for (double value : this.containerHistory) {
            sum += value;
        }
        return sum / this.containerHistory.size();
    }

    public double greatestFluctuation() {
        if (this.containerHistory.isEmpty() || this.containerHistory.size() == 1) {
            return 0;
        }

        double greatestFluctuation = 0.0;

        for (int i = 1; i < this.containerHistory.size(); i++) {
            if (Math.abs(this.containerHistory.get(i) - this.containerHistory.get(i - 1)) >= greatestFluctuation) {
                greatestFluctuation = Math.abs(this.containerHistory.get(i) - this.containerHistory.get(i - 1));
            }
        }
        return greatestFluctuation;
    }

    public double variance() {
        if (this.containerHistory.isEmpty() || this.containerHistory.size() == 1) {
            return 0;
        }

        double variance = 0.0;
        for (double value : this.containerHistory) {
            variance += ((value - this.average()) * (value - this.average()));
        }
        return variance / (this.containerHistory.size() - 1);
    }
}
