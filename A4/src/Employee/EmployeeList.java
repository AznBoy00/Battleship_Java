/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.util.NoSuchElementException;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class EmployeeList {
    private class EmployeeNode {
        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee, EmployeeNode next) {
            this.employee = employee;
            this.next = next;
        }
        
        public Employee get() {
            return employee;
        }
    }
    
    private EmployeeNode head;
    
    public EmployeeList() {
        head = null;
    }
    
    public void addToStart(Employee employee) {
        head = new EmployeeNode(employee, head);
    }
    
    public Employee getEmployee(int index) {
		if (index > size() -1)
		{
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}
		int i = 0;
		EmployeeNode temp = head;
		while(i != index)
		{
			temp = temp.next;
			i++;
		}
		
		return temp.employee;
	}
    
    /**
     * delete first entry of the node list
     * @return if delete head node was successful
     */
    public boolean deleteHeadNode() {
        if (head != null) {
            head = head.next;
            return true;
        } else {
            return false;
        }
    }
    
    public int size() {
        int count = 0;
        EmployeeNode position = head;
        while(position != null) {
            count++;
            position = position.next;
        }
        return count;
    }

    public EmployeeNode getHead() {
        return head;
    }

    public void setHead(EmployeeNode head) {
        this.head = head;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public void clear() {
        head = null;
    }
    
    public void addAtEnd(Employee e) {
        if(head == null)
            head = new EmployeeNode(e, null);

        EmployeeNode enode = head;
        while(enode.next != null)
            enode = enode.next;

        EmployeeNode n = new EmployeeNode(e, null);	
        enode.next = n; 						
        n = null;
    }
    
    public double getTotalSalary() {
        double salaries = 0;
        EmployeeNode t = head;
        if (t != null) {
            do{
                salaries += t.employee.getSalary();
                
                t = t.next;
            } while (t.next != null);
        }
        return salaries;
    }
    
    public void findLowestSalary() {
        EmployeeNode t = head;
        double lowest = -1;
        if (t != null)
            lowest = head.employee.getSalary();
        
        if (t != null) {
            do{
                if (t.employee.getSalary() < lowest) {
                    lowest = t.employee.getSalary();
                }
                t = t.next;
            } while (t.next != null);
        }
        if (lowest > 0) {
            System.out.println("The employee(s) with the lowest salary is/are:");
            t = head;
            if (t != null) {
                do{
                    if (t.employee.getSalary() == lowest) {
                        System.out.println(t.employee.toString());
                    }
                    t = t.next;
                } while (t.next != null);
            }
        }
    }
    
    public void findHighestSalary() {
        EmployeeNode t = head;
        double highest = -1;
        if (t != null)
            highest = head.employee.getSalary();
        
        if (t != null) {
            do{
                if (t.employee.getSalary() > highest) {
                    highest = t.employee.getSalary();
                }
                t = t.next;
            } while (t.next != null);
        }
        if (highest > 0) {
            System.out.println("The employee(s) with the highest salary is/are:");
            t = head;
            if (t != null) {
                do{
                    if (t.employee.getSalary() == highest) {
                        System.out.println(t.employee.toString());
                    }
                    t = t.next;
                } while (t.next != null);
            }
        }
    }
    
    public void IncreaseStaffSalary() {
        EmployeeNode t = head;
        /*if (t != null) {
            do{
                bonus = 0;
                if (((Staff)t.employee).getPerformanceCode().toLowerCase().equals("a")) {
                    bonus = 0.08*t.employee.getSalary();
                } else if (((Staff)t.employee).getPerformanceCode().toLowerCase().equals("b")){
                    bonus = 0.06*t.employee.getSalary();
                } else if (((Staff)t.employee).getPerformanceCode().toLowerCase().equals("c")){
                    bonus = 0.03*t.employee.getSalary();
                } else if (((Staff)t.employee).getPerformanceCode().toLowerCase().equals("d")){
                    bonus = 0.01*t.employee.getSalary();
                } else if (((Staff)t.employee).getPerformanceCode().toLowerCase().equals("e")){
                    bonus = 0.00*t.employee.getSalary();
                } else {
                    System.out.println("ERROR! Invalide code. Exiting...");
                    System.exit(1);
                }
                t.employee.setSalary((t.employee.getSalary() + bonus));
                ((Staff)(t.employee)).setPerformanceCode("E");
                t = t.next;
            } while (t.next != null);
        }*/
        while (t != null && t.next != null) {
            switch (((Staff)t.employee).getPerformanceCode().toLowerCase()) {
                case "a":
                    t.employee.setSalary(t.employee.getSalary()*1.08);
                    ((Staff)(t.employee)).setPerformanceCode("E");
                    break;
                case "b":
                    t.employee.setSalary(t.employee.getSalary()*1.06);
                    ((Staff)(t.employee)).setPerformanceCode("E");
                    break;
                case "c":
                    t.employee.setSalary(t.employee.getSalary()*1.03);
                    ((Staff)(t.employee)).setPerformanceCode("E");
                    break;
                case "d":
                    t.employee.setSalary(t.employee.getSalary()*1.01);
                    ((Staff)(t.employee)).setPerformanceCode("E");
                    break;
                case "e":
                    t.employee.setSalary(t.employee.getSalary());
                    break;
                default:
                    System.out.println("Error on performanceCode");
                    break;
            }
            t = t.next;
        }
    }
}
