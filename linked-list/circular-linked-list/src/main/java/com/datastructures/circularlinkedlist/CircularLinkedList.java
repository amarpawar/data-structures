package com.datastructures.circularlinkedlist;

import java.util.Objects;

public class CircularLinkedList<T>
{
    Node<T> head;
    Node<T> tail;

    public void addAtStart(T data)
    {
        Node<T> newNode = new Node<>(data);

        if (Objects.isNull(head))
        {
            head = tail = newNode;
        }
        else
        {
            newNode.setNext(head);
            head = newNode;
        }

        tail.setNext(head);
    }

    public void addAtEnd(T data)
    {
        if (Objects.isNull(head))
        {
            addAtStart(data);
            return;
        }

        Node<T> newNode = new Node<>(data, head);
        tail.setNext(newNode);
        tail = newNode;
    }

    public void add(T data, T after)
    {
        if (Objects.isNull(head))
        {
            throw new IllegalStateException("List is empty");
        }
        else if (Objects.isNull(after))
        {
            throw new NullPointerException("after cannot be null");
        }

        Node<T> afterNode = head;

        while (!afterNode.getData().equals(after))
        {
            afterNode = afterNode.getNext();

            if (afterNode == head)
            {
                afterNode = null;
                break;
            }
        }

        if (Objects.isNull(afterNode))
        {
            throw new IllegalArgumentException("Node " + after + " not found ");
        }

        if (afterNode == tail)
        {
            addAtEnd(data);
        }
        else
        {
            afterNode.setNext(new Node<>(data, afterNode.getNext()));
        }
    }

    public void removeFromStart()
    {
        if (Objects.nonNull(head))
        {
            if (head == tail)
            {
                head = tail = null;
            }
            else
            {
                head = head.getNext();
                tail.setNext(head);
            }
        }
    }

    public void removeFromEnd()
    {
        if (Objects.nonNull(head))
        {
            if (head == tail)
            {
                head = tail = null;
            }
            else
            {
                Node<T> tempNode = head;

                while (tempNode.getNext() != tail)
                {
                    tempNode = tempNode.getNext();
                }

                tempNode.setNext(head);
                tail = tempNode;
            }
        }
    }

    public void remove(T data)
    {
        if (Objects.nonNull(head))
        {
            Node<T> tempNode = head;

            while (!tempNode.getNext().getData().equals(data))
            {
                tempNode = tempNode.getNext();

                if (tempNode.getNext() == head)
                {
                    tempNode = null;
                    break;
                }
            }

            if (Objects.isNull(tempNode))
            {
                throw new IllegalArgumentException("Node " + data + " not found");
            }

            if (tempNode.getNext() == head)
            {
                removeFromStart();
            }
            else if (tempNode.getNext() == tail)
            {
                removeFromEnd();
            }
            else
            {
                tempNode.setNext(tempNode.getNext().getNext());
            }
        }
    }

    public void traverse()
    {
        if (Objects.isNull(head))
        {
            throw new IllegalStateException("List is empty");
        }
        else
        {
            Node<T> tempNode = head;

            do
            {
                System.out.println(tempNode.getData().toString());
                tempNode = tempNode.getNext();
            }
            while (tempNode != head);
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

        public Node(T data)
        {
            this.data = data;
        }

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
