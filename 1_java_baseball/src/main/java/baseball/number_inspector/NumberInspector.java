package baseball.number_inspector;

public class NumberInspector {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static final int LENGTH = 3;

    private int strike;
    private int ball;

    public NumberInspector() {
        this.strike = 0;
        this.ball = 0;
    }


    public void inspect(int src, int dst){

        strike = strikeInspect(String.valueOf(src), String.valueOf(dst));
        ball = ballOrStrikeInspect(String.valueOf(src), dst) - strikeInspect(String.valueOf(src), String.valueOf(dst));

    }

    public String getOutput() {

        if(strike==0 && ball == 0){
            return NOTHING;
        }
        StringBuilder sb = new StringBuilder();

        if(ball>0){
            sb.append(ball).append(BALL+" ");
        }
        if(strike>0){
            sb.append(strike).append(STRIKE);
        }

        return sb.toString();
    }

    private int ballOrStrikeInspect(String src, int dst) {

        int ballOrStrike = 0;
        int srcInt = Integer.parseInt(src);
        int[] numbs = new int[10];

        while(dst > 0){
            numbs[dst%10]++;
            dst/=10;
        }

        while(srcInt > 0){
            if(numbs[srcInt%10]>0){
                numbs[srcInt%10]--;
                ballOrStrike++;
            }
            srcInt/=10;
        }

        return ballOrStrike;
    }

    private int strikeInspect(String src, String dst) {
        int strike = 0;

        for(int i=0;i<LENGTH;i++){
            if(src.charAt(i)==dst.charAt(i)){
                strike++;
            }
        }

        return strike;
    }






}
