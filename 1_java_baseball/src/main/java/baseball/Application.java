package baseball;

import baseball.game_machine.GameMachine;
import baseball.input_inspector.BaseInputInspector;
import baseball.number_inspector.BaseNumberInspector;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameMachine gameMachine = new GameMachine(3, new BaseInputInspector(), new BaseNumberInspector());
        gameMachine.run();
    }
}
