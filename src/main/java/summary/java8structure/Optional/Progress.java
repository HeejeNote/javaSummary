package summary.java8structure.Optional;

import java.time.Duration;

public class Progress {
    
    private Duration studyDuration; // 공부 기간
    
    private boolean finished; // 완강 여부

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }

    public Duration getStudyDuration() {
        return studyDuration;
    }
}
