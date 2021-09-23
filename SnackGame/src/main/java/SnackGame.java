/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jason
 */
public class SnackGame {
    static boolean startGame=false;
    public static void main(String[] args) {
        MoveObject.clear();
       // SnackFrame snackframe = new SnackFrame();
        
       Runnable runnable=new SnackFrame();
        Thread oneThread=new Thread(runnable);
        oneThread.start();
       
    }
}
