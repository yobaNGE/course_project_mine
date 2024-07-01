package org.contest.course_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.contest.course_project.HibernateSession;
import org.contest.course_project.Utilities;
import org.contest.course_project.entities.Teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Cud implements Initializable {
    public TableView tableView;
    public TextField fullName;
    public TextField number;
    public Label id;
    public Button save;
    Utilities utilities = new Utilities();
    public void save(ActionEvent actionEvent) {
        HibernateSession.sessionFactory().inTransaction(session -> {
            Teacher teacher = new Teacher();
            teacher.setFullName(fullName.getText());
            teacher.setPhoneNumber(number.getText());
            session.persist(teacher);
        });
    }

    public void update(ActionEvent actionEvent) {
        HibernateSession.sessionFactory().inTransaction(session -> {
            Teacher teacher = session.get(Teacher.class, Long.parseLong(id.getText()));
            teacher.setFullName(fullName.getText());
            teacher.setPhoneNumber(number.getText());
            session.persist(teacher);
        });
    }

    public void delete(ActionEvent actionEvent) {
        HibernateSession.sessionFactory().inTransaction(session -> {
            Teacher teacher = session.get(Teacher.class, Long.parseLong(id.getText()));
            session.remove(teacher);
        });

    }

    public void back(ActionEvent actionEvent) throws IOException {
        utilities.goToStage(save, "hello-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        utilities.createColumns(tableView, Teacher.class);
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });
    }
    private void onEdit() {
        // Проверяем, что из TableView выбрана строка
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            Teacher teacher = (Teacher) tableView.getSelectionModel().getSelectedItem();
            id.setText(String.valueOf(teacher.getId()));
            fullName.setText(teacher.getFullName());
            number.setText(teacher.getPhoneNumber());
        }
    }

    public void refresh(ActionEvent actionEvent) {
        HibernateSession.sessionFactory().inTransaction(session -> {
            tableView.getItems().clear();
            tableView.getItems().addAll(session.createQuery("from Teacher", Teacher.class).list());
        });
    }
}
