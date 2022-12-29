package lab3;

public interface CustomList<T> {

    /*
     * Вставка элемента в конец
     * */
    void add(T element);

    /*
     * Вставка элемента перед заданным индексом
     * */
    void insert(int index, T element);

    /*
     *  Получение значения элемента по индексу
     * */
    T get(int index);

    /*
    * удаление элемента по значению
В случае, если элемент с ключом не найден, функция должна вернуть false, иначе - true
    * */
    T remove(int index);

    /*
    * удаление элемента по значению
В случае, если элемент с ключом не найден, функция должна вернуть false, иначе - true
    * */
    boolean remove(T element);

    /*
     * Освобождение памяти от структуры данны
     * */
    void clear();


    int size();

    CustomList<T> copy();
}
