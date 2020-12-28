import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Registration implements ActionListener{
    JTextField jtfName = new JTextField(14);
    JTextField jtfAuthor = new JTextField(14);
    JComboBox<String> jcbday = new JComboBox<String>(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
    JComboBox<String> jcbmonth = new JComboBox<String>(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
    JComboBox<String> jcbyear = new JComboBox<String>(new String[]{"2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020", "2021", "2022"});
    JTextField jtfPublisher = new JTextField(14);
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton publicButton = new JRadioButton("public", true);
    JRadioButton privateButton = new JRadioButton("private", false);
    JButton jbFill = new JButton("Fill");
    JButton jbClear = new JButton("Clear");
    JLabel jlabResult = new JLabel("Fill the form");
    String fileName = "file.txt";
    public Registration(){
        JLabel jlabName, jlabAuthor, jlabDay, jlabPublisher;
        jlabName = new JLabel("Set title :");
        jlabAuthor = new JLabel("Set authors :");
        jlabDay = new JLabel("Set publication date :");
        jlabPublisher = new JLabel("Set publisher :");
        JFrame jfr = new JFrame("Registration form :");
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setLayout(null);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        jfr.setSize(350, 450);
        jlabName.setBounds(50, 25, 100,20);
        jtfName.setBounds(25, 50, 200, 20);
        jlabAuthor.setBounds(40, 75, 100, 20);
        jtfAuthor.setBounds(25, 100, 200, 20);
        jlabDay.setBounds(50, 125, 250,20);
        jcbday.setBounds(25, 150, 75, 20);
        jcbmonth.setBounds(120, 150, 85, 20);
        jcbyear.setBounds(220, 150, 75, 20);
        jlabPublisher.setBounds(50, 175, 100,20);
        jtfPublisher.setBounds(25, 200, 200,20);
        jbFill.setBounds(25, 300, 100, 60);
        jbClear.setBounds(175, 300, 100,60);
        jlabResult.setBounds(130, 370, 200, 20);
        jbFill.addActionListener(this);
        jbClear.addActionListener(this);
        buttonGroup.add(publicButton);
        buttonGroup.add(privateButton);
        panel.add(publicButton);
        panel.add(privateButton);
        panel.setVisible(true);
        panel.setBounds(25, 230 ,300, 40);
        jfr.add(jlabName);
        jfr.add(jtfName);
        jfr.add(jlabAuthor);
        jfr.add(jtfAuthor);
        jfr.add(jlabDay);
        jfr.add(jcbday);
        jfr.add(jcbmonth);
        jfr.add(jcbyear);
        jfr.add(jlabPublisher);
        jfr.add(jtfPublisher);
        jfr.add(panel);
        jfr.add(jbFill);
        jfr.add(jbClear);
        jfr.add(jlabResult);
        jfr.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getActionCommand().equals("Clear")) {
                jtfName.setText("");
                jtfAuthor.setText("");
                jtfPublisher.setText("");
                buttonGroup.setSelected(publicButton.getModel(), true);
                jcbday.setSelectedIndex(0);
                jcbmonth.setSelectedIndex(0);
                jcbyear.setSelectedIndex(0);
                jlabResult.setText("Fill the form");
            }
            else{
                if(jtfName.getText().equals("")||jtfAuthor.getText().equals("")||jtfPublisher.getText().equals(""))
                    {jlabResult.setText("Pls, complete all the forms"); return;}
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
                    writer.newLine();
                    writer.write("Title : "+ jtfName.getText());
                    writer.newLine();
                    writer.write("Authors : "+ jtfAuthor.getText());
                    writer.newLine();
                    writer.write("Publication date : "+jcbday.getSelectedItem()+" "+jcbmonth.getSelectedItem()+" "+jcbyear.getSelectedItem());
                    writer.newLine();
                    writer.write("Publisher :"+ jtfPublisher.getText());
                    writer.newLine();
                    writer.write((privateButton.isSelected())?"Inaccessible to the public ":"Available to the public");
                    writer.newLine();
                    jlabResult.setText("Info has been recorded to "+fileName);
                }catch (IOException ex) {System.out.println("ex with recording to file"+ex);}
            }}catch(Exception ex) {System.out.println(ex);}
    }

}
