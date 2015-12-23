package express.presentation.financialUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import express.businessLogic.infoManageBL.BankAccount;
import express.businesslogicService.financialBLService.BankAccountBLService;
import express.presentation.mainUI.MainUIService;
import express.vo.BankAccountVO;

public class FinanceManageBankAccountUI extends JPanel {

	private MainUIService m;
	private JButton ok, cancel, find, exit;
	private JTextField name, income, outcome, profit, search;
	private JButton[] buttonList;
	private JTextField[] textList;
	private String account, inmoney, outmoney;
	private JPanel bankAccount;
	private JScrollPane scrollPane;

	public FinanceManageBankAccountUI(MainUIService main) {

		setLayout(null);
		m = main;
		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);

		Font font = new Font("楷体", Font.PLAIN, 20);
		Font f = new Font("仿宋", Font.PLAIN, 18);
		Font font2 = new Font("楷体", Font.BOLD, 20);

		JLabel title = new JLabel("新建银行账户");
		title.setBounds(120, 60, 140, 30);
		title.setFont(font2);
		this.add(title);

		JLabel timeLabel = new JLabel("账户名");
		timeLabel.setBounds(5, 120, 60, 30);
		timeLabel.setFont(font);
		this.add(timeLabel);

		JLabel incomeLabel = new JLabel("收入");
		incomeLabel.setBounds(20, 210, 50, 30);
		incomeLabel.setFont(font);
		this.add(incomeLabel);

		JLabel outcomeLabel = new JLabel("支出");
		outcomeLabel.setBounds(20, 300, 50, 30);
		outcomeLabel.setFont(font);
		this.add(outcomeLabel);

		JLabel profitLabel = new JLabel("余额");
		profitLabel.setBounds(20, 390, 50, 30);
		profitLabel.setFont(font);
		this.add(profitLabel);

		name = new JTextField();
		name.setBounds(80, 120, 200, 30);
		name.setFont(f);
		name.setText("");
		name.setBackground(Color.WHITE);
		name.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		this.add(name);

		income = new JTextField();
		income.setBounds(80, 210, 200, 30);
		income.setText("");
		income.setBackground(Color.WHITE);
		income.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		income.setFont(f);
		this.add(income);

		outcome = new JTextField();
		outcome.setBounds(80, 300, 200, 30);
		outcome.setText("");
		outcome.setBackground(Color.WHITE);
		outcome.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		outcome.setFont(f);
		this.add(outcome);

		profit = new JTextField();
		profit.setBounds(80, 390, 200, 30);
		profit.setEditable(false);
		// profit.setBackground(Color.WHITE);
		profit.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		profit.setFont(f);
		this.add(profit);

		JLabel line = new JLabel();
		line.setBounds(310, 67, 2, 460);
		line.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.add(line);

		Listener listen = new Listener();
		ok = new JButton("新建账户");
		ok.setBounds(20, 487, 110, 40);
		ok.setVisible(true);
		ok.setBackground(Color.WHITE);
		ok.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		ok.setFont(new Font("隶书", Font.PLAIN, 18));
		ok.addMouseListener(listen);
		this.add(ok);

		cancel = new JButton("取消");
		cancel.setBounds(170, 487, 110, 40);
		cancel.setVisible(true);
		cancel.setBackground(Color.WHITE);
		cancel.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		cancel.setFont(new Font("隶书", Font.PLAIN, 18));
		cancel.addMouseListener(listen);
		this.add(cancel);

		exit = new JButton("返回菜单");
		exit.setBounds(20, 600, 260, 40);
		exit.setVisible(true);
		exit.setBackground(Color.WHITE);
		exit.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		exit.setFont(new Font("隶书", Font.PLAIN, 18));
		exit.addMouseListener(listen);
		this.add(exit);

		search = new JTextField();
		search.setBounds(350, 80, 350, 30);
		search.setBackground(Color.WHITE);
		search.setText("");
		search.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		search.setFont(f);
		this.add(search);

		find = new JButton("查找");
		find.setBounds(701, 80, 80, 29);
		find.setVisible(true);
		find.setBackground(Color.WHITE);
		find.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		find.setFont(new Font("楷体", Font.PLAIN, 18));
		find.addMouseListener(listen);
		this.add(find);
		// find.addMouseListener(listen);

