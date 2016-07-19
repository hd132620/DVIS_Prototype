/**
 * 
 */
package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
public class Candidate {
	
	private SimpleIntegerProperty canNum;
	private SimpleStringProperty psd;
	private SimpleStringProperty vPsd;
	/**
	 * @param canNum
	 * @param psd
	 * @param vPsd
	 */
	public Candidate(int canNum,String psd,
			String vPsd) {
		super();
		this.canNum = new SimpleIntegerProperty(canNum);
		this.psd = new SimpleStringProperty(psd);
		this.vPsd = new SimpleStringProperty(vPsd);
	}
	public SimpleIntegerProperty getCanNum() {
		return canNum;
	}
	public void setCanNum(SimpleIntegerProperty canNum) {
		this.canNum = canNum;
	}
	public SimpleStringProperty getPsd() {
		return psd;
	}
	public void setPsd(SimpleStringProperty psd) {
		this.psd = psd;
	}
	public SimpleStringProperty getvPsd() {
		return vPsd;
	}
	public void setvPsd(SimpleStringProperty vPsd) {
		this.vPsd = vPsd;
	}

}
