package com.leapley.Week4;

import java.util.*;

/*
Hudson Leapley 2/7/2019
Write a program that first prompts the user to enter a list of city names,
one at a time until the user specifies "END". Next, the program should prompt
the user to enter the average daily temperature for each of the next five days
for each city. The program should store the user's cities and temperature data
in one data structure. Next, calculate the five-day average for each city.

Finally, display a message containing the city's name and the average for each city.

The code to prompt the user for input, to calculate the five-day average, and to display
the results should be in separate methods.

Hint: You can use String.split(" ") to split a string into an array of strings based on where spaces occur in the original string.
 */
public class Main {

    static void displayTemp(Map<String, Double> cityNTemp){ //Method to display city and average temperature.

        for(Map.Entry<String,Double> entry : cityNTemp.entrySet()) { //For each loop the treemap.
            String city = entry.getKey();
            Double avgTemp = entry.getValue();
            System.out.println("City: " + city);
            System.out.println("Avg Temp: " + avgTemp);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Double> cityNTemps = new TreeMap<>();
        String input;

        do{ //Enter cities into list until 'END'
            System.out.println("Enter city name('END' when done):");
            input = scan.nextLine();
            if (!input.contains("END")){
                cityNTemps.put(input,0.0);
            }
        }while(!input.contains("END"));

        for(Map.Entry<String,Double> entry : cityNTemps.entrySet()){ //For each loop the treemap
            String city = entry.getKey();
            double temp = 0;
            for(int z=1;z<=5;z++){
                System.out.println("What is the temperature in "+ city + " during Day " + z + ":");
                temp+=scan.nextDouble();
            }
            cityNTemps.put(city,(temp/5)); //Update key/value
        }

        displayTemp(cityNTemps);
    }
}







//OLD CODE

/*

    static void display(List<String> cities,int cityCount){ //Display results
        for (int i=0;i<cityCount;i++){
            System.out.println("City: " + cities.get(i));
            System.out.println("Avg Temp: " + cities.get(i+cityCount));
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
	    List<String> cities = new ArrayList<>();
        String input;
        int cityCount = 0;

        do{ //Enter cities into list until 'END'
            System.out.println("Enter city name('END' when done):");
            input = scan.nextLine();
            if (!input.contains("END")){
                cities.add(input);
                cityCount++;
            }
        }while(!input.contains("END"));

        for(int i=0;i<cityCount;i++){
            double temp = 0;
            for(int z=1;z<=5;z++){
                System.out.println("What is the temperature in "+ cities.get(i) + " during Day " + z + ":");
                temp+=scan.nextDouble();
            }
            cities.add(Double.toString(temp/5));
        }
        display(cities,cityCount);
    }

    */