package Utilization;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class FakerUtils {

    private static final Faker faker = new Faker(new Locale("en"));

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomMiddleName() {
        return (String.valueOf(faker.lorem().character()).toUpperCase() + ".");
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress(); // ensures uniqueness
    }

    public static String getRandomPassword() {
        return faker.internet().password(7, 16, true, true, true);
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static String getRandomCountry() {
        return faker.address().country();
    }

    public static String getRandomZipCode() {
        return faker.address().zipCode();
    }

    public static String getRandomCompany() {
        return faker.company().name();
    }

    public static String getRandomJobTitle() {
        return faker.job().title();
    }

    public static String getRandomSentence() {
        return faker.lorem().sentence();
    }

    public static String getRandomParagraph() {
        return faker.lorem().paragraph();
    }

    public static String getRandomUsername() {
        return faker.name().username();
    }

    public static String getRandomFutureDate() {
        return faker.date().future(30, TimeUnit.DAYS).toString();
    }

    public static String getRandomPastDate() {
        Date pastDate = faker.date().past(30, TimeUnit.DAYS);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(pastDate);
    }

    public static int getRandomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public static String getRandomCardNumber() {
        return "4" + faker.number().digits(15); // Visa usually starts with 4
    }

    public static String getRandomCardExpiry() {
        int month = faker.number().numberBetween(1, 12);
        int year = faker.number().numberBetween(26, 30); // 2026–2030
        return String.format("%02d/%02d", month, year);
    }

    public static String getRandomCardCVV() {
        return faker.number().digits(3);
    }

    public static String getRandomCardHolderName() {
        return getRandomFirstName() + " " + getRandomLastName();
    }
}
