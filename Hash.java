//Во оваа задача ќе работите со два објекти „Вработени“ и „Проекти“.
//
//        Еден вработен е дефиниран со 2 вредности: Име (String), Возраст (цел број).
//
//        Еден проект е дефиниран со 2 вредности: Работно Време (цел број), Плата по час (цел број).
//
//        За даден проект вкупната плата се пресметува како производ на работното време и платата по час.
//
//        Вработените ќе добиваат понудени проекти, и треба да го изберат проектот од кој ќе добијат најголема плата (доколку имаат избор од повеќе проекти со иста најголема плата, тогаш првиот таков).
//
//        Ваша задача ќе биде да им помогнете на вработените со тоа што ќе искористите CBHT со 10 кофички каде што за секој вработен ќе ја чувате неговата најдобра понуда.
//
//        За хеш функција користете производ од возраста на вработениот и ASCII вредноста на првата буква од името на вработениот.
//
//        Влез:
//        Во првиот ред е даден еден цел број N кој го означува бројот на понуди. Потоа во следните N редови се дадени по 4 вредности, информациите за понудите, името и возраста на вработениот и работното време и платата од час на проектот соодветно:
//
//        N
//        name_1 age_1 time_1 rate_1
//        name_2 age_2 time_2 rate_2
//        ...
//        name_N age_N time_N rate_N
//        Излез:
//
//        Отпечатете ја целата табела (со готовиот toString метод).
//
//        Секој вработен да се печати во формат "<name, age>" каде на местото на name и age треба да стои името и возраста на вработениот соодветно (имплементирајте го ова во toString метод)
//
//        Секој проект да се печати во формат "<time, rate>" каде на местото на time и rate треба да стои работното време и платата по час на проектот соодветно (имплементирајте го ова во toString метод)
//
//        -----------------------------------
//
//        In this task, you will work with two objects "Employees" and "Projects".
//
//        An employee is defined with 2 values: Name (String), Age (integer).
//
//        A project is defined with 2 values: Working Time (integer), Hourly Salary (integer).
//
//        For a given project, the total salary is calculated as the product of the working time and the hourly salary.
//
//        Employees will be offered projects, and they should choose the project from which they will receive the highest salary (if they have a choice of multiple projects with the same highest salary, then the first one).
//
//        Your task will be to help employees by using CBHT with 10 buckets where for each employee you will store their best offer.
//
//        For the hash function, use the product of the employee's age and the ASCII value of the first letter of the employee's name.
//
//        Input:
//        The first line contains an integer N that indicates the number of offers. Then, in the next N rows, 4 values ​​are given, the information about the offers, the name and age of the employee and the working hours and hourly wage of the project respectively:
//
//        N
//        name_1 age_1 time_1 rate_1
//        name_2 age_2 time_2 rate_2
//        ...
//        name_N age_N time_N rate_N
//        Output:
//
//        Print the entire table (with the ready-made toString method).
//
//        Each employee should be printed in the format "<name, age>" where in place of name and age should be the name and age of the employee respectively (implement this in the toString method)
//
//        Each project should be printed in the format "<time, rate>" where in place of time and rate should be the working hours and hourly wage of the project respectively (implement this in the toString method)
//
//
//
//        Пример/Еxample:
//        Влез/Input:
//        5
//        Martin 25 3 100
//        Jana 26 4 90
//        Martin 25 5 120
//        Jana 26 2 95
//        Nenad 20 6 80
//        Излез/Output:
//        0:<<Nenad, 20>,<6, 80>>
//        1:
//        2:
//        3:
//        4:<<Jana, 26>,<4, 90>>
//        5:<<Martin, 25>,<5, 120>>
//        6:
//        7:
//        8:
//        9:
//
//
//
//
//        For example:
//
//        Input	Result
//        5
//        Martin 25 3 100
//        Jana 26 4 90
//        Martin 25 5 120
//        Jana 26 2 95
//        Nenad 20 6 80
//        0:<<Nenad, 20>,<6, 80>>
//        1:
//        2:
//        3:
//        4:<<Jana, 26>,<4, 90>>
//        5:<<Martin, 25>,<5, 120>>
//        6:
//        7:
//        8:
//        9:
//        1
//        Toni 45 10 500
//        Toni 42 30 600
//        Ana 20 10 300
//        Jana 20 15 350
//        0:<<Toni, 45>,<10, 500>>
//        1:
//        2:
//        3:
//        4:
//        5:
//        6:
//        7:
//        8:
//        9:




import com.sun.source.tree.Tree;

import java.util.*;
import java.util.logging.Level;


class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + " ";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }
}
class MapEntry<K, E> {
    // Each MapEntry object is a pair consisting of a key
    // and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K, E> {
    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is equal to targetKey.
        // Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(targetKey)) return currNode;
            else currNode = currNode.succ;
        }
        return null;
    }

    public void insert(K key, E val) {
        // Insert the entry <key, val> into this CBHT.
        // If entry with same key exists, overwrite it.
        MapEntry<K, E> newEntry = new MapEntry<>(key, val);
        int b = hash(key);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                // Make newEntry replace the existing entry ...
                currNode.element = newEntry;
                return;
            } else currNode = currNode.succ;
        }
        // Insert newEntry at the front of the SLL in bucket b ...
        buckets[b] = new SLLNode<>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        SLLNode<MapEntry<K, E>> predNode = null, currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                if (predNode == null) buckets[b] = currNode.succ;
                else predNode.succ = currNode.succ;
                return;
            } else {
                predNode = currNode;
                currNode = currNode.succ;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + " ";
                curr = curr.succ;
            }
            temp += "\n";
        }
        return temp;
    }
}

