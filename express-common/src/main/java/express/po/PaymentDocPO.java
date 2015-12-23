package express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class PaymentDocPO extends DocumentPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5672515769370646252L;
	private ArrayList<PaymentItem> payment;
	private double sum;
	private String paymentID;

	public PaymentDocPO(ArrayList<PaymentItem> payment, double sum,
			String paymentID) {
		this.payment = payment;
		this.sum = sum;
		this.paymentID = paymentID;
	}

	public PaymentDocPO() {
		payment = new ArrayList<PaymentItem>();
		sum = 0;
		paymentID = "0";
	}

	public ArrayList<PaymentItem> getPaymentList() {
		return payment;
	}

	public double getSum() {
		return sum;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentList(ArrayList<PaymentItem> p) {
		payment = p;
	}

	public void setID(String id) {
		paymentID = id;
	}

	public void setSum(double s) {
		sum = s;
	}

}
