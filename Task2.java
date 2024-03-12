package codsoft_internship;

import java.util.Scanner;

public class STUDENT_GRADE_CALCULATOR {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the number of courses: ");
        int numCourses = inputScanner.nextInt();

        int[] courseMarks = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter marks for course " + (i + 1) + " (out of 100): ");
            courseMarks[i] = inputScanner.nextInt();
        }

        int totalScore = calculateTotalScore(courseMarks);
        double averageScore = calculateAverageScore(totalScore, numCourses);

        char performanceGrade = determinePerformanceGrade(averageScore);

        System.out.println("\nPerformance Summary:");
        System.out.println("Total Score: " + totalScore);
        System.out.printf("Average Score: %.2f%%\n", averageScore);
        System.out.println("Performance Grade: " + performanceGrade);
    }

    private static int calculateTotalScore(int[] courseMarks) {
        int totalScore = 0;
        for (int mark : courseMarks) {
            totalScore += mark;
        }
        return totalScore;
    }

    private static double calculateAverageScore(int totalScore, int numCourses) {
        return (double) totalScore / numCourses;
    }

    private static char determinePerformanceGrade(double averageScore) {
        if (averageScore >= 90) {
            return 'A';
        } else if (averageScore >= 80) {
            return 'B';
        } else if (averageScore >= 70) {
            return 'C';
        } else if (averageScore >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
