import com.example.time.ITimeConverterService;
import org.springframework.stereotype.Service;

@Service
public class TimeConverterServiceImpl implements ITimeConverterService {
    public  String convertToWords(String timeStr) {

        try {

            int hour = Integer.parseInt(timeStr.split(":")[0]);
            int minute = Integer.parseInt(timeStr.split(":")[1]);

            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Invalid time format");
            }
            String[] hours = {
                    "Midnight", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve"
            };
            String[] minutes = {
                    "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
            };
            String[] tens = {
                    "", "", "twenty", "thirty", "forty", "fifty"
            };
            String timeInWords = "";
            if (hour == 0 && minute == 0) {
                timeInWords = "Midnight";
            } else if (hour == 12 && minute == 0) {
                timeInWords = "Midday";
            } else {
                if (hour >= 13) {
                    hour -= 12;
                }
                timeInWords = "It's " + hours[hour];
                if (minute != 0) {
                    if (minute < 10) {
                        timeInWords += " o'clock " + hours[minute];
                    } else if (minute < 20) {
                        timeInWords += " " + minutes[minute];
                    } else {
                        timeInWords += " " + tens[minute / 10] + " " + minutes[minute % 10];
                    }
                }
            }
            return timeInWords;

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format");
        }
    }



}
