package it.tadbir;

/**
 * Created by m_admin on 6/7/2017.
 * <p>
 * Sample Skeleton for 'mainView.fxml' Controller Class
 * <p>
 * Sample Skeleton for 'mainView.fxml' Controller Class
 * <p>
 * Sample Skeleton for 'mainView.fxml' Controller Class
 * <p>
 * Sample Skeleton for 'mainView.fxml' Controller Class
 * <p>
 * Sample Skeleton for 'mainView.fxml' Controller Class
 * <p>
 * Sample Skeleton for 'mainView.fxml' Controller Class
 * <p>
 * Sample Skeleton for 'mainView.fxml' Controller Class
 */
/**
 * Sample Skeleton for 'mainView.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements javafx.fxml.Initializable {
    protected static Controller instance = null;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPath"
    protected TextField txtPath; // Value injected by FXMLLoader

    @FXML
    protected Label txtLabel;

    @FXML // fx:id="btnBrowse"
    protected Button btnBrowse; // Value injected by FXMLLoader

    @FXML // fx:id="btnGo"
    protected Button btnGo; // Value injected by FXMLLoader

    @FXML // fx:id="grp"
    protected TilePane grp; // Value injected by FXMLLoader

    @FXML // fx:id="btnAll"
    protected Hyperlink btnAll; // Value injected by FXMLLoader

    @FXML // fx:id="btnNone"
    protected Hyperlink btnNone; // Value injected by FXMLLoader

    @FXML // fx:id="btnInvert"
    protected Hyperlink btnInvert; // Value injected by FXMLLoader

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("FXML init.");

        assert txtPath != null : "fx:id=\"txtPath\" was not injected: check your FXML file 'mainView.fxml'.";
        assert btnBrowse != null : "fx:id=\"btnBrowse\" was not injected: check your FXML file 'mainView.fxml'.";
        assert btnGo != null : "fx:id=\"btnGo\" was not injected: check your FXML file 'mainView.fxml'.";
        assert grp != null : "fx:id=\"grp\" was not injected: check your FXML file 'mainView.fxml'.";
        assert btnAll != null : "fx:id=\"btnAll\" was not injected: check your FXML file 'mainView.fxml'.";
        assert btnNone != null : "fx:id=\"btnNone\" was not injected: check your FXML file 'mainView.fxml'.";
        assert btnInvert != null : "fx:id=\"btnInvert\" was not injected: check your FXML file 'mainView.fxml'.";

        instance = this;
    }
}