class OBHT<K, E> {

    // An object of class OBHT is an open-bucket hash table, containing entries
    // of class MapEntry.
    private MapEntry<K, E>[] buckets;

    // buckets[b] is null if bucket b has never been occupied.
    // buckets[b] is former if bucket b is formerly-occupied
    // by an entry that has since been deleted (and not yet replaced).

    static final int NONE = -1; // ... distinct from any bucket index.

    private final MapEntry<K, E> former = new MapEntry<>(null, null);
    // This guarantees that, for any genuine entry e,
    // e.key.equals(former.key) returns false.

    private int occupancy = 0;
    // ... number of occupied or formerly-occupied buckets in this OBHT.

    @SuppressWarnings("unchecked")
    public OBHT(int m) {
        // Construct an empty OBHT with m buckets.
        buckets = (MapEntry<K, E>[]) new MapEntry[m];
    }


    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }


    public int search(K targetKey) {
        // Find which if any bucket of this OBHT is occupied by an entry whose key
        // is equal to targetKey. Return the index of that bucket.
        int b = hash(targetKey);

        for (int n_search = 0; n_search < buckets.length; n_search++) {
            MapEntry<K, E> currEntry = buckets[b];
            if (currEntry == null) return NONE;
            else if (currEntry != former && currEntry.key.equals(targetKey)) return b;
            else b = (b + 1) % buckets.length;
        }
        return NONE;
    }

    public MapEntry<K, E> getBucket(int bucket) {
        return buckets[bucket];
    }


    public void insert(K key, E val) {
        // Insert the entry <key, val> into this OBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        int n_search = 0;
        Integer free_position = null;
        Integer existing_position = null;
        while (n_search < buckets.length) {
            MapEntry<K, E> currEntry = buckets[b];
            if (currEntry == null) {
                if (free_position == null) free_position = b;
                break;
            } else if (currEntry != former && currEntry.key.equals(key)) {
                existing_position = b;
                break;
            } else {
                if (currEntry == former && free_position == null) {
                    free_position = b;
                }
                b = (b + 1) % buckets.length;
                n_search++;
            }
        }
        if (existing_position != null)
            buckets[existing_position] = newEntry;
        else if (free_position != null) {
            buckets[free_position] = newEntry;
            if (++occupancy == buckets.length) {
                System.out.println("Hash tabelata e polna!!!");
            }
        } else {
            // failed to insert, table was already full
        }
    }


    @SuppressWarnings("unchecked")
    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this OBHT.
        int b = hash(key);
        int n_search = 0;
        while (n_search < buckets.length) {
            MapEntry<K, E> currEntry = buckets[b];
            if (currEntry == null) return;
            else if (currEntry != former && currEntry.key.equals(key)) {
                buckets[b] = former;
                --occupancy;
                return;
            } else {
                b = (b + 1) % buckets.length;
                n_search++;
            }
        }
    }


    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            if (buckets[i] == null)
                temp += "\n";
            else if (buckets[i] == former)
                temp += "former\n";
            else
                temp += buckets[i] + "\n";
        }
        return temp;
    }


    public OBHT<K, E> clone() {
        OBHT<K, E> copy = new OBHT<K, E>(buckets.length);
        for (int i = 0; i < buckets.length; i++) {
            MapEntry<K, E> e = buckets[i];
            if (e != null && e != former)
                copy.buckets[i] = new MapEntry<>(e.key, e.value);
            else if(e == former)
                copy.buckets[i] = copy.former;
            else
                copy.buckets[i] = null;
        }
        return copy;
    }
}

class Vraboten{
    String ime;
    int vozrast;

    public Vraboten(String ime, int vozrast) {
        this.ime = ime;
        this.vozrast = vozrast;
    }

    public String getIme() {
        return ime;
    }

    public int getVozrast() {
        return vozrast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vraboten vraboten = (Vraboten) o;
        return vozrast == vraboten.vozrast && Objects.equals(ime, vraboten.ime);
    }

    @Override
    public int hashCode() {
        return vozrast*ime.charAt(0);
    }


    @Override
    public String toString() {
        return "<"+ime+", "+vozrast+">";
    }
}

class Proekt{
    int rab_vreme;
    int plata;

    public Proekt(int rab_vreme, int plata) {
        this.rab_vreme = rab_vreme;
        this.plata = plata;
    }

    public int getRab_vreme() {
        return rab_vreme;
    }

    public int getPlata() {
        return plata;
    }

    public int vkupno_plata(){
        return rab_vreme*plata;
    }

    @Override
    public String toString() {
        return "<"+rab_vreme+", "+plata+">";
    }
}



public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<Vraboten,Proekt> tabela = new CBHT<>(10);

        for(int i=0;i<n;i++){
            Vraboten v = new Vraboten(sc.next(), sc.nextInt());
            Proekt p = new Proekt(sc.nextInt(), sc.nextInt());
            SLLNode<MapEntry<Vraboten, Proekt>>tmp=tabela.search(v);
            if (tmp == null) {
                tabela.insert(v, p);

            }else{
                Proekt najdobar=tmp.element.value;
                if(p.vkupno_plata()>najdobar.vkupno_plata()){

                    tabela.insert(v,p);
                }
            }
        }



        System.out.println(tabela);
    }
}
