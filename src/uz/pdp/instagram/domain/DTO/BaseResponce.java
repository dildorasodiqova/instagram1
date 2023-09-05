package uz.pdp.instagram.domain.DTO;

public class BaseResponce<T> {
    private String massege;
    private T data;
    private int status;

    public BaseResponce(String message, T data, int status) {
        this.massege = message;
        this.data = data;
        this.status = status;
    }

    public BaseResponce(String message, int status) {
        this.massege = message;
        this.status = status;
    }

    public String getMessage() {
        return massege;
    }

    public void setMessage(String massege) {
        this.massege = massege;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
