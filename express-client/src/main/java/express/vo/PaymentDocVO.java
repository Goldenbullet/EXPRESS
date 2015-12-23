package express.vo;

import java.util.ArrayList;

import express.po.PaymentItem;

public class PaymentDocVO extends DocumentVO{

	private String title="付款单";
	private ArrayList<PaymentItem> payment;
	private double sum;
	private String paymentID;
	
	public PaymentDocVO(ArrayList<PaymentItem> payment,double sum,String paymentID){
		this.payment=payment;
		this.sum=sum;
		this.paymentID=paymentID;
	}
	
	public PaymentDocVO(){
		payment=new ArrayList<PaymentItem>();
		sum=0;
		paymentID="0";
	}
	
	public ArrayList<PaymentItem> getPaymentList(){
		return payment;
	}
	
	public double getSum(){
		return sum;
	}
	
	public String getPaymentID(){
		return paymentID;
	}
	
	public void setPaymentList(ArrayList<PaymentItem> p){
		payment=p;
	}

	public void setID(String id){
		paymentID=id;
	}
	
	public void setSum(double s){
		sum=s;
	}
	//add title
		public String getTitle(){
			return title;
		}
}
