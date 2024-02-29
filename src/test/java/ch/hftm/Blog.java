package ch.hftm;

public class Blog {
    
    private long id;

    private String title;

    private String content;

    private boolean isValid = false;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
        this.isValid = false;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean getIsValid(){
        return this.isValid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setIsValid(boolean isValid){
        this.isValid = isValid;
    }
}
