package dev.ivanrojas;

import java.util.ArrayList;

public class ArregloEstudiantes {

  private ArrayList<Estudiante> estudiantes;

  public ArregloEstudiantes() {
    estudiantes = new ArrayList<>();
  }

  public int size(){
    return estudiantes.size();
  }

  public Estudiante getEstudiante(int pos){
    return estudiantes.get(pos);
  }

  public void Adicionar(Estudiante estudiante) {
    estudiantes.add(estudiante);
  }

  public void eliminar(Estudiante estudiante) {
    estudiantes.remove(estudiante);
  }

  public Estudiante buscar(String dni) {
    for (Estudiante estudiante : estudiantes) {
      if (estudiante.getDni().equals(dni)) {
        return estudiante;
      }
    }
    return null;
  }
}
