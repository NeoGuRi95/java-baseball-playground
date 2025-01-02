package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<BallStatus> ballStatusList = new ArrayList<>();
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public void add(BallStatus ballStatus) {
        this.ballStatusList.add(ballStatus);
        if (ballStatus.isStrike()) {
            this.strikeCnt++;
        } else if (ballStatus.isBall()) {
            this.ballCnt++;
        }
    }

    public boolean isAnswer() {
        return this.strikeCnt == 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.ballCnt > 0) sb.append(this.ballCnt).append("볼 ");
        if (this.strikeCnt > 0) sb.append(this.strikeCnt).append("스트라이크");
        return sb.length() == 0 ? sb.append("낫싱").toString() : sb.toString().trim();
    }
}
