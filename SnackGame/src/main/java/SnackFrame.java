

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class SnackFrame extends JFrame implements Runnable, KeyListener {

    SnackPanel snackpanel = new SnackPanel();
    static int gameStart = 0;

    public SnackFrame() {
        this.setTitle("貪吃蛇");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(snackpanel);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.addKeyListener(this);
        
        //gameStart = 1;
        SnackPanel.start.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                          SnackFrame.gameStart=1;
                          SnackPanel.start.setVisible(false);
                    }
                });
        SnackPanel.restart.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                          SnackPanel.restart.setVisible(false);
                           SnackPanel.ate.setVisible(false);
                            SnackPanel.dead.setVisible(false);
                            MoveObject.clear();
                            gameStart=1;
                    }
                });
        Food.location();

    }

    @Override
    public void run() {
        while (true) {
            System.out.println("");
            if (gameStart == 1) {
                //System.out.println("hi");
                if (MoveObject.checkDead() == true) {
                    SnackPanel.dead.setVisible(true);
                    SnackPanel.ate.setVisible(true);
                    SnackPanel.ate.setText("吃到"+Integer.toString(SnackPanel.eatApple)+"顆蘋果");
                    gameStart = 0;
                    SnackPanel.restart.setVisible(true);
                }
                if (Food.eat() == true) {
                    Food.location();
                    MoveObject.nowLength++;
                }
                try {
                    Thread.sleep(100);
                    MoveObject.move();
                    repaint();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SnackPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //System.out.println("x:y:" + x + "  " + y);

        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            MoveObject.moveType = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            MoveObject.moveType = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            MoveObject.moveType = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            MoveObject.moveType = 3;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
}
