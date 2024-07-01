package org.contest.course_project.controllers.search;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.contest.course_project.HibernateSession;
import org.contest.course_project.Utilities;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Request2 implements Initializable {
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
        Platform.runLater(() -> {
            HibernateSession.sessionFactory().inTransaction(session -> {
                Query query = session.createQuery(
                        "SELECT s.id, s.group, a.fullName " +
                                "FROM Student s JOIN Applicant a " +
                                "ON s.applicant.id = a.id " +
                                "WHERE a.specialty.name = :specialtyName");
                query.setParameter("specialtyName", textInput.getText());
                List<Result> results = new ArrayList<>();
                List<Object> list = query.getResultList();
                for (Object o : list) {
                    Object[] row = (Object[]) o;
                    results.add(new Result((long) row[0], (String) row[1], (String) row[2]));
                }
                ObservableList<Result> observe = FXCollections.observableList(results);
                tableView.getItems().setAll(observe);
            });
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        utilities.createColumns(tableView, Result.class);
    }

    protected class Result {
        private long studentId;
        private String group;
        private String fullName;

        public Result(long applicantId, String group, String fullName) {
            this.studentId = applicantId;
            this.group = group;
            this.fullName = fullName;
        }

        public long getStudentId() {
            return studentId;
        }

        public void setStudentId(long studentId) {
            this.studentId = studentId;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }
}
