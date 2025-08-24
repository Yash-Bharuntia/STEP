import java.util.Scanner;

public class BMICalculator {

    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        return new String[]{String.format("%.2f", bmi), status};
    }

    public static String[][] computeBMIStatus(double[][] hwArray) {
        String[][] result = new String[hwArray.length][4];
        for (int i = 0; i < hwArray.length; i++) {
            double weight = hwArray[i][0];
            double height = hwArray[i][1];
            String[] bmiData = calculateBMI(weight, height);
            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }
        return result;
    }

    public static void displayTable(String[][] arr) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("--------------------------------------------------------");
        for (String[] strings : arr) {
            System.out.println(strings[0] + "\t\t" + strings[1] + "\t\t" + strings[2] + "\t" + strings[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] hwArray = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            hwArray[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            hwArray[i][1] = sc.nextDouble();
        }

        String[][] result = computeBMIStatus(hwArray);
        displayTable(result);
    }
}
