import javax.swing.*;
import javax.swing.event.MenuDragMouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JFrame jFrame = getFrame();

    public static void main(String[] agrs){
        String File = "123456789";



        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("file");
        JMenu edit = new JMenu("edit");
        jMenuBar.add(file);
        jMenuBar.add(edit);

        file.add(new JMenuItem("Open"));
        file.add(new JMenuItem("Save"));
        file.addSeparator();
        file.add(new JMenuItem("Exit")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        edit.add(new JMenuItem("Encryption")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller a = new Controller();
                a.codeString1(File);

            }
        });
        edit.add(new JMenuItem("decryption")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller a = new Controller();
                System.out.println("123456789");
                a.codeString2(a.codeString1(File));
                //a.codeString2(a.codeString1(File));

            }
        });





        jFrame.setJMenuBar(jMenuBar);
        jFrame.revalidate();

    }
    static JFrame getFrame()
    {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(450,150,500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }

}