package howoldareyou;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main extends AgeCalculator
{

    public static void main(String[] args)
    {

        System.out.println("Enter you date of birth (yyyy-mm-dd):");

        //It prevents entering the wrong date format and throwing DateTimeParseException
        try {
            LocalDate birthDate;
            LocalDate currentDate;
            LocalDate nextBDay;

            Scanner scanner = new Scanner(System.in);

            //Get date of user's birth
            birthDate = LocalDate.parse(scanner.nextLine());

            //Get today date
            currentDate = LocalDate.now();

            //Get years, months and days since birthday
            int years = AgeCalculator.calculateAge(birthDate,currentDate).getYears();
            int months = AgeCalculator.calculateAge(birthDate,currentDate).getMonths();
            int days = AgeCalculator.calculateAge(birthDate,currentDate).getDays();

            //Singular version of words related to the date
            String sgYear = " year, ";
            String sgMonth = " month ";
            String sgDay = " day";

            //Changing singular to plural if years/months/days are bigger than one
            if (years>1)
                sgYear = " years, ";

            if (months>1)
                sgMonth = " months ";

            if (days>1)
                sgDay = " days";


            //Check if date of birth isn't after current date
            if (birthDate.isAfter(currentDate))
            {
                System.out.println("This date is after today. You cannot have birthday in that day ;)");
            }
            else
            {
                //Print the result
                System.out.println("You have: " + years + sgYear + months + sgMonth + "and " + days + sgDay + ".");
            }

            //Getting date of the next birthday
            nextBDay = birthDate.withYear(currentDate.getYear());

            //If user's birthday has occurred this year already, add 1 to the year.
            if (nextBDay.isBefore(currentDate) || nextBDay.isEqual(currentDate))
            {
                nextBDay = nextBDay.plusYears(1);
            }

            //Calculate date to next the birthday
            Period timeToNextBDay = AgeCalculator.nextBirthDay(nextBDay,currentDate);

            //Get number of months to the next birthday
            int monthsToNextBDay = timeToNextBDay.getMonths();

            //Get number of days to the next birthday
            int daysToNextBDay = timeToNextBDay.getDays();

            //Singular version of words related to the date of next birthday
            String sgNextMonth = " month,";
            String sgNextDay = " day ";

            //Changing singular to plural
            if (monthsToNextBDay>1)
                sgNextMonth = " months,";

            if (daysToNextBDay>1)
                sgNextDay = " days ";


            System.out.println("There are " + monthsToNextBDay + sgNextMonth +" and " + daysToNextBDay + sgNextDay + "until your next birthday.");

        }
        catch (DateTimeParseException e)
        {
            System.out.println("Invalid date format");
        }
    }
}

