/*
 * Elaborar un programa en Java para manejar una pila, en la cual se pueda 
 * apilar, desapilar y buscar si un elemento existe en la pila. Usar la clase 
 * Stack. Los datos de entrada los ingresa el usuario. El proceso buscar 
 * elemento significa que después de ingresar los datos, el programa le 
 * pregunta al usuario por un elemento a buscar; si el elemento está en la 
 * pila, el programa responde que sí lo encontró. Los datos a ingresar son 
 * números enteros, excepto el 0; si el usuario digita 0, el programa no puede 
 * permitir que ese número se apile y el programa debe volver preguntarle al 
 * usuario por un número.
 */
package ejercicios;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author scorpion
 */
public class ManejoPilas2 {

    static Stack<Integer> pila = new Stack<Integer>();

    public static void main(String[] args) {
        int opcion;
        String mensaje = "1. Apilar\n2. Desapilar\n3. Mostrar pila\n4. Buscar elemento\n5. Salir\n";
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje + "Ingrese una opción"));
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
                    buscarElemento();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Finalizo Programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 5);
    }

    public static int devuelveNumero(String mensaje) {
        int numero, indicador = 0;
        String cadena_nueva = "", valor;
        do {
            valor = JOptionPane.showInputDialog(null, mensaje);
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

    public static void apilar() {
        int numero;
        do {
            numero = devuelveNumero("Ingrese un valor numérico");
            if (numero != 0) {
                pila.push(numero);
            } else {
                JOptionPane.showMessageDialog(null, "El 0 no se puede apilar", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
            }
        } while (numero == 0);
    }

    public static void desapilar() {
        int cuenta = 0; 
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede desapilar", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
        } else {
            pila.pop();
            JOptionPane.showMessageDialog(null, "Se elimino elemento de la pila");
        }
    }

    public static void mostrarPila() {
        int vector[] = new int[pila.size()];
        String mensaje = "datos de la pila\n";
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pila vacia", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
        } else {
//            for (int i = 0; i < pila.size(); i++) {
//                vector[i] = pila.elementAt(i);
//            }
//            for (int i = vector.length - 1; i >= 0; i--) {
//                mensaje += vector[i] + "\n";
//            }
            for (int i = pila.size() - 1; i >= 0; i--) {
                mensaje += pila.elementAt(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public static void buscarElemento() {
        int numero, bandera = 0;
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pila vacia", "Ventana Error Pila", JOptionPane.ERROR_MESSAGE);
        } else {
            do {
                numero = devuelveNumero("Ingrese elemento a buscar");
                for (int i = 0; i < pila.size(); i++) {
                    if (numero == pila.elementAt(i)) {
                        bandera = 1;
                    }
                }
                if (bandera == 1) {
                    JOptionPane.showMessageDialog(null, "El elemento si esta en la pila");
                } else {
                    JOptionPane.showMessageDialog(null, "El elemento no esta en la pila");
                }
            } while (numero == 0);
        }
    }

}
