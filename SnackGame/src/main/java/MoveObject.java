/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jason
 */
public class MoveObject {

    static int moveType = 0;
    static int nowLength = 5;
    static int[] xState = new int[500];
    static int[] yState = new int[500];

    public static void clear() {
        moveType = 0;
        nowLength = 5;
        for (int i = 0; i < 500; i++) {
            xState[i] = -20;
            yState[i] = 0;
        }
        for (int i = 0; i < nowLength; i++) {
            xState[i] = 100 - (i * 20);
        }
        SnackPanel.eatApple=0;
    }

    public static void move() {
        update();
        if (moveType % 4 == 0) {
            xState[0] += 20;
        }
        if (moveType % 4 == 1) {
            xState[0] -= 20;
        }
        if (moveType % 4 == 2) {
            yState[0] -= 20;
        }
        if (moveType % 4 == 3) {
            yState[0] += 20;
        }
    }

    public static void update() {
        for (int i = nowLength - 1; i > 0; i--) {
            xState[i] = xState[i - 1];
            yState[i] = yState[i - 1];
        }
    }

    public static boolean checkDead() {
        if (xState[0] < 0 || xState[0] > 465 || yState[0] > 440 || yState[0] < 0) {
            return true;
        }
        for (int i = 1; i < nowLength; i++) {
            if (Math.abs(xState[i] - xState[0]) < 10 && Math.abs(yState[i] - yState[0]) < 10) {
                return true;
            }
        }
        return false;
    }

}
