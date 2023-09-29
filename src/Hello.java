import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hello extends JFrame{
    private JPanel tab;
    private JTextField noSeQueEstoyTextField;
    private JButton firstbtn;

    public Hello(){
       firstbtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(firstbtn, "Fuck");
           }
       });
    }

    public static void main(String[] args) {
        Hello hi = new Hello();
        hi.setContentPane(hi.tab);
        hi.setTitle("Rummy mierda");
        hi.setSize(300, 300);
        hi.setVisible(true);
        hi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
