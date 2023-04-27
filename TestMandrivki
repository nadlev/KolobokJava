import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Mandrivka {
    String name;
    String city;

    public Mandrivka(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " - " + city;
    }
}

public class Main {
    static Mandrivka[] mandri = new Mandrivka[5];

    public static void main(String[] args) {
        mandri[0] = new Mandrivka("Ivan", "Kyiv");
        mandri[1] = new Mandrivka("Petro", "Lviv");
        mandri[2] = new Mandrivka("Oksana", "Kyiv");
        mandri[3] = new Mandrivka("Ivan", "Lviv");
        mandri[4] = new Mandrivka("Oksana", "Odessa");

        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Enter 'A' to get list of travelers who never visited a city");
        System.out.println("Enter 'B' to get list of cities where a traveler visited");
        System.out.println("Enter 'C' to get list of travelers who visited all cities");

        input = scanner.nextLine();
        switch (input) {
            case "A":
                System.out.println("Enter city name:");
                String city = scanner.nextLine();
                List<String> travelers = getTravelers();
                List<String> visitedTravelers = getVisitedTravelers(city);
                for (String traveler : travelers) {
                    if (!visitedTravelers.contains(traveler)) {
                        System.out.println(traveler);
                    }
                }
                break;
            case "B":
                System.out.println("Enter traveler name:");
                String traveler = scanner.nextLine();
                List<String> visitedCities = getVisitedCities(traveler);
                for (String visitedCity : visitedCities) {
                    System.out.println(visitedCity);
                }
                break;
            case "C":
                List<String> allCities = getAllCities();
                List<String> allTravelers = getTravelers();
                List<String> traveledToAllCities = getTraveledToAllCities(allCities, allTravelers);
                for (String travelerName : traveledToAllCities) {
                    System.out.println(travelerName);
                }
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static ArrayList<String> getTraveledToAllCities(Mandrivka[] mandri) {
    ArrayList<String> traveledToAllCities = new ArrayList<String>();
    String[] cities = getAllCities(mandri);

    for (Mandrivka m : mandri) {
        boolean allCitiesVisited = true;

        for (String city : cities) {
            if (!m.getVisitedCities().contains(city)) {
                allCitiesVisited = false;
                break;
            }
        }

        if (allCitiesVisited) {
            traveledToAllCities.add(m.getName());
        }
    }

    return traveledToAllCities;
}

    public static List<String> getTravelers() {
        List<String> travelers = new ArrayList<>();
        for (Mandrivka mandrivka : mandri) {
            if (!travelers.contains(mandrivka.name)) {
                travelers.add(mandrivka.name);
            }
        }
        return travelers;
    }

    public static List<String> getVisitedCities(String travelerName) {
        List<String> visitedCities = new ArrayList<>();
        for (Mandrivka mandrivka : mandri) {
            if (mandrivka.name.equals(travelerName)) {
                visitedCities.add(mandrivka.city);
            }
        }
        return visitedCities;
    }

    public static ArrayList<String> getAllCities(Mandrivka[] mandri) {
    ArrayList<String> cities = new ArrayList<>();

    for (Mandrivka mandrivka : mandri) {
        String city = mandrivka.city;
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }

    return cities;
}

public static ArrayList<String> findNeverVisited(Mandrivka[] mandri, String city) {
    ArrayList<String> neverVisited = new ArrayList<>();
    ArrayList<String> visited = new ArrayList<>();

    // Створюємо список відвіданих міст
    for (Mandrivka mandrivka : mandri) {
        String visitedCity = mandrivka.city;
        if (!visited.contains(visitedCity)) {
            visited.add(visitedCity);
        }
    }

    // Знаходимо міста, які ніколи не відвідували
    for (Mandrivka mandrivka : mandri) {
        if (!mandrivka.city.equals(city)) {
            if (!visited.contains(mandrivka.city) && !neverVisited.contains(mandrivka.name)) {
                neverVisited.add(mandrivka.name);
            }
        }
    }

    return neverVisited;
}

Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.println("Введіть запит (А, Б або В) або 'exit' для виходу:");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            switch (input) {
                case "А":
                    System.out.println("Введіть назву міста:");
                    String city = scanner.nextLine();
                    ArrayList<String> neverVisited = findNeverVisited(mandri, city);
                    if (neverVisited.size() == 0) {
                        System.out.println("Усі мандрівники відвідали місто " + city);
                    } else {
                        System.out.println("Мандрівники, які ніколи не відвідували місто " + city + ":");
                        for (String name : neverVisited) {
                            System.out.println(name);
                        }
                    }
                    break;
                case "Б":
                    System.out.println("Введіть ім'я мандрівника:");
                    String name = scanner.nextLine();
                    ArrayList<String> visitedCities = findVisitedCities(mandri, name);
                    if (visitedCities.size() == 0) {
                        System.out.println("Мандрівник " + name + " не відвідував жодного міста");
                    } else {
                        System.out.println("Міста, які відвідав мандрівник " + name + ":");
                        for (String cityVisited : visitedCities) {
                            System.out.println(cityVisited);
                        }
                    }
                    break;
                case "В":
                    ArrayList<String> allCities = findAllCities(mandri);
                    HashMap<String, ArrayList<String>> visitedMap = new HashMap<>();
                    for (String cityVisited : allCities) {
                        for (Mandrivka mandrivka : mandri) {
                            if (mandrivka.getCity().equals(cityVisited)) {
                                String nameVisited = mandrivka.getName();
                                ArrayList<String> citiesVisited = visitedMap.getOrDefault(nameVisited, new ArrayList<>());
                                citiesVisited.add(cityVisited);
                                visitedMap.put(nameVisited, citiesVisited);
                            }
                        }
                    }
                    System.out.println("Мандрівники, які відвідали всі міста:");
                    for (String nameVisited : visitedMap.keySet()) {
                        if (visitedMap.get(nameVisited).size() == allCities.size()) {
                            System.out.println(nameVisited);
                        }
                    }
                    break;
                default:
                    System.out.println("Неправильний запит, спробуйте ще раз");
                    break;
            }
        }