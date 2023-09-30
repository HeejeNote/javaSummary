package summary.java8structure.Optional;

import java.util.Optional;

public class OnlineClass {
    Long id; // id
    String title; // 제목
    boolean closed; // 강의 신청 마감 여부
    public Progress progress;

    public OnlineClass(Long id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress(){
        return Optional.ofNullable(progress); // Optional.of()는 null이 아님을 가정하기에 null 체크가 되지 않음.
    }

//    public Progress getProgress() {
//        if(this.progress == null){
//            throw new IllegalStateException(); // null 일 경우에는 예외 처리
//        }
//        return progress; // 참조타입은 기본값이 null
//    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    /**
     * 파라미터에 Optional은 사용가능? 가능하다.
     * -> 하지만 return 타입으로만 사용하는 것이 좋다.
     * -> 파라미터에 null이 들어가면 null 체크를 해야한다.
     */
//    public void setProgress(Optional<Progress> progress){
//        if(progress != null) { // Optional 타입을 파라미터로 받으면
//            progress.isPresent(p -> this.progress = p);
//        }
//        //this.progress = progress.get();
//    }


}
