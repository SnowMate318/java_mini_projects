package baseball.game_machine;

import baseball.input_inspector.BaseInputInspector;
import baseball.input_inspector.InputInspector;
import baseball.number_inspector.NumberInspector;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class GameMachine {

    private static final String END = "3스트라이크";
    private final int numberLengthForGame;
    private int generatedNumber;

    InputInspector inputInspector;
    NumberInspector numberInspector;

    public GameMachine(int numberLengthForGame, InputInspector inputInspector, NumberInspector numberInspector){
        this.numberLengthForGame = numberLengthForGame;
        this.inputInspector = inputInspector;
        this.numberInspector = numberInspector;
        this.inputInspector.setLength(numberLengthForGame);
    }



    public void run() {

        while(true){
            init();
            while(true){

                if(getTurn()) break;

            }
            if(!endGameAndQuestionUserToReplay()) break;
        }

    }

    private void init(){
        generateNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private boolean getTurn(){

        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        inputInspector.inspect(userInput);
        numberInspector.inspect(Integer.parseInt(userInput),generatedNumber);
        String output = numberInspector.getOutput();
        System.out.println(output);

        return output.equals(END);
    }

    private boolean endGameAndQuestionUserToReplay(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        while(true){
            String userInput = Console.readLine();
            if(userInput.equals("1")){
                return true;
            }
            if(userInput.equals("2")){
                return false;
            }

        }


    }


    private void generateNumber() {
        int minNum = 1;
        int maxNum = 9;

        for(int i=1;i<numberLengthForGame;i++){
            minNum*=10;
            maxNum=maxNum*10+9;
        }

        generatedNumber = Randoms.pickNumberInRange(minNum, maxNum);
    }


}
