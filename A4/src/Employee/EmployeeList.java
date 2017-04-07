/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.util.Objects;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class EmployeeList {
    private class ListNode {
        private Object employee;
        private ListNode next;

        public ListNode(Object employee, ListNode next) {
            this.employee = employee;
            this.next = next;
        }
    }
    
    private ListNode head;
    
    public EmployeeList() {
        head = null;
    }
    
    public void addToStart(Object employee) {
        head = new ListNode(employee, head);
    }
    
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
        ListNode position = head;
        while(position != null) {
            count++;
            position = position.next;
        }
        return count;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public void clear() {
        head = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmployeeList other = (EmployeeList) obj;
        if (!Objects.equals(this.head, other.head)) {
            return false;
        }
        return true;
    }
    
    
}
