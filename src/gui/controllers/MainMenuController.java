package gui.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import models.CriminalOrganization;
import models.Perpetrator;

import java.net.URL;
import java.util.ResourceBundle;

import static gui.resources.SampleData.generateOrganizations;
import static helpers.Logger.log;
import static models.exceptions.ExceptionMessageProvider.*;

public class MainMenuController implements Initializable {

    @FXML private TableView<CriminalOrganization> tblOrg;
    @FXML private TableColumn<CriminalOrganization, String> colOrgName;
    @FXML private TableColumn<CriminalOrganization, String> colOrgBusiness;
    @FXML private TableColumn<CriminalOrganization, String> colOrgStatus;
    @FXML private TableColumn<CriminalOrganization, String> colOrgIntStatus;

    @FXML private TableView<Perpetrator> tblMem;
    @FXML private TableColumn<Perpetrator, String> colMemID;
    @FXML private TableColumn<Perpetrator, String> colMemAlias;
    @FXML private TableColumn<Perpetrator, String> colMemHeight;
    @FXML private TableColumn<Perpetrator, String> colMemWeight;
    @FXML private TableColumn<Perpetrator, String> colMemStatus;
    @FXML private TableColumn<Perpetrator, String> colMemNumOffenses;

    /**
     * Sets cell value factories on all fields in organization table in order to handle events. PropertyValueFactory args
     * must match the attribute names in appropriate classes.
     */
    private void populateOrganizations() {
        colOrgBusiness.setCellValueFactory(new PropertyValueFactory<>("business"));
        colOrgName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrgIntStatus.setCellValueFactory(new PropertyValueFactory<>("internationalStatus"));
        colOrgStatus.setCellValueFactory(new PropertyValueFactory<>("organizationStatus"));
        tblOrg.setItems(generateOrganizations());
    }

    /**
     * Sets cell value factories on all fields in perpetrator table in order to handle events. PropertyValueFactory args
     * must match the attribute names in appropriate classes.
     */
    private void populatePerpetrators() {
        colMemID.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        colMemAlias.setCellValueFactory(new PropertyValueFactory<>("alias"));
        colMemHeight.setCellValueFactory(new PropertyValueFactory<>("height"));
        colMemWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        colMemStatus.setCellValueFactory(new PropertyValueFactory<>("perpetratorStatus"));
    }

    /**
     * Sets a listener that awaits for row selection and populates perpetrator table accordingly on click.
     */
    private void handleOrgChoice() {
        tblOrg.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                log(tblOrg.getSelectionModel().getSelectedItem());
                tblMem.setItems(FXCollections.observableArrayList(tblOrg.getSelectionModel().getSelectedItem().getMembers()));
            }
        });
    }

    /**
     * Sets default error message in case no content is present.
     */
    private void setPlaceholders() {
        tblOrg.setTooltip(new Tooltip(ON_NO_ACTION_TOOLTIP));
        tblOrg.setPlaceholder(new Label(NO_CONTENT_ORG_MESSAGE));
        tblMem.setPlaceholder(new Label(NO_CONTENT_MEM_MESSAGE));
    }

    public void initialize(URL location, ResourceBundle resources) {
        setPlaceholders();
        handleOrgChoice();
        populatePerpetrators();
        populateOrganizations();
    }


}
