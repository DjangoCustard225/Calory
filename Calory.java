import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calory extends Application{

    public void start(Stage stage) {

        Label l1 = makeLabel("Enter weight (kg): ");
        Label l2 = makeLabel("Enter height (cm): ");
        Label l3 = makeLabel("Enter age: ");
        Label l4 = makeLabel("Select gender: ");
        Label l5 = makeLabel("Select activity level: ");
        Label l6 = makeLabel("Select objective: ");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        ComboBox<String> cb1 = new ComboBox<>();
        cb1.getItems().addAll("Male", "Female");
        cb1.setMaxWidth(Double.MAX_VALUE);
        ComboBox<String> cb2 = new ComboBox<>();
        cb2.getItems().addAll("Sedentary", "Light", "Moderate", "Heavy", "Athlete");
        cb2.setMaxWidth(Double.MAX_VALUE);
        ComboBox<String> cb3 = new ComboBox<>();
        cb3.getItems().addAll("Lose weight", "Gain weight");
        cb3.setMaxWidth(Double.MAX_VALUE);

        TextArea ta = new TextArea();
        ta.setPadding(new Insets(10));

        Button b1 = new Button("CALORY!");
        b1.setMaxWidth(100);
        b1.setAlignment(Pos.TOP_CENTER);
        b1.setOnAction((e) -> {
            double weight = Double.parseDouble(tf1.getText());
            double height = Double.parseDouble(tf2.getText());
            int age = Integer.parseInt(tf3.getText());
            String level = cb2.getValue();
            String goal = cb3.getValue();
            String gender = cb1.getValue();
            double bmr = (10 * weight) + (6.25 * height) - (5 * age);
            if (gender.equals("Male")) {
                bmr += 5;
            } else {
                bmr -= 161;
            } 
            ta.setText("Basal Metabolic Rate (BMR): " + bmr + " calories\n");
            double tdee = bmr;
            switch (level) {
                case "Sedentary": {
                    tdee = bmr*1.2;
                    break;
                }
                case "Light": {
                    tdee = bmr*1.375;
                    break;
                }
                case "Moderate": {
                    tdee = bmr*1.55;
                    break;
                }
                case "Heavy": {
                    tdee = bmr*1.725;
                    break;
                }
                case "Athlete": {
                    tdee = bmr*1.9;
                    break;
                }
            }
            ta.appendText("Total Daily Energy Expenditure: " + tdee + " calories\n");
            if (goal.equals("Lose weight")) {
                ta.appendText("Daily calorie intake: " + tdee*.8 + " calories\n");
            } else {
                ta.appendText("Daily calorie intake: " + tdee*1.1 + " calories\n");
            }
            
        });
        
        GridPane g1 = new GridPane();
        g1.setAlignment(Pos.TOP_CENTER);
        g1.setPadding(new Insets(7));
        g1.setHgap(5);
        g1.setVgap(7);
        g1.add(l1, 0, 0);
        g1.add(tf1, 1, 0);
        g1.add(l2, 0, 1);
        g1.add(tf2, 1, 1);
        g1.add(l3, 0, 2);
        g1.add(tf3, 1, 2);
        g1.add(l4, 0, 3);
        g1.add(cb1, 1, 3);
        g1.add(l5, 0, 4);
        g1.add(cb2, 1, 4);
        g1.add(l6, 0, 5);
        g1.add(cb3, 1, 5);
        VBox v1 = new VBox();
        v1.setAlignment(Pos.TOP_CENTER);
        v1.setSpacing(10);
        v1.getChildren().addAll(g1, b1, ta);

        Scene scene = new Scene(v1, 380, 380);
        stage.setScene(scene);
        stage.setTitle("Calory");
        stage.show();
    }

    public Label makeLabel(String text) {
        Label label = new Label(text);
        label.setFont(new Font("Arial", 20));
        return label;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
