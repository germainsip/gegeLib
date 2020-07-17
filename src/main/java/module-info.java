open module gegeLib.main {
    requires transitive com.fasterxml.jackson.core;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive com.fasterxml.jackson.annotation;
    requires org.apache.logging.log4j;
    requires transitive javafx.fxml;
    requires javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.web;
    requires java.datatransfer;
    requires java.desktop;
    requires com.jfoenix;

    exports org.gerblog ;
}