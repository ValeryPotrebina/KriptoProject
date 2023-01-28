import grafics.Grafics;
import servises.BruteForce;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Grafics().start();
        /*Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        BruteForce.bruteForce(path);
        System.out.println();*/
    }
}
