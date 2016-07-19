package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		// TODO Auto-generated method stub

		FXMLLoader mainfxmlLoader = new FXMLLoader();

		MainController controller = new MainController();

		controller.setStage(stage);

		mainfxmlLoader.setController(controller);
		mainfxmlLoader.setLocation(getClass().getResource("main.fxml"));

		Parent root = (Parent) mainfxmlLoader.load();

		stage.setScene(new Scene(root));
		stage.setTitle("DVIS Test_Prototype v0.2 후보별결과 - 이은찬");

		stage.show();

		// //////////////////////////////////////////////////////////////////

		javafx.application.Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Stage totalStage = new Stage();

				FXMLLoader totalfxmlLoader = new FXMLLoader();

				TotalController tcontroller = new TotalController();

				tcontroller.setStage(totalStage);

				totalfxmlLoader.setController(tcontroller);
				totalfxmlLoader.setLocation(getClass()
						.getResource("Total.fxml"));

				Parent totalroot;
				try {
					totalroot = (Parent) totalfxmlLoader.load();

					totalStage.setScene(new Scene(totalroot));
					totalStage
							.setTitle("DVIS Test_Prototype v0.2 - 전체결과 - 이은찬");

					totalStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
