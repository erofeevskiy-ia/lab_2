package eolimpSort;

/**
 * Created by Игорь on 15.11.2016.
 */

import java.io.*;
import java.util.StringTokenizer;
public class QuickSort {

    FastScanner in;
    PrintWriter out;
    //int[] array;
    int[] arr;
    int size=0;
    QuickSort(String s){
        String[] ss = s.split(" ");
        arr = new int[ss.length];
        //for (String retval : s.split(" ")){
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
    }

    void quickSort(int[] a,int l,int r){
    if(l<r) {
        int q = partition(a, l, r);
        quickSort(a, l, q);
        quickSort(a,q+1, r);
    }
    }
    void swap(int[] a, int fir, int sec){
        int tmp = a[fir];
        a[fir]=a[sec];
        a[sec]=tmp;

    }

    int partition(int[]a, int l, int r){

        int v = a[l+(r-l+1)/2];
        int i = l;
        int j = r;
        while (i <=j) {
            while (a[i]<v) i++;
            while (a[j]>v) j--;
            if (i<=j) swap(a,i++,j--);
        }
        return j;
    }


    public void run() throws FileNotFoundException {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            //--------SOLVE
            quickSort(arr,0,arr.length-1);

            //------------SOLVE
            for(int i = 0;i<arr.length;i++)
                out.print(arr[i]+" ");
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
        new QuickSort(N).run();
    }
}



