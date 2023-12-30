package com.example.javacalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class HelloController {
    StringBuilder historyString = new StringBuilder();

    private int equalClick = 0;
    private int decimalClick = 0;
    private String generalOperationObject;
    @FXML
    private TextField historyField;
    @FXML
    private TextField textField;
    private double firstDouble;

    @FXML
    void decimalHandlerAction(ActionEvent event) {
        if(decimalClick==0){
            String decimalObject = ((Button)event.getSource()).getText();
            String oldText = textField.getText();
            String newText = oldText + decimalObject;
            textField.setText(newText);
            historyString.append(newText);
            historyField.setText(historyString.toString());
            decimalClick++;
        }
    }

    @FXML
    void digitActionHandler(ActionEvent event) {
        String digitObject = ((Button)event.getSource()).getText();
        if(equalClick>0){
            textField.setText("");
            historyField.setText("");
            historyString = new StringBuilder();
        }
        String oldText = textField.getText();
        String newText = oldText + digitObject;
        textField.setText(newText);
        equalClick=0;
    }

    @FXML
    void equalActionHandler(ActionEvent event) {
        equalClick++;
        double secondDouble;
        double result=0;
        String secondText = textField.getText();
        secondDouble = Double.parseDouble(secondText);
        String toAppend = textField.getText();
        historyString.append(toAppend);
        historyField.setText(historyString.toString());

        switch(generalOperationObject){
            case "+":
                result = firstDouble+secondDouble;
                break;
            case "-":
                result = firstDouble - secondDouble;
                break;
            case "x":
                result = firstDouble * secondDouble;
                break;
            case "÷":
                result = firstDouble / secondDouble;
                break;

            default:
        }
        String format = String.format("%.1f",result);
        textField.setText(format);
    }

    @FXML
    void generalActionHandler(ActionEvent event) {
        generalOperationObject = ((Button)event.getSource()).getText();
        switch(generalOperationObject){
            case "C":
                decimalClick = 0;
                textField.setText("");
                historyField.setText("");
                historyString = new StringBuilder();
                equalClick = 0;
                break;
            case "+":
            case "-":
            case "x":
            case "÷":
            case "sin":
            case "cos":
            case "tan":

                String oldText = textField.getText();
                String newText = oldText + generalOperationObject;
                String currentText = textField.getText();
                firstDouble = Double.parseDouble(currentText);
                textField.setText("");
                historyString.append(newText);
                historyField.setText(historyString.toString());
                decimalClick=0;
                break;
                default:

        }
    }

}
