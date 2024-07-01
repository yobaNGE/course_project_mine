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
import org.contest.course_project.entities.Applicant;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Request3 implements Initializable {
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
                Query query = session.createQuery("SELECT e.id, e.examTime, d.name " +
                        "FROM Exam e JOIN Discipline d " +
                        "ON e.discipline.id = d.id " +
                        "WHERE d.name = :disciplineName");
                query.setParameter("disciplineName", textInput.getText());
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
        private long examId;
        private String examTime;
        private String disciplineName;

        public Result(long examId, String examTime, String disciplineName) {
            this.examId = examId;
            this.examTime = examTime;
            this.disciplineName = disciplineName;
        }

        public long getExamId() {
            return examId;
        }

        public void setExamId(long examId) {
            this.examId = examId;
        }

        public String getExamTime() {
            return examTime;
        }

        public void setExamTime(String examTime) {
            this.examTime = examTime;
        }

        public String getDisciplineName() {
            return disciplineName;
        }

        public void setDisciplineName(String disciplineName) {
            this.disciplineName = disciplineName;
        }
    }
}
