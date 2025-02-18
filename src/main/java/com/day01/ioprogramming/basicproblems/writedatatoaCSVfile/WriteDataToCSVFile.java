package com.day01.ioprogramming.basicproblems.writedatatoaCSVfile;

import com.opencsv.CSVWriter;
import java.io.*;
import java.util.Scanner;

public class WriteDataToCSVFile {


    public static void writeDataToCSVFileUsingFileWriter(String fileName) {
        Scanner scanner=new Scanner(System.in);
        try {
            FileWriter writer=new FileWriter(fileName);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write("ID, Name, Department, Salary");
            bufferedWriter.newLine();
            for (int i=0;i<1;i++){
                System.out.println("Enter Employee ID ");
                int ID=scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter Employee Name ");
                String name=scanner.nextLine();

                System.out.println("Enter Employee Department ");
                String department=scanner.nextLine();

                System.out.println("Enter Employee Salary ");
                double salary=scanner.nextDouble();
                scanner.nextLine();

                bufferedWriter.write(ID+","+name+","+department+","+salary);


            }
            bufferedWriter.flush();
            System.out.println("CSV file created successfully: " + fileName);

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("Error in writing to file");
        }

        scanner.close();
    }
    public static void writeDataToCSVFileUsingOpenCSV(String fileName){
        Scanner scanner=new Scanner(System.in);
        try {
            FileWriter writer=new FileWriter(fileName);
            CSVWriter csvWriter=new CSVWriter(writer);
            String header[]={"ID, Name, Department, Salary"};
            csvWriter.writeNext(header);
            for (int i=0;i<2;i++){
                System.out.println("Enter Employee ID ");
                String ID=scanner.nextLine();

                System.out.println("Enter Employee Name ");
                String name=scanner.nextLine();

                System.out.println("Enter Employee Department ");
                String department=scanner.nextLine();

                System.out.println("Enter Employee Salary ");
               String salary=scanner.nextLine();


                String emp[]={ID, name, department,salary};

                csvWriter.writeNext(emp);

            }
            csvWriter.flush();
            System.out.println("CSV file created successfully: " + fileName);

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("Error in writing to file");
        }

    }
}
