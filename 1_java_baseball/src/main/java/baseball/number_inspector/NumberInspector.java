package baseball.number_inspector;

public class NumberInspector {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static final int MAX_SCOPE = 100000000;

    private int strike;
    private int ball;

    public NumberInspector() {
        this.strike = 0;
        this.ball = 0;
    }


    public void inspect(int src, int dst){

        String srcString = String.valueOf(src);
        String dstString = String.valueOf(dst);

        if(srcString.length()!=dstString.length()){
            throw new IllegalArgumentException("입력한 값과 검사할 값의 길이는 동일해야 합니다.");
        }

        if(src>=MAX_SCOPE || dst>=MAX_SCOPE){
            throw new IllegalArgumentException("1억 이상의 값은 등록할 수 없습니다.");
        }

        strike = strikeInspect(srcString, dstString);
        ball = ballOrStrikeInspect(src, dst) - strikeInspect(srcString, dstString);

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

    private int ballOrStrikeInspect(int src, int dst) {

        int ballOrStrike = 0;
        int[] numbs = new int[10];

        while(dst > 0){
            numbs[dst%10]++;
            dst/=10;
        }

        while(src > 0){
            if(numbs[src%10]>0){
                numbs[src%10]--;
                ballOrStrike++;
            }
            src/=10;
        }

        return ballOrStrike;
    }

    private int strikeInspect(String src, String dst) {
        int strike = 0;

        for(int i=0;i<src.length();i++){
            if(src.charAt(i)==dst.charAt(i)){
                strike++;
            }
        }

        return strike;
    }






}
