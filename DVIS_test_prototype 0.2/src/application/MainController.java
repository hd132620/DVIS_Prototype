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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <pre>
 * application
 *  	|_ MainController
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2016. 5. 22.
 * </pre>
 * 
 * @author : 이은찬
 * @version : 1.0
 */
public class MainController implements Initializable {

	@FXML
	private AnchorPane ap;

	@FXML
	private TableView<VoteTable> ballotTable;

	Thread main;

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private List<VoteTable> vnr = new ArrayList<VoteTable>();

	private Stage primaryStage;

	public void setStage(Stage stage) {
		this.primaryStage = stage;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		primaryStage.setOnCloseRequest(event -> {

			System.out.println("종료 - main");

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

						/* DB 접속 정보를 지정 합니다. (사용할 db정보://주소:포트/데이터베이스명, ID, PW) */

						// /////////////////////////////////////////////////////////////////

						ps = (PreparedStatement) conn
								.prepareStatement("select * from candidates inner join votenum on candidates.UID = votenum.UID order by Num desc;");

						/* 실행 할 쿼리문을 넣어서 executeQuery를 하면 rs에 결과값이 담깁니다. */

						rs = ps.executeQuery();

						/* rs의 cursour를 이동합니다. 이동에 성공하면 true를 반납합니다. */

						vnr.clear();

						while (rs.next()) {

							System.out.println("진입 - main");
							/*
							 * rs에 있는 정보를 출력합니다. rs.getString("id") 식으로 필드명을 바로
							 * 적어서도 할 수 있습니다.
							 */

							vnr.add(new VoteTable(new VoteNum(new Candidate(rs
									.getInt(1), rs.getString(2), rs
									.getString(3)), rs.getInt("Num"), rs
									.getInt("Percentage"), rs
									.getInt("ReqBallot"))));

						}

						ballotTable.setItems(FXCollections
								.observableArrayList(vnr));
						System.out.println("성공");

					} catch (SQLException e) {

						e.printStackTrace();

					}

					// ////////////////////////////////////////////

					TableColumn UID = ballotTable.getColumns().get(0);
					UID.setCellValueFactory(new PropertyValueFactory<VoteTable, Integer>(
							"canNum"));
					UID.setStyle("-fx-alignment: CENTER;");

					TableColumn psd = ballotTable.getColumns().get(1);
					psd.setCellValueFactory(new PropertyValueFactory<VoteTable, String>(
							"psd"));
					psd.setStyle("-fx-alignment: CENTER;");

					TableColumn vpsd = ballotTable.getColumns().get(2);
					vpsd.setCellValueFactory(new PropertyValueFactory<VoteTable, String>(
							"vpsd"));
					vpsd.setStyle("-fx-alignment: CENTER;");

					TableColumn ballot = ballotTable.getColumns().get(3);
					ballot.setCellValueFactory(new PropertyValueFactory<VoteTable, Integer>(
							"num"));
					ballot.setStyle("-fx-alignment: CENTER;");

					TableColumn perc = ballotTable.getColumns().get(4);
					perc.setCellValueFactory(new PropertyValueFactory<VoteTable, Integer>(
							"percentage"));
					perc.setStyle("-fx-alignment: CENTER;");

					TableColumn reqBallot = ballotTable.getColumns().get(5);
					reqBallot
							.setCellValueFactory(new PropertyValueFactory<VoteTable, Integer>(
									"reqBallot"));
					reqBallot.setStyle("-fx-alignment: CENTER;");

					Thread.sleep(500);

				}

			}
		};

		main = new Thread(manageMain);

		main.start();

	}

}
