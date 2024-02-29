package ch.hftm;

public class TextValidatorResponseDto {

    private long sourceId;
    private String text;
    public boolean valid;

    public long getId() {
        return sourceId;
    }

    public void setId(long sourceId) {
        this.sourceId = sourceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
