

import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The MedicineReminderManager class should have methods to add reminders, get reminders
 *  1. for a specific user, and
 *  2. get reminders that are DUE for a specific user.
 *
 *  You'll need to integrate this class with your application and database logic to
 *  1. store,
 *  2. update, and
 *  3. delete reminders as needed.
 */

public class MedicineReminderManager {
    private List<MedicineReminder> reminders;

    public MedicineReminderManager() {
        this.reminders = new ArrayList<>();
    }

    public void addReminder(MedicineReminder reminder) {
        reminders.add(reminder);
    }

    public List<MedicineReminder> getRemindersForUser(int userId) {
        List<MedicineReminder> userReminders = new ArrayList<>();
    
        for (MedicineReminder reminder : reminders) {
            if (reminder.getUserId() == userId) {
                userReminders.add(reminder);
            }
        }

        return userReminders;
    }

    public List<MedicineReminder> getDueReminders(int userId) {
        List<MedicineReminder> dueReminders = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        
        for (MedicineReminder reminder : reminders) {
            if (reminder.getUserId() == userId) {
                LocalDateTime reminderTime = reminder.getStartDate().atTime(reminder.getTime());
                if (reminderTime.isBefore(now)) {
                    dueReminders.add(reminder);
                }
            }
        }
        return dueReminders;
    }
}
