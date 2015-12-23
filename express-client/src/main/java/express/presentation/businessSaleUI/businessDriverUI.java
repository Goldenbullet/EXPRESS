package express.presentation.businessSaleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import express.businessLogic.infoManageBL.Driver;
import express.businesslogicService.businessSaleBLService.DriverBusinessSaleblService;
import express.presentation.mainUI.MainUIService;
import express.presentation.mainUI.MyTableModel;

public class businessDriverUI extends JPanel{
	private DriverBusinessSaleblService dbs;
	
	private MyTableModel tableModel;
	private TableColumnModel tcm;
	private JTable table;
	
	private JButton delete,change,add;
	private JTextField idtf;
	private JComboBox gendercb;
	
    private String driverNumber;
	private String orgID;
	private String name;
	private String date;
	private String ID;
	private String cellPhone;
	private boolean sex;// men are true,women are false
	private int deadline;

	private String changeunder = "<HTML><U>修改</U></HTML>";
	private String confirmunder = "<HTML><U>确认</U></HTML>";
	private Object[][] data;
	private String[] header = {"选择" ,"司机编号", "营业厅编号","姓名",
			"出生日期","身份证号","联系方式","性别","行驶证期限","修改" };

	private String[] genders={"男","女"};

	public businessDriverUI(){
		Font font = new Font("楷体", Font.PLAIN, 18);
		Font f = new Font("仿宋", Font.PLAIN, 16);

		setLayout(null);

		this.setBounds(0, 0, 850, 700);
		this.setBackground(Color.WHITE);
		
		dbs=new Driver();
		JListener listener=new JListener();
		
		
		
		Class[] typeArray = { Boolean.class,Object.class,Object.class,Object.class,
				Object.class,Object.class,Object.class,JComboBox.class,Object.class,Object.class};
		Object[] driver1 = {true,"001", "A01", "未加入底层","2015-06-07","11","11","男" ,"5",changeunder};
		Object[] driver2 = { false,"002", "B01","未加入底层","2015-06-07","22" ,"22","女","6",changeunder };
		Object vehicle[][] = { driver1, driver2 };
		data = vehicle;
		
		tableModel=new MyTableModel(data, header, typeArray);
		table=new JTable(tableModel);
		table.setBounds(50, 60, 750, 600);
		table.setFont(f);
		table.setRowHeight(40);
		
		gendercb=new JComboBox(genders);
		tcm = table.getColumnModel();
		tcm.getColumn(7).setCellEditor(new DefaultCellEditor(gendercb));
		
		
		
		table.addMouseListener(listener);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 60, 750, 600);
		this.add(scrollPane);
		
		delete = new JButton("删除");
		delete.setBounds(50, 10, 100, 40);
		delete.setFont(font);
 		delete.addMouseListener(listener);
		this.add(delete);

		add = new JButton("添加");
		add.setBounds(190, 10, 100, 40);
	 	add.addMouseListener(listener);
		add.setFont(font);
		this.add(add);

		change = new JButton("查找");
		change.setBounds(320, 10, 100, 40);
		change.addMouseListener(listener);
		change.setFont(font);
		this.add(change);
		
		
		JLabel id = new JLabel("司机编号");
		id.setBounds(450, 10, 100, 40);
		id.setFont(font);
		this.add(id);

		idtf = new JTextField();
		idtf.setBounds(560, 10, 150, 40);
		idtf.setFont(f);
		this.add(idtf);
	}
	private class JListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			 if (e.getSource()==delete){
					for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
						if ((boolean) tableModel.getValueAt(i, 0)) {
							tableModel.removeRow(i);
							dbs.removeDriverInfo((String)table.getValueAt(i, 1));//逻辑层删除这条记录
							dbs.endManage();//删除之后，逻辑层会调用数据层的writeall，更新所有记录	
							
						}
					}
					JOptionPane.showMessageDialog(null, "删除成功", "提示",
							JOptionPane.INFORMATION_MESSAGE);
			 }
			 else if (e.getSource()==add){
				 businessDriverAddUI DriverAddpanel=new businessDriverAddUI(tableModel);
				 DriverAddpanel.setVisible(true);
			 }
			 else if (e.getSource()==change){
				 
			 }else if (e.getSource()==table){
				 
			 }
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
