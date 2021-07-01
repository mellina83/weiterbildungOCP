package function02.functions;

@FunctionalInterface
public interface TriFunction<T,U,S,R> {
	R apply(T t, U u, S s);
}
