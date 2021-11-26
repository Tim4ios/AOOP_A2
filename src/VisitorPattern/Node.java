package VisitorPattern;

import java.util.List;

public class Node<T> implements Tree<T> {

    private final List<Tree<T>> children;

    public Node(List<Tree<T>> trees) {
        children = trees;
    }

    public <R> R accept(TreeVisitor<T, R> v, R initialResult) {
        return v.visit(this, initialResult);
    }

    public String toString() {
        return getClass().getName() + "[children = " + children + "]";
    }

    public List<Tree<T>> getChildren() {
        return children;
    }
}