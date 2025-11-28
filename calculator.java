import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.*;
import javax.swing.*;

public class calculator extends JFrame implements ActionListener {
    // create variables for calculation
    boolean number1 = true;
    double ergebnis;
    double zahl1;
    double zahl2;
    String currentInput = "";
    String operator = "";
    JLabel calculationlabel = new JLabel();
    JLabel rescalc = new JLabel();
    Font font = new Font("Arial", Font.PLAIN, 32);
    Font buttonfont = new Font("Arial", Font.PLAIN, 28);

    public calculator() {
        // settings for windows
        this.setTitle("Calculator");
        this.setSize(800, 400);
        this.setLocation(250, 140);

        // panel for full screen
        JPanel screen = new JPanel();
        screen.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        // panel for calculation, location: top, borderlayout
        JPanel result = new JPanel();
        result.setLayout(new GridLayout(1, 2));
        // panel for buttons with 5 columns/row
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(0, 5));

        // label to show calculation
        calculationlabel.setPreferredSize(new Dimension(160, 40));
        calculationlabel.setOpaque(true);
        calculationlabel.setBackground(Color.GRAY);
        calculationlabel.setHorizontalAlignment(JLabel.CENTER);
        calculationlabel.setFont(font);

        // label to show result
        rescalc.setPreferredSize(new Dimension(160, 40));
        rescalc.setOpaque(true);
        rescalc.setBackground(Color.GREEN);
        rescalc.setHorizontalAlignment(JLabel.CENTER);
        rescalc.setFont(font);

        // create buttons
        JButton plus = new JButton("+");
        plus.setFont(buttonfont);
        JButton minus = new JButton("-");
        minus.setFont(buttonfont);
        JButton mult = new JButton("*");
        mult.setFont(buttonfont);
        JButton div = new JButton("/");
        div.setFont(buttonfont);
        JButton zero = new JButton("0");
        zero.setFont(buttonfont);
        JButton one = new JButton("1");
        one.setFont(buttonfont);
        JButton two = new JButton("2");
        two.setFont(buttonfont);
        JButton three = new JButton("3");
        three.setFont(buttonfont);
        JButton four = new JButton("4");
        four.setFont(buttonfont);
        JButton five = new JButton("5");
        five.setFont(buttonfont);
        JButton six = new JButton("6");
        six.setFont(buttonfont);
        JButton seven = new JButton("7");
        seven.setFont(buttonfont);
        JButton eight = new JButton("8");
        eight.setFont(buttonfont);
        JButton nine = new JButton("9");
        nine.setFont(buttonfont);
        JButton calc = new JButton("=");
        calc.setFont(new Font("Arial", Font.BOLD, 28));
        JButton dot = new JButton(".");
        dot.setFont(buttonfont);
        JButton reset = new JButton("C");
        reset.setFont(buttonfont);
        JButton del = new JButton("DEL");
        del.setFont(buttonfont);

        // add ActionListener to buttons
        plus.addActionListener(this);
        minus.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        calc.addActionListener(this);
        dot.addActionListener(this);
        reset.addActionListener(this);
        del.addActionListener(this);

        // add buttons to buttonpanel
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);
        buttons.add(del);
        buttons.add(reset);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(mult);
        buttons.add(div);
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(plus);
        buttons.add(minus);
        buttons.add(zero);
        buttons.add(dot);
        buttons.add(calc);

        // add calculationlabel and rescalclabel to screenpanel
        result.add(calculationlabel);
        result.add(rescalc);

        // add buttons and screen to full panel
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        screen.add(result, c);
        c.gridy = 1;
        c.weighty = 2;
        screen.add(buttons, c);
        this.add(screen);
    }

    public static void main(String[] args) {
        calculator calc = new calculator();
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

    ActionListener listener = new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent ae) {
            JButton clicked = (JButton) ae.getSource();
            String value = clicked.getText();
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        String value = clicked.getText();

        if (value.matches("[0-9]")) {
            currentInput += value;
            if (number1 == true) {
                calculationlabel.setText(String.valueOf(currentInput));
            } else {
                calculationlabel.setText(zahl1 + " " + operator + " " + currentInput);
            }
            return;
        }

        if (value.matches("[+\\-*/]")) {
            number1 = false;
            zahl1 = Double.parseDouble(currentInput);
            operator = value;
            currentInput = "";
            calculationlabel.setText(zahl1 + " " + operator + " " + currentInput);
            return;
        }

        if (value.equals("=")) {
            zahl2 = Double.parseDouble(currentInput);
            double ergebnis = 0;

            switch (operator) {
                case "+":
                    ergebnis = zahl1 + zahl2;
                    break;
                case "-":
                    ergebnis = zahl1 - zahl2;
                    break;
                case "*":
                    ergebnis = zahl1 * zahl2;
                    break;
                case "/":
                    ergebnis = zahl1 / zahl2;
                    break;
            }
            /*
             * if (ergebnis % 1 == 0) {
             * zahl1 =
             * }
             */

            calculationlabel.setText(String.valueOf(zahl1 + " " + operator + " " + zahl2));
            rescalc.setText(String.valueOf(ergebnis));
            return;
        }

        if (value.equals("C")) {
            currentInput = "";
            operator = "";
            zahl1 = 0;
            zahl2 = 0;
            number1 = true;
            calculationlabel.setText("");
            rescalc.setText("");
            return;
        }

        if (value.equals("DEL")) {
            if (!currentInput.isEmpty()) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
            }

            if (number1 == true) {
                calculationlabel.setText(currentInput);
                rescalc.setText("");
            } else {
                calculationlabel.setText(zahl1 + "" + operator + "" + currentInput);
                rescalc.setText("");
            }
            return;
        }

        if (value.equals(".")) {
            if (!currentInput.contains(".")) {
                currentInput += ".";
                if (number1 == true) {
                    calculationlabel.setText(currentInput);
                } else {
                    calculationlabel.setText(zahl1 + "" + operator + "" + currentInput);
                }
            }
            return;
        }
    }

}