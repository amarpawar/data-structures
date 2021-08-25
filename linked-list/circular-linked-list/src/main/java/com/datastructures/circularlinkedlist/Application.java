package com.datastructures.circularlinkedlist;

import java.util.Objects;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int option;
        CircularLinkedList<Employee> circularLinkedList = new CircularLinkedList<>();

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
                    addEmployee(circularLinkedList, scanner);
                    break;
                case 2:
                    removeEmployee(circularLinkedList, scanner);
                    break;
                case 3:
                    listAllEmployees(circularLinkedList, scanner);
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

    public static void addEmployee(CircularLinkedList<Employee> circularLinkedList, Scanner scanner)
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
        System.out.println("\t3. After");
        System.out.print("\nSelect an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option)
        {
            case 1:
                circularLinkedList.addAtStart(employee);
                break;
            case 2:
                circularLinkedList.addAtEnd(employee);
                break;
            case 3:
                System.out.println("\nEnter employee details after which you want to add new employee");

                System.out.print("\tId: ");
                String afterId = scanner.nextLine();

                System.out.print("\tName: ");
                String afterName = scanner.nextLine();

                circularLinkedList.add(employee, new Employee(afterId, afterName));
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

    public static void removeEmployee(CircularLinkedList<Employee> circularLinkedList, Scanner scanner)
    {
        clearConsole();
        System.out.println("====================================================");
        System.out.println("Remove an employee");
        System.out.println("====================================================\n");

        System.out.println("From where to remove the employee from the list?");
        System.out.println("\t1. From the start");
        System.out.println("\t2. From the end");
        System.out.println("\t3. Employee ");
        System.out.print("\nSelect an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option)
        {
            case 1:
                circularLinkedList.removeFromStart();
                break;
            case 2:
                circularLinkedList.removeFromEnd();
                break;
            case 3:
                System.out.println("Enter the employee details: ");

                System.out.print("\tId: ");
                String empId = scanner.nextLine();

                System.out.print("\tName: ");
                String empName = scanner.nextLine();
                scanner.nextLine();

                circularLinkedList.remove(new Employee(empId, empName));
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

    public static void listAllEmployees(CircularLinkedList<Employee> circularLinkedList, Scanner scanner)
    {
        CircularLinkedList.Node<Employee> headNode = circularLinkedList.getHead();
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

            do
            {
                System.out.println("\t\t" + counter++ + " \t" + headNode.getData().getId() + " \t" + headNode.getData().getName());
                headNode = headNode.getNext();
            }
            while (headNode != circularLinkedList.getHead());

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
