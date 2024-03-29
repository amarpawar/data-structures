package com.datastructures.linkedlist;

import java.util.Objects;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int option;
        SinglyLinkedList<Employee> singlyLinkedList = new SinglyLinkedList<>();

        while (true)
        {
            option = showMenuAndGetOption(scanner);

            if (option == 4)
            {
                break;
            }

            switch (option)
            {
                case 1:
                    addEmployee(singlyLinkedList, scanner);
                    break;
                case 2:
                    removeEmployee(singlyLinkedList, scanner);
                    break;
                case 3:
                    listAllEmployees(singlyLinkedList, scanner);
                    break;
                default:
                    break;
            }
        }
    }

    public static int showMenuAndGetOption(Scanner scanner)
    {
        clearConsole();
        System.out.println("====================================================");
        System.out.println("Employee management system");
        System.out.println("====================================================\n");

        System.out.println("\t1. Add Employee");
        System.out.println("\t2. Remove Employee");
        System.out.println("\t3. List all the employees");
        System.out.println("\t4. Exit\n");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public static void addEmployee(SinglyLinkedList<Employee> singlyLinkedList, Scanner scanner)
    {
        clearConsole();
        System.out.println("====================================================");
        System.out.println("Add new employee");
        System.out.println("====================================================\n");

        System.out.print("\tId: ");
        String id = scanner.nextLine();

        System.out.print("\tName: ");
        String name = scanner.nextLine();
        System.out.println();

        Employee employee = new Employee(id, name);

        System.out.println("Where to add the employee in the list?");
        System.out.println("\t1. At the start");
        System.out.println("\t2. At the end");
        System.out.println("\t3. At position ");
        System.out.print("\nSelect an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option)
        {
            case 1:
                singlyLinkedList.addAtStart(employee);
                break;
            case 2:
                singlyLinkedList.addAtEnd(employee);
                break;
            case 3:
                System.out.print("\nEnter the position: ");
                int index = scanner.nextInt();
                singlyLinkedList.add(employee, index);
                break;
            default:
                break;
        }

        System.out.println("\nEmployee added successfully. Redirecting back to main menu...");

        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e) {}
    }

    public static void removeEmployee(SinglyLinkedList<Employee> singlyLinkedList, Scanner scanner)
    {
        clearConsole();
        System.out.println("====================================================");
        System.out.println("Remove an employee");
        System.out.println("====================================================\n");

        System.out.println("From where to remove the employee from the list?");
        System.out.println("\t1. From the start");
        System.out.println("\t2. From the end");
        System.out.println("\t3. From the position ");
        System.out.print("\nSelect an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option)
        {
            case 1:
                singlyLinkedList.removeFromStart();
                break;
            case 2:
                singlyLinkedList.removeFromEnd();
                break;
            case 3:
                System.out.print("\nEnter the position: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                singlyLinkedList.remove(index);
                break;
            default:
                break;
        }

        System.out.println("\nEmployee removed successfully. Redirecting back to main menu...");

        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e) {}
    }

    public static void listAllEmployees(SinglyLinkedList<Employee> singlyLinkedList, Scanner scanner)
    {
        SinglyLinkedList.Node<Employee> headNode = singlyLinkedList.getHead();
        int counter = 1;

        clearConsole();

        if (Objects.isNull(headNode))
        {
            System.out.println("List is empty. Enter any key to go back to the main menu...");
            scanner.nextLine();
        }
        else
        {
            System.out.println("====================================================");
            System.out.println("List of all the employees");
            System.out.println("====================================================\n");

            System.out.println("\t\tSr No. \tID \tName");

            while (Objects.nonNull(headNode))
            {
                System.out.println("\t\t" + counter++ + " \t" + headNode.getData().getId() + " \t" + headNode.getData().getName());
                headNode = headNode.getNext();
            }

            System.out.println("\nEnter any key to go back to the main menu...");
            scanner.nextLine();
        }
    }

    public static void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
