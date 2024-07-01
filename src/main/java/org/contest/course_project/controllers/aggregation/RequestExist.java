package org.contest.course_project.controllers.aggregation;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.contest.course_project.HibernateSession;
import org.contest.course_project.Utilities;
import org.contest.course_project.entities.Applicant;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RequestExist {
    public Label output;
    public TextField input;
    public TableView tableView;
    @FXML
    Button back;
    Utilities utilities = new Utilities();

    public void goBack(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(back, "hello-view.fxml");
    }

    public void find(ActionEvent actionEvent) {
        utilities.createColumns(tableView, Applicant.class);
        Platform.runLater(() -> {
            HibernateSession.sessionFactory().inTransaction(session -> {
                Query query = session.createQuery("SELECT a " +
                        "FROM Applicant a JOIN a.exam e " +
                        "WHERE EXISTS (SELECT 1 FROM Exam ex WHERE ex.id = e.id AND ex.examResult >= :minScore)", Applicant.class);
                query.setParameter("minScore", Integer.parseInt(input.getText()));
                List<Applicant> ids = query.getResultList();
                tableView.getItems().clear();
                tableView.setItems(FXCollections.observableList(ids));
            });
        });
    }
}
