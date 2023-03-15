public class Converter {

    double convertToKm (int steps) {
        double stepsToKm = steps * 0.00075;
        int result = (int) Math.round(stepsToKm);
        return result;
    }

    double convertStepsToKilocalories(int steps) {
        double stepsToKilocalories = steps * 0.05;
        int result = (int) Math.round(stepsToKilocalories);
        return result;
    }
}
