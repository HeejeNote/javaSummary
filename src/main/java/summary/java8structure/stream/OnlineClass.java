package summary.java8structure.stream;

public class OnlineClass {

    Long id; // id
    String title; // 제목
    boolean closed; // 강의 신청 마감 여부

    public OnlineClass(Long id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }
}
