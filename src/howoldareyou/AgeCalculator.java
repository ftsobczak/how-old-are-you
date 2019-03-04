package howoldareyou;

/**
 * Class <code>AgeCalculator</code> calculates user's age nad time to her/his next birthday.
 */

import java.time.LocalDate;
import java.time.Period;

class AgeCalculator
{

    AgeCalculator()
    {
    }

    /**
     *
     * @param birthDate - date of user's birthday
     * @param currentDate - today date
     * @return period between current date and user's birthday
     */
    static Period calculateAge(LocalDate birthDate, LocalDate currentDate)
    {
        return Period.between(birthDate, currentDate);
    }

    /**
     *
     * @param nextBDay - date of user's next birthday
     * @param currentDate - today date
     * @return period between current date and user's next birthday
     */
    static Period nextBirthDay(LocalDate nextBDay, LocalDate currentDate)
    {
        return Period.between(currentDate, nextBDay);
    }
}
