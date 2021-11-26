package VisitorPattern;

import java.util.List;

public class PrintTreeVisitor<T> implements TreeVisitor<T, String>{

    @Override
    public String visit(Tree<T> t, String initialResult) {
        return t.accept(this, initialResult);
    }

    @Override
    public String visit(Leaf<T> l, String initialResult) {
        return " "+initialResult + l.getValue() + "\n" ;
    }

    @Override
    public String visit(Node<T> n, String initialResult) {
          String result= "\n";
          //Goes though each child
        for (Tree<T> child : n.getChildren()) {
            result += child.accept(this, initialResult);
        }
        return result;
    }
}
