package com.datastructures.doublylinkedlist;

import java.util.Objects;

public class DoublyLinkedList<T>
{
    Node<T> head;

    public void addAtStart(T data)
    {
        head = new Node<>(data, head, null);
    }

    public void addAtEnd(T data)
    {
        if (Objects.isNull(head))
        {
            addAtStart(data);
            return;
        }

        Node<T> tempHead = head;

        while (Objects.nonNull(tempHead.getNext()))
        {
            tempHead = tempHead.getNext();
        }

        tempHead.setNext(new Node<>(data, null, tempHead));
    }

    public void add(T data, int index)
    {
        if (index == 0)
        {
            addAtStart(data);
            return;
        }

        int counter = 2;
        Node<T> tempNode = head;

        while (counter < index)
        {
            tempNode = tempNode.getNext();

            if (Objects.isNull(tempNode.getNext()))
            {
                tempNode.setNext(new Node<>(data, null, tempNode));
                return;
            }

            counter++;
        }

        tempNode.setNext(new Node<>(data, tempNode.getNext(), tempNode));
    }

    public void removeFromStart()
    {
        if (Objects.nonNull(head))
        {
            head = head.getNext();
            head.setPrevious(null);
        }
    }

    public void removeFromEnd()
    {
        if (Objects.nonNull(head))
        {
            Node<T> tempNode = head;

            while (Objects.nonNull(tempNode.getNext()))
            {
                tempNode = tempNode.getNext();
            }

            tempNode.getPrevious().setNext(null);
        }
    }

    public void remove(int index)
    {
        if (Objects.nonNull(head))
        {
            if (index == 0 || Objects.isNull(head.getNext()))
            {
                removeFromStart();
                return;
            }

            Node<T> currentNode = head.getNext();
            int counter = 2;

            while (counter <= index)
            {
                if (Objects.isNull(currentNode.getNext()))
                {
                    currentNode.getPrevious().setNext(null);
                    return;
                }

                currentNode = currentNode.getNext();
                counter++;
            }

            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        }
    }

    public Node<T> getHead()
    {
        return head;
    }

    public static class Node<T>
    {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data, Node<T> next, Node<T> previous)
        {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public T getData()
        {
            return data;
        }

        public void setNext(Node<T> next)
        {
            this.next = next;
        }

        public Node<T> getNext()
        {
            return next;
        }

        public void setPrevious(Node<T> previous)
        {
            this.previous = previous;
        }

        public Node<T> getPrevious()
        {
            return previous;
        }
    }

}
