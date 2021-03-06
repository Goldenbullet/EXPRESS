package express.presentation.customUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.NonWritableChannelException;
import java.security.SecureRandom;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import express.rmi.RMIClient;

public class SearchUI extends JPanel{
	final JFrame searchframe =new JFrame();
	JPanel pane;
	final JLabel errortip=new JLabel("这里显示输入错误信息");
	ResultUI result;
	JTextField orderid;
	public void init(){
		pane=new SearchUI();
		Font f=new Font("苹方",Font.PLAIN, 35);
		JButton exitbutton= new JButton(new ImageIcon("picture/x.png"));
		
		JButton confirm=new JButton(new ImageIcon("picture/search1.png"));
		orderid= new JTextField("请输入订单条形码号");
		orderid.addKeyListener(new Keylistener());
		searchframe.getContentPane().add(pane);
		searchframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//540*38  100*38
		pane.setLayout(null);
		pane.setBackground(Color.WHITE);
		searchframe.setSize(820, 550);
		
		final JPanel buttonPanel = new JPanel();  
		buttonPanel.setBackground(null);                      // 把背景设置为会  
		buttonPanel.setOpaque(false); 
		buttonPanel.setLayout(null);
		buttonPanel.setSize(820,550);
		pane.add(buttonPanel);
		
		
		orderid.setSize(583,48);
		orderid.setLocation(130,249);
		pane.add(orderid);
		
		confirm.setSize(36,36);
		confirm.setLocation(670, 255);
		confirm.setBorderPainted(false);
		buttonPanel.add(confirm);
		
		
		searchframe.setLocationRelativeTo(null);
		searchframe.setUndecorated(true);
		searchframe.setVisible(true);
		
		exitbutton.setSize(30,30);
		exitbutton.setBorderPainted(false);
		exitbutton.setLocation(790,0);
		pane.add(exitbutton);
		
		
		
		errortip.setSize(300,100);
		errortip.setForeground(Color.white);
		errortip.setLocation(360, 270);
		pane.add(errortip);
		
		
		exitbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				yesClicked();
			}
		});
		
	}
	
	public void yesClicked(){
		if(orderid.getText().equals("")){
			errortip.setText("请输入订单条形码号");

		}
		else{
			result=new ResultUI();
			if(result.checkOrder(orderid.getText())){
				errortip.setText("");
				pane.setVisible(false);
				searchframe.setContentPane(result.getResult());
			}
			else{
				errortip.setText("订单不存在");
			}
		}
	}
	
	
	
	public class Keylistener extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				yesClicked();
			}
		}
	}
	
	
	
	public static void main(String[] args){
		try{
			RMIClient.init();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		SearchUI ui=new SearchUI();
		ui.init();
	}
	
	
	
	public void paintComponent(Graphics g){
		Image image=new ImageIcon("picture/bkbkbk1.png").getImage();
		g.drawImage(image,0,0,this);
}
	
	
}
