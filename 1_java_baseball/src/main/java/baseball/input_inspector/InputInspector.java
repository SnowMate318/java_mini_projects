package baseball.input_inspector;

public class InputInspector {

    public InputInspector() {

    }

    public void inspect(String userInput) throws IllegalArgumentException{

        String input = userInput.trim();
        inspectFormat(input);
        inspectLength(input);

    }

    private void inspectFormat(String input){
        try {
            //숫자가 아닐경우
            int result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야합니다.");
        }
    }

    private void inspectLength(String input){
        //3자리 숫자가 아닐경우
        if(input.length()!=3){
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
    }


}
