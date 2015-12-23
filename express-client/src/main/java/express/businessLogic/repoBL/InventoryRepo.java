package express.businessLogic.repoBL;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import express.businessLogic.syslogBL.SysLog;
import express.dataService.repoDataService.RepoDataService;
import express.rmi.RMIClient;
import express.vo.InDocVO;

public class InventoryRepo {
	
	
	
	public InventoryRepo(){
		
	}
	
	public ArrayList<InDocVO> inventoryRepo() {
		
		return null;
	}
	
	public boolean exportExcel(ArrayList<InDocVO> repoCache) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("学生表一");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		
		HSSFCell cell;
		String[] title={"快递编号","入库日期","目的地","区号","排号","架号","位号"};
		for(int i=0;i<title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		

		
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("E:/students.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void endRepoInventory() {
		SysLog log=new SysLog();
		log.addSysLog("库存盘点");
	}

}
