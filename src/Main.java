import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner ;

public class Main {

    public static void heapInsert(ArrayList<Integer> heap,int value,int pos){
        System.out.println(value);
        if(heap.isEmpty()){
            heap.add(pos,value);
        }else {
            heap.add(pos, value);
            while (pos > 0) {
                if (heap.get(pos) > heap.get((pos - 1) / 2)) {
                    int temp = heap.get(pos);
                    heap.set(pos, heap.get((pos - 1) / 2));
                    heap.set((pos - 1) / 2, temp);
                }
                pos = (pos - 1) / 2;
            }
            System.out.println(heap);
        }
    }

    public static void deleteHeap(ArrayList<Integer> heap,int pos){

        heap.set(0,heap.get(pos-1));
        heap.remove(pos-1);

        heapify(heap,0);
    }

    public static void printHeap(ArrayList<Integer> heap){
        for(int i=0;i< heap.size()/2 ; i++){
            try{
            System.out.println("parent is - "+heap.get(i)+" Lchild is - "+heap.get(2*i+1)+" R child is - "+heap.get(2*i+2));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void heapify(ArrayList<Integer> heap){
        int pos = heap.size() - 1 ;
        while (pos > 0) {
            if (heap.get(pos) > heap.get((pos - 1) / 2)) {
                int temp = heap.get(pos);
                heap.set(pos, heap.get((pos - 1) / 2));
                heap.set((pos - 1) / 2, temp);
            }
            pos = (pos - 1) / 2;
        }
    }

    public static void isHeapOk(ArrayList<Integer> heap){
        for(int i=0;i<heap.size()/2 ; i++){
            if((2*i+2) >= heap.size()){

            }else if((2*i + 1) >= heap.size()){

            }else{
                if(heap.get(i) > heap.get(2*i+2) && heap.get(i) > heap.get(2*i+1))
            }
        }
    }

    public static void heapify(ArrayList<Integer> heap,int pos){

        if(isLeaf(heap,pos)){
            System.out.println("leaf node detected");
            return ;
        }

        if(heap.size() == 2){
            if(heap.get(0) < heap.get(1)){
                int temp = heap.get(pos);
                heap.set(pos, heap.get(2*pos+1));
                heap.set(2*pos+1, temp);
            }
            return;
        }

        if(heap.get(pos) < heap.get(pos*2 +1 ) || heap.get(pos*2 +2) > heap.get(pos)){
            if(heap.get(pos*2 +1 ) > heap.get(pos*2+2)){
                int temp = heap.get(pos);
                heap.set(pos, heap.get(2*pos+1));
                heap.set(2*pos+1, temp);
                heapify(heap,2*pos+1);
            }else{
                int temp = heap.get(pos);
                heap.set(pos, heap.get(2*pos+2));
                heap.set(2*pos+2, temp);
                heapify(heap,2*pos+2);
            }
        }

    }

    public static boolean isLeaf(ArrayList<Integer> heap,int pos){

        if(2*pos+1 >= heap.size())
            return true;
        return false ;
    }

    public static void main(String[] args) {

        int size = 0 ;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Capacity of an array");
        size = scanner.nextInt() ;

        ArrayList<Integer> heap = new ArrayList<Integer>();

        int pos = 0 ;

        while(size>0) {
            System.out.println("Enter a value to insert into heap");
            int val = scanner.nextInt();
            try {
                heapInsert(heap, val, pos);
                pos++;
            } catch (Exception e) {
                e.printStackTrace();
            }
            size--;
        }

        System.out.println("Deleting the ROOT");

        try {
            deleteHeap(heap, pos);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.print(heap);

    }
}
