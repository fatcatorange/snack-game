/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jason
 */
public class Food {

    public static int x = 0;
    public static int y = 0;

    public static void location() {
        x = (int) (Math.random() * 465);
        y = (int) (Math.random() * 440);

    }

    public static boolean eat() {
        if (Math.abs(x - MoveObject.xState[0]) < 15 && Math.abs(y - MoveObject.yState[0]) < 15) {
            SnackPanel.eatApple += 1;
            return true;
        }
        return false;

    }

}
