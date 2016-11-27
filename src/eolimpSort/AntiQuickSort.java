package eolimpSort;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AntiQuickSort {

    FastScanner in;
    PrintWriter out;
    //int[] array;
    int[] arr;
    int size=0;

    AntiQuickSort(int N){
        arr=new int[N];

        for(int i=0;i<arr.length;i++) {
            arr[i]=i+1;
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
    void antiqs() {

        for (int i = 2; i < arr.length; i++) {
            int t = arr[i];
            arr[i] = arr[i / 2];
            arr[i / 2] = t;
        }

    }


    public void run() throws FileNotFoundException {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            //--------SOLVE
            int max=Integer.MAX_VALUE;
            antiqs();
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
        Scanner in = new Scanner(new File("input.txt"));
        int N= in.nextInt();
        new AntiQuickSort(N).run();
    }
}



