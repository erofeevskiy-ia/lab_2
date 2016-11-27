package eolimpSort;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountWar {

    Reader in;
    PrintWriter out;

    public void run() throws FileNotFoundException {
        try {
            in = new  FileReader("input.txt");
            out = new PrintWriter(new File("output.txt"));
            int countW=0;
            int countZ=0;
            int c;
            //--------SOLVE
           while((c=in.read())>0)
           {
               if(c==' '|| c=='\n')
                   countW++;
               if(c=='.'||c=='?'||c=='!'||c==','||c=='-')
                   countZ++;

           }
            System.out.println("countW="+countW);
            System.out.println("countZ="+countZ);
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

    public static void main(String[] arg) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        new CountWar().run();
    }
}



