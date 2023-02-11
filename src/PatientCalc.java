/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 /*
 * @author Silas
 */
public class PatientCalc {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
     System.out.println("*************");
     System.out.println("Journey Lite Patient Metric Calculator");
     System.out.println("*************");

    double height = 0;
    double weight = 0;
    int age = 0;
    char gender = ' ';
    double percent = 0;
    
    while (height <= 0) {
      System.out.print("Enter your height (in inches, must be greater than 0): ");
      height = scanner.nextDouble();
    }
    
    while (weight <= 0) {
      System.out.print("Enter Intial Weight (in pounds, must be greater than 0): ");
      weight = scanner.nextDouble();
    }
      System.out.print("Enter Todays Weight: ");
         double todayWeight = scanner.nextDouble();
    while (age <= 0) {
      System.out.print("Enter age (in years, must be greater than 0): ");
      age = scanner.nextInt();
    }
    
    while (gender != 'm' && gender != 'f') {
      System.out.print("Enter your gender (M or F, Must be lowercase!): ");
      
      gender = scanner.next().charAt(0);


        System.out.println("\n *** RESULTS ***: ");
                

        
    double weightLost = weight-todayWeight;
    double bmi = weight * 703 / (height * height);
    double bee = 0;
    double newBee = 0;
    double currentBmi = todayWeight * 703 / (height*height);
    double idealWeight = 110+(height-60)*5.06;
    double excessWeightLossPercent = (weightLost / weight) * 100;
    double excessBodyWeight = weight-idealWeight;
    double goalWeight = todayWeight-(0.75*excessBodyWeight);
    double fluidGoal = (goalWeight / 2.2)*30;
    double ebwl = (weightLost/excessBodyWeight)*100;
    double proteinGoal = 0;
    
    currentBmi = (double) Math.round(currentBmi * 10) / 10;
    fluidGoal = Math.round(fluidGoal);
    goalWeight = Math.round(goalWeight);
    idealWeight = Math.round(idealWeight);
    excessWeightLossPercent = Math.round(excessWeightLossPercent);
    bmi = (double) Math.round(bmi * 10) / 10;
    
    if (gender == 'm') 
    {
      bee = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
      proteinGoal = (idealWeight/2.2)*1.1;
    } 
    else if (gender == 'f') 
    {
      bee = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
      proteinGoal = (idealWeight/2.2)*1.1;
    }
    bee = (double) Math.round(bee * 10) / 10;
    
    if (gender == 'm') {
     newBee = 66 + (6.23 * goalWeight) + (12.7 * height) - (6.8 * age);
    } else if (gender == 'f') {
      bee = 655 + (4.35 * goalWeight) + (4.7 * height) - (4.7 * age);
    }
    newBee = (double) Math.round(newBee * 10) / 10;
    
    

     
     
    
    
    
 


    

    if(weightLost < 0)
    {
        System.out.println("Patient has GAINED, negative (-) value equals pounds gained!");
    }
    
    // Console OUTPUT Statements *********
    System.out.println("Patient has lost/gained: " + weightLost +  "lbs, " + excessWeightLossPercent + "% of excess weight");
    System.out.println("Starting BMI: " + bmi);
    System.out.println("Current BMI: " + currentBmi);
    // BMI Overweight/Underweight Determiner
        if (currentBmi < 18.5) {
      System.out.println("Current BMI results = underweight");
    } else if (bmi >= 18.5 && bmi < 25) {
      System.out.println("Current BMI results = normal");
    } else {
      System.out.println("Current BMI results = overweight");
    }
    
    System.out.println("BEE: " + bee + " calories");
    System.out.println("BEE 75%: " + newBee + " calories");
    System.out.println("Goal Weight: " + goalWeight + " pounds");
    System.out.println("Ideal Weight: " + idealWeight);
    System.out.println("Excess Body Weight: " + excessBodyWeight + " lbs");
    System.out.println("Percent Excess Body Weight Loss: " + ebwl + " %");
    System.out.println("Fluid Goal: " + fluidGoal + " cc");
    System.out.println("Protein Goal: " + proteinGoal + " grams");
    
    System.out.print("\nEnter Desired TBWL Loss Percent (5,8,10 or custom): ");
    double twbl = scanner.nextDouble();
    double scheduleWeight = (todayWeight*twbl)/100;
    System.out.println("Pre Schedule Loss: " + todayWeight + " > " + scheduleWeight + "lbs lost" );
    
    
    
     System.out.print("\nDo you want to save the output to a txt file? (y/n): ");
     
     
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter the name for the txt file: ");
            String fileName = scanner.next();
            try {
                File file = new File(fileName + ".txt");
                FileWriter writer = new FileWriter(file);
                    writer.write("Journeylite Weight Loss Metrics"+ System.lineSeparator());
                  writer.write("BEE: " + bee + " calories\n");
                  writer.write("BEE 75%: " + newBee + " calories\n");
                  writer.write("Goal Weight: " + goalWeight + " pounds\n");
                  writer.write("Ideal Weight: " + idealWeight + "\n");
                  writer.write("Excess Body Weight: " + excessBodyWeight + " lbs\n");
                  writer.write("Percent Excess Body Weight Loss: " + ebwl + " %\n");
                  writer.write("Fluid Goal: " + fluidGoal + " cc\n");
                  writer.write("Protein Goal: " + proteinGoal + " grams\n");
                    writer.write("Pre Schedule Loss: " + todayWeight + " > " + scheduleWeight + "lbs lost\n");
                    if (currentBmi < 18.5) {
                      writer.write("Current BMI results = underweight\n");
                    } else if (bmi >= 18.5 && bmi < 25) {
                      writer.write("Current BMI results = normal\n");
                    } else {
                      writer.write("Current BMI results = overweight\n");
                    }

                    writer.write("Thank You For Visiting JourneyLite!!!"+ System.lineSeparator());
                writer.close();
                System.out.println("File saved successfully! To acess the txt file, please visit this applications folder.");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("Output not saved to a file.");
        }
    
    }
    }
}





    

    
    
  

        // TODO code application logic here
    
    

