package express.businesslogicService.transcenterRepoBLService;

import java.util.ArrayList;

import express.vo.InDocVO;

public interface InventoryRepoBLService {

	public ArrayList<InDocVO> inventoryRepo();
	
	public boolean exportExcel(ArrayList<InDocVO> repoCache);
	
	public void endRepoInventory();
}
