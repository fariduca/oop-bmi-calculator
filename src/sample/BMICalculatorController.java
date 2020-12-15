package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.math.RoundingMode;

public class BMICalculatorController {

    @FXML
    private RadioButton metricRadio;

    @FXML
    private ToggleGroup units;

    @FXML
    private RadioButton englishRadio;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField bmiTextField;

    @FXML
    private Label textLabel;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            if (metricRadio.isSelected()) {
                double weight = Double.parseDouble(weightTextField.getText());
                double height = Double.parseDouble(heightTextField.getText());
                double bmi = weight / Math.pow(height, 2);
                bmi = ((int) (bmi * 100)) / 100.0;
                bmiTextField.setText(String.valueOf(bmi));
            } else if (englishRadio.isSelected()) {
                double weight = Double.parseDouble(weightTextField.getText());
                double height = Double.parseDouble(heightTextField.getText());
                double bmi = 703 * weight / Math.pow(height, 2);
                bmi = ((int) (bmi * 100)) / 100.0;
                bmiTextField.setText(String.valueOf(bmi));
            } else {
                //don't calculate anything
                metricRadio.requestFocus();
            }
        } catch (NumberFormatException | NullPointerException e) {
            heightTextField.setText("Enter height");
            heightTextField.selectAll();
            heightTextField.requestFocus();
            weightTextField.setText("Enter weight");
            weightTextField.selectAll();
        }

    }

    public void initialize() {
        textLabel.setText("Underweight: \tless than 18.5\n" +
                "Normal: \tbetween 18.5 and 24.9\n" +
                "Overweight: \tbetween 25 and 29.9\n" +
                "Obese: \t30 or greater");
    }

}
