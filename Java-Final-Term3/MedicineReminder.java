import java.time.LocalDate;
import java.time.LocalTime;

public class MedicineReminder {
    private int id;
    private int userId;
    private String medicineName;
    private String dosage;
    private LocalTime schedule;
    private LocalDate startDate;
    private LocalDate endDate;

    public MedicineReminder(int id, int userId, String medicineName, String dosage, LocalTime schedule, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.userId = userId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.schedule = schedule;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MedicineReminder(int userId, String medicineName, String dosage, LocalTime schedule, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.schedule = schedule;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalTime schedule) {
        this.schedule = schedule;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getTime() {
        return this.schedule;
    }
}


// LocalTime schedule = LocalTime.of(10, 0);
// LocalDate startDate = LocalDate.of(2023, 4, 17);
// LocalDate endDate = LocalDate.of(2023, 4, 30);
// MedicineReminder medicineReminder = new MedicineReminder(1, 75, "Ibuprofen", "200mg", schedule, startDate, endDate);