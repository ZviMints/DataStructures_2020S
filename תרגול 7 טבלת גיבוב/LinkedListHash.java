import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

// ======================= Students ======================= //
class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }
}

// ======================= HashNode ======================= //
class HashNode {
    Integer key;
    Student value;

    // Constructor
    public HashNode(Integer key, Student value) {
        this.key = key;
        this.value = value;
    }
}

// ======================= LinkedListHash ======================= //
public class LinkedListHash {

    private LinkedList<HashNode>[] buckets;

    // Constructor
    public LinkedListHash(int capacity) {
        buckets = new LinkedList[capacity];
        Arrays.fill(buckets, new LinkedList<HashNode>());
    }

    // Copy Constructor
    public LinkedListHash(LinkedListHash other) {

        this.buckets = new LinkedList[other.buckets.length];
        for (int i = 0; i < other.buckets.length; i++) {
            HashNode[] newBucket = (HashNode[]) Arrays.copyOf(other.buckets[i].toArray(), other.buckets[i].size());
            buckets[i] = (LinkedList<HashNode>) Arrays.asList(newBucket);
        }
    }

    public Integer insert(int key, Student value) {
        int h = Hash(key);

        // Check if key is already present
        if (get(key) != null) {
            for (int i = 0; i < buckets[h].size(); i++)
                if (buckets[h].get(i).key.equals(key))
                    buckets[h].get(i).value = value;
        } else buckets[h].add(new HashNode(key, value));

        return key;
    }

    public Student get(int key) {
        int h = Hash(key);
        for (int i = 0; i < buckets[h].size(); i++)
            if (buckets[h].get(i).key.equals(key))
                return buckets[h].get(i).value;

        // If key not found
        throw new NoSuchElementException("key cannot be find in the data structure");
    }

    public void remove(int key) {
        if (get(key) == null) return;
        int h = Hash(key);
        for (int i = 0; i < buckets[h].size(); i++)
            if (buckets[h].get(i).key.equals(key))
                buckets[h].remove(i);

    }

    private int Hash(int x) {
        return x % buckets.length;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < buckets.length; i++) {
            s += i + ": ";
            for (int j = 0; j < buckets[i].size(); j++)
                s += buckets[i].get(j).value + " -> ";
            s += "null";
            s += "\n";
        }
        return s;
    }
}
