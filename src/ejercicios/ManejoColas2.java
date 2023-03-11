/*
 * Elaborar un programa en Java para el manejo de la estructura de datos Cola. 
 * Hacer esto usando la clase ArrayList. Los datos a ingresar son los nombres 
 * y el año de nacimiento de personas. El programa no puede permitir el ingreso 
 * de años negativos; ni tampoco nombres que contengan números.
 */
package ejercicios;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author scorpion
 */
public class ManejoColas2 {

    static ArrayList<Persona> cola = new ArrayList();
    static int inicio = 0;

    public static void main(String[] args) {
        int opcion = 0;
        String mensaje = "1. Insertar\n2. Sacar\n3. Visualizar\n4. Salir\n";
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje + "Ingrese una opción"));
            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    mostrarCola();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Finalizo Programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 4);
    }

    public static int devuelveAnio() {
        int numero, indicador = 0;
        String cadena_nueva = "", valor;
        do {
            valor = JOptionPane.showInputDialog(null, "Ingrese Año de nacimiento");
            for (int i = 0; i < valor.length(); i++) {
                char caracter = valor.substring(i, i + 1).charAt(0);
                if (caracter < '0' || caracter > '9') {
                    JOptionPane.showMessageDialog(null, "Solo debe escribir numeros", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
                    indicador = 1;
                    break;
                } else {
                    cadena_nueva += String.valueOf(caracter);
                    indicador = 0;
                }
            }
        } while (indicador == 1);
        numero = Integer.parseInt(cadena_nueva);
        return numero;
    }

    public static String devuelveTexto(String mensaje) {
        int indicador = 0;
        String texto_nuevo = "", texto;
        do {
            texto = JOptionPane.showInputDialog(null, mensaje);
            for (int i = 0; i < texto.length(); i++) {
                char caracter = texto.substring(i, i + 1).charAt(0);
                int letra = (int) caracter;
                if (letra >= 33 && letra < 65 || letra >= 91 && letra < 97 || letra >= 123 && letra < 128) {
                    JOptionPane.showMessageDialog(null, "No puede ingresar Caracteres especiales\nSólo letras!!!", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
                    indicador = 1;
                    break;
                } else {
                    texto_nuevo += String.valueOf(caracter);
                    indicador = 0;
                }
            }
        } while (indicador == 1);
        return texto_nuevo;
    }

    public static Persona registro() {
        Persona persona = new Persona();
        persona.setNombre(devuelveTexto("Ingrese Nombre"));
        persona.setApellido(devuelveTexto("Ingrese Apellido"));
        persona.setAnio(devuelveAnio());
        return persona;
    }

    public static void insertar() {
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cola vacía, se inicio el llenado");
            cola.add(registro());
            JOptionPane.showMessageDialog(null, "Se adiciono a la cola");
        } else {
            cola.add(registro());
            JOptionPane.showMessageDialog(null, "Se adiciono a la cola");
        }

    }

    public static void sacar() {
        ArrayList<Persona> aux = new ArrayList();
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cola vacía", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
        } else {
            if (cola.size() == 1) {
                cola.remove(0);
            } else {
                for (int i = 0; i < cola.size() - 1; i++) {
                    aux.add(cola.get(i + 1));
                }
            }
            JOptionPane.showMessageDialog(null, "Se elimino elemento de la cola");
            cola = aux;
        }
    }

    public static void mostrarCola() {
        String mensaje = "datos de la cola\n";
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "cola vacía", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < cola.size(); i++) {
                mensaje += "elemento " + (i + 1) + "--> Nombre : " + cola.get(i).getNombre() + ", Apellido : " + cola.get(i).getApellido() + ", Año nacimiento : " + cola.get(i).getAnio() + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

}
