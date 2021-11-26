package VisitorPattern;

public class Leaf<T> implements Tree<T> {

    private final T value;


    public Leaf(T v) {
        value = v;

    }

    public <R> R accept(TreeVisitor<T, R> v, R initialResult) {
        return v.visit(this, initialResult);
    }

    public String toString() {
        return getClass().getName() + value+"\n";
    }

    public T getValue() {
        return value;
    }
}