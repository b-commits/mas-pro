package gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.CriminalOrganization;
import models.Perpetrator;
import models.enums.InternationalStatus;
import models.enums.OrganizationStatus;

import java.net.URL;
import java.util.ResourceBundle;

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

    private void populateOrganizations() {
        colOrgName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrgBusiness.setCellValueFactory(new PropertyValueFactory<>("business"));
        tblOrg.setItems(getOrgs());
    }

    public ObservableList<CriminalOrganization> getOrgs() {
        ObservableList<CriminalOrganization> organizations = FXCollections.observableArrayList();
        CriminalOrganization organization1 = new CriminalOrganization("Los matadores", "Drugs");
        CriminalOrganization organization2 = new CriminalOrganization("La Ropa Vieja", "Theft");
        CriminalOrganization organization3 = new CriminalOrganization("Niszczyciele Trybun", "Hooligans");
        organizations.add(organization1);
        organizations.add(organization2);
        organizations.add(organization3);
        return organizations;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateOrganizations();
    }
}
