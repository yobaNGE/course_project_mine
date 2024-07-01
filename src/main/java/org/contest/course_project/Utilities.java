package org.contest.course_project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;

public class Utilities {
    public void goToStage(Button button, String fxml) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Parent root =
                FXMLLoader.load(getClass().getResource(fxml));
        ;
        stage.setTitle(fxml.replace(".fxml", ""));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void createColumns(TableView tableView, Class<?> entityClass) {
        tableView.getColumns().clear();

        Field[] fields = entityClass.getDeclaredFields();

        for (Field field : fields) {
            TableColumn<Object, Object> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(column);
        }
    }
}
