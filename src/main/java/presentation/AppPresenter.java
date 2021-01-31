package presentation;

public class AppPresenter {

    public void welcomeMessage() {
        System.out.println("Please provide path to .json file on press Enter for default data");
    }

    public void printAverageFlightTime(long minutes) {
        String result = minutesToString(minutes);
        System.out.println("Average flight time: " + result);
    }

    public void printPercentileFlightTime(long minutes, double percentile) {
        String result = minutesToString(minutes);
        String percent = String.valueOf((int) percentile);
        System.out.println(percent + "th percentile flight time: " + result);
    }

    private String minutesToString(long minutes) {
        long hours = minutes / 60;
        long mins = minutes % 60;
        return hours + " hour(s) and " + mins + " minute(s).";
    }

}
