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

        if(heap.size() == 0){
            System.out.println("Empty heap");
            return ;
        }

        if(heap.size() == 1){
            System.out.println("heap becomes empty after deleting the Current root");
            heap.remove(0);
            return;
        }
        heap.set(0,heap.get(pos-1));
        heap.remove(pos-1);
        heapify(heap,0);
        System.out.println(heap);

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

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> heap = new ArrayList<Integer>();

        int pos = 0 ;

        while(true) {

            System.out.println("Chooose one option \n1. insert \n2. delete \nAny other key to stop excecution");
            int choice = scanner.nextInt();
            if(choice == 1) {
                System.out.println("Enter a value to insert into heap");
                int val = scanner.nextInt();
                try {
                    heapInsert(heap, val, pos);
                    pos++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(choice == 2){
                System.out.println("deleting a node");
                try {
                    deleteHeap(heap, heap.size());
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }else {
                System.out.println("Stopping the max heap program");
                break;
            }
        }

        System.out.print(heap);

    }
}
