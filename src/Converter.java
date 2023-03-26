class Converter {
    int centimetersInStep = 75;
    int caloriesInStep = 50;
    int caloriesInKilocalorie = 1000;
    int centimetersInKilometer = 100000;

    int convertToKm(int steps) {
        return (steps*centimetersInStep)/centimetersInKilometer;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps*caloriesInStep)/caloriesInKilocalorie;
    }
}
