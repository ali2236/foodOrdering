package sample.controllers;

import com.sun.javafx.stage.StageHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.data.Note;
import sample.storage.SceneManager;
import sample.storage.Users.UserManager;

public class NoteController {

    @FXML
    private TextArea notes_area;

    @FXML
    private Button save_btn;

    @FXML
    private Button cancel_btn;

    @FXML
    public void initialize(){
        String userNotes = UserManager.getCurrentUser().getNote().body;
        if (userNotes != null){
            notes_area.setText(userNotes);
        }
    }

    public void save(ActionEvent event){
        // save to user notes
        Note note = UserManager.getCurrentUser().getNote();
        note.body = notes_area.getText();
        UserManager.getCurrentUser().setNote(note);

        // go back
        goBack();
    }

    public void cancel(ActionEvent event){
        // get back
        goBack();
    }

    private void goBack(){
        Stage mainStage = StageHelper.getStages().get(0);
        mainStage.setScene(SceneManager.getLastScene());
        mainStage.show();
    }
}
