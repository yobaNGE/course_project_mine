package org.contest.course_project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.contest.course_project.entities.AdmissionCommittee;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button go;
    private Utilities utilities = new Utilities();
    public void fifthSearh(ActionEvent actionEvent) throws Exception {
        utilities.goToStage(go, "request5.fxml");
    }

    public void fourthSearh(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "request4.fxml");
    }

    public void thirdSearh(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "request3.fxml");
    }

    public void secondSearh(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "request2.fxml");
    }

    public void firstSearh(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "request1.fxml");
    }

    public void avg(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "RequestAvg.fxml");
    }

    public void count(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "RequestCount.fxml");
    }

    public void exist(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "RequestExist.fxml");
    }

    public void sum(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "RequestSum.fxml");
    }

    public void cud(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(go, "cud.fxml");
    }
}