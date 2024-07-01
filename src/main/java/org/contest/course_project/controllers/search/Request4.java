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

public class Request4 implements Initializable {
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
                Query query = session.createQuery("SELECT s.id, s.group, a.fullName, e.examTime " +
                        "FROM Student s JOIN s.applicant a JOIN a.exam e " +
                        "ON s.applicant.id = a.id AND a.exam.id = e.id " +
                        "WHERE e.discipline.name = :disciplineName");
                query.setParameter("disciplineName", textInput.getText());
                List<Result> results = new ArrayList<>();
                List<Object> list = query.getResultList();
                for (Object o : list) {
                    Object[] row = (Object[]) o;
                    results.add(new Result((long) row[0], (String) row[1], (String) row[2], (String) row[3]));
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
        private String studentGroup;
        private String studentFullName;
        private String examTime;

        public Result(long studentId, String studentGroup, String studentFullName, String examTime) {
            this.studentId = studentId;
            this.studentGroup = studentGroup;
            this.studentFullName = studentFullName;
            this.examTime = examTime;
        }

        public long getStudentId() {
            return studentId;
        }

        public void setStudentId(long studentId) {
            this.studentId = studentId;
        }

        public String getStudentGroup() {
            return studentGroup;
        }

        public void setStudentGroup(String studentGroup) {
            this.studentGroup = studentGroup;
        }

        public String getStudentFullName() {
            return studentFullName;
        }

        public void setStudentFullName(String studentFullName) {
            this.studentFullName = studentFullName;
        }

        public String getExamTime() {
            return examTime;
        }

        public void setExamTime(String examTime) {
            this.examTime = examTime;
        }
    }
}
