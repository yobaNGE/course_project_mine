package org.contest.course_project.controllers.aggregation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.contest.course_project.HibernateSession;
import org.contest.course_project.Utilities;
import org.contest.course_project.entities.Applicant;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RequestAvg{
    public Label output;
    @FXML
    Button back;
    Utilities utilities = new Utilities();
    public void goBack(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(back, "hello-view.fxml");
    }
    public void find(ActionEvent actionEvent) {
        Platform.runLater(() ->{
            HibernateSession.sessionFactory().inTransaction(session -> {
                Query query = session.createQuery("SELECT AVG(e.examResult) " +
                        "FROM Applicant a JOIN a.exam e " +
                        "WHERE a.goldMedal = true");
                Double average = (Double) query.getSingleResult();
                output.setText(average.toString());
            });
        });
    }

}