		bankAccount = new JPanel();
		bankAccount.setBounds(350, 140, 440, 500);
		bankAccount.setLayout(null);
		scrollPane = new JScrollPane(bankAccount);
		scrollPane.setFont(font);
		scrollPane.setBackground(Color.white);
		scrollPane.setBorder(BorderFactory.createMatteBorder(3, 0, 3, 0,
				Color.gray));
		scrollPane.setBounds(350, 140, 440, 500);
		this.add(scrollPane);
	}

	private void findBankAccount(String s) {
		BankAccountBLService bank = new BankAccount();
		ArrayList<BankAccountVO> list = bank.findBankAccount(s);
		
		bankAccount.removeAll();
		if(list != null){
			int len = list.size();
			buttonList = new JButton[len];
			textList = new JTextField[len];
			for(int i = 0;i < len;i++){
				
				BankAccountVO vo = list.get(i);
				addLine(vo,i);
			}
		}
	}
	
	private void addLine(BankAccountVO vo,int i){
		
		Font f = new Font("楷体", Font.PLAIN, 18);
		int len = 75 * i;
		
		JLabel nLabel = new JLabel("账户名");
		nLabel.setBounds(5, 5 + len, 60, 30);
		nLabel.setFont(f);
		bankAccount.add(nLabel);
		
		JLabel mLabel = new JLabel();
		mLabel.setBounds(5, 35 + len, 425, 40);
		String title ="余额 ：" + vo.getBalance();
		mLabel.setText(title);
		mLabel.setFont(f);
		mLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
		bankAccount.add(mLabel);
		
		JTextField n = new JTextField();
		n.setBounds(70, 5 + len, 280, 30);
		n.setFont(f);
		n.setText(vo.getName());
		n.setBackground(Color.WHITE);
		n.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		bankAccount.add(n);
		textList[i] = n;
		
		Action action = new Action();
		
		JButton change = new JButton("修改");
		change.setBounds(350, 5 + len, 80, 30);
		change.setBackground(Color.WHITE);
		change.setActionCommand(i + "#" + vo.getName());
		change.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		change.setFont(f);
		change.addActionListener(action);
		bankAccount.add(change);
		buttonList[i] = change;
	}

	private void addBankAccount() {
		BankAccountBLService bank = new BankAccount();
		account = name.getText();
		inmoney = income.getText();
		outmoney = outcome.getText();
		double in = Double.parseDouble(inmoney);
		double out = Double.parseDouble(outmoney);
		String pro = String.valueOf(in - out);
		profit.setText(pro);
		
		BankAccountVO vo = new BankAccountVO(account,in,out,in - out);
		boolean succ = bank.addBankAccount(vo);
		bank.endManage();
		
		if (succ) {
			JOptionPane.showConfirmDialog(null, "新 建 成 功！", null,
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			JOptionPane.showConfirmDialog(null, "新 建 失 败！", null,
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null);
		}
	}

	private boolean check() {

		if (checkNotFill()) {
			
			JOptionPane.showConfirmDialog(null, "信 息 未 填！", null,
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null);
			
			return false;
		} else {
			boolean isValid = true,isDup = false;
			
			BankAccountBLService bank = new BankAccount();
			
			if(!bank.checkMoney(inmoney)){
				income.setBackground(Color.RED);
				isValid = false;
			}
			if(!bank.checkMoney(outmoney)){
				outcome.setBackground(Color.RED);
				isValid = false;
			}
			if(bank.checkDuplication(account)){
				name.setBackground(Color.RED);

				JOptionPane.showConfirmDialog(null, "账 户 重 名！", null,
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null);
				isDup = true;
			}
			if(!isValid){
				JOptionPane.showConfirmDialog(null, "金 额 输 入 错 误！", null,
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null);
			}
			return isValid && (!isDup);
		}
	}

	private boolean checkNotFill() {
		boolean fill = false;
		if (account.equals("")) {
			name.setBackground(Color.YELLOW);
			fill = true;
		}
		if (inmoney.equals("")) {
			income.setBackground(Color.YELLOW);
			fill = true;
		}
		if (outmoney.equals("")) {
			outcome.setBackground(Color.YELLOW);
			fill = true;
		}
		return fill;
	}

	private class Listener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == cancel) {
				name.setText("");
				income.setText("");
				outcome.setText("");
				profit.setText("");
			} else if (e.getSource() == find) {
				String s = search.getText();
				findBankAccount(s);
			} else if (e.getSource() == ok) {
				account = name.getText();
				inmoney = income.getText();
				outmoney = outcome.getText();
				
				if(check()){
					addBankAccount();
					name.setBackground(Color.WHITE);
					income.setBackground(Color.WHITE);
					outcome.setBackground(Color.WHITE);
				}
			} else if (e.getSource() == exit) {
				
			}
			repaint();
		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
			
		}
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();
			String[] source = s.split("#");
			int i = Integer.parseInt(source[0]);
			JTextField text = textList[i];
			String n = "";
			try{
				
				n = text.getText();
				
			}catch(Exception ex){
				text.setBackground(Color.YELLOW);
				
				JOptionPane.showConfirmDialog(null, "账 户 名 未 填！", null,
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null);
			}
			BankAccountBLService bank = new BankAccount();
			if(bank.checkDuplication(n)){
				text.setBackground(Color.RED);
				
				JOptionPane.showConfirmDialog(null, "账 户 重 名！", null,
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null);
			} else {
				boolean succ = bank.changeBankAccount(source[1], n);
				bank.endManage();
				text.setBackground(Color.WHITE);
				
				if (succ) {
					JOptionPane.showConfirmDialog(null, "修 改 成 功！", null,
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					JOptionPane.showConfirmDialog(null, "修 改 失 败！", null,
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null);
				}
			}
		}
	}
}
