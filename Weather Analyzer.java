package Package1;
import java.util.Scanner;

public class Assignment_2 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int days;
        do {
            System.out.println("How many days are you going to check? (Enter a number between 1 and 365): ");
            days = input.nextInt();
            if (days < 1 || days > 365) {
                System.out.println("That doesn't seem right! Please pick a number between 1 and 365.");
            }
        } while (days < 1 || days > 365);
        
        double[] lows = new double[days];
        double[] highs = new double[days];
        
        for (int i = 0; i < days; i++) {
            double lowTemp, highTemp;
            do {
                System.out.println("What was the low temperature for day " + (i + 1) + "?");
                lowTemp = input.nextDouble();
                
                if (lowTemp < -45 || lowTemp > 45) {
                    System.out.println("Oops! That's out of range. It must be between -45 and 45.");
                    continue;
                }
                
                System.out.println("And the high temperature?");
                highTemp = input.nextDouble();
                
                if (highTemp < -45 || highTemp > 45 || highTemp < lowTemp) {
                    System.out.println("Hmmm... that doesn't seem right. It should be between -45 and 45, and higher than the low temperature.");
                    continue;
                }
                
                break;
            } while (true);
            
            lows[i] = lowTemp;
            highs[i] = highTemp;
            
            double avgTemp = (lows[i] + highs[i]) / 2;
            System.out.println("The average temperature for day " + (i + 1) + " is: " + avgTemp);
        }
        
        double overallAvg = calculateOverallAverage(lows, highs);
        System.out.println("The overall average temperature is: " + overallAvg);
        
        int lowestDay = findLowestTemperatureDay(lows);
        System.out.println("The coldest day was day " + (lowestDay + 1));
        
        int highestDay = findHighestTemperatureDay(highs);
        System.out.println("The hottest day was day " + (highestDay + 1));
        
        input.close();
    }
    
    public static double calculateOverallAverage(double[] lows, double[] highs) {
        double sum = 0;
        for (int i = 0; i < lows.length; i++) {
            sum += (lows[i] + highs[i]) / 2;
        }
        return sum / lows.length;
    }
    
    public static int findLowestTemperatureDay(double[] lows) {
        int lowestIndex = 0;
        for (int i = 1; i < lows.length; i++) {
            if (lows[i] < lows[lowestIndex]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }
    
    public static int findHighestTemperatureDay(double[] highs) {
        int highestIndex = 0;
        for (int i = 1; i < highs.length; i++) {
            if (highs[i] > highs[highestIndex]) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }
}

