package express.po;

import java.io.Serializable;

import express.dataService.organizationDataService.OrganizationDataService;

public class InDocPO extends DocumentPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8769532078588459715L;
	private String deliveryNumber;
	private String date;
	private String arrival;
	private RepoPosition repoPosition;
	
	private String orgid;
	
	
	public InDocPO(String de,String d,String a,
			RepoPosition repoPosition){
		this.deliveryNumber=de;
		this.date=d;
		this.arrival=a;
		this.repoPosition=repoPosition;
	}
	
	public void setOrgID(String orgid){
		this.orgid=orgid;
	}
	
	
	
	public String getdeliveryNumber(){
		return deliveryNumber;
	}
	
	public void setdeliveryNumber(String deliveryNumber){
		this.deliveryNumber=deliveryNumber;
	}
	public String getdate(){
		return date;
	}
	public void setdate(String date){
		this.date=date;
	}
	public  String getarrival(){
		return arrival;
	}
	
	public  void setarrival(String arrival){
		this.arrival=arrival;
	}
	
	public RepoPosition getRepoPosition(){
		return repoPosition;
	}
	
	public void setRepoPosition(RepoPosition repoPosition){
		this.repoPosition=repoPosition;
	}
	
}
