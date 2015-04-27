import java.io.*;
import java.lang.Thread;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.io.File;
import java.util.Scanner;

public class NewAutoNexus {
    
    private static Robot robot;
    private static Color color;
    
    private static int x1;
    private static int y1;
    private static int x2;
    private static int y2;
    private static int p;
    private static int xc;
    private static int yc;

    private static int r;
    private static int g;
    private static int b;

    private static int count;
    
    private static void StartRobot() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public static boolean Aprox(int a, int b) {
        if (abs(a - b) <= 2) {
            return true;
        }
        return false;
    }

    public static boolean CheckColor(int r1, int g1, int b1, int r2, int g2, int b2) {
        if (Aprox(r1, r2) && Aprox(g1, g2) && Aprox(b1, b2)) {
            return true;
        }
        return false;
    }

    public static void Fuckoff() {
        System.out.println("Fuckoff initiated...");
        for (int i = 0; i < 10; ++i) {
             robot.keyPress('R');
             robot.keyRelease('R');
        }
        ++count;
        System.out.println("You've been saved " + count + " times");
        Sleep(20000);
        System.out.println("The hack is working again.");
    }

    public static void Check(int x, int y) {
        int r1;
        int b1;
        int g1;
        color = robot.getPixelColor(x, y);
        r1 = color.getRed();
        g1 = color.getGreen();
        b1 = color.getBlue();
        // System.out.println(r + " " + g + " " + b + "   " + r1 + " " + g1 + " " + b1);
        if (CheckColor(r, g, b, r1, g1, b1)) {
            Fuckoff();
        }
    }
    
    public static void main(String[] args) {
        File file = new File("config");
        try {
            System.out.println("The hack is on. Good luck >:)");
            Scanner in = new Scanner(file);
            StartRobot();
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            color = robot.getPixelColor(x1, y1);
            r = color.getRed();
            g = color.getGreen();
            b = color.getBlue();
            // System.out.println(r + " " + g + " " + b);
            while (true) {
                Check(x2, y2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
