package eolimpSort;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HeapSort {

    FastScanner in;
    PrintWriter out;
    //int[] array;
    int[] aHeap;
    int size=0;
    HeapSort(String s){
        String[] ss = s.split(" ");
        aHeap = new int[ss.length];
        //for (String retval : s.split(" ")){
        for(int i=0;i<aHeap.length;i++) {
            aHeap[i] = Integer.parseInt(ss[i]);
        }

    }

    void siftDown(int i,int heapSize) {
        while (2 * i + 1 < heapSize) {     // heapSize — количество элементов в куче
            int left = 2 * i + 1;      // left — левый сын
            int right = 2 * i + 2;     // right — правый сын
            int j = left;
            if (right<heapSize && aHeap[right] > aHeap[left])
                j = right;
            if (aHeap[i]>= aHeap[j])
                break;
            int item=aHeap[i];
            aHeap[i]=aHeap[j];
            aHeap[j]=item;
            i = j;
        }
    }

    void siftUp(int i) {
        while (aHeap[i] > aHeap[(i - 1) / 2]) {    // i == 0 — мы в корне
            int item=aHeap[i];
            aHeap[i]=aHeap[(i-1)/2];
            aHeap[(i-1)/2]=item;
            i = (i - 1) / 2;
        }
    }
    void insert(int k){
        size = size + 1;
        aHeap[size - 1] = k;
        siftUp(size - 1);

    }


    void build(){
        size=aHeap.length;
        for(int i=aHeap.length/2; i>-1;i--){
            siftDown(i,size);
        }
    }


    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            /*int N=in.nextInt();
            for(int i=0;i<N;i++)
                aHeap[i]=in.nextInt();*/
            //--------SOLVE
            int heapSize = aHeap.length;
            build();
            for(int i=aHeap.length;i>1;i--) {
                int tmp = aHeap[0];
                aHeap[0]=aHeap[heapSize-1];
                aHeap[heapSize-1]=tmp;
                heapSize--;
                siftDown(0,heapSize);

            }
            //------------SOLVE
            for(int i = 0;i<aHeap.length;i++)
                out.print(aHeap[i]+" ");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        String N= in.readLine();
        new HeapSort(N).run();
    }
}



