package baseball.number_inspector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseNumberInspectorTest {

    @Test
    void 사용자가_입력한_값이_정답_값과_일치하는_숫자가_없으면_낫싱(){

        int src = 123;
        int dst = 456;

        BaseNumberInspector baseNumberInspector = new BaseNumberInspector();
        baseNumberInspector.inspect(src,dst);

        Assertions.assertEquals(baseNumberInspector.getOutput(),"낫싱");

    }

    @Test
    void 볼과_스트라이크_갯수만큼_출력(){

        int dst = 456;
        int ball_1 = 612;
        int ball_2 = 534;
        int ball_3 = 645;
        int strike_1 = 412;
        int strike_2 = 451;
        int strike_3 = 456;

        BaseNumberInspector baseNumberInspector = new BaseNumberInspector();

        baseNumberInspector.inspect(ball_1,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"1볼 ");
        baseNumberInspector.inspect(ball_2,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"2볼 ");
        baseNumberInspector.inspect(ball_3,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"3볼 ");
        baseNumberInspector.inspect(strike_1,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"1스트라이크");
        baseNumberInspector.inspect(strike_2,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"2스트라이크");
        baseNumberInspector.inspect(strike_3,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"3스트라이크");

    }

    @Test
    void 볼_스트라이크_복합_출력(){

        int dst = 456;
        int ball_1_strike_1 = 467;
        int ball_2_strike_1 = 654;

        BaseNumberInspector baseNumberInspector = new BaseNumberInspector();

        baseNumberInspector.inspect(ball_1_strike_1,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"1볼 1스트라이크");
        baseNumberInspector.inspect(ball_2_strike_1,dst);
        Assertions.assertEquals(baseNumberInspector.getOutput(),"2볼 1스트라이크");


    }


}
