module ca.ucalgary.syeda.rakib.demo3gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.ucalgary.syeda.rakib.demo3gui to javafx.fxml;
    exports ca.ucalgary.syeda.rakib.demo3gui;
}