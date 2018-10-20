package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Label saatLabel=new Label();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Task<Void> task=new Saat(this);
        Thread thread=new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
    private class Saat extends Task<Void> {

        Controller controller;

        public Saat (Controller controller) {
            this.controller = controller;
        }

        @Override
        protected Void call() throws Exception {
            makeChanges();
            return null;
        }

        private void makeChanges() {
            while (true) {
                try {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Calendar calendar = new GregorianCalendar();
                            int saat = calendar.get(Calendar.HOUR_OF_DAY);
                            int dakika = calendar.get(Calendar.MINUTE);
                            int saniye = calendar.get(Calendar.SECOND);
                            controller.saatLabel.setText(saat + ":" + dakika+":"+saniye);
                        }
                    });
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
            }
        }
    }
}
