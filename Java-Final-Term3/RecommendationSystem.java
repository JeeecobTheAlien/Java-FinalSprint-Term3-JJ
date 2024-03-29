

import java.util.ArrayList;
import java.util.List;

public class RecommendationSystem {
            private static final int MIN_HEART_RATE = 60;
            private static final int MAX_HEART_RATE = 100;
            private static final int MIN_STEPS = 10000;
            private static final int OPTIMAL_STEPS = 15000;
            private static final int MAX_SLEEP_HOURS = 8;
            private static final int MIN_SLEEP_HOURS = 6;
            private static final int MAX_BMI = 25;
/**
 * In this basic version of the
 * RecommendationSystem class, complete the generateRecommendations to take a
 * HealthData object as input and generates recommendations based on the user's heart rate and step count.
 * You can also expand this class to include more health data analysis and generate more specific
 * recommendations based on the user's unique health profile
 * NOTE:
 * To integrate this class into your application, you'll need to pass the HealthData object to the generateRecommendations method
 * and store the generated recommendations in the recommendations table in the database.
 */

    public List<String> generateRecommendations(HealthData healthData) {
        List<String> recommendations = new ArrayList<>();

        // Analyze heart rate
        int heartRate = healthData.getHeartRate();
        if (heartRate < MIN_HEART_RATE) {
            recommendations.add("Your heart rate is lower than the recommended range. " +
                    "Consider increasing your physical activity to improve your cardiovascular health.");
        } else if (heartRate > MAX_HEART_RATE) {
            recommendations.add("Your heart rate is higher than the recommended range. " +
                    "Consider reducing your physical activity and speaking with a healthcare professional.");
        }

        // Analyze steps
        int steps = healthData.getSteps();
        if (steps < MIN_STEPS) {
            recommendations.add("You are not meeting the minimum daily step count. " +
                    "Try to increase your steps to " + MIN_STEPS + " each day.");
        } else if (steps > OPTIMAL_STEPS) {
            recommendations.add("You have exceeded the optimal daily step count. " +
                    "Consider reducing your steps to " + OPTIMAL_STEPS + " each day, unless you are training for a specific event.");
        }

       // Analyze sleep hours
        int sleepHours = healthData.getSleepHours();
        if (sleepHours < MIN_SLEEP_HOURS) {
            recommendations.add("You are not getting enough sleep. " +
                    "Consider adjusting your sleep schedule to ensure you get at least " + MIN_SLEEP_HOURS + " hours of sleep each night.");
        } else if (sleepHours > MAX_SLEEP_HOURS) {
            recommendations.add("You are getting too much sleep. " +
                    "Consider adjusting your sleep schedule to ensure you do not exceed " + MAX_SLEEP_HOURS + " hours of sleep each night.");
        }

        // Analyze BMI
        double weight = healthData.getWeight();
        double height = healthData.getHeight();
        double bmi = calculateBMI(weight, height);
        if (bmi > MAX_BMI) {
            recommendations.add("Your BMI is higher than the recommended range. " +
                    "Consider speaking with a healthcare professional to develop a weight loss plan.");
        } else if (bmi < 18.5) {
            recommendations.add("Your BMI is lower than the recommended range. " +
                    "Consider speaking with a healthcare professional to develop a weight gain plan.");
        }

//        // Add more health data analysis and recommendations as needed

        return recommendations;
    }

    private double calculateBMI(double weight, double height) {
                return weight / (height * height);
   }
}
