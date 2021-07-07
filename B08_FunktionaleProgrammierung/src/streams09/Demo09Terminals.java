package streams09;

/**
 * @Terminal_Operations Abschlieﬂende Operationen
 * 
 * @forEach(Consumer) Performs an action for each element of this stream.
 * 
 * @count() Returns the count of elements in this stream.
 *
 * @min(Comparator) Returns the minimum element of this stream according to the
 *                  provided Comparator.
 *
 * @max(Comparator) Returns the maximum element of this stream according to the
 *                  provided Comparator.
 *
 * @allMatch(Predicate) Returns whether all elements of this stream match the
 *                      provided predicate. May not evaluate the predicate on
 *                      all elements if not necessary for determining the
 *                      result. If the stream is empty then true is returned and
 *                      the predicate is not evaluated.
 *
 * @anyMatch(Predicate) Returns whether any elements of this stream match the
 *                      provided predicate. May not evaluate the predicate on
 *                      all elements if not necessary for determining the
 *                      result. If the stream is empty then false is returned
 *                      and the predicate is not evaluated.
 *
 * @noneMatch(Predicate) Returns whether no elements of this stream match the
 *                       provided predicate. May not evaluate the predicate on
 *                       all elements if not necessary for determining the
 *                       result. If the stream is empty then true is returned
 *                       and the predicate is not evaluated.
 *
 * @findAny() Returns an Optional describing some element of the stream, or an
 *            empty Optional if the stream is empty.
 * 
 * @findFirst() Returns an Optional describing the first element of this stream,
 *              or an empty Optional if the stream is empty. If the stream has
 *              no encounter order, then any element may be returned.
 *
 * @reduce(BinaryOperator accumulator) Performs a reduction on the elements of
 *                        this stream, using an associative accumulation
 *                        function, and returns an Optional describing the
 *                        reduced value,if any.
 * 
 * @reduce Bietet noch 2 weitere Konstelationen an Parametern. Diese werden wir
 *         uns in der entsprechenden Demo Datei anschauen.
 * 
 * @collect() sammelt die Elemente des Streams
 */
public class Demo09Terminals {

}
