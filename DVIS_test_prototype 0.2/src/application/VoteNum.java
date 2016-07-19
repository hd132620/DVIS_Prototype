/**
 * 
 */
package application;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * <pre>
 * application
 *	 	|_ Candidate
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2016. 5. 19.
 * </pre>
 * 
 * @author		: 이은찬
 * @version		: 1.0
 */
public class VoteNum {
	
	private Candidate can;
	private SimpleIntegerProperty num;
	private SimpleIntegerProperty percentage;
	private SimpleIntegerProperty reqBallot;
	/**
	 * @param can
	 * @param num
	 * @param percentage
	 * @param reqBallot
	 */
	public VoteNum(Candidate can, int num, int percentage, int reqBallot) {
		super();
		this.can = can;
		this.num = new SimpleIntegerProperty(num);
		this.percentage =  new SimpleIntegerProperty(percentage);
		this.reqBallot =  new SimpleIntegerProperty(reqBallot);
	}
	
	public VoteNum(Candidate can) {
		super();
		this.can = can;
	}

	public Candidate getCan() {
		return can;
	}

	public void setCan(Candidate can) {
		this.can = can;
	}

	public SimpleIntegerProperty getNum() {
		return num;
	}

	public void setNum(SimpleIntegerProperty num) {
		this.num = num;
	}

	public SimpleIntegerProperty getPercentage() {
		return percentage;
	}

	public void setPercentage(SimpleIntegerProperty percentage) {
		this.percentage = percentage;
	}

	public SimpleIntegerProperty getReqBallot() {
		return reqBallot;
	}

	public void setReqBallot(SimpleIntegerProperty reqBallot) {
		this.reqBallot = reqBallot;
	}
	
	
	

}
