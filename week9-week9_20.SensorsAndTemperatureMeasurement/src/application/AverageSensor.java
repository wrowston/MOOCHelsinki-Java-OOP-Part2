package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> allSensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.allSensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        this.allSensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.allSensors) {
            if (sensor.isOn()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.allSensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.allSensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!isOn()) {
            throw new IllegalArgumentException("All sensors must be turned on");
        } else if (this.allSensors.size() == 0) {
            throw new IllegalArgumentException("Sensor has not been added to AverageSensor yet");
        }

        int sumOfReadings = 0;
        int averageReading = 0;

        for (Sensor sensor : this.allSensors) {
            sumOfReadings += sensor.measure();
        }
        averageReading = sumOfReadings / this.allSensors.size();
        this.readings.add(averageReading);

        return averageReading;
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
