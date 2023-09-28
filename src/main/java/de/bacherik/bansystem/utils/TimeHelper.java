package de.bacherik.bansystem.utils;

import de.bacherik.bansystem.platform.bungee.Main;
import de.bacherik.bansystem.utils.config.MessagesConfig;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeHelper {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String timeAddFormat = "^(\\d{0,10})([y,m,w,d,h,m,s])$";

    private static final int YEAR_IN_SEC = 31536000;
    private static final int DAY_IN_SEC = 86400;
    private static final int HOUR_IN_SEC = 3600;
    private static final int MIN_IN_SEC = 60;


    /**
     * This function takes a {@code string} time and adds it to given time {@code LocalDateTime}
     *
     * @param time      the time
     * @param timeToAdd time to be added
     * @return the new time
     */
    public static LocalDateTime addTime(LocalDateTime time, String timeToAdd) {
        Pattern pattern = Pattern.compile(timeAddFormat);
        Matcher matcher = pattern.matcher(timeToAdd); //regex check time format

        if (!matcher.find()) return null;

        int multiplier = Integer.parseInt(matcher.group(1));
        String timeUnit = matcher.group(2);

        long secondsToAdd = secondsToAdd(multiplier, timeUnit);

        return time.plusSeconds(secondsToAdd);
    }


    private static long secondsToAdd(long multiplier, String timeUnit) {
        switch (timeUnit) {
            case "y":
                return YEAR_IN_SEC * multiplier;
            case "d":
                return DAY_IN_SEC * multiplier;
            case "h":
                return HOUR_IN_SEC * multiplier;
            case "m":
                return MIN_IN_SEC * multiplier;
            default:
                return multiplier;
        }
    }

    /**
     * Calculate difference between two dates and return as string format
     *
     * @param start the start date
     * @param end   the end date
     * @return the formatted difference as string
     */
    public static String getDifference(LocalDateTime start, LocalDateTime end) {
        MessagesConfig config = Main.getInstance().getMessagesConfig();

        Duration duration = Duration.between(start, end);
        long years = duration.toDays() / 365;
        if (years > 100) return config.get("bansystem.timeformat.permanent");
        long days = duration.toDays() % 365;
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return (years == 1 ? years + config.get("bansystem.timeformat.year") : (years != 0) ? years + config.get("bansystem.timeformat.years") : "") +
                (days == 1 ? days + config.get("bansystem.timeformat.day") : (days != 0) ? days + config.get("bansystem.timeformat.days") : "") +
                (hours == 1 ? hours + config.get("bansystem.timeformat.hour") : (hours != 0) ? hours + config.get("bansystem.timeformat.hours") : "") +
                (minutes == 1 ? minutes + config.get("bansystem.timeformat.minute") : (minutes != 0) ? minutes + config.get("bansystem.timeformat.minutes") : "") +
                (seconds == 1 ? seconds + config.get("bansystem.timeformat.second") : (seconds != 0) ? seconds + config.get("bansystem.timeformat.seconds") : "");
    }

    public static String formatTime(String time) {
        MessagesConfig config = Main.getInstance().getMessagesConfig();

        Pattern pattern = Pattern.compile(timeAddFormat);
        Matcher matcher = pattern.matcher(time);

        if (!matcher.find()) return "Invalid";

        int timeValue = Integer.parseInt(matcher.group(1));
        String timeUnit = matcher.group(2);

        if (timeUnit.equals("s")) {
            return timeValue + config.get("bansystem.timeformat.second" + (timeValue != 1 ? "s" : ""));
        }
        if (timeUnit.equals("m")) {
            return timeValue + config.get("bansystem.timeformat.minute" + (timeValue != 1 ? "s" : ""));
        }
        if (timeUnit.equals("h")) {
            return timeValue + config.get("bansystem.timeformat.hour" + (timeValue != 1 ? "s" : ""));
        }
        if (timeUnit.equals("d")) {
            return timeValue + config.get("bansystem.timeformat.day" + (timeValue != 1 ? "s" : ""));
        }
        if (timeUnit.equals("y")) {
            if (timeValue > 100) {
                return config.get("bansystem.timeformat.permanent");
            }
            return timeValue + config.get("bansystem.timeformat.year" + (timeValue != 1 ? "s" : ""));
        }
        return "Invalid";
    }
}
