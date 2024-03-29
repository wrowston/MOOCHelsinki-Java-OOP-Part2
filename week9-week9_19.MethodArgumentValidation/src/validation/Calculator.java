package validation;

public class Calculator {

    public int multiplication(int fromInteger) {

        if (fromInteger < 0) {
            throw new IllegalArgumentException("Parameter must be positive number");
        }
        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {

        if (setSize < 0 && subsetSize < 0) {
            throw new IllegalArgumentException("Parameters must be positive");
        }
        if (setSize < subsetSize) {
            throw new IllegalArgumentException("Subset must be smaller than setsize");
        }

        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
