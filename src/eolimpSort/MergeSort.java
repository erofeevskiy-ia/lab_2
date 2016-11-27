package eolimpSort;

/**
 * Created by Игорь on 15.11.2016.
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class MergeSort {

    FastScanner in;
    PrintWriter out;
    //int[] array;
    int[][] arr;
    int size=0;
    MergeSort(int n){
        arr = new int[n][2];
    }
    private static void merge(int[][] a, int[][] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k][0] = a[k][0];
            aux[k][1] = a[k][1];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid){
                a[k][0] = aux[j][0];
                a[k][1] = aux[j][1];
                j++;
            }
            else if (j > hi){
                a[k][0] = aux[i][0];
                a[k][1] = aux[i][1];
                i++;
            }
            else if (aux[j][0]<aux[i][0]){
                a[k][0] = aux[j][0];
                a[k][1] = aux[j][1];
                j++;
            }
            else {
                a[k][0] = aux[i][0];
                a[k][1] = aux[i][1];
                i++;
            }
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[][] a, int[][] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public static void sort(int[][] a) {
        int [][] aux = new int[a.length][2];
        sort(a, aux, 0, a.length-1);

    }



    public void run() throws FileNotFoundException {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));
            int N = in.nextInt();
            for(int i=0;i<N;i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            //--------SOLVE
            sort(arr);
            //------------SOLVE
            for(int i = 0;i<arr.length;i++)
                out.println(arr[i][0]+" "+arr[i][1]);
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
        Scanner in = new Scanner(new File("input.txt"));
        int N= in.nextInt();
        new MergeSort(N).run();
    }
}



