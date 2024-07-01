package org.contest.course_project.controllers.aggregation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.contest.course_project.HibernateSession;
import org.contest.course_project.Utilities;
import org.hibernate.query.Query;

import java.io.IOException;

public class RequestCount {
    public Label output;
    public TextField input;
    @FXML
    Button back;
    Utilities utilities = new Utilities();
    public void goBack(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(back, "hello-view.fxml");
    }
    public void find(ActionEvent actionEvent) {
        Platform.runLater(() ->{
            HibernateSession.sessionFactory().inTransaction(session -> {
                Query query = session.createQuery(
                        "SELECT COUNT(DISTINCT a) " +
                        "FROM Applicant a JOIN a.exam e " +
                        "WHERE e.examResult >= :minScore");
                query.setParameter("minScore", Integer.parseInt(input.getText()));
                Long count = (Long) query.getSingleResult();
                output.setText(count.toString());
            });
        });
    }
}
