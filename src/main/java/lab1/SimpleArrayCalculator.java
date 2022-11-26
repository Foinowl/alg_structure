package lab1;

import java.util.*;
import java.util.stream.Collectors;
import utils.CollectionUtils;


public class SimpleArrayCalculator implements ArrayCalculator {


    @Override
    public AverageResult calculateAverageAndToNullNumber(List<Double> source) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }

        var average = getAverage(source);

        var result = makeNumberToNullIfLessAverage(average, source);

        return new AverageResult(average, result);
    }


    @Override
    public RepeatResult sortArrayAndCountRepeatNumber(List<Integer> source) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }

        var result = new ArrayList<>(source);
        Collections.sort(result);

        var maps = source
            .stream()
            .collect(Collectors.toMap(it -> it, it -> 1, Integer::sum));

        return new RepeatResult(maps, result);
    }


    @Override
    public Integer recursiveCalculateSum(List<Integer> source) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }

        var result = new ArrayList<>(source);

        return recursiveCalculateSumInternal(result, 0, 0);
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

        for (int i = 0; i < n / 2; i++ ) {
            int temp = source[i];
            source[i] = source[n - i - 1];
            source[n - i - 1] = temp;
        }
    }


    private Integer recursiveCalculateSumInternal(List<Integer> source, Integer result, Integer position) {
        if (source.size() == position) {
            return result;
        }

        result += source.get(position);
        position++;

        return recursiveCalculateSumInternal(source, result, position);
    }


    private Double getAverage(List<Double> source) {
        double total = 0.0;

        for (Double number : source) {
            total += number;
        }

        return total / source.size();
    }


    private List<Double> makeNumberToNullIfLessAverage(Double average, List<Double> source) {
        var result = new ArrayList<Double>();

        for (Double number : source) {
            var el = number < average ? 0.0 : number;
            result.add(el);
        }

        return result;
    }


    private enum OperationBasic {
        PLUS("+", (x, y) -> x + y) ,
        MINUS("-", (x, y) -> x - y) ,
        DIVIDE("/", (x, y) -> x / y) ,
        MULTIPLE("*", (x, y) -> x * y) ,
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


        public Operation getOperation() {
            return operation;
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
    }

    @FunctionalInterface
    public interface Operation {
        Integer apply(Integer x, Integer y);
    }
}
