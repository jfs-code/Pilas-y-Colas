/*
 * Elaborar un programa en Java para el manejo de la estructura de datos Cola. 
 * Hacer esto usando arreglos (No usar clases especiales como Vector, ArrayList,
 * ni otras parecidas). Los datos a ingresar son números pares; si el usuario 
 * ingresa un impar, el programa no puede poner ese número en la cola, y el 
 * programa debe volver preguntarle al usuario por un número.
 */
package ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author scorpion
 */
public class ManejoColas1 {

    static int[] cola = new int[1000];
    static int inicio = 0;

    public static void main(String[] args) {
        int opcion;
        for (int i = 0; i < 1000; i++) {
            cola[i] = 0;
        }
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

    public static int devuelveNumeroPar() {
        int numero, indicador = 0;
        String cadena_nueva = "", valor;
        do {
            valor = JOptionPane.showInputDialog(null, "Ingrese un valor numérico par");
            for (int i = 0; i < valor.length(); i++) {
                char caracter = valor.substring(i, i + 1).charAt(0);
                if (i == 0 && caracter == '-') {
                    cadena_nueva = "-";
                } else {
                    if (caracter < '0' || caracter > '9') {
                        JOptionPane.showMessageDialog(null, "Solo debe escribir numeros pares", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
                        indicador = 1;
                        break;
                    } else {
                        cadena_nueva += String.valueOf(caracter);
                    }
                }
            }
            if (Integer.parseInt(cadena_nueva) % 2 == 0) {
                indicador = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Solo debe escribir numeros pares", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
                indicador = 1;
                cadena_nueva="";
            }
        } while (indicador == 1);
        numero = Integer.parseInt(cadena_nueva);
        return numero;
    }

    public static void insertar() {
        int numero;
        do {
            numero = devuelveNumeroPar();
            if (numero != 0) {
                if (cola[0] == 0) {
                    JOptionPane.showMessageDialog(null, "Cola vacía, se inicio el llenado");
                    cola[0] = numero;
                    JOptionPane.showMessageDialog(null, "Se adiciono a la cola");
                } else {
                    for (int i = 0; i < cola.length; i++) {
                        if (cola[i] == 0) {
                            cola[i] = numero;
                            JOptionPane.showMessageDialog(null, "Se adiciono a la cola");
                            break;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El 0 no se puede apilar", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
            }
        } while (numero == 0);
    }

    public static void sacar() {
        if (cola[inicio] == 0) {
            JOptionPane.showMessageDialog(null, "Cola vacía", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < cola.length; i++) {
                if (i == cola.length - 1) {
                    cola[i] = 0;
                } else {
                    cola[i] = cola[i + 1];
                }
            }
            JOptionPane.showMessageDialog(null, "Se elimino elemento de la cola");
        }
    }

    public static void mostrarCola() {
        String mensaje = "datos de la cola\n";
        if (cola[inicio] == 0) {
            JOptionPane.showMessageDialog(null, "cola vacía", "Ventana Error cola", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < cola.length; i++) {
                if (cola[i] != 0) {
                    mensaje += cola[i] + " , ";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

}
