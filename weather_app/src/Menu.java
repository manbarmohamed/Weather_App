import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    public static void MenuPrincipal() throws SQLException {
        int mainChoice;

        do {
            System.out.println("\t\t\t||=======================================||");
            System.out.println("\t\t\t||----------| Main Menu |----------------||");
            System.out.println("\t\t\t||=======================================||");
            System.out.println("\t\t\t||----------| 1: City Management      |---||");
            System.out.println("\t\t\t||----------| 2: City History Management |");
            System.out.println("\t\t\t||----------| 3: Quitter               |---||");
            System.out.println("\t\t\t||=======================================||");
            System.out.print("Enter your choice: ");
            mainChoice = new Scanner(System.in).nextInt();

            switch (mainChoice) {
                case 1:
                    cityInfo();
                    break;
                case 2:
                    cityHistoryInfo();
                    break;
                case 3:
                    System.out.println("End Programme!!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (mainChoice != 3);
    }

    public static void cityInfo() throws SQLException {
        int choice, id, currentTemperature, currentHumidity, currentWindSpeed;
        String name;
        do {
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("\t\t\t||------------|              City Management            |-----------||");
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("\t\t\t||------------|   1: Add City                            |-----------||");
            System.out.println("\t\t\t||------------|   2: Update City                         |-----------||");
            System.out.println("\t\t\t||------------|   3: Delete City                         |-----------||");
            System.out.println("\t\t\t||------------|   4: Display All City                    |-----------||");
            System.out.println("\t\t\t||------------|   5: Search City                         |-----------||");
            System.out.println("\t\t\t||------------|   6: Quitter application                    |-----------||");
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("Enter votre choix: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID : ");
                    id = new Scanner(System.in).nextInt();
                    System.out.print("NAME : ");
                    name = new Scanner(System.in).nextLine();
                    System.out.print("Current Temperature : ");
                    currentTemperature = new Scanner(System.in).nextInt();
                    System.out.print("Current Humidity : ");
                    currentHumidity = new Scanner(System.in).nextInt();
                    System.out.print("Current WindSpeed : ");
                    currentWindSpeed = new Scanner(System.in).nextInt();
                    DatabaseManager.addCity(new City(id, name, currentTemperature, currentHumidity, currentWindSpeed));
                    break;
                case 2:
                    System.out.print("Enter City ID to update: ");
                    id = new Scanner(System.in).nextInt();
                    System.out.print("NAME : ");
                    name = new Scanner(System.in).nextLine();
                    System.out.print("Current Temperature : ");
                    currentTemperature = new Scanner(System.in).nextInt();
                    System.out.print("Current Humidity : ");
                    currentHumidity = new Scanner(System.in).nextInt();
                    System.out.print("Current WindSpeed : ");
                    currentWindSpeed = new Scanner(System.in).nextInt();
                    DatabaseManager.updateCity(new City(id, name, currentTemperature, currentHumidity, currentWindSpeed));
                    break;
                case 3:
                    System.out.print("Enter City ID to delete: ");
                    id = new Scanner(System.in).nextInt();
                    DatabaseManager.deleteCity(id);
                    break;
                case 4:
                    System.out.println("All Citys:");
                    for (City ct : DatabaseManager.getAlCities()) {
                        System.out.println(ct);
                    }
                    break;
                case 5:
                    System.out.print("Enter the name of the city to search: ");
                    String cityNameToSearch = new Scanner(System.in).nextLine();
                    City selectedCity = DatabaseManager.getCityByName(cityNameToSearch);

                    if (selectedCity != null) {
                        System.out.println("Selected City:");
                        System.out.println("ID: " + selectedCity.getCityId());
                        System.out.println("Name: " + selectedCity.getCityName());
                        System.out.println("Temperature: " + selectedCity.getCurrentTemperature());
                        System.out.println("Humidity: " + selectedCity.getCurrentHumidity());
                        System.out.println("Wind Speed: " + selectedCity.getCurrentWindSpeed());
                    } else {
                        System.out.println("City not found.");
                    }
                    break;
            }
        } while (choice != 6);
    }
    public static void cityHistoryInfo() throws SQLException {
        int choice, id_h,temperature,cityId;
        String Event_S ;
        LocalDate eventDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("\t\t\t||------------|              City Management            |-----------||");
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("\t\t\t||------------|   1: Add City History                            |-----------||");
            System.out.println("\t\t\t||------------|   2: Update City History                        |-----------||");
            System.out.println("\t\t\t||------------|   3: Delete City History                      |-----------||");
            System.out.println("\t\t\t||------------|   4: Display All City History                 |-----------||");
            System.out.println("\t\t\t||------------|   5: Search City History                     |-----------||");
            System.out.println("\t\t\t||------------|   6: Quitter                     |-----------||");
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("Enter votre choix: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID : ");
                    id_h = new Scanner(System.in).nextInt();
                    System.out.print("Temperature : ");
                    temperature = new Scanner(System.in).nextInt();
                    System.out.println("Enter publication date of book (DD/MM/YYYY): ");
                    Event_S = new Scanner(System.in).nextLine();
                    try {
                         eventDate = LocalDate.parse(Event_S, formatter);

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use DD/MM/YYYY.");
                        return;
                    }
                    System.out.print("City id : ");
                    cityId = new Scanner(System.in).nextInt();
                    DatabaseManager.addCityHistory(new CityHistory(id_h,cityId,eventDate,temperature));
                    break;
                case 2:
                    id_h = new Scanner(System.in).nextInt();
                    System.out.print("Temperature : ");
                    temperature = new Scanner(System.in).nextInt();
                    System.out.println("Enter publication date of book (DD/MM/YYYY): ");
                     Event_S = new Scanner(System.in).nextLine();
                    try {
                        eventDate = LocalDate.parse(Event_S, formatter);

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use DD/MM/YYYY.");
                        return;
                    }
                    System.out.print("City id : ");
                    cityId = new Scanner(System.in).nextInt();
                    DatabaseManager.updateCityHistory(new CityHistory(id_h,cityId,eventDate,temperature));
                    break;
                case 3:
                    System.out.print("Enter City ID to delete: ");
                    id_h = new Scanner(System.in).nextInt();
                    DatabaseManager.deleteCityHistory(id_h);
                    break;
                case 4:
                    System.out.println("All Citys:");
                    for (CityHistory cth : DatabaseManager.getAlCityHistory()) {
                        System.out.println(cth);
                    }
                    break;
                case 5:
                    System.out.print("Enter the id of the city history to search: ");
                    int cityidToSearch =new  Scanner(System.in).nextInt();
                    CityHistory selectedCity = DatabaseManager.getCityHistoryByName(cityidToSearch);

                    if (selectedCity != null) {
//                        System.out.println("Selected City:");
//                        System.out.println("ID: " + selectedCity.getCityId());
//                        System.out.println("Name: " + selectedCity.getCityName());
//                        System.out.println("Temperature: " + selectedCity.getCurrentTemperature());
//                        System.out.println("Humidity: " + selectedCity.getCurrentHumidity());
//                        System.out.println("Wind Speed: " + selectedCity.getCurrentWindSpeed());
                        for (CityHistory cth : DatabaseManager.getAlCityHistory()) {
                            System.out.println(cth);
                        }
                    } else {
                        System.out.println("City history not found.");
                    }
                    break;
            }
        }while (choice != 6) ;

    }
}
