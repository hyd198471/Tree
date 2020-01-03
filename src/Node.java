import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<T> {

    private T data;

    private Node<T> parent = null;

    private List<Node<T>> children = new ArrayList<>();

    public Node(T data) {
        this.data = data;
    }

    public Node<T> addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<Node<T>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public Node<T> getRoot() {
        if (parent == null) {
            return this;
        }
        return parent.getRoot();
    }

    public void deleteNode() {
        if (parent != null) {
            int index = this.parent.children.indexOf(this);
            this.parent.children.remove(this);
            children.forEach(each -> each.setParent(this.parent));
            this.parent.children.addAll(index,
                                        this.children);
        } else {
            deleteRootNode();
        }

        this.children.clear();
    }

    private void deleteRootNode() {
        if (parent != null) {
            throw new IllegalArgumentException("Root node is not null");
        }
        Node<T> newParent = null;
        if (!children.isEmpty()) {
            newParent = children.get(0);
            newParent.setParent(null);
            children.remove(0);
            for (Node<T> child : children) {
                child.setParent(newParent);
            }

            newParent.children.addAll(children);
            this.children.clear();
        }

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data,
                              node.data) &&
               Objects.equals(parent,
                              node.parent) &&
               Objects.equals(children,
                              node.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data,
                            parent,
                            children);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }


}
