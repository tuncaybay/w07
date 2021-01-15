package w07;

public class Main {
    public static void main(String[] args) {
        TimeConverter saat12 = new TimeConverter();
        String time;
        Boolean saatDogru;

        do {
            time = saat12.timeInput();
            saatDogru = saat12.timeCheck(time);
            if (saatDogru) {
                saat12.timeConvert(saat12.getSaat(), saat12.getDakika(), saat12.getAmpm());
            }
        } while (saatDogru == false);
    }
}