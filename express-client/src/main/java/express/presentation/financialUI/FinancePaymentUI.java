package express.presentation.financialUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import express.presentation.mainUI.MainUIService;

public class FinancePaymentUI extends JPanel{

	private MainUIService m;
	private JButton ok,exit;
	private JRadioButton rent,freight,wage,award;
	private ButtonGroup entry;
	private JTextField datetf,moneytf,persontf,accounttf,rentyeartf,trackingnumtf,wagemonthtf;
	private String date,person,account,rentyear,trackingnum,wagemonth;
	private double money;
	
	public FinancePaymentUI(MainUIService main){
		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		int leftside1 = 200;
		int leftside2 = 300;
		int textwidth = 160;
		int textheight = 30;
		Font font = new Font("楷体",Font.PLAIN,18);
		Font f = new Font("仿宋",Font.PLAIN,16);
		
		JLabel datel = new JLabel("付款日期");
		datel.setFont(font);
		datel.setBounds(leftside1, 40, 100, 40);
		this.add(datel);
		
		datetf = new JTextField();
		datetf.setBounds(leftside2, 40, textwidth, textheight);
		datetf.setFont(f);
		this.add(datetf);
		
		JLabel moneyl = new JLabel("付款金额");
		moneyl.setFont(font);
		moneyl.setBounds(leftside1, 90, 100, 40);
		this.add(moneyl);
		
		moneytf = new JTextField();
		moneytf.setBounds(leftside2, 90, textwidth, textheight);
		moneytf.setFont(f);
		this.add(moneytf);
		
		JLabel personl = new JLabel("付款人");
		personl.setFont(font);
		personl.setBounds(leftside1, 140, 100, 40);
		this.add(personl);
		
		persontf = new JTextField();
		persontf.setBounds(leftside2, 140, textwidth, textheight);
		persontf.setFont(f);
		this.add(persontf);
		
		JLabel accountl = new JLabel("付款账号");
		accountl.setFont(font);
		accountl.setBounds(leftside1, 190, 100, 40);
		this.add(accountl);
		
		accounttf = new JTextField();
		accounttf.setBounds(leftside2, 190, textwidth, textheight);
		accounttf.setFont(f);
		this.add(accounttf);
		
		JLabel entryl = new JLabel("条目");
		entryl.setFont(font);
		entryl.setBounds(leftside1, 240, 100, 40);
		this.add(entryl);

		entry = new ButtonGroup();
		rent = new JRadioButton("租金");
		rent.setBounds(leftside2, 240, 100, 30);
		rent.setFont(font);
		freight = new JRadioButton("运费");
		freight.setBounds(leftside2, 280, 100, 30);
		freight.setFont(font);
		wage = new JRadioButton("人员工资");
		wage.setBounds(leftside2, 320, 100, 30);
		wage.setFont(font);
		award = new JRadioButton("奖励");
		award.setBounds(leftside2, 360, 100, 30);
		award.setFont(font);
		
		entry.add(rent);
		entry.add(freight);
		entry.add(wage);
		entry.add(award);
		this.add(rent);
		this.add(freight);
		this.add(wage);
		this.add(award);
		
		JLabel remark = new JLabel("备注");
		remark.setFont( new Font("楷体",Font.BOLD,18));
		remark.setBounds(leftside1, 405, 100, 40);
		this.add(remark);
				
		JLabel rentyearl = new JLabel("租金年份");
		rentyearl.setFont(font);
		rentyearl.setBounds(leftside1, 450, 100, 40);
		this.add(rentyearl);
		
		rentyeartf = new JTextField();
		rentyeartf.setBounds(leftside2, 450, textwidth, textheight);
		rentyeartf.setFont(f);
		this.add(rentyeartf);
	
		JLabel trackingnuml = new JLabel("运单号");
		trackingnuml.setFont(font);
		trackingnuml.setBounds(leftside1, 500, 100, 40);
		this.add(trackingnuml);
		
		trackingnumtf = new JTextField();
		trackingnumtf.setBounds(leftside2, 500, textwidth, textheight);
		trackingnumtf.setFont(f);
		this.add(trackingnumtf);
		
		JLabel wagemonthl = new JLabel("运单号");
		wagemonthl.setFont(font);
		wagemonthl.setBounds(leftside1, 550, 100, 40);
		this.add(wagemonthl);
		
		wagemonthtf = new JTextField();
		wagemonthtf.setBounds(leftside2, 550, textwidth, textheight);
		wagemonthtf.setFont(f);
		this.add(wagemonthtf);
		
		Listener lis = new Listener();
		
		ok = new JButton("确认");
		ok.setBounds(220, 600, 110, 30);
		this.add(ok);
		
		exit = new JButton("取消");
		exit.setBounds(420, 600, 110, 30);
		this.add(exit);
		
		ok.addMouseListener(lis);
		exit.addMouseListener(lis);
	}
	
	private class Listener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==exit){
				datetf.setText("");
				moneytf.setText("");
				persontf.setText("");
				accounttf.setText("");
				rentyeartf.setText("");
				trackingnumtf.setText("");
				wagemonthtf.setText("");
				entry.clearSelection();
			}else if(e.getSource()==ok){	
				
			}
			repaint();
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}	
}
