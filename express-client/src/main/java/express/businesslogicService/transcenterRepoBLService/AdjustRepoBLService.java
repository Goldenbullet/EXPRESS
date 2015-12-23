package express.businesslogicService.transcenterRepoBLService;

import express.vo.RepoPositionVO;

public interface AdjustRepoBLService {

	public boolean checkRepoBlockUsed(RepoPositionVO position);
	
	public boolean setRepoBlock(RepoPositionVO position);
	
	public boolean alarm(RepoPositionVO position);
	
	public boolean adjustRepo(RepoPositionVO oldPosition,RepoPositionVO newPosition);
	
	public void endRepoManage();
}
