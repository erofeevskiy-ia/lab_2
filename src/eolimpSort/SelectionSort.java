package eolimpSort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Игорь on 13.11.2016.
 */
public class SelectionSort {

    FastScanner in;
    PrintWriter out;
    int[] array;
    SelectionSort(int N){
        array=new int[N];
    }

    public static int  selectionSort(int[] a)  {
        int check=0;
        int count=0;
        for (int i=0;i<a.length-1;i++) {
            int min = i;
            for(int j=i+1;j<a.length;j++) {
                if(a[j]<a[min]) min=j;
            }
            if(i==check&&i!=min) {
                count++;
                check=min;
            } else if(min==check&&i!=min){
                count++;
                check=i;
            }
            int tmp=a[i];
            a[i]=a[min];
            a[min]=tmp;
        }

        return count;
    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));

            int N=in.nextInt();
            for(int i=0;i<N;i++)
                array[i]=in.nextInt();


            out.println(SelectionSort.selectionSort(array));
//            for(int i=0;i<N;i++)
//                out.println(array[i]);

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
        new SelectionSort(N).run();
    }
}

