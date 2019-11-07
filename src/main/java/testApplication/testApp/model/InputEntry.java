package testApplication.testApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entries")
public class InputEntry {
    @Id
    private long id;
    private String content;

    public InputEntry() {
    }

    @Override
    public String toString() {
        return "InputEntry: " + id + " " + content;
    }

    public InputEntry(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

