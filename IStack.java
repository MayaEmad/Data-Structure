import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}


public class MyStack implements IStack {
    public class SNode{
        int data;
        SNode next;
    }
    SNode head = null;
    SNode tail = null;
    int size = 0;
    
    
     public void add(int element){
        if(isEmpty()){
            SNode tmp = new SNode();
            tmp.data = element ;
            head = tmp;
            tail = tmp;
        }
        else{
            SNode tmp = new SNode();
            tmp.data =  element;
            tail.next = tmp;
            tail = tmp;
        }
    }
    public void print(){
        SNode h = head ;
        while (h != null){
            if (h.next != null)
                System.out.print(h.data + ", ");
            else
                System.out.print(h.data);
            h = h.next;
        }
    }
    public void clear(){
        head = null;
        tail= null;
        size = 0;
        print();
    }

     public boolean isEmpty(){
        if(head == null) {return true;}
        else{return false;}
    }

    public int size(){
        int count = 0;
        if (isEmpty()) {
            count = 0;
        } else {
            SNode current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;
    }

    public void push(Object data){
        SNode node = new SNode();
        node.data = (int)data;
        node.next = head;
        head = node;
        print();

    }
    public Object get(int index){
        SNode ptr=head;
        for(int i=0 ; i< index ; i++)
        {
            ptr=ptr.next;
        }
        return ptr.data;
    }
    public Object peek(){
       if (isEmpty()) 
           return ("Error");
        else
        return get(0);
    }

    public Object pop(){
        if (isEmpty()) 
            System.out.print("Error");
        // SNode first = null;
        // Object item = first.data;      // save item to return
        // first = first.next;           // delete first node
        else{
        head = head.next;
        System.out.print("[");
        print();
        System.out.print("]");
        }
        System.exit(0);
        return pop();
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        MyStack LL = new MyStack ();
        Scanner sc = new Scanner(System.in);
        String fun;
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[]  s = sin.split(", " );
        int i = 0;
        if (s.length == 1 && s[0].isEmpty() ) {
            LL.clear();
        }
        else{
            while (i <= s.length - 1){
                LL.add(Integer.parseInt(s[i]));
                i++;
            }
        }
        fun = sc.nextLine();
        switch (fun){
                case "isEmpty" :
                if(LL.isEmpty())
                    System.out.println("True");
                else
                    System.out.println("False");
                break;

                 case "size" :
                System.out.println(LL.size());
                break;

            case "push" :
                int el = sc.nextInt();
                 System.out.print("[");
                LL.push(el);
                 System.out.print("]");
                break;
                
            case "peek" :
                System.out.print(LL.peek());
                break;
                
            case "pop" :
                    System.out.print(LL.pop());
             
             
        }

    }
}