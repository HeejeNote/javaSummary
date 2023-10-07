package summary.codeModifyHandling.codeCoverage;

/**
 * jacoco :::
 * 코드 리버커리 분석 오픈 소스 라이브러리
 */
public class Meeting {

    /**
     * jacoco 코드 리버커리 테스트를 위한 클래스 생성
     */
    int maxMeetCount; // 최대 모임 참가원 수
    int meetCount; // 참가원 수

    public boolean isFullCountCheck(){
        if(maxMeetCount == 0){
            return false;
        }

        if(meetCount < maxMeetCount){
            return false;
        }
        return true;
    }

}
