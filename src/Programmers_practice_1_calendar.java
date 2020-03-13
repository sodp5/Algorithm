import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Programmers_practice_1_calendar {
    public String solution(int a, int b) throws ParseException {
        String answer = "";
        String[] result = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        String A;
        String B;

        if (a < 10) {
            A = "0" + a;
        } else {
            A = "" + a;
        }

        if (b < 10) {
            B = "0" + b;
        } else {
            B = "" + b;
        }

        String d = "2016" + A + B;
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(d);

        Calendar calendar = Calendar.getInstance(Locale.KOREA);
        calendar.setTime(date);
        answer = result[calendar.get(Calendar.DAY_OF_WEEK) % 8 - 1];

        return answer;
    }
}
