package gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import models.CriminalOrganization;
import models.Perpetrator;

import java.net.URL;
import java.util.ResourceBundle;

import static gui.resources.SampleData.generateOrganizations;
import static helpers.Logger.log;

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

    private void populateOrganizations() {
        colOrgBusiness.setCellValueFactory(new PropertyValueFactory<>("business"));
        colOrgName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrgIntStatus.setCellValueFactory(new PropertyValueFactory<>("internationalStatus"));
        colOrgStatus.setCellValueFactory(new PropertyValueFactory<>("organizationStatus"));
        tblOrg.setItems(getOrganizations());
    }

    private void populatePerpetrators() {
        colMemID.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
        colMemAlias.setCellValueFactory(new PropertyValueFactory<>("alias"));
        colMemHeight.setCellValueFactory(new PropertyValueFactory<>("height"));
        colMemWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        colMemStatus.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
    }

    private void handleOrgChoice() {
        tblOrg.setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                log(tblOrg.getSelectionModel().getSelectedItem());
                tblMem.setItems(FXCollections.observableArrayList(tblOrg.getSelectionModel().getSelectedItem().getMembers()));
            }
        });
    }

    public ObservableList<CriminalOrganization> getOrganizations() {
        return generateOrganizations();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handleOrgChoice();
        populateOrganizations();
    }


}
