class Converter {
    final int centimetersInStep = 75;
    final int caloriesInStep = 50;
    final int caloriesInKilocalorie = 1000;
    final int centimetersInKilometer = 100000;

    int convertToKm(int steps) {
        return (steps*centimetersInStep)/centimetersInKilometer;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps*caloriesInStep)/caloriesInKilocalorie;
    }
}
