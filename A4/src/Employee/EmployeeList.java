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
                
                t = t.next;
            } while (t.next != null);
        }
        return salaries;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}
