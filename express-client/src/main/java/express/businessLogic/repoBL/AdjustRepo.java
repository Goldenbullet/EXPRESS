package express.businessLogic.repoBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.businessLogic.IDKeeper;
import express.businessLogic.syslogBL.SysLog;
import express.dataService.repoDataService.RepoDataService;
import express.po.Area;
import express.po.RepoInfoPO;
import express.po.RepoPosition;
import express.rmi.RMIClient;
import express.vo.RepoPositionVO;

public class AdjustRepo {

	RepoDataService repo;
	
	public AdjustRepo(){
		repo=RMIClient.getRepoInfoObject();
	}
	
	public boolean checkRepoBlockUsed(RepoPositionVO position){
		
		try {
			RepoInfoPO  r=repo.getRepo(IDKeeper.getOrgID());
			
			ArrayList<RepoPosition> list=r.getRepoPosition();
			if(list==null)
				return false;
			if(list.size()==0)
				return false;
			
			RepoPosition rp = new RepoPosition(position.getOrderID(),
					position.getblock(), position.getrow(),
					position.getshelf(), position.getposition(), true);
			
			for(RepoPosition p:list){
				if(rp.equals(p)){
					return true;
				}
			}
			return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setRepoBlock(RepoPositionVO position){
		try {
			RepoPosition r = new RepoPosition(position.getOrderID(),
					position.getblock(), position.getrow(),
					position.getshelf(), position.getposition(),
					position.getIsUsed());

			
			return repo.addBlock(IDKeeper.getOrgID(), r);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alarm(RepoPositionVO position){
		try {
			RepoInfoPO r=repo.getRepo(IDKeeper.getOrgID());
			if(repo==null)
				return false;
			
			int curr=0;
			int max=0;
			if(position.getblock().equals(Area.AIR)){
				curr=r.getAirSum();
				max=r.getAirSize();
			}
			if(position.getblock().equals(Area.TRAIN)){
				curr=r.getTrainSum();
				max=r.getTrainSize();
			}
			if(position.getblock().equals(Area.TRAIN)){
				curr=r.getTruckSum();
				max=r.getTruckSize();
			}
			
			int alarm=(int)Math.ceil(max*0.9);
			//仓库的每一个位都是整数，向上取整
			
			if(curr<alarm)
				return true;
			//未达警戒线
			else
				return false;
			//大于等于警戒线
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean adjustRepo(RepoPositionVO oldPosition,RepoPositionVO newPosition){
		RepoPosition oldP = new RepoPosition(oldPosition.getOrderID(),
				oldPosition.getblock(), oldPosition.getrow(),
				oldPosition.getshelf(), oldPosition.getposition(), true);
		
		RepoPosition newP = new RepoPosition(newPosition.getOrderID(),
				newPosition.getblock(), newPosition.getrow(),
				newPosition.getshelf(), newPosition.getposition(), true);
		
		try {
			repo.deleteBlock(IDKeeper.getOrgID(), oldP);
			return repo.addBlock(IDKeeper.getOrgID(), newP);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void endRepoManage(){
		SysLog log=new SysLog();
		log.addSysLog("仓库调整");
	}

}
