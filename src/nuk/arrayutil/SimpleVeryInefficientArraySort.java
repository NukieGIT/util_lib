package nuk.arrayutil;

public class SimpleVeryInefficientArraySort {
    private static <T extends Number> T[] sort(T[] inputArray, boolean ascending) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (ascending && inputArray[i].doubleValue() < inputArray[j].doubleValue() || !ascending && inputArray[i].doubleValue() > inputArray[j].doubleValue()) {
                    continue;
                }
                T tmp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = tmp;
            }
        }
        return inputArray;
    }

    public static <T extends Number> T[] sort(T[] inputArray, boolean ascending, boolean mutate) {
        if (mutate) {
            return sort(inputArray, ascending);
        }
        return sort(inputArray.clone(), ascending);
    }
}
