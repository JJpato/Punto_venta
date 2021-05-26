package Modelo;

import java.util.List;

public interface DAO<T>{
    public List listar(); 
    public T encontrar(int nc);
    public int insertar(T a);
    public int actualizar(T a);
    public int eliminar(int nc);
}
