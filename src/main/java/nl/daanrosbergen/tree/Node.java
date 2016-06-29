package nl.daanrosbergen.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Node<T> {
    private Node<T> parent, leftChild, rightChild;
    private T userObject;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    // Constructors
    public Node() {
        this( null );
    }

    public Node( T userObject ) {
        parent = null;
        leftChild = null;
        rightChild = null;
        this.userObject = userObject;
    }

    // Methoden
    public void add( Node<T> newChild ) {
        if( leftChild == null )
            insert( newChild, LEFT );
        else
        if( rightChild == null )
            insert( newChild, RIGHT );
        else
            throw new IllegalArgumentException(
                "Meer dan 2 kinderen" );
    }

    public T get() {
        return userObject;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void insert( Node<T> newChild, int childIndex ) {
        if( isAncestor( newChild ) )
            throw new IllegalArgumentException(
                "Nieuw kind is voorouder" );
        if( childIndex != LEFT &&
            childIndex != RIGHT )
            throw new IllegalArgumentException(
                "Index moet 0 of 1 zijn" );

        if( newChild != null ) {
            Node<T> oldParent = newChild.getParent();
            if( oldParent != null )
                oldParent.remove( newChild );
        }

        newChild.parent = this;
        if( childIndex == LEFT )
            leftChild = newChild;
        else
            rightChild = newChild;
    }

    public boolean isChild( Node<T> aNode ) {
        return aNode == null?
            false :
            aNode.getParent() == this;
    }

    public boolean isAncestor( Node<T> aNode ) {
        Node<T> ancestor = this;
        while( ancestor != null && ancestor != aNode )
            ancestor = ancestor.getParent();
        return ancestor != null;
    }

    public void remove( Node<T> aChild ) {
        if( aChild == null )
            throw new IllegalArgumentException(
                "Argument is null" );

        if( !isChild( aChild ) )
            throw new IllegalArgumentException(
                "Argument is geen kind" );

        if( aChild == leftChild ) {
            leftChild.parent = null;
            leftChild = null;
        }
        else {
            rightChild.parent = null;
            rightChild = null;
        }
    }

    public String toString() {
        return userObject.toString();
    }

    public void printPreOrder(Node<T> node) {
        System.out.print(node.userObject +" ");
        if (node.getLeftChild() != null)
            printPreOrder(node.getLeftChild());
        if (node.getRightChild() != null)
            printPreOrder(node.getRightChild());
    }

    public void printPostOrder(Node<T> node) {
        if (node.getLeftChild() != null) {
            printPostOrder(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            printPostOrder(node.getRightChild());
        }
        System.out.print(node.userObject + " ");
    }

    public void printInOrder(Node<T> node) {
        if (node.getLeftChild() != null) {
            printInOrder(node.getLeftChild());
        }
        System.out.print(node.userObject + " ");
        if (node.getRightChild() != null) {
            printInOrder(node.getRightChild());
        }
    }

    public void printTree() {
        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        currentLevel.add(this);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> currentLevelIter = currentLevel.iterator();
            while (currentLevelIter.hasNext()) {
                Node currentNode = currentLevelIter.next();
                if (currentNode.getLeftChild() != null) {
                    nextLevel.add(currentNode.getLeftChild());
                }
                if (currentNode.getRightChild() != null) {
                    nextLevel.add(currentNode.getRightChild());
                }
                System.out.print(currentNode + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();

        }
    }

    public static int diepte(Node node) {
        if (node == null) {
            return 0;
        } else {
            int linkerNodeDiepte = diepte(node.getLeftChild());
            int rechterNodeDiepte = diepte(node.getRightChild());
            return (linkerNodeDiepte > rechterNodeDiepte ? linkerNodeDiepte + 1 : rechterNodeDiepte + 1);
        }
    }

    public int aantalKnopen() {
        Node<T> leftNode = getLeftChild();
        Node<T> rightNode = getRightChild();
        return 1 + (leftNode != null ? leftNode.aantalKnopen() : 0) + (rightNode != null ? rightNode.aantalKnopen() : 0);
    }

}
