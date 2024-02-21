import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int choice, id,currentTemperature,currentHumidity,currentWindSpeed;
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
                    DatabaseManager.addCity(new City(id, name, currentTemperature,currentHumidity,currentWindSpeed));
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
                    DatabaseManager.updateCity(new City(id, name, currentTemperature,currentHumidity,currentWindSpeed));
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
                    String cityNameToSearch =new  Scanner(System.in).nextLine();
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
        }while (choice != 6) ;

    }
}