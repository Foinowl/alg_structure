package lab1;

import java.util.List;
import java.util.Map;
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

    private final static Integer RECURSIVE_SUM_RESULT = 15;
    private static ArrayCalculator simpleArrayCalculator;

    @BeforeAll
    static void setup() {
        simpleArrayCalculator = new SimpleArrayCalculator();
    }

    private static Stream<Arguments> getDoubleElements() {
        return Stream.of(
            Arguments.of(new double[]{ 1.0, 2.0, 5.0, 3.0, 6.0 }, 3.4, new double[]{ 0.0, 0.0, 5.0, 0.0, 6.0 }),
            Arguments.of(new double[]{ 5.0 }, 5.0, new double[]{ 5.0 })
        );
    }

    @ParameterizedTest
    @MethodSource("getDoubleElements")
    void testCalculateAverageAndNullElements(double[] source, double averageResult, double[] listResult) {
        var result = simpleArrayCalculator.calculateAverageAndToNullNumber(source);

        Assertions.assertEquals(result.average(), averageResult);
        Assertions.assertArrayEquals(result.result(), listResult);
    }

    @Test
    void testCalculateAverageAndNullElementsIfEmptyCollections() {
        var result = simpleArrayCalculator.calculateAverageAndToNullNumber(new double[]{});

        Assertions.assertNull(result);
    }

    @Test
    void testSortArrayAndCountRepeatNumber() {
        int[] sourceList = new int[]{ 4, 6, 2, 3, 5, 4, 3, 6, 3 };
        int[] assertSourceList = new int[]{ 2, 3, 3, 3, 4, 4, 5, 6, 6 };
        var assertMap = Map.ofEntries(
            entry(2, 1),
            entry(3, 3),
            entry(4, 2),
            entry(5, 1),
            entry(6, 2));

        var result = simpleArrayCalculator.sortArrayAndCountRepeatNumber(sourceList);

        Assertions.assertArrayEquals(result.result(), assertSourceList);


        for (int i = 0; i < result.keyRepeats().length; i++) {
            int key = result.keyRepeats()[i];

            if (key == 0) {Assertions.assertEquals(0, key);break;}

            int value = assertMap.get(key);

            Assertions.assertEquals(result.valueRepeats()[i], value);
        }
    }

    @Test
    void testRecursiveCalculateSum() {
        int[] sourceList = { 6, 4, 5 };

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
        int[] listResult = { 1, 2, 3, 4 };
        List<Integer> destResult = List.of(4, 3, 2, 1);

        simpleArrayCalculator.reverse(listResult);
        List<Integer> result = IntStream.of(listResult).boxed().collect(Collectors.toList());

        Assertions.assertEquals(result, destResult);
    }
}