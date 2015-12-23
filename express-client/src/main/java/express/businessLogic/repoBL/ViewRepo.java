package express.businessLogic.repoBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import express.businessLogic.IDKeeper;
import express.dataService.repoDataService.RepoDataService;
import express.po.RepoInfoPO;
import express.po.RepoPosition;
import express.rmi.RMIClient;
import express.vo.RepoCacheVO;
import express.vo.RepoPositionVO;

public class ViewRepo {
	
	RepoDataService repo;
	
	public ViewRepo(){
		repo=RMIClient.getRepoInfoObject();
	}

	public RepoCacheVO getRepoInfo(String city, String startDate, String endDate) {
		
		try {
			RepoCacheVO cache = new RepoCacheVO();
			RepoInfoPO po;
			
			int countImport = countInDoc(startDate,endDate);
			int countExport = countOutDoc(startDate,endDate);
			
			cache.setImportSum(countImport);
			cache.setExportSum(countExport);
			
			po = repo.getRepo(IDKeeper.getOrgID());
			if(repo==null)
				cache.setSum(0);
			else
				cache.setSum(po.getRepoSum());
			
			return cache;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}

	public ArrayList<RepoPositionVO> getRepoPositionList(String city) {
		try {
			RepoInfoPO po=repo.getRepo(IDKeeper.getOrgID());
			
			if(repo==null)
				return null;
			ArrayList<RepoPosition> positionList =po.getRepoPosition();
			
			if(positionList==null)
				return null;
			if(positionList.size()==0)
				return null;
			
			ArrayList<RepoPositionVO> transList = new ArrayList<RepoPositionVO>();

			for (RepoPosition r : positionList) {
				RepoPositionVO vo = new RepoPositionVO(r.getOrderID(),
						r.getblock(), r.getrow(), r.getshelf(),
						r.getposition(), r.getIsUsed());
				
				transList.add(vo);
			}
			
			return transList;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public boolean checkBeginAndEndDate(String beginDate, String endDate) {
		
		if(beginDate.compareTo(endDate)>0)
			return false;
		else
			return true;

	}
	
	private int countInDoc(String startDate, String endDate){
		int count = 0;
		
		if(startDate == null){
			if(endDate == null){
				
			}
			else{
				
			}
		}
		else{
			if(endDate == null){
				
			}
			else{
				
			}
		}
		
		return count;
	}
	
	private int countOutDoc(String startDate, String endDate){
		int count = 0;
		
		if(startDate == null){
			if(endDate == null){
				
			}
			else{
				
			}
		}
		else{
			if(endDate == null){
				
			}
			else{
				
			}
		}
		
		return count;
	}
	
}
