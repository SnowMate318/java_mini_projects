package baseball.input_inspector;

import baseball.input_inspector.InputInspector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputInspectorTest {

    InputInspector inputInspector = new InputInspector();

    @Test
    void 사용자가_3자리_숫자를_입력했는지_확인(){

        String shortNum = "12";
        String goodNum = "123";
        String longNum = "1234";

        Assertions.assertThrows(IllegalArgumentException.class, ()->inputInspector.inspect(shortNum));
        Assertions.assertDoesNotThrow(()->inputInspector.inspect(goodNum));
        Assertions.assertThrows(IllegalArgumentException.class, ()->inputInspector.inspect(longNum));

    }

    @Test
    void 사용자가_입력한_값이_숫자가_아니면_오류_발생(){

        String wrongInput = "1ab";

        Assertions.assertThrows(IllegalArgumentException.class, ()->inputInspector.inspect(wrongInput));

    }

}
