package lab1;

import java.util.List;


public interface ArrayCalculator {
    /*
* 1. Разработайте программу по описанию. Дан массив вещественных чисел. Вычислите
    среднее значение и занулите элементы, которые меньше среднего
* */
    AverageResult calculateAverageAndToNullNumber(List<Double> source);


    //    4. Разработайте следующий алгоритм сортировки. Дан массив чисел от 0 до 9.
//    Посчитайте кол-во повторений каждой из цифр и выведите отсортированный
//    массив (упорядоченный от меньшего к большему) на основе этой информации
    RepeatResult sortArrayAndCountRepeatNumber(List<Integer> source);


    /*
    * 3. Разработайте рекурсивный алгоритм рассчета суммы элементов целочисленного
массива
    * */
    Integer recursiveCalculateSum(List<Integer> source);


    /*
    * 2.1 Реализуйте алгоритмы, нарисованные на блок-схемах в виде функций
    * */
    Integer calculate(String operand1, String operation, String operand2);


    /*
     * 2.2 Реализуйте алгоритмы, нарисованные на блок-схемах в виде функций
    * */
    void reverse(int[] source);
}
