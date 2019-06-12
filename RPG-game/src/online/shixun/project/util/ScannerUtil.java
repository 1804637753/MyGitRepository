package online.shixun.project.util;

import java.util.Scanner;

/**
 * 为了避免在每个需要输入的类中都定义scanner 
 */
public class ScannerUtil {
    
    /**
     * 定义静态公开的scanner对象，方便其他类直接使用
     */
    public static Scanner scanner = new Scanner(System.in);
    
}