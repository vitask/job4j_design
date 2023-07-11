package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E children) {
        boolean result = false;
        Optional<Node<E>> optionalParent = findBy(parent);
        Optional<Node<E>> optionalChildren = findBy(children);
        if (optionalParent.isPresent() && optionalChildren.isEmpty()) {
            optionalParent.get().children.add(new Node<>(children));
            result = true;
        }
        return result;
    }

    @Override
    public boolean isBinary() {
        return findByPredicate(opt -> opt.children.size() > 2).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(opt -> opt.value.equals(value));
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
