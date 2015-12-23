package express.businesslogicService.transcenterRepoBLService;

import express.vo.InDocVO;
import express.vo.OutDocVO;

public interface InDocblService {
	public boolean addInDoc(InDocVO vo);
	public InDocVO getInDoc(String orderID);
	public boolean isOrderIDavailable(String id);  
	public void endInDoc();
}
