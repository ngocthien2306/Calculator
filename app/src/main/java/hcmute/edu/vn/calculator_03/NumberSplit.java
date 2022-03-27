package hcmute.edu.vn.calculator_03;

import java.util.ArrayList;
import java.lang.StringBuffer;
public class NumberSplit {
    public String CurrentNumber;
    public ArrayList ListNumber;
    public String[] ListOperator;

    public NumberSplit(String currentNumber, ArrayList listNumber, String[] listOperator) {
        CurrentNumber = currentNumber;
        ListNumber = listNumber;
        ListOperator = listOperator;
    }
    public NumberSplit() {

    }

    public String getCurrentNumber() {
        return CurrentNumber;
    }

    public void setCurrentNumber(String currentNumber) {
        CurrentNumber = currentNumber;
    }

    public ArrayList getListNumber() {
        return ListNumber;
    }

    public void setListNumber(ArrayList listNumber) {
        ListNumber = listNumber;
    }

    public String[] getListOperator() {
        return ListOperator;
    }

    public void setListOperator(String[] listOperator) {
        ListOperator = listOperator;
    }


}
