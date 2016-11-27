package eolimpSort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Игорь on 13.11.2016.
 */
public class BubbleSort2 {

    FastScanner in;
    PrintWriter out;
    int[] array;
    BubbleSort2(int N){
        array=new int[N];
    }

    public static int  bubbleSort(int[] a)  {
        int count=0;
        for(int i=a.length-1;i>=0;i--)
            for(int j=0;j<i;j++)
                if(a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    count++;
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


                out.print(BubbleSort2.bubbleSort(array));
            //solve();

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
        new BubbleSort2(N).run();
    }
}

