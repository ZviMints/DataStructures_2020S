import java.util.NoSuchElementException;

public class MaxHeap {

    int[] heap;
    int SIZE;

    // ==================================== Insertion ==============================================
    public void add(int value) {
        if (SIZE == heap.length - 1) ensureCapacity();
        else {
            heap[SIZE + 1] = value;
            SIZE++;
            swapUp(SIZE - 1);
        }
    }

    private void ensureCapacity() {
        int[] newArr = new int[SIZE * 2 + 1];
        for (int i = 1; i < SIZE; i++)
            newArr[i] = heap[i];
        heap = newArr;
    }

    private void swapUp(int index)
    {
        if(index != 1) // if its not the head
        {
            int parent = parent(index);
            if(heap[parent] < heap[index])
            {
                swap(heap,parent,index);
                swapUp(parent);
            }
        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int i)
    {
        if (i < 1 ) throw new NoSuchElementException();
        else return (i/2);
    }

    // ==================================== Delete ==============================================
    public int removeMax()
    {
        if(SIZE == 0) throw new NoSuchElementException();
        else
        {
            swap(heap,1,SIZE); // swap root with last item
            SIZE--; // delete the root ( he is the last item at the heap )
            maxHeapify(1); // MaxHeapify from root
        }
        return heap[SIZE + 1]; // will show what deleted
    }

    private void maxHeapify(int i) // Down [After Remove]
    {
        int left,right;
        try { left = left(i); } catch(NoSuchElementException e) { left = 0; } ;
        try { right = right(i); } catch(NoSuchElementException e) { right = 0; } ;
        int largest = i;
        if(left >=1 && heap[left] > heap[largest])
            largest = left;
        if(right >= 1 && heap[right] > heap[largest])
            largest = right;

        // Now Largest is the maximum between i, right(i), left(i)
        if(largest != i)
        {
            swap(heap,largest,i);
            maxHeapify(largest);
        }
    }


    private int left(int i)
    {
        int answer = 2*i;
        if (answer > SIZE ) throw new NoSuchElementException();
        return answer;
    }

    private int right(int i)
    {
        int answer = 2*i + 1;
        if (answer > SIZE ) throw new NoSuchElementException();
        return answer;
    }

    // ==================================== Other API's ==============================================
    public int max() {
        return heap[1];
    }

    // Constructor
    public MaxHeap(int capacity)
    {
        if(capacity < 0 )  throw new RuntimeException("Capacity must be > 0");
        heap = new int[capacity + 1];  // Start with 1
        SIZE = 0;
    }

    // Function to build a Max-Heap from the given array O(n)
    public MaxHeap(int arr[]) // Build heap
    {
        // Copy the values
        heap = new int[arr.length + 1];
        for(int i=1; i<heap.length; i++)
            heap[i] = arr[i-1];


        // Initialize SIZE
        SIZE = heap.length - 1;

        buildHeap();
    }
    private void buildHeap() { // O(n)
        // Build heap
        for(int i = SIZE/2; i >= 1; i--)
            maxHeapify(i);
    }

    // log2(n) = log10(n) / log10(2)
    public int height() {
        return (int) Math.floor((Math.log(SIZE) / Math.log(2)) + 1);
    }

}
