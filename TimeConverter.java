package w07;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TimeConverter {
    private int saat;
    private int dakika;
    private String ampm;
    private boolean timeCorrect = false;
    private LocalTime saat24;

    public String timeInput() {
        String time;
        Scanner sc = new Scanner(System.in);
        System.out.print("Saat giriniz: ");
        time = sc.nextLine();
        return time;
    }

    public boolean timeCheck(String time) {
        time = time.trim();
        if (time.length() > 5 && time.length() < 9 && time.indexOf(":") > 0) {
            this.setAmpm(time.substring(time.length() - 2).toUpperCase());
            this.setSaat(parseInt(time.substring(0, time.indexOf(":")).trim()));
            this.setDakika(parseInt(time.substring(time.indexOf(":") + 1, time.length() - 2).trim()));
            if (
                    (this.ampm.equals("AM") || this.ampm.equals("PM")) &&
                    (this.saat <= 12 && this.saat >= 0) &&
                    (this.dakika >= 0 && this.dakika <= 60)) {
                this.timeCorrect = true;
            }
        }

        if (this.timeCorrect == false) {
            System.out.println("Girilen veri hatali, lütfen tekrar deneyin");
        }
        return this.timeCorrect;
    }

    public void timeConvert(int saat, int dakika, String ampm) {
        if (ampm.equals("PM")) {
            saat += 12;
        }
        LocalTime saat24 = LocalTime.of(saat, dakika);
        System.out.println(saat24.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
    }

    public int getSaat() {
        return saat;
    }

    public int getDakika() {
        return dakika;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public void setDakika(int dakika) {
        this.dakika = dakika;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }
}
