package ExamenListasEnlazadas;
// Clase Nodo
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Clase Lista Enlazada
class LinkedList {
    private Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addMiddle(int data, int position) {
        if (position == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void printList() {
        Node current = head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

// Clase Main para pruebas
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Grupo 1:
        System.out.println("1. Agregar 0 al inicio");
        list.addFirst(0);

        System.out.println("2. Agregar 2 al final");
        list.add(2);

        System.out.println("3. Agregar 4 en la posicion 1");
        list.addMiddle(4, 1);

        System.out.println("4. Mostrar lista actual");
        list.printList();

        System.out.println("5. Remover el numero 2");
        list.remove(2);

        System.out.println("6. Mostrar lista despues de eliminacion");
        list.printList();

        System.out.println("7. Agregar 6 al final");
        list.add(6);

        System.out.println("8. Verificar si 4 esta en la lista: " + list.contains(4));
        System.out.println("9. Verificar si 8 esta en la lista: " + list.contains(8));

        System.out.println("10. Revertir lista");
        list.reverse();

        System.out.println("11. Mostrar lista despues de revertir");
        list.printList();

        System.out.println("12. Agregar 8 al inicio");
        list.addFirst(8);

        System.out.println("13. Mostrar lista final");
        list.printList();
    }
}
