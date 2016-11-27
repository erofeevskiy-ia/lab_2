package eolimpSort;


import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CountingSort {

    FastScanner in;
    PrintWriter out;
    //int[] array;
    int[] arr;
    int size=0;
    CountingSort(int n){
        arr = new int[n];
    }

    void simpleCountingSort(int[] a) {
        int max=findMax(a);
        int[] count = new int[max+1];
        for(int x:a) count[x]++;
        int pos=0;
        for(int k=0;k<=max;k++){
            for(int i=0;i<count[k];i++){
                a[pos++]=k;
            }
        }
    }

    private int findMax(int[] a) {
        int max=0;
        for(int x:a){
            max=Math.max(max,x);
        }
        return max;
    }


    public void run() throws FileNotFoundException {
        try {
            in = new FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));
            int N = in.nextInt();
            for(int i=0;i<N;i++) {
                arr[i] = in.nextInt();
            }
            //--------SOLVE
            simpleCountingSort(arr);
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
        new CountingSort(N).run();
    }
}




