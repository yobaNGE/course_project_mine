module org.contest.course_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens org.contest.course_project to javafx.fxml;
    opens org.contest.course_project.controllers.search to javafx.fxml, javafx.base;
    opens org.contest.course_project.controllers.aggregation to javafx.fxml, javafx.base;
    opens org.contest.course_project.controllers to javafx.fxml, javafx.base;
    opens org.contest.course_project.entities to org.hibernate.orm.core, javafx.base;

    exports org.contest.course_project;
    exports org.contest.course_project.controllers.search to javafx.fxm;
}