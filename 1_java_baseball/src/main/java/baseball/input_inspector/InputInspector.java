package baseball.input_inspector;

public class InputInspector {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 8;

    private final int length;

    public InputInspector(int length) {

        if(notInScope(length)){
            throw new IllegalArgumentException("입력 검사기의 검사 가능 길이는 1~8입니다.");
        }
        this.length = length;

    }

    public void inspect(String userInput) throws IllegalArgumentException{

        String input = userInput.trim();
        inspectFormat(input);
        inspectLength(input);

    }

    private boolean notInScope(int length){
        return !(MIN_LENGTH<=length && length <=MAX_LENGTH);
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
        if(input.length()!=length){
            throw new IllegalArgumentException(length+"자리 숫자가 아닙니다.");
        }
    }


}
