
import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jason
 */
public class SnackPanel extends JPanel {

    static int x = 100;
    static int y = 0;
    static Label dead = new Label("你死了");
    static Button start = new Button("start");
    static Button restart = new Button("restart");
    static Label ate=new Label();
    static int eatApple=0;
    public SnackPanel() {

        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);
        dead.setForeground(Color.red);
        this.add(dead);
        ate.setBounds(200, 250, 100, 100);
        ate.setVisible(false);
        ate.setForeground(Color.red);
        this.add(ate);
        dead.setBounds(200, 150, 100, 100);
        dead.setVisible(false);
        this.setLayout(null);
       // start.setBounds(200, 150, 100, 50);
        
        start.setBounds(200, 150, 100, 50);
        start.setBackground(Color.WHITE);
        this.add(start);
        restart.setBounds(175, 350, 100, 50);
        restart.setBackground(Color.WHITE);
        this.add(restart);
        restart.setVisible(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("hi");
        g.setColor(Color.ORANGE);
        for (int i = 0; i < MoveObject.nowLength; i++) {
            g.fillOval(MoveObject.xState[i], MoveObject.yState[i], 20, 20);
        }
        g.setColor(Color.BLACK);
         g.fillOval(MoveObject.xState[0]+10, MoveObject.yState[0]+2, 3, 3);
        g.setColor(Color.red);
        g.fillOval(Food.x, Food.y, 20, 20);
        g.setColor(Color.BLACK);
        g.drawLine(Food.x+10,Food.y+5, Food.x+13, Food.y-5);

    }
    // @Override

}
