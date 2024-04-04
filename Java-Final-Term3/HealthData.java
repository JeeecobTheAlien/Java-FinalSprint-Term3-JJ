import java.time.LocalDate;

public class HealthData {
    private int id;
    private int userId;
    private double weight;
    private double height;
    private int steps;
    private int heartRate;
    private int sleepHours;
    private LocalDate date;

    public HealthData(int id, int userId, double weight, double height, int steps, int heartRate, int sleepHours, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.weight = weight;
        this.height = height;
        this.steps = steps;
        this.heartRate = heartRate;
        this.sleepHours = sleepHours;
        this.date = date;
    }

    public HealthData(int userId, double weight, double height, int steps, int heartRate, int sleepHours, LocalDate date) {
        this.userId = userId;
        this.weight = weight;
        this.height = height;
        this.steps = steps;
        this.heartRate = heartRate;
        this.sleepHours = sleepHours;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(int sleepHours) {
        this.sleepHours = sleepHours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

// LocalDate date = LocaleDate.of(2023, 4, 17);
// HealthData healthData = newHealthData(1, 75.5, 170.0, 10000, 80, 7, date);
