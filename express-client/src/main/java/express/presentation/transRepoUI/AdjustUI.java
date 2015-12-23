package express.presentation.transRepoUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import express.presentation.mainUI.MainUIService;

public class AdjustUI extends JPanel{

	private JButton button_adjust;
	
	public AdjustUI(){
		
		setLayout(null);
	    this.setBounds(0, 0, 850, 700);
	    this.setBackground(Color.WHITE);
	    
	    button_adjust=new JButton("点击库存调整之后");
        button_adjust.setBounds(100, 100, 150, 50);
        
        this.add( button_adjust);
	}
}
