package codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public String calculator(String number1, String number2, Character character) {
        String result = null;
        switch (character) {
            case '+':
                try {
                    result = String.valueOf(Integer.parseInt(number1)+ Integer.parseInt(number2));
                }catch (NumberFormatException numberFormatException){
                    result  = "number1 and number not empty";
                }
                break;
            case '-':
                try {
                    result = String.valueOf(Integer.parseInt(number1) -Integer.parseInt(number2));
                }catch (NumberFormatException numberFormatException){
                    result  = "number1 and number not empty";
                }
                break;
            case '*':
                try {
                    result = String.valueOf(Integer.parseInt(number1) * Integer.parseInt(number2));
                }catch (NumberFormatException numberFormatException){
                    result  = "number1 and number not empty";
                }
                break;
            case '/':
                try {
                    result = String.valueOf(Integer.parseInt(number1) / Integer.parseInt(number2));
                }catch (NumberFormatException numberFormatException){
                    result  = "number1 and number not empty";
                }
                break;
            default:
                break;
        }
        return result;
    }


}
