package domain;

public class Archive {
    private int id;
    private String title;
    private String dateOfCreate;
    private String data;

    public Archive() {
    }

    public Archive(String title, String dateOfCreate, String data) {
        this.title = title;
        this.dateOfCreate = dateOfCreate;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(String dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data){
        this.data = data;
    }


    @Override
    public String toString() {
        return "\nАрхив{" +
                "id=" + id +
                ",название='" + title + '\'' +
                ",датаСоздания='" + dateOfCreate + '\'' +
                ",данные='" + data + '\'' +
                "}";
    }
}
