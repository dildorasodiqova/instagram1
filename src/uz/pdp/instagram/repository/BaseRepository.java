package uz.pdp.instagram.repository;

import java.util.ArrayList;
import java.util.UUID;

public interface BaseRepository <T>{
    ArrayList<T> getAll();
    int save (T t);
    T getById(UUID uuid);
    void  remove (UUID uuid);
    void remove(T t);
    ArrayList<T> getArrayById(UUID uuid);

}
