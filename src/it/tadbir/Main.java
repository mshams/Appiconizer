package it.tadbir;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

public class Main extends Application {
    private final String STR_PATH = "strPath";
    private final String APP_NAME = "Appiconizer";
    protected int[] sizes = new int[]{10, 16, 24, 29, 32, 36, 48, 50, 57, 58, 60, 72, 76, 100, 114, 120, 128, 144, 152, 256, 512, 1024};
    protected static Controller ui;
    Preferences prefs;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Main start.");

        try {
            //load fxml
            Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
            primaryStage.setTitle(APP_NAME);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

            //get controller instance
            ui = Controller.instance;

            //set event listeners
            ui.btnBrowse.setOnMouseClicked(evtBrowse);
            ui.btnGo.setOnMouseClicked(evtGo);
            ui.btnAll.setOnMouseClicked(evtLinks);
            ui.btnNone.setOnMouseClicked(evtLinks);
            ui.btnInvert.setOnMouseClicked(evtLinks);

            //set init values
            prefs = Preferences.userRoot().node(this.getClass().getName());
            ui.txtPath.setText(prefs.get(STR_PATH, ""));
            CheckBox ch;
            for (int i = 0; i < sizes.length; i++) {
                ch = new CheckBox(String.valueOf(sizes[i]) + "x" + String.valueOf(sizes[i]));
                ch.setId("c" + String.valueOf(i));
                ui.grp.getChildren().add(ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected EventHandler<MouseEvent> evtGo = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            String path = ui.txtPath.getText();

            CheckBox c;
            for (int i = 0; i < sizes.length; i++) {
                c = (CheckBox) ui.grp.getChildren().get(i);
                if (c.isSelected()) {

                    File source = new File(path);
                    String s = "-" + String.valueOf(sizes[i]);
                    File dest = new File(path.substring(0, path.lastIndexOf(".")) + s + ".png");

                    System.out.println(dest.getAbsolutePath());

                    try {
                        Thumbnails.of(source).size(sizes[i], sizes[i]).toFile(dest);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            prefs.put(STR_PATH, path);
        }
    };

    protected EventHandler<MouseEvent> evtLinks = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            CheckBox c;
            boolean value = false;

            for (int i = 0; i < sizes.length; i++) {
                c = (CheckBox) ui.grp.getChildren().get(i);

                switch (((Node) event.getSource()).getId()) {
                    case "btnAll":
                        value = true;
                        break;

                    case "btnNone":
                        value = false;
                        break;

                    case "btnInvert":
                        value = !c.isSelected();
                        break;
                }

                c.setSelected(value);
            }
        }
    };

    protected EventHandler<MouseEvent> evtBrowse = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG image files.", "*.png"));
            chooser.setTitle("Open File");

            File path = new File(ui.txtPath.getText());
            if (path.getParent() != null)
                chooser.setInitialDirectory(new File(path.getParent()));

            File file = chooser.showOpenDialog(new Stage());

            ui.txtPath.setText(file.getAbsolutePath());
            ui.btnGo.setDisable(false);
        }
    };

    public static void main(String[] args) {
        launch(args);
    }
}
