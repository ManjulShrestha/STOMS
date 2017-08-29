/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.utils;

/**
 * Since we are prone to use system.out most of the time so instead
 * of that we can use this class to write to STDOUT. Doing this, 
 * it will be easier to block all the STDOUT prints from here
 * once and for entire project
 * @author Bibek Shrestha
 */
public class Console {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void print(String message){
        System.out.print(message);
    }
    
    // Just changing color of output
    public static void println(String message){
        System.out.println(ANSI_GREEN+message+ANSI_RESET);
    }

    public static void info(String message) {
        System.out.println(ANSI_CYAN+message+ANSI_RESET);
    }

    public static void warning(String message) {
        System.out.println(ANSI_YELLOW+message+ANSI_RESET);
    }
    
    public static void error(String message){
        System.out.println(ANSI_RED+message+ANSI_RED);
    }
    
}
