package org.contest.course_project.controllers.aggregation;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.contest.course_project.HibernateSession;
import org.contest.course_project.Utilities;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestSum {
    public Label output;
    public TableView tableView;
    @FXML
    Button back;
    Utilities utilities = new Utilities();
    public void goBack(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(back, "hello-view.fxml");
    }
    public void find(ActionEvent actionEvent) {
        utilities.createColumns(tableView, Result.class);
        Platform.runLater(() ->{
            HibernateSession.sessionFactory().inTransaction(session -> {
                Query query = session.createQuery("SELECT e.id AS examId, SUM(a.score) AS totalScore " +
                        "FROM Exam e JOIN e.applicants a " +
                        "GROUP BY examId");
                List<Object[]> results = query.getResultList();
                List<Result> results1 = new ArrayList<>();
                for (Object[] result : results) {
                    results1.add(new Result((Long) result[0], (Long) result[1]));
                }
                tableView.getItems().clear();
                tableView.getItems().addAll(FXCollections.observableArrayList(results1));
            });
        });
    }
    protected class Result {
        private Long examId;
        private Long totalScore;

        public Result(Long examId, Long totalScore) {
            this.examId = examId;
            this.totalScore = totalScore;
        }

        public Long getExamId() {
            return examId;
        }

        public Long getTotalScore() {
            return totalScore;
        }
    }
}
