package lab1;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.util.Map.entry;


class SimpleArrayCalculatorTest {

    private static ArrayCalculator simpleArrayCalculator;

    @BeforeAll
    static void setup() {
        simpleArrayCalculator = new SimpleArrayCalculator();
    }


    private static Stream<Arguments> getDoubleElements() {
        return Stream.of(
            Arguments.of(List.of(1.0, 2.0, 5.0, 3.0, 6.0), 3.4, List.of(0.0, 0.0, 5.0, 0.0, 6.0)),
            Arguments.of(List.of(5.0), 5.0, List.of(5.0))
        );
    }


    @ParameterizedTest
    @MethodSource("getDoubleElements")
    void testCalculateAverageAndNullElements(List<Double> source, Double averageResult, List<Double> listResult) {
        var result = simpleArrayCalculator.calculateAverageAndToNullNumber(source);

        Assertions.assertEquals(result.average(), averageResult);
        Assertions.assertEquals(result.result(), listResult);
    }


    @Test
    void testCalculateAverageAndNullElementsIfEmptyCollections() {
        var result = simpleArrayCalculator.calculateAverageAndToNullNumber(List.of());

        Assertions.assertNull(result);
    }


    @Test
    void testSortArrayAndCountRepeatNumber() {
        var sourceList = List.of(4, 6, 2, 3, 5, 4, 3, 6, 3);
        var assertSourceList = List.of(2, 3, 3, 3, 4, 4, 5, 6, 6);
        var assertMap = Map.ofEntries(
            entry(2, 1),
            entry(3, 3),
            entry(4, 2),
            entry(5, 1),
            entry(6, 2));

        var result = simpleArrayCalculator.sortArrayAndCountRepeatNumber(sourceList);

        Assertions.assertEquals(result.result(), assertSourceList);
        Assertions.assertEquals(result.repeats(), assertMap);
    }


    private final static Integer RECURSIVE_SUM_RESULT = 15;
    @Test
    void testRecursiveCalculateSum() {
        var sourceList = List.of(6, 4, 5);

        var result = simpleArrayCalculator.recursiveCalculateSum(sourceList);

        Assertions.assertEquals(result, RECURSIVE_SUM_RESULT);
    }


    private static Stream<Arguments> getCalculatorElements() {
        return Stream.of(
            Arguments.of("5", "+", "10", 15),
            Arguments.of("2", "+", "7", 9),
            Arguments.of("2", "-", "7", -5),
            Arguments.of("50", "-", "2", 48),
            Arguments.of("25", "*", "2", 50),
            Arguments.of("50", "/", "2", 25)
            );
    }


    @ParameterizedTest
    @MethodSource("getCalculatorElements")
    void testCalculate(String operand1, String operation, String operand2, Integer destResult) {
        var result = simpleArrayCalculator.calculate(operand1, operation, operand2);

        Assertions.assertEquals(result, destResult);
    }


    @ParameterizedTest
    @MethodSource("getCalculatorElements")
    void testCalculateIfParametersIsNotCorrect() {
        Supplier<Integer> result1 = () -> simpleArrayCalculator.calculate("", "+", "2");
        Supplier<Integer> result2 = () -> simpleArrayCalculator.calculate("1", "+", "");
        Supplier<Integer> result3 = () -> simpleArrayCalculator.calculate("1", "", "3");


        Assertions.assertThrows(RuntimeException.class, result1::get);
        Assertions.assertThrows(RuntimeException.class, result2::get);
        Assertions.assertThrows(RuntimeException.class, result3::get);
    }


    @Test
    void testReverse() {
        int[] listResult = {1, 2, 3, 4};
        List<Integer> destResult = List.of(4, 3, 2, 1);

        simpleArrayCalculator.reverse(listResult);
        List<Integer> result = IntStream.of(listResult).boxed().collect(Collectors.toList());

        Assertions.assertEquals(result, destResult);
    }
}