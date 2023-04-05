package bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Log implements Serializable {
    private int id;
    private LocalDateTime createDate;
    private Source source;
    private int severityLevel;
    private Event event;

    public Log() {
    }

    public Log(int id, LocalDateTime createDate, Source source, int severityLevel, Event event) {
        this.id = id;
        this.createDate = createDate;
        this.source = source;
        this.severityLevel = severityLevel;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(int severityLevel) {
        this.severityLevel = severityLevel;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", source=" + source +
                ", severityLevel=" + severityLevel +
                ", event=" + event +
                '}';
    }
}
