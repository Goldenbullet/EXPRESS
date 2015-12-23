package express.businesslogicService.transcenterRepoBLService;

import java.util.ArrayList;

import express.vo.RepoCacheVO;
import express.vo.RepoPositionVO;

public interface ScanRepoBLService {

	public RepoCacheVO getRepoInfo(String city,String startDate,String endDate);
	
	public ArrayList<RepoPositionVO> getRepoPositionList(String city);
	
	public boolean checkBeginAndEndDate(String BeginDate,String endDate);
}
