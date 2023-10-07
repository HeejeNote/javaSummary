package summary.codeModifyHandling.codeCoverage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MeetingTest {

    /**
     * jacoco 리커버리 체크하기 위해 테스트 작성
     */

    @Test
    public void isFull() {
        // given
        Meeting meeting = new Meeting();

        // when
        meeting.maxMeetCount = 100;
        meeting.meetCount = 10;

        // then
        assertFalse(meeting.isFullCountCheck());
    }
}