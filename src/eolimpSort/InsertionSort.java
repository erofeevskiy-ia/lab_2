package eolimpSort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Игорь on 13.11.2016.
 */
public class InsertionSort {

    FastScanner in;
    PrintWriter out;
    int[] array;
    InsertionSort(int N){
        array=new int[N];
    }



    public static void insertionSort(int[] a) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("output.txt"));
        for (int i=0;i<a.length;i++) {
            for(int j=i;j>0&&a[j]<a[j-1];j--) {
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;

                for(int k=0;k<a.length;k++){
                    out.print(a[k]+" ");
                }
                out.println();
            }
        }
        out.close();

    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            int N=in.nextInt();
            for(int i=0;i<N;i++)
                array[i]=in.nextInt();
            //--------SOLVE
           /* int curr;
            int i,j;

            for (i=0;i<array.length;i++){
                boolean check=false;
                curr=array[i];
                for(j=i;j>0&&array[j]<array[j-1];j--){
                    array[j]=array[j-1];
                    check=true;
                }
                array[j]=curr;
                if(check!=false){
                    for(int k=0;k<array.length;k++){
                        out.print(array[k]+" ");
                    }
                    out.println();
                }
            }
            for(int k=0;k<array.length;k++){
                out.print(array[k]+" ");
            }
            out.println();*/


            for (int i=0;i<array.length;i++) {
                boolean check=false;
                for(int j=i;j>0&&array[j]<array[j-1];j--) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    check=true;
                }
                if(check!=false){
                    for(int k=0;k<array.length;k++){
                        out.print(array[k]+" ");
                    }
                    out.println();
                }

            }
            //------------SOLVE

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

    public static void main(String[] arg) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int N= in.nextInt();
        new InsertionSort(N).run();
    }
}


