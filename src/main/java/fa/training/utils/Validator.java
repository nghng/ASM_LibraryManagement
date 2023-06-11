package fa.training.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String ISBN_REGEX = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)((?:\\d+[- ]?)){3}\\d+[- ]{0,1}\\d+[- ]{0,1}\\d+[- ]{0,1}\\d+[- ]{0,1}\\d+[- ]{0,1}\\d+$";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String EMPTY_DATE_ERR = "Date cannot be empty!";
    private static final String INCORRECT_FORMAT_ERR = "Incorrect date format - dd/MM/yyyy";
    private static final String FUTURE_DATE_ERR = "Date must be before current date!";
    private static Validator instance;
    private Scanner sc = new Scanner(System.in);

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public int validateChooseMenu(int min, int max) {
        int option = -1;
        do {
            System.out.println("Please choose a menu option from " + min + " to " + max + ":");

            try {
                option = Integer.parseInt(sc.nextLine());
                if (option < min || option > max) {
                    System.out.println("Options must be in the range of " + min + " to " + max);
                }
            }catch (Exception e){
                System.out.println("Invalid input");
            }

        } while (option < min || option > max);
        return option;
    }


    public String validateISBN(String message) {
        String isbn;
        while (true) {
            System.out.println(message);
            isbn = sc.nextLine();
            Matcher matcher = Pattern.compile(ISBN_REGEX).matcher(isbn);
            if (matcher.matches()) {
                return isbn;
            }
            System.out.println("Invalid ISBN format");
        }
    }


    public Set<String> validationAuthor(String mess) {
        System.out.println(mess);
        int num = validateIntInput("Number of author: ");
        System.out.println("Input name of author: ");
        Set<String> authors = new HashSet<>();
        while (num > 0) {
            String authorName = validateStringInput("Author name: ");
            if (authors.contains(authorName)) {
                System.out.println("Duplicate author name");
            } else {
                authors.add(authorName);
                num--;
            }
        }
        return authors;
    }

    private LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            System.out.println(INCORRECT_FORMAT_ERR);
            return null;
        }
    }

    public LocalDate validateDate(String message) {
        System.out.println(message);
        LocalDate date;
        while (true) {
            String dateStr = sc.nextLine().trim();
            if (dateStr.isBlank()) {
                System.out.println(EMPTY_DATE_ERR);
                continue;
            }
            date = parseDate(dateStr);
            if (date != null && date.isBefore(LocalDate.now())) {
                break;
            } else if (date != null) {
                System.out.println(FUTURE_DATE_ERR);
            }
        }
        return date;
    }


    public String validateStringInput(String message) {
        System.out.println(message);
        String input = sc.nextLine().trim();

        while (input.isBlank() || input.isEmpty()) {
            System.out.println("The input can't be blank or empty, please enter a valid input: ");
            input = sc.nextLine();
        }
        return input;
    }

    public int validateIntInput(String message) {
        int num;
        do {
            System.out.println(message);
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Invalid input. Please enter a valid positive integer.");
            }
            num = sc.nextInt();
            sc.nextLine();
            if (num <= 0) {
                System.out.println("Invalid input. Please enter a integer greater than 0.");

            }

        } while (num <= 0);
        return num;
    }


}
