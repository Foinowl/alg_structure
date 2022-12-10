package lab1;

import java.util.Optional;


public class SimpleArrayCalculator implements ArrayCalculator {


    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    @Override
    public AverageResult calculateAverageAndToNullNumber(double[] source) {
        if (source == null || source.length == 0) {
            return null;
        }

        double average = getAverage(source);

        double[] result = makeNumberToNullIfLessAverage(average, source);

        return new AverageResult(average, result);
    }

    @Override
    public RepeatResult sortArrayAndCountRepeatNumber(int[] source) {
        if (source == null || source.length == 0) {
            return null;
        }

        sort(source);

        int[] keys = new int[source.length];
        int[] values = new int[source.length];

        int prev = source[0];
        int repeat = 0;
        int indexRepeat = 0;

        int i = 0;
        while (i < source.length) {
            if (source[i] == prev) {
                repeat++;
                i++;

                if (i == source.length) {
                    keys[indexRepeat] = prev;
                    values[indexRepeat] = repeat;
                }

                continue;
            }

            keys[indexRepeat] = prev;
            values[indexRepeat] = repeat;

            repeat = 0;
            prev = source[i];
            indexRepeat++;
        }

        return new RepeatResult(keys, values, source);
    }

    private void sort(int[] source) {
        for (int i = 0; i < source.length; i++)
            for (int j = i; j > 0 &&
                source[j - 1] > source[j]; j--)
                swap(source, j, j - 1);
    }

    @Override
    public Integer recursiveCalculateSum(int[] source) {
        if (source == null) {
            return null;
        }

        return recursiveCalculateSumInternal(source, 0, 0);
    }


    @Override
    public Integer calculate(String operand1, String operation, String operand2) {
        if (operand1 == null || operand2 == null) {
            throw new RuntimeException("Операнды пустые");
        }

        if (operation.isBlank()) {
            throw new RuntimeException("Операция пустая :(");
        }

        var x = Integer.valueOf(operand1);
        var y = Integer.valueOf(operand2);

        return OperationBasic.calculate(x, operation, y);
    }


    @Override
    public void reverse(int[] source) {
        if (source == null) {
            throw new RuntimeException("Пустой массив");
        }

        int n = source.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = source[i];
            source[i] = source[n - i - 1];
            source[n - i - 1] = temp;
        }
    }


    private Integer recursiveCalculateSumInternal(int[] source, Integer result, Integer position) {
        if (source.length == position) {
            return result;
        }

        result += source[position];
        position++;

        return recursiveCalculateSumInternal(source, result, position);
    }


    private double getAverage(double[] source) {
        double total = 0.0;

        for (double number : source) {
            total += number;
        }

        return total / source.length;
    }


    private double[] makeNumberToNullIfLessAverage(Double average, double[] source) {
        double[] result = new double[source.length];

        for (int i = 0; i < source.length; i++) {
            var el = source[i] < average ? 0.0 : source[i];
            result[i] = el;
        }

        return result;
    }


    private enum OperationBasic {
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        DIVIDE("/", (x, y) -> x / y),
        MULTIPLE("*", (x, y) -> x * y),
        ;

        private final String symbol;
        private final Operation operation;


        OperationBasic(String symbol, Operation operation) {
            this.symbol = symbol;
            this.operation = operation;
        }

        public static Integer calculate(Integer x, String operation, Integer y) {
            return of(operation)
                .orElseThrow(() -> new RuntimeException("Операция [" + operation + " ] не поддерживается"))
                .getOperation()
                .apply(x, y);
        }

        private static Optional<OperationBasic> of(String operation) {
            OperationBasic element = null;

            for (OperationBasic el : values()) {
                if (el.symbol.equals(operation)) {
                    return Optional.of(el);
                }
            }

            return Optional.empty();
        }

        public Operation getOperation() {
            return operation;
        }
    }

    @FunctionalInterface
    public interface Operation {
        Integer apply(Integer x, Integer y);
    }
}
