package summary.java8structure.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Date ::: 휴먼 타임 용도
         * Mutable 하다. -> Thread safe 하지 않음
         */
        System.out.println("::: Date ::: ");
        Date date = new Date();;
        long time = date.getTime();
        System.out.println("date = " + date);
        System.out.println("time = " + time);
        System.out.println("--------------------------------------");

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println("after3Seconds = " + after3Seconds); // Sun Oct 01 13:17:45 KST 2023
        after3Seconds.setTime(time); // mutable
        System.out.println("before3Seconds = " + after3Seconds); // Sun Oct 01 13:17:42 KST 2023
        System.out.println("--------------------------------------");

        GregorianCalendar birth = new GregorianCalendar(1992, Calendar.MAY, 22); // 타입 safety 하지 않음
        System.out.println("birth = " + birth.getTime()); //  Fri May 22 00:00:00 KST 1992
        System.out.println("--------------------------------------");

        System.out.println("::: Instant ::: "); // 머신 타임 용도
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC, GMT // 2023-10-01T04:17:45.189668200Z
        System.out.println("instant.atZone(ZoneId.of(\"UTC\")) = " + instant.atZone(ZoneId.of("UTC"))); // 2023-10-01T04:19:04.915819Z[UTC]
        System.out.println("--------------------------------------");
        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone); // Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime); // 2023-10-01T13:17:45.189668200+09:00[Asia/Seoul]
        System.out.println("--------------------------------------");

        /**
         * LocalDateTime :::
         * -> 프로그램을 실행하는 로컬 시간을 가져옴
         * -> 서버에 배포시에는 서버 시스템의 zone의 LocalDateTime을 참고해서 시간이 세팅된다.
         */
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now); // 2023-10-01T13:22:38.496841
        LocalDateTime birthday = LocalDateTime.of(1992, Month.MAY, 22, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("birthday = " + birthday); // 1992-05-22T00:00
        System.out.println("nowInKorea = " + nowInKorea); // 2023-10-01T13:22:38.496841+09:00[Asia/Seoul]
        System.out.println("--------------------------------------");

        /**
         * Period ::: 휴먼 타임 용도
         * Period.between(비교1,비교2)
         * 비교1.until(비교2)
         */
        LocalDate today = LocalDate.now();
        LocalDate toBirthday = LocalDate.of(2024, Month.MAY,22);
        System.out.println("today = " + today);
        System.out.println("toBirthday = " + toBirthday);
        Period period = Period.between(today,toBirthday);
        System.out.println("내년 생일까지 남은 기간 ::: between 사용 ::: " + period.getMonths() + "개월 " + period.getDays() + "일");
        System.out.println("내년 생일까지 남은 기간 ::: between 사용 ::: " + period.get(ChronoUnit.MONTHS) + "개월 " + period.get(ChronoUnit.DAYS) + "일");
        System.out.println("--------------------------------------");
        Period until = today.until(toBirthday);
        System.out.println("내년 생일까지 남은 기간 ::: until 사용 ::: " + until.get(ChronoUnit.MONTHS) +"개월 " + until.get(ChronoUnit.DAYS) + "일");
        System.out.println("내년 생일까지 남은 기간 ::: until 사용 ::: " + until.getMonths() +"개월 " + until.getDays() + "일");
        System.out.println("--------------------------------------");

        /**
         * Duration ::: 머신 타임 용도
         */
        Instant nowSecond = Instant.now();
        System.out.println("nowSecond = " + nowSecond);
        Instant plusSecond = nowSecond.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(nowSecond, plusSecond);
        System.out.println("between.getSeconds() = " + between.getSeconds());
        System.out.println("--------------------------------------");

        /**
         * formatting :::
         */
        LocalDateTime nowTime= LocalDateTime.now();
        DateTimeFormatter yearMonthDay = DateTimeFormatter.ofPattern("yyyyMMdd"); // 년월일
        System.out.println("yearMonthDay ::: " + nowTime.format(yearMonthDay));

        LocalDate parse = LocalDate.parse("20230909", yearMonthDay);
        System.out.println("parse = " + parse);

        DateTimeFormatter yearMonthDayTime = DateTimeFormatter.ofPattern("yyyyMMdd hh:mm:ss"); // 년월일 시간
        System.out.println("yearMonthDayTime ::: " + nowTime.format(yearMonthDayTime));
        System.out.println("--------------------------------------");

        /**
         * Date <-> Instant
         */
        Date dateTrans = new Date();
        Instant instantTrans = dateTrans.toInstant(); // Date -> Instant
        Date newDate = Date.from(instantTrans); // Instant -> Date
        System.out.println("instantTrans = " + instantTrans); // 023-10-01T04:54:06.968Z
        System.out.println("newDate = " + newDate); // Sun Oct 01 13:54:06 KST 2023
        System.out.println("--------------------------------------");

    }
}
