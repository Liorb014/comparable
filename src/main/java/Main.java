import entities.Country;
import entities.CountryStatisticsManager;
import enums.Continent;
import enums.MenuOption;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        CountryStatisticsManager csm = new CountryStatisticsManager();
        csm.loadDataFromFile("/data.csv");

        Scanner scanner = new Scanner(System.in);
        MenuOption option;
        do {
            System.out.println("Enter option: (A)dd country, (F)ind country, (L)ist countries, (S)ort countries, (C)ontinent filter, (Q)uit");
            String userInput = scanner.nextLine();
            option = MenuOption.fromCode(userInput);

            if (option == null) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            switch (option) {
                case ADD_COUNTRY:
                    // Logic to add country
                    String countryData="";
                    System.out.println("enter country name: ");
                    countryData += scanner.nextLine();
                    System.out.println("enter country population: ");
                    countryData += "," + scanner.nextLine();
                    System.out.println("enter country GDP: ");
                    countryData += "," + scanner.nextLine();
                    System.out.println("enter country content: ");
                    countryData += "," + scanner.nextLine();
                    System.out.println("enter country economic rating: ");
                    countryData += "," + scanner.nextLine();
                    System.out.println("enter country population rating: ");
                    countryData += "," + scanner.nextLine();
                    System.out.println("enter country content rating: ");
                    countryData += "," + scanner.nextLine();
                    Country newCountry = new Country(countryData);
                    CountryStatisticsManager.countries.add(newCountry);
                    break;
                case FIND_COUNTRY:
                    // Logic to find and display country
                    System.out.println("enter your desire country name: ");
                    System.out.println(CountryStatisticsManager.countries.stream().map(country -> country.getName().contains(scanner.nextLine())).findFirst().toString());
                    break;
                case LIST_COUNTRIES:
                    // Logic to list all countries
                    System.out.println(CountryStatisticsManager.countries.toString());
                    break;
                case SORT_COUNTRIES:
                    // Logic to sort countries
                    System.out.println(CountryStatisticsManager.countries.stream().sorted(Comparator.comparing(Country::getName)).toList().toString());
                    break;
                case CONTINENT_FILTER:
                    // Logic to filter countries by continent
                    System.out.println("please enter content name: ");
                    CountryStatisticsManager.countries.stream().filter(country ->{
                        country.getContinent().compareTo(Continent.valueOf(scanner.nextLine()));
                        return true;
                    }).toList();

                    break;
                case QUIT:
                    System.out.println("Exiting...");
                    break;
            }

        } while (option != MenuOption.QUIT);

        scanner.close();
    }
}