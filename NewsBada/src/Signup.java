

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Character.UnicodeBlock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Signup extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JTextField textField;
   //
   String url = "jdbc:mysql://localhost:3306/newschema";
   String user = "root";
   String password = "aodgml23125!";
   //
   String id;
   String ps;
   String sex;
   int age;
   //
   private JLabel lblSex;
   private JLabel label;
   private JTextField textField_2;
   private JLabel label_1;
   ButtonGroup buttonGroup = new ButtonGroup();
   JRadioButton rdbtnNewRadioButton;
   JRadioButton radioButton;
   JButton btnNewButton;
   private JPasswordField passwordField;
   Connection myConn = null;
   PreparedStatement myStmt = null;
   ResultSet myRs = null;


   public static boolean containsHangul(String str) {
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(ch);
         if (UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)
               || UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock)
               || UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock))
            return true;
      }
      return false;
   }

   /**
    * Create the frame.
    */
   public Signup() {

      setForeground(Color.WHITE);
      setBackground(Color.WHITE);
      setTitle("\uD68C\uC6D0\uAC00\uC785");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 596, 444);
      contentPane = new JPanel();
      contentPane.setBackground(Color.WHITE);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);

      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514(\uC601\uBB38) :");
      lblNewLabel.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      lblNewLabel.setBackground(Color.WHITE);

      JLabel lblPassword = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
      lblPassword.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      lblPassword.setBackground(Color.WHITE);

      textField = new JTextField();
      textField.setColumns(10);
      textField.addActionListener(this);

      lblSex = new JLabel("\uC131\uBCC4 :");
      lblSex.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      lblSex.setBackground(Color.WHITE);

      label = new JLabel("\uB098\uC774 :");
      label.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      label.setBackground(Color.WHITE);

      textField_2 = new JTextField();
      textField_2.setColumns(10);
      textField_2.addActionListener(this);

      label_1 = new JLabel("\uC138");
      label_1.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      label_1.setBackground(Color.WHITE);

      rdbtnNewRadioButton = new JRadioButton("\uB0A8");
      rdbtnNewRadioButton.addActionListener(this);
      buttonGroup.add(rdbtnNewRadioButton);
      rdbtnNewRadioButton.setFont(new Font("±¼¸²", Font.PLAIN, 18));
      rdbtnNewRadioButton.setBackground(Color.WHITE);

      radioButton = new JRadioButton("\uC5EC");
      radioButton.addActionListener(this);
      buttonGroup.add(radioButton);
      radioButton.setFont(new Font("±¼¸²", Font.PLAIN, 18));
      radioButton.setBackground(Color.WHITE);

      btnNewButton = new JButton("submit");
      btnNewButton.addActionListener(this);
      btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 18));

      passwordField = new JPasswordField();
      passwordField.addActionListener(this);
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane
            .setHorizontalGroup(
                  gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup().addGap(167).addComponent(btnNewButton)
                              .addContainerGap())
                        .addGroup(
                              Alignment.LEADING, gl_contentPane
                                    .createSequentialGroup().addGap(111).addGroup(gl_contentPane
                                          .createParallelGroup(
                                                Alignment.LEADING)
                                          .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 100,
                                                      GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
                                                      60, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100,
                                                      GroupLayout.PREFERRED_SIZE))
                                          .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane
                                                      .createParallelGroup(Alignment.LEADING, false)
                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                            .addComponent(lblSex,
                                                                  GroupLayout.PREFERRED_SIZE, 100,
                                                                  GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(
                                                                  ComponentPlacement.RELATED)
                                                            .addComponent(rdbtnNewRadioButton)
                                                            .addGap(52).addComponent(radioButton,
                                                                  GroupLayout.PREFERRED_SIZE, 47,
                                                                  GroupLayout.PREFERRED_SIZE))
                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                            .addGroup(gl_contentPane
                                                                  .createParallelGroup(
                                                                        Alignment.LEADING)
                                                                  .addComponent(lblNewLabel)
                                                                  .addComponent(lblPassword,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        149,
                                                                        GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(
                                                                  ComponentPlacement.UNRELATED)
                                                            .addGroup(gl_contentPane
                                                                  .createParallelGroup(
                                                                        Alignment.TRAILING,
                                                                        false)
                                                                  .addComponent(passwordField)
                                                                  .addComponent(textField,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        166, Short.MAX_VALUE))))
                                                .addGap(14)))
                                    .addContainerGap(96, Short.MAX_VALUE)));
      gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
            Alignment.TRAILING,
            gl_contentPane.createSequentialGroup().addContainerGap(74, Short.MAX_VALUE).addGroup(gl_contentPane
                  .createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
                  .addGroup(gl_contentPane.createSequentialGroup().addGap(6).addComponent(textField,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                  .addGap(39)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE))
                  .addGap(36)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdbtnNewRadioButton)
                        .addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                  .addGap(30)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                  .addGap(44).addComponent(btnNewButton).addContainerGap()));
      contentPane.setLayout(gl_contentPane);
   this.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      
      Object source = e.getSource();
      

      if (source == btnNewButton) {

         if (rdbtnNewRadioButton.isSelected()) {
            sex = rdbtnNewRadioButton.getText();
         }

         else if (radioButton.isSelected()) {
            sex = radioButton.getText();
         }
         id = textField.getText();
         ps = String.valueOf(passwordField.getPassword());
         age = Integer.parseInt(textField_2.getText());

         if (containsHangul(id) == true) {
            JOptionPane.showMessageDialog(Signup.this, "¾ÆÀÌµð´Â ÇÑ±ÛÀÌ ¾Æ´Ñ ¿µ¹®À¸·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
         }

         else {
            try {
               // 1. Get connection
               myConn = DriverManager.getConnection(url, user, password);
               // 2. Create a statement
               myStmt = myConn.prepareStatement("insert into user (ID, password, sex, age) values (?,?,?,?)");
               // 3. Set the parameters
               myStmt.setString(1, id);
               myStmt.setString(2, ps);
               myStmt.setString(3, sex);
               myStmt.setInt(4, age);
               
               // 4. Execute SQL query
               myStmt.executeUpdate();

               System.out.println("Insert Done");

            }

            catch (Exception exc) {
               exc.printStackTrace();
            }
         }
      }

   }
}