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
            System.out.println("\t\t\t||----------| 1: City Management     |---||");
            System.out.println("\t\t\t||----------| 2: City History Management  |");
            System.out.println("\t\t\t||----------| 3: Quitter             |---||");
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
        City ct = new City();
        int choice, id, currentTemperature, currentHumidity, currentWindSpeed;
        String name;
        do {
            System.out.println("*************************************************");
            System.out.println("*           City Management System               *");
            System.out.println("*************************************************");
            System.out.println("* 1. Add City                                   *");
            System.out.println("* 2. Update City                                 *");
            System.out.println("* 3. Delete City                                 *");
            System.out.println("* 4. Display All City                            *");
            System.out.println("* 5. Search City                                 *");
            System.out.println("* 6. Quitter                                     *");
            System.out.println("*************************************************");

            System.out.println("Enter your choice: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
//                    System.out.print("ID : ");
//                    id = new Scanner(System.in).nextInt();
                    System.out.print("NAME : ");
                    ct.setCityName(new Scanner(System.in).nextLine());
                    System.out.print("Current Temperature : ");
                    ct.setCurrentTemperature(new Scanner(System.in).nextInt()) ;
                    System.out.print("Current Humidity : ");
                    ct.setCurrentHumidity(new Scanner(System.in).nextInt()) ;
                    System.out.print("Current WindSpeed : ");
                    ct.setCurrentWindSpeed(new Scanner(System.in).nextInt());
                    DatabaseManager.addCity(ct);
//                    DatabaseManager.AddCity();
                    break;
                case 2:
                    System.out.print("Enter City ID to update: ");
                    ct.setCityId(new Scanner(System.in).nextInt());
                    System.out.print("New City name : ");
                    ct.setCityName(new Scanner(System.in).nextLine());
                    System.out.print("New Temperature : ");
                    ct.setCurrentTemperature(new Scanner(System.in).nextInt()) ;
                    System.out.print("New Humidity : ");
                    ct.setCurrentHumidity(new Scanner(System.in).nextInt()) ;
                    System.out.print("New WindSpeed : ");
                    ct.setCurrentWindSpeed(new Scanner(System.in).nextInt());
                    DatabaseManager.updateCity(ct);
                    break;
                case 3:
                    System.out.print("Enter City ID to delete: ");
                    ct.setCityId(new Scanner(System.in).nextInt());
                    DatabaseManager.deleteCity(ct.getCityId());
                    break;
                case 4:
                    System.out.println("All Cities:");
                    for (City ct1 : DatabaseManager.getAlCities()) {
                        System.out.println(ct1);
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
//                    DatabaseManager.getItemByName();
                    break;
            }
        } while (choice != 6);
    }

    public static void cityHistoryInfo() throws SQLException {
        int choice, id_h, temperature, cityId;
        String Event_S;
        LocalDate eventDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        CityHistory cth=new CityHistory();
        do {
            System.out.println("*************************************************");
            System.out.println("*           City Management System               *");
            System.out.println("*************************************************");
            System.out.println("* 1. Add City History                            *");
            System.out.println("* 2. Update City History                         *");
            System.out.println("* 3. Delete City History                         *");
            System.out.println("* 4. Display All City History                    *");
            System.out.println("* 5. Search City History                         *");
            System.out.println("* 6. Quitter                                     *");
            System.out.println("*************************************************");

            System.out.println("Enter your choice: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
//                    System.out.print("ID : ");
//                    id_h = new Scanner(System.in).nextInt();
                    System.out.print("Temperature : ");
                    cth.setTemperature(new Scanner(System.in).nextInt()) ;
                    System.out.println("Enter publication date of book (DD/MM/YYYY): ");
                    Event_S = new Scanner(System.in).nextLine();
                    try {
                        cth.setEventDate(LocalDate.parse(Event_S, formatter));

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use DD/MM/YYYY.");
                                           }
                    System.out.print("City id : ");
                    cth.setCityId(new Scanner(System.in).nextInt());
                    DatabaseManager.addCityHistory(cth);
                    break;
                case 2:
                    cth.setHistoricalDataId(new Scanner(System.in).nextInt()) ;
                    System.out.print("New Temperature : ");
                    cth.setTemperature(new Scanner(System.in).nextInt());
                    System.out.println("Enter publication date of book (DD/MM/YYYY): ");
                    Event_S = new Scanner(System.in).nextLine();
                    try {
                        cth.setEventDate(LocalDate.parse(Event_S, formatter));

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use DD/MM/YYYY.");
                        return;
                    }
                    System.out.print("City id : ");
                    cth.setCityId(new Scanner(System.in).nextInt());
                    DatabaseManager.updateCityHistory(cth);
                    break;
                case 3:
                    System.out.print("Enter City ID to delete: ");
                    cth.setHistoricalDataId(new Scanner(System.in).nextInt());
                    DatabaseManager.deleteCityHistory(cth.getHistoricalDataId());
                    break;
                case 4:
                    System.out.println("All Cities:");
                    for (CityHistory cth1 : DatabaseManager.getAlCityHistory()) {
                        System.out.println(cth1);
                    }
                    break;
                case 5:
                    System.out.print("Enter the id of the city history to search: ");
                    int cityidToSearch = new Scanner(System.in).nextInt();
                    DatabaseManager.getCityHistoryById(cityidToSearch);
//                    CityHistory selectedCity = DatabaseManager.getCityHistoryById(cityidToSearch);
//
//                    if (selectedCity != null) {
////                        System.out.println("Selected City:");
////                        System.out.println("ID: " + selectedCity.getCityId());
////                        System.out.println("Name: " + selectedCity.getCityName());
////                        System.out.println("Temperature: " + selectedCity.getCurrentTemperature());
////                        System.out.println("Humidity: " + selectedCity.getCurrentHumidity());
////                        System.out.println("Wind Speed: " + selectedCity.getCurrentWindSpeed());
//                        for (CityHistory cth : DatabaseManager.getAlCityHistory()) {
//                            System.out.println(cth);
//                        }
//                    } else {
//                        System.out.println("City history not found.");
//                    }
//                    break;
            }
        } while (choice != 6);

    }
}
