package express.businessLogic.documentBL;

import java.util.ArrayList;

import express.businessLogic.syslogBL.SysLog;
import express.businesslogicService.managerBLService.SysLogBLService;
import express.businesslogicService.transcenterRepoBLService.InDocblService;
import express.dataService.documentDataService.InDocDataService;
import express.po.InDocPO;
import express.po.OutDocPO;
import express.rmi.RMIClient;
import express.vo.InDocVO;
import express.vo.OutDocVO;
import javafx.geometry.VPos;

public class InDoc implements InDocblService{
	InDocDataService  rmiObj;
	public InDoc() {
		rmiObj=RMIClient.getInDocObject();
	}
	
	
	
	@Override
	public boolean addInDoc(InDocVO vo) {
		if(!isOrderIDavailable(vo.getdeliveryNumber())){
			return false;
		}
		InDocPO po=new InDocPO(vo.getdeliveryNumber(), vo.getdate(), vo.getarrival(),vo.getRepoPosition());
		try{
			rmiObj.createInDoc(po);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public InDocVO getInDoc(String orderID) {
		if(isOrderIDavailable(orderID)){
			try{
				InDocPO po=rmiObj.getInDocPO(orderID);
				InDocVO vo=new InDocVO(po.getdeliveryNumber(), po.getdate(), po.getarrival(), po.getRepoPosition());
				return vo;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public boolean isOrderIDavailable(String id) {
		CheckOrder checker=new CheckOrder();
		return checker.isOrderIDAvailable(id);
	}

	@Override
	public void endInDoc() {
		SysLogBLService syslog=new SysLog();
		syslog.addSysLog("生成入库单");
		try{
			rmiObj.writeAllInDoc();
		}catch(Exception e){
			e.printStackTrace();
		}	

		
	}
	
	public boolean changeInDoc(InDocVO vo){
		InDocPO po=new InDocPO(vo.getdeliveryNumber(), vo.getdate(), vo.getarrival(),vo.getRepoPosition());
		try{
			rmiObj.changeInDoc(po);
			return true;	
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	
	public ArrayList<InDocVO> getUnexamedInDoc(){
		try{
			ArrayList<InDocPO> list=rmiObj.getInDocPOlist();
			ArrayList<InDocVO> unexam=new ArrayList<InDocVO>();
			for(InDocPO po:list){
				if(po.getState()==false){
				InDocVO vo=new InDocVO(po.getdeliveryNumber(), po.getdate(), po.getarrival(), po.getRepoPosition());
				unexam.add(vo);
				}
			}
			return unexam;	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;	
	}

}
