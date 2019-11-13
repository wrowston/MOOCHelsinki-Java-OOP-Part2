package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive{
    private Random random = new Random();
    private String name;
    private double udderCapacity;
    private double udderAmount = 0;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = NAMES[random.nextInt(NAMES.length)];
        this.udderCapacity = 15 + random.nextInt(26);
    }

    public Cow(String name) {
        this.name = name;
        this.udderCapacity = 15 + random.nextInt(26);
    }

    public String getName() {
        return name;
    }

    public double getUdderCapacity() {
        return udderCapacity;
    }

    public double getUdderAmount() {
        return udderAmount;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.udderAmount) + "/" + Math.ceil(this.udderCapacity);
    }

    @Override
    public void liveHour() {
        double amount = (1.3 * random.nextDouble()) + 0.7;
        if (this.udderAmount + amount <= this.udderCapacity) {
            this.udderAmount += amount;
        } else {
            this.udderAmount = this.udderCapacity;
        }
    }

    @Override
    public double milk() {
        double ret = this.udderAmount;
        this.udderAmount = 0;
        return ret;
    }
}
