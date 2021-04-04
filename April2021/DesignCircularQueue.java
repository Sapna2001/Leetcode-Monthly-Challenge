/*
Link :- https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3696/
*/

class MyCircularQueue {
    int size, count = 0, rear = -1, front = -1;
    int arr[];

    public MyCircularQueue(int k) {
        this.size = k;
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) 
            return false;
        rear = ++rear % size;
        arr[rear] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false; 
        front = ++front % size;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return arr[(front+1)%size];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return arr[(rear)%size];    
    }
    
    public boolean isEmpty() {
        return count == 0;  
    }
    
    public boolean isFull() {
        return count == size;   
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
