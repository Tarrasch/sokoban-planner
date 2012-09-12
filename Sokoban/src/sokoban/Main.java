/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author arash
 */
public class Main {
    
    static public int[] a = { 1};
    static public int[] getA (){ return a; }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] b = getA();
        b[0]=5;
        
        System.out.println(a[0]);
        // TODO code application logic here
    }
}
