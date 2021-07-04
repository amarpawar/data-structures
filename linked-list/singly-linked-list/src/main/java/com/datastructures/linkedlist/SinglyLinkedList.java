package com.datastructures.linkedlist;

import java.util.Objects;

public class SinglyLinkedList<T>
{
    Node<T> head;

    public void addAtStart(T data)
    {
        head = new Node<>(data, head);
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

        tempHead.setNext(new Node<>(data, null));
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
                tempNode.setNext(new Node<>(data, null));
                return;
            }

            counter++;
        }

        tempNode.setNext(new Node<>(data, tempNode.getNext()));
    }

    public void removeFromStart()
    {
        if (Objects.nonNull(head))
        {
            head = head.getNext();
        }
    }

    public void removeFromEnd()
    {
        if (Objects.nonNull(head))
        {
            Node<T> tempNode = head;
            Node<T> preNode = head;

            while (Objects.nonNull(tempNode.getNext()))
            {
                preNode = tempNode;
                tempNode = tempNode.getNext();
            }

            preNode.setNext(null);
        }
    }

    public void remove(int index)
    {
        if (Objects.nonNull(head))
        {
            if (index == 1 || Objects.isNull(head.getNext()))
            {
                removeFromStart();
                return;
            }

            Node<T> currentNode = head.getNext();
            Node<T> previousNode = head;
            int counter = 2;

            while (counter < index)
            {
                if (Objects.isNull(currentNode.getNext()))
                {
                    previousNode.setNext(null);
                    return;
                }

                previousNode = currentNode;
                currentNode = currentNode.getNext();
                counter++;
            }

            previousNode.setNext(currentNode.getNext());
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

        public Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
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
    }

}
