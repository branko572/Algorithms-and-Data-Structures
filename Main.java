//За дадена двојно поврзана листа од N цели броеви, треба да се најде бројот на елементи такви што просекот на елементите од пред него во листата е поголем од просекот на елементи после него во листата.
//
//        Влез: Првиот број од влезот е бројот на елементи во листата N, а потоа во следниот ред се дадени самите елементи одделени со празно место.
//
//        Излез: Бројот на елементи што го задоволуваат условот.
//
//        /
//
//        For a given doubly-linked list with N integers, you need to find the number of elements such that the average of all elements before it is bigger than the average of all elements after it in the list.
//
//        Input: The first number in the input is the number of integers in the list N, then in the next line the elements are given, separated by spaces.
//
//        Output: The number of elements that satisfy the condition.
//
//        For example:
//
//        Input	Result
//        5
//        1 2 3 4 5
//        0
//        4
//        5 4 3 2
//        2



import java.util.*;

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E delete(DLLNode<E> node) {
        if (node == first)
            return deleteFirst();
        if (node == last)
            return deleteLast();
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null) last = null;
            return tmp.element;
        }
        return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        return null;
    }

    public DLLNode<E> find(E o) {
        DLLNode<E> tmp = first;
        while (tmp != null) {
            if (tmp.element.equals(o))
                return tmp;
            tmp = tmp.succ;
        }
        return null;
    }

    public int getSize() {
        int size = 0;
        DLLNode<E> tmp = first;
        while (tmp != null) {
            size++;
            tmp = tmp.succ;
        }
        return size;
    }

    public DLLNode<E> getFirst() {
        return first;
    }
    public DLLNode<E> getLast() {
        return last;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        DLLNode<E> tmp = first;
        while (tmp != null) {
            ret.append(tmp.toString());
            if (tmp.succ != null)
                ret.append("<->");
            tmp = tmp.succ;
        }
        return ret.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int sum=0;
        DLL<Integer>list=new DLL<>();
        for (int i=0;i<N;i++){
            int element = sc.nextInt();
            list.insertLast(element);
            sum+=element;
        }


        int size= list.getSize();
        int count=0;

        DLLNode<Integer>curr=list.getFirst();

        int sumbef=0;
        int sizebef=0;

        while (curr!=null){
            int sumafter=sum-sumbef- curr.element;
            int sizeafter=size-sizebef-1;
            if(sizebef>0 && sizeafter>0){
                double avgbef=(double) sumbef/sizebef;
                double avgafter=(double) sumafter/sizeafter;
                if(avgbef>avgafter){
                    count++;
                }
            }
            sumbef+=curr.element;
            sizebef++;
            curr=curr.succ;

        }



        System.out.println(count);
    }
}
