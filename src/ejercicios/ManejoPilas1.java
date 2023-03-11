/*
 * Elaborar un programa en Java para manejar una pila, en la cual se pueda 
 * apilar y desapilar. Usar sólo arreglos (No usar clases especiales como 
 * Vector, ArrayList, ni otras parecidas). Los datos de entrada los ingresa 
 * el usuario. Los datos a ingresar son números enteros, excepto el 0; si el 
 * usuario digita 0, el programa no puede permitir que ese número se apile y 
 * el programa debe volver preguntarle al usuario por un número.
 */
package ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author scorpion
 */
public class ManejoPilas1 {

    static final int MAXIMO = 1000;
    static int[] pila = new int[MAXIMO];

    public static void main(String[] args) {
        for (int i = 0; i < MAXIMO; i++) {
            pila[i] = 0;
        }
        int opcion;
        String mensaje = "1. Apilar\n2. Desapilar\n3. Mostrar pila\n4. Salir\n";
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje + "Ingrese una opción"));
//            opcion = validaNumero(mensaje);
            switch (opcion) {
                case 1:
                    apilar();
                    break;
                case 2:
                    desapilar();
                    break;
                case 3:
                    mostrarPila();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Finalizo Programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 4);
    }

    public static int devuelveNumero() {
        int numero, indicador = 0;
        String cadena_nueva = "", valor;
        do {
            //cadena_nueva ="";
            valor = JOptionPane.showInputDialog(null, "Ingrese un valor numérico");
            for (int i = 0; i < valor.length(); i++) {
                char caracter = valor.substring(i, i + 1).charAt(0);
                if (i == 0 && caracter == '-') {
                    cadena_nueva = "-";
                } else {
                    if (caracter < '0' || caracter > '9') {
                        JOptionPane.showMessageDialog(null, "Solo debe escribir numeros", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
                        indicador = 1;
                        break;
                    } else {
                        cadena_nueva += String.valueOf(caracter);
                        indicador = 0;
                    }
                }
            }
        } while (indicador == 1);
        numero = Integer.parseInt(cadena_nueva);
        return numero;
    }

//    public static int validaNumero(String mensaje) {
//        int numero, indicador = 0;
//        String cadena_nueva = "", valor;
//        do {
//            valor = JOptionPane.showInputDialog(null, mensaje+"Ingrese una opción");
//            for (int i = 0; i < valor.length(); i++) {
//                char caracter = valor.substring(i, i + 1).charAt(0);
//                if (caracter < '0' || caracter > '9') {
//                    JOptionPane.showMessageDialog(null, "Solo debe escribir numeros", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
//                    indicador = 1;
//                    break;
//                } else {
//                    cadena_nueva += String.valueOf(caracter);
//                    indicador = 0;
//                }
//            }
//        } while (indicador == 1);
//        numero = Integer.parseInt(cadena_nueva);
//        return numero;
//    }

    public static void apilar() {
        int numero;
        do { 
            numero = devuelveNumero();
            if (numero != 0) {
                if (pila[0] == 0) {
                    pila[0] = numero;
                    JOptionPane.showMessageDialog(null, "Se adiciono a la pila");
                } else {
                    for (int i = 0; i < pila.length; i++) {
                        if (pila[i] == 0) {
                            pila[i] = numero;
                            JOptionPane.showMessageDialog(null, "Se adiciono a la pila");
                            break;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El 0 no se puede apilar", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
            }
        } while (numero == 0);
    }

    public static void desapilar() {
        int cuenta = 0;
        if (pila[0] == 0) {
            JOptionPane.showMessageDialog(null, "No se puede desapilar", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < pila.length; i++) {
                if (pila[i] != 0) {
                    cuenta++;
                }
            }
            if (cuenta == 1) {
                for (int i = 0; i < 1000; i++) {
                    pila[i] = 0;
                }
            } else {
                for (int i = 0; i < 1000; i++) {
                    if (i == cuenta - 1) {
                        pila[i] = 0;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Se elimino elemento de la pila");
        }
    }

    public static void mostrarPila() {
        String mensaje = "datos de la pila\n";
        if (pila[0] == 0) {
            JOptionPane.showMessageDialog(null, "Pila vacia", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = pila.length - 1; i >= 0; i--) {
                if (pila[i] != 0) {
                    mensaje += pila[i] + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

}
