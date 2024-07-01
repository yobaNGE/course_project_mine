package org.contest.course_project.controllers.search;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.contest.course_project.HibernateSession;
import org.contest.course_project.Utilities;
import org.contest.course_project.entities.Applicant;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Request1 implements Initializable {
    @FXML
    TextField textInput;
    @FXML
    TableView tableView;
    @FXML
    Button back;
    Utilities utilities = new Utilities();
    public void goBack(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(back, "hello-view.fxml");
    }

    public void find(ActionEvent actionEvent) {
        Platform.runLater(() ->{
            HibernateSession.sessionFactory().inTransaction(session -> {
                Query query = session.createQuery("from Applicant a where a.score > :score", Applicant.class);
                query.setParameter("score", Integer.parseInt(textInput.getText()));
                tableView.getItems().setAll(query.getResultList());
            });
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        utilities.createColumns(tableView, Applicant.class);
    }
}
