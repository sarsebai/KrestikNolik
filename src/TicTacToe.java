import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    int counter=0;

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean pp=true;
    JButton restart_button = new JButton("Рестарт");



    TicTacToe(){

        frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.orange);
        textfield.setForeground(new Color(0,0,0));
        textfield.setFont(new Font("SERIF",Font.ITALIC,40));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Крестики-Нолики");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,1000,180);


        button_panel.setLayout(new GridLayout(3,3));


        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("SERIF",Font.ITALIC,60));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.ORANGE);
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        restart_button.setBackground(Color.white);
        restart_button.addActionListener(e -> restart());
        title_panel.add(restart_button, BorderLayout.SOUTH);
        restart_button.setPreferredSize(new Dimension(500, 35));
        restart_button.setFocusPainted(false);


    }

    public void restart() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setBackground(Color.ORANGE);
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        counter = 0;
        pp = true;
        textfield.setText("Крестики-Нолики");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++) {
            if (e.getSource() == buttons[i]) {
                if (pp) {
                    counter++;
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        pp = false;
                        textfield.setText("O ходит");
                        proverka();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        counter++;
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        pp = true;
                        textfield.setText("X ходит");
                        proverka();
                    }
                }
            }
        }
    }


    public void proverka() {
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            xWins(0,1,2);counter=0;
        }
        if(
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);counter=0;
        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);counter=0;
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);counter=0;
        }
        if(
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);counter=0;
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);counter=0;
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);counter=0;
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);counter=0;
        }

        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);counter=0;
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);counter=0;
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);counter=0;
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);counter=0;
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);counter=0;
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);counter=0;
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(0,4,8);counter=0;
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(2,4,6);counter=0;
        }
        else if (counter==9){
            textfield.setText("Ничья");
        }

    }


    public void xWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X выиграл");
    }
    public void oWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O выиграл");
    }

}