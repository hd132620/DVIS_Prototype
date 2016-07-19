/**
 * 
 */
package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * <pre>
 * application
 *	 	|_ VoteTable
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2016. 5. 23.
 * </pre>
 * 
 * @author		: 이은찬
 * @version		: 1.0
 */
public class VoteTable {
	
	private SimpleIntegerProperty canNum;
	private SimpleStringProperty psd;
	private SimpleStringProperty vpsd;
	private SimpleIntegerProperty num;
	private SimpleIntegerProperty percentage;
	private SimpleIntegerProperty reqBallot;
	
	public VoteTable(VoteNum vn) {
		this.canNum = vn.getCan().getCanNum();
		this.psd = vn.getCan().getPsd();
		this.vpsd = vn.getCan().getvPsd();
		this.num = vn.getNum();
		this.percentage = vn.getPercentage();
		this.reqBallot = vn.getReqBallot();
	}

	@Override
	public String toString() {
		return "VoteTable [canNum=" + canNum + ", psd=" + psd + ", vPsd="
				+ vpsd + ", num=" + num + ", percentage=" + percentage
				+ ", reqBallot=" + reqBallot + "]";
	}

	public int getCanNum() {
		return canNum.get();
	}

	public void setCanNum(Integer canNum) {
		this.canNum.set(canNum);
	}

	public String getPsd() {
		return psd.get();
	}

	public void setPsd(String psd) {
		this.psd.set(psd);
	}

	public String getVpsd() {
		return vpsd.get();
	}

	public void setVpsd(String vpsd) {
		this.vpsd.set(vpsd);
	}

	public int getNum() {
		return num.get();
	}

	public void setNum(int num) {
		this.num.set(num);
	}

	public int getPercentage() {
		return percentage.get();
	}

	public void setPercentage(int percentage) {
		this.percentage.set(percentage);
	}

	public int getReqBallot() {
		return reqBallot.get();
	}

	public void setReqBallot(int reqBallot) {
		this.reqBallot.set(reqBallot);
	}
	
	

}
