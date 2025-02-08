package baseball.input_inspector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputInspectorTest {

    @Test
    void 입력_검사기의_검사가능_길이는_1에서_8이다(){

        int shortLen = 0;
        int minLen = 1;
        int maxLen = 8;
        int longLen = 9;

        Assertions.assertThrows(IllegalArgumentException.class,()->new InputInspector(shortLen));
        Assertions.assertDoesNotThrow(()->new InputInspector(minLen));
        Assertions.assertDoesNotThrow(()->new InputInspector(maxLen));
        Assertions.assertThrows(IllegalArgumentException.class,()->new InputInspector(longLen));

    }

    @Test
    void 사용자가_사전에_등록한_길이와_같은_길이의_숫자를_입력해야_한다(){

        int length = 3;
        String shortNum = "12";
        String goodNum = "123";
        String longNum = "1234";

        InputInspector inputInspector = new InputInspector(length);

        Assertions.assertThrows(IllegalArgumentException.class, ()->inputInspector.inspect(shortNum));
        Assertions.assertDoesNotThrow(()->inputInspector.inspect(goodNum));
        Assertions.assertThrows(IllegalArgumentException.class, ()->inputInspector.inspect(longNum));

    }

    @Test
    void 사용자가_입력한_값이_숫자가_아니면_오류_발생(){

        int length = 3;
        String wrongInput = "1ab";

        InputInspector inputInspector = new InputInspector(length);

        Assertions.assertThrows(IllegalArgumentException.class, ()->inputInspector.inspect(wrongInput));

    }

}
