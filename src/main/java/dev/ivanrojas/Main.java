package dev.ivanrojas;

import java.util.Scanner;

public class Main {

  static ArregloEstudiantes arregloEstudiantes = new ArregloEstudiantes();
  static Scanner sc = new Scanner(System.in);


  public static void main(String[] args) {
    sc.useDelimiter("\n");
    int option = 0;

    do {
      System.out.println("\n----- Menú de Opciones -----");
      System.out.println("[1] AGREGAR");
      System.out.println("[2] ELIMINAR");
      System.out.println("[3] BUSCAR");
      System.out.println("[4] MODIFICAR");
      System.out.println("[5] LISTAR");
      System.out.println("[6] SALIR");

      System.out.print("Ingrese una opcion: ");
      option = sc.nextInt();

      switch (option) {
        case 1:
          agregar();
          break;
        case 2:
          eliminar();
          break;
        case 3:
          buscar();
          break;
        case 4:
          modificar();
          break;
        case 5:
          listar();
          break;
        case 6:
          break;
      }
    } while (option != 6);
  }

  private static void agregar() {
    System.out.print("Ingrese dni de estudiante: ");
    String dni = sc.next();

    Estudiante objEstudiante = arregloEstudiantes.buscar(dni);
    if (objEstudiante == null) {
      System.out.print("Ingrese nombre de estudiante: ");
      String nombre = sc.next();
      System.out.print("Ingrese apellido de estudiante: ");
      String apellido = sc.next();
      System.out.print("Ingrese edad de estudiante: ");
      int edad = sc.nextInt();

      Estudiante a = new Estudiante(dni, nombre, apellido, edad);
      arregloEstudiantes.Adicionar(a);
      System.out.println("Estudiante registrado correctamente");
    } else {
      System.out.println("Estudiante ya se encuentra registrado");
    }
  }

  private static void eliminar() {
    System.out.print("Ingrese dni de estudiante a eliminar: ");
    String dni = sc.next();
    Estudiante estudiante = arregloEstudiantes.buscar(dni);
    if (estudiante != null) {
      arregloEstudiantes.eliminar(estudiante);
      System.out.println("Estudiante eliminado correctamente");
    } else {
      System.out.println("DNI de estudiante no existe");
    }
  }

  private static void buscar() {
    System.out.print("Ingrese dni de estudiante a buscar: ");
    String dni = sc.next();
    Estudiante estudiante = arregloEstudiantes.buscar(dni);
    if (estudiante != null) {
      System.out.println(estudiante.toString());
    } else {
      System.out.println("DNI de estudiante no existe");
    }
  }

  public static void modificar() {
    System.out.print("Ingrese dni de estudiante a modificar: ");
    String dni = sc.next();
    Estudiante estudiante = arregloEstudiantes.buscar(dni);
    if (estudiante != null) {
      System.out.print("Ingrese nuevo nombre: ");
      String nombre = sc.next();
      estudiante.setNombre(nombre);
      System.out.print("Ingrese nuevo apellido: ");
      String apellido = sc.next();
      estudiante.setApellido(apellido);
      System.out.print("Ingrese nueva edad: ");
      int edad = sc.nextInt();
      estudiante.setEdad(edad);
      System.out.println("Estudiante actualizado correctamente");
    } else {
      System.out.println("DNI de estudiante no existe");
    }
  }

  public static void listar() {
    if (arregloEstudiantes.size() > 0) {
      for (int i = 0; i < arregloEstudiantes.size(); i++) {
        Estudiante a = arregloEstudiantes.getEstudiante(i);
        System.out.print(a.getDni() + "\n" +
                a.getNombre() + "\n" +
                a.getApellido() + "\n" +
                a.getEdad() + "\n\n");
      }
    } else {
      System.out.println("No hay estudiantes registrados");
    }
  }


}