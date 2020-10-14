import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Registration implements ActionListener{
    JTextField jtfName = new JTextField(14);
    JTextField jtfProducer = new JTextField(14);
    JComboBox<String> jcbday = new JComboBox<String>(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
    JComboBox<String> jcbmonth = new JComboBox<String>(new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"});
    JComboBox<String> jcbyear = new JComboBox<String>(new String[]{"2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020", "2021", "2022"});
    JTextField jtfShelfLife = new JTextField(14);
    JCheckBox jchbBanUnder18= new JCheckBox("Prohibit if under 18");
    JButton jbFill = new JButton("Fill");
    JButton jbClear = new JButton("Clear");
    JLabel jlabResult = new JLabel("Fill the form");
    String fileName = "file.txt";
    public Registration(){
        JLabel jlabName, jlabProducer, jlabDay, jlabShelfLife;
        jlabName = new JLabel("Set title :");
        jlabProducer = new JLabel("Set producer :");
        jlabDay = new JLabel("Set delivery day :");
        jlabShelfLife = new JLabel("Set shel life :");
        JFrame jfr = new JFrame("Registration form :");
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr.setLayout(null);
        jfr.setSize(350, 450);
        jlabName.setBounds(50, 25, 100,20);
        jtfName.setBounds(25, 50, 200, 20);
        jlabProducer.setBounds(40, 75, 100, 20);
        jtfProducer.setBounds(25, 100, 200, 20);
        jlabDay.setBounds(100, 125, 100,20);
        jcbday.setBounds(25, 150, 75, 20);
        jcbmonth.setBounds(120, 150, 85, 20);
        jcbyear.setBounds(220, 150, 75, 20);
        jlabShelfLife.setBounds(50, 175, 100,20);
        jtfShelfLife.setBounds(25, 200, 200,20);
        jchbBanUnder18.setBounds(100, 250, 200,20);
        jbFill.setBounds(25, 300, 100, 60);
        jbClear.setBounds(175, 300, 100,60);
        jlabResult.setBounds(130, 370, 200, 20);
        jbFill.addActionListener(this);
        jbClear.addActionListener(this);
        jfr.add(jlabName);
        jfr.add(jtfName);
        jfr.add(jlabProducer);
        jfr.add(jtfProducer);
        jfr.add(jlabDay);
        jfr.add(jcbday);
        jfr.add(jcbmonth);
        jfr.add(jcbyear);
        jfr.add(jlabShelfLife);
        jfr.add(jtfShelfLife);
        jfr.add(jchbBanUnder18);
        jfr.add(jbFill);
        jfr.add(jbClear);
        jfr.add(jlabResult);
        jfr.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getActionCommand().equals("Clear")) {
                jtfName.setText("");
                jtfProducer.setText("");
                jtfShelfLife.setText("");
                jchbBanUnder18.setSelected(false);
                jcbday.setSelectedIndex(0);
                jcbmonth.setSelectedIndex(0);
                jcbyear.setSelectedIndex(0);
                jlabResult.setText("Fill the form");
            }
            else{
                if(jtfName.getText().equals("")||jtfProducer.getText().equals("")||jtfShelfLife.getText().equals(""))
                    {jlabResult.setText("Pls, complete all the forms"); return;}
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
                    writer.newLine();
                    writer.write("Title : "+ jtfName.getText());
                    writer.newLine();
                    writer.write("Producer : "+ jtfProducer.getText());
                    writer.newLine();
                    writer.write("Supply day : "+jcbday.getSelectedItem()+" "+jcbmonth.getSelectedItem()+" "+jcbyear.getSelectedItem());
                    writer.newLine();
                    writer.write("Shelf life :"+ jtfShelfLife.getText());
                    writer.newLine();
                    writer.write((jchbBanUnder18.isSelected()==true)?"Prohibit for children":"Allowed for children");
                    writer.newLine();
                    jlabResult.setText("Info has been recorded to "+fileName);
                }catch (IOException ex) {System.out.println("ex with recording to file"+ex);}
            }}catch(Exception ex) {System.out.println(ex);}
    }

}
