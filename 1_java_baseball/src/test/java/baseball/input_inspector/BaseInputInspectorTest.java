package baseball.input_inspector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseInputInspectorTest {

    @Test
    void 입력_검사기의_검사가능_길이는_1에서_8이다(){

        int shortLen = 0;
        int minLen = 1;
        int maxLen = 8;
        int longLen = 9;

        Assertions.assertThrows(IllegalArgumentException.class,()->new BaseInputInspector(shortLen));
        Assertions.assertDoesNotThrow(()->new BaseInputInspector(minLen));
        Assertions.assertDoesNotThrow(()->new BaseInputInspector(maxLen));
        Assertions.assertThrows(IllegalArgumentException.class,()->new BaseInputInspector(longLen));

    }

    @Test
    void 사용자가_사전에_등록한_길이와_같은_길이의_숫자를_입력해야_한다(){

        int length = 3;
        String shortNum = "12";
        String goodNum = "123";
        String longNum = "1234";

        BaseInputInspector baseInputInspector = new BaseInputInspector(length);

        Assertions.assertThrows(IllegalArgumentException.class, ()-> baseInputInspector.inspect(shortNum));
        Assertions.assertDoesNotThrow(()-> baseInputInspector.inspect(goodNum));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> baseInputInspector.inspect(longNum));

    }

    @Test
    void 사용자가_입력한_값이_숫자가_아니면_오류_발생(){

        int length = 3;
        String wrongInput = "1ab";

        BaseInputInspector baseInputInspector = new BaseInputInspector(length);

        Assertions.assertThrows(IllegalArgumentException.class, ()-> baseInputInspector.inspect(wrongInput));

    }

}
