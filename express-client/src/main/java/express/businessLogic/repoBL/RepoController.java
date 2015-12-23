package express.businessLogic.repoBL;

import java.util.ArrayList;

import express.businesslogicService.transcenterRepoBLService.AdjustRepoBLService;
import express.businesslogicService.transcenterRepoBLService.InventoryRepoBLService;
import express.businesslogicService.transcenterRepoBLService.ScanRepoBLService;
import express.vo.InDocVO;
import express.vo.RepoCacheVO;
import express.vo.RepoPositionVO;

public class RepoController implements AdjustRepoBLService,
		InventoryRepoBLService, ScanRepoBLService {
	
	ViewRepo view;
	InventoryRepo inventry;
	AdjustRepo adjust;
	
	public RepoController(){
		view=new ViewRepo();
		inventry=new InventoryRepo();
		adjust=new AdjustRepo();
	}

	public RepoCacheVO getRepoInfo(String city, String startDate, String endDate) {
		return view.getRepoInfo(city, startDate, endDate);
	}

	public ArrayList<RepoPositionVO> getRepoPositionList(String city) {
		return view.getRepoPositionList(city);
	}

	public boolean checkBeginAndEndDate(String beginDate, String endDate) {
		return view.checkBeginAndEndDate(beginDate, endDate);
	}

	public ArrayList<InDocVO> inventoryRepo() {
		return inventry.inventoryRepo();
	}

	public boolean exportExcel(ArrayList<InDocVO> repoCache) {
		return inventry.exportExcel(repoCache);
	}

	public void endRepoInventory() {
		inventry.endRepoInventory();
		
	}

	public boolean checkRepoBlockUsed(RepoPositionVO position) {
		return adjust.checkRepoBlockUsed(position);
	}

	public boolean setRepoBlock(RepoPositionVO position) {
		return adjust.setRepoBlock(position);
	}

	public boolean alarm(RepoPositionVO position) {
		return adjust.alarm(position);
	}

	public boolean adjustRepo(RepoPositionVO oldPosition,
			RepoPositionVO newPosition) {
		return adjust.adjustRepo(oldPosition, newPosition);
	}

	public void endRepoManage() {
		adjust.endRepoManage();
		
	}

}
