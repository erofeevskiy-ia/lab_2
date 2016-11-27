package eolimpSort;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Игорь on 25.11.2016.
 */
public class Dir {
    public static void main(String[] args) {
        /*String list[] = new File("C:\\Users\\Игорь\\Desktop\\ГОСЫ").list();
        for(int i = 0; i < list.length; i++) {
            System.out.println(list[i] + "/");
     }   */
        File dir = new File("C:\\Users\\Игорь\\Desktop\\ГОСЫ");
    ArrayList<File> files=listFilesWithSubFolders(dir);
        Iterator<File> iter = files.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public static ArrayList<File> listFilesWithSubFolders(File dir) {
        ArrayList<File> files = new ArrayList<File>();
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                files.addAll(listFilesWithSubFolders(file));
            else
                files.add(file);
        }
        return files;
    }
}
