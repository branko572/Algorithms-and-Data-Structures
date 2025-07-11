//Библиотека е посетена од студентите со цел да изнајмат еден или повеќе типови на книги. Дадена книга може да припаѓа на една од трите категории: Наука, Научна фантастика или Историја. Кога библиотеката ќе започне со работа првин се услужени студентите кои чекаат ред за книга од тип Наука, потоа студентите кои чекаат ред за книга од тип научна фантастика и на крај студентите кои чекаат ред за книга од тип Историја.
//
//        Доколку студент чека ред за книги од различен тип, тој чека ред првин во редицата за книга од тип Наука, потоа во редицата за книга од тип Научна фантастика и на крај во редицата за книга од тип Историја (во зависност ако ги бара овие книги за позајмување).
//
//
//        Влез: Во првата линија е даден број на студенти кои имаат дојдено во библиотеката да позајмат книга. Потоа 4 редици се внесуваат за секој студент, каде првата линија е име на студент, а во останатите 3 редици се внесува дали студентот ќе позајми книга од даден тип (Наука, Научна фантастика и Историја соодветно), каде 1 значи дека има за цел да позајми книга од тој тип, 0 значи дека нема да позајми книга од тој тип.
//
//        Пример:
//
//        Иван Ивановски
//
//        1
//
//        1
//
//        0
//
//        значи дека студентот Иван Ивановски има за цел да позајми книга од тип Наука и тип Научна фантастика, но не има за цел да позајми книга од тип Историја.
//
//        Излез: Испечати го редоследот на студентите по редослед како завршуваат со позајмување на сите книги.
//
/////
//        A library is visited by students in order to borrow one or more types of books. A given book can belong to one of three categories: Science, Science Fiction, or History. When the library opens, students waiting in line for a Science book are served first, then students waiting in line for a Science Fiction book, and finally students waiting in line for a History book.
//
//        If a student is waiting in line for books of different types, he waits in line first for a Science book, then for a Science Fiction book, and finally for a History book (depending on whether he is requesting these books for borrowing).
//
//        Input: The first line contains the number of students who have come to the library to borrow a book. Then 4 lines are entered for each student, where the first line is the student's name, and the remaining 3 lines indicate whether the student will borrow a book of a given type (Science, Science Fiction, and History, respectively), where 1 means that he intends to borrow a book of that type, 0 means that he will not borrow a book of that type.
//
//        Example:
//
//        Ivan Ivanovski
//
//        1
//
//        1
//
//        0
//
//        means that student Ivan Ivanovski aims to borrow a book of type Science and type Science Fiction, but does not aim to borrow a book of type History.
//
//        Output: Print the order of students in the order they finish borrowing all the books.
//
//        For example:
//
//        Input	Result
//        2
//        Иван Ивановски
//        1
//        1
//        0
//        Марија Маркова
//        1
//        0
//        1
//        Иван Ивановски
//        Марија Маркова
//        3
//        Иван Ивановски
//        1
//        0
//        1
//        Марија Маркова
//        0
//        1
//        1
//        Петар Петров
//        1
//        1
//        0
//
//        Петар Петров
//        Иван Ивановски
//        Марија Маркова
//





import java.util.*;

interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}


class ArrayQueue<E> {
    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size() {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek() {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        // Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue(E x) {
        // Go dodava x na kraj od redicata.
        if (length == elems.length)
            throw new NoSuchElementException();
        elems[rear++] = x;
        if (rear == elems.length) rear = 0;
        length++;
    }

    public E dequeue() {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length) front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

class Biblioteka{
    String ime;
    int nauka;
    int scifi;
    int istorija;

    Biblioteka(String ime, int nauka, int scifi, int istorija) {
        this.ime = ime;
        this.nauka = nauka;
        this.scifi = scifi;
        this.istorija = istorija;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayQueue<Biblioteka> redNauka = new ArrayQueue<>(n * 3);
        ArrayQueue<Biblioteka> redScifi = new ArrayQueue<>(n * 3);
        ArrayQueue<Biblioteka> redIstorija = new ArrayQueue<>(n * 3);

        for (int i = 0; i < n; i++) {
            String ime = sc.nextLine();
            int nauka = Integer.parseInt(sc.nextLine());
            int scifiBook = Integer.parseInt(sc.nextLine());
            int istorija = Integer.parseInt(sc.nextLine());

            Biblioteka b = new Biblioteka(ime, nauka, scifiBook, istorija);

            if (b.nauka == 1)
                redNauka.enqueue(b);
            else if (b.scifi == 1)
                redScifi.enqueue(b);
            else if (b.istorija == 1)
                redIstorija.enqueue(b);
        }

        while (!redNauka.isEmpty() || !redScifi.isEmpty() || !redIstorija.isEmpty()) {

            int size = redNauka.size();
            for (int i = 0; i < size; i++) {
                Biblioteka b = redNauka.dequeue();
                b.nauka = 0;
                if (b.scifi == 1)
                    redScifi.enqueue(b);
                else if (b.istorija == 1)
                    redIstorija.enqueue(b);
                else
                    System.out.println(b.ime);
            }

            size = redScifi.size();
            for (int i = 0; i < size; i++) {
                Biblioteka b = redScifi.dequeue();
                b.scifi = 0;
                if (b.istorija == 1)
                    redIstorija.enqueue(b);
                else
                    System.out.println(b.ime);
            }

            size = redIstorija.size();
            for (int i = 0; i < size; i++) {
                Biblioteka b = redIstorija.dequeue();
                b.istorija = 0;
                System.out.println(b.ime);
            }
        }
    }
}
