package Task4;

import java.io.File;
import java.util.Scanner;

public class task4 {

    public static long getTotalSize(File dir) {
        long size = 0;
        File[] files = dir.listFiles();
        if (files == null) {
            return 0;
        }
        for (File f : files) {
            if (f.isFile()) {
                size += f.length();
            } else if (f.isDirectory()) {
                size += getTotalSize(f); // recursive
            }
        }
        return size;
    }

    public static void printEachDirectorySize(File dir, String indent) {
        long size = getTotalSize(dir);
        System.out.println(indent + dir.getName() + " : " + size + " bytes");

        File[] files = dir.listFiles();
        if (files == null) return;
        for (File f : files) {
            if (f.isDirectory()) {
                printEachDirectorySize(f, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory name: ");
        String path = sc.nextLine();

        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Error: Directory does not exist!");
            return;
        }

        long totalBytes = getTotalSize(dir);
        double totalKB = totalBytes / 1024.0;
        double totalMB = totalKB / 1024.0;

        System.out.println("\nTotal Size:");
        System.out.println("Bytes: " + totalBytes + " bytes");
        System.out.println("Kilobytes: " + totalKB + " KB");
        System.out.println("Megabytes: " + totalMB + " MB");

        System.out.println("\nEach Directory Size:");
        printEachDirectorySize(dir, "");

        sc.close();
    }
}