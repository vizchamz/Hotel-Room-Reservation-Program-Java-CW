package classes;

public class CQueue {
    int size = 5;
    int front, rear;
    Room items[] = new Room[size];

    CQueue() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    void enQueue(Room element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % size;
            items[rear] = element;
            System.out.println("Inserted ");
        }
    }

    Room deQueue() {
        Room element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % size;
            }
            return (element);
        }
    }
}