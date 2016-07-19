/**
 * 
 */
package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * <pre>
 * application
 *  	|_ TotalController
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2016. 5. 23.
 * </pre>
 * 
 * @author : 이은찬
 * @version : 1.0
 */
public class TotalController implements Initializable {

	@FXML
	Label ballot;//
	@FXML
	Label voterate;//
	@FXML
	Label ballotrate;//

	@FXML
	Label validballot;//
	@FXML
	Label invalidballot;//
	@FXML
	Label whiteballot;//
	@FXML
	Label votenum;//

	@FXML
	Label EP;//

	@FXML
	Label electrorate;//

	private int ballotValue;
	private int invalidballotValue;
	private int whiteballotValue;
	private int votenumValue;
	private double ballotrateValue;
	private int electrorateValue;
	private int validballotValue;
	private double voterateValue;

	private int EPnum;

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	Thread main;

	private Stage primaryStage;

	public void setStage(Stage stage) {
		this.primaryStage = stage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		primaryStage.setOnCloseRequest(event -> {

			System.out.println("종료 - total");

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {

				}
			}

			if (conn != null) {
				try {

					conn.close();

				} catch (SQLException e) {

				}
			}

			if (main.isAlive())
				main.interrupt();

		});

		/* DB 접속 정보를 지정 합니다. (사용할 db정보://주소:포트/데이터베이스명, ID, PW) */
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dvis_db", "root", "lec2554ec");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Task<Void> manageMain = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				// MySql 연결

				while (true) {

					try {
						// /////////////////////////////////////////////////////////////////

						ps = (PreparedStatement) conn
								.prepareStatement("SELECT * FROM voteresult;");

						/* 실행 할 쿼리문을 넣어서 executeQuery를 하면 rs에 결과값이 담깁니다. */

						rs = ps.executeQuery();

						/* rs의 cursour를 이동합니다. 이동에 성공하면 true를 반납합니다. */

						while (rs.next()) {

							System.out.println("진입 - total");

							rs.getInt(1);

							validballotValue = rs.getInt(2); // 유효표
							invalidballotValue = rs.getInt(3); // 무효표
							whiteballotValue = rs.getInt(4); // 백표
							votenumValue = rs.getInt(5); // 전체표
							electrorateValue = rs.getInt(7); // 유권자

							validballot.setText(String
									.valueOf(validballotValue));
							invalidballot.setText(String
									.valueOf(invalidballotValue));
							whiteballot.setText(String
									.valueOf(whiteballotValue));
							votenum.setText(String.valueOf(votenumValue));
							electrorate.setText(String
									.valueOf(electrorateValue));

							EPnum = rs.getInt(6);

							if (EPnum == 0)
								EP.setText("결정되지 않음");
							else
								EP.setText(String.valueOf(EPnum));

							ballotValue = validballotValue + invalidballotValue
									+ whiteballotValue;
							ballot.setText(String.valueOf(ballotValue));

							voterateValue = ((double) votenumValue / electrorateValue) * 100;
							voterate.setText(String.format("%.1f",
									voterateValue) + "%");

							ballotrateValue = ((double) ballotValue / votenumValue) * 100;
							ballotrate.setText(String.format("%.1f",
									ballotrateValue) + "%");

						}

					} catch (SQLException e) {

						e.printStackTrace();

					}

					Thread.sleep(500);

				}

			}
		};

		main = new Thread(manageMain);

		main.start();

	}

}
