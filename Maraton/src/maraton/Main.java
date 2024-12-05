/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maraton;

import javax.swing.JOptionPane;

/**
 *
 * @author tamar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Maraton maraton = new Maraton(100); // Máximo 100 participantes
       // Generar datos iniciales
       maraton.registrarParticipante(new Participante("Jimena Leon", 17, 1, 230));
       maraton.registrarParticipante(new Participante("Richard Ruiz", 25, 2, 170));
       maraton.registrarParticipante(new Participante("David Nuñez", 45, 3, 210));
       int opcion;
       do {
           opcion = Integer.parseInt(JOptionPane.showInputDialog(
               "MARATON 2024, BIENVENIDO\n\n"+
               "Menú:\n" +
               "1. Registrar participante\n" +
               "2. Buscar participante por numero\n" +
               "3. Listar participantes por categoria\n" +
               "4. Eliminar participante\n" +
               "5. Generar tiempos reales\n" +
               "6. Mostrar primeros tres lugares\n" +
               "7. Generar reporte final\n" +
               "0. Salir"
           ));
           switch (opcion) {
               case 1 -> {
                   String nombre = JOptionPane.showInputDialog("Nombre completo:");
                   int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                   int numero = Integer.parseInt(JOptionPane.showInputDialog("Numero de corredor:"));
                   int tiempoEstimado = Integer.parseInt(JOptionPane.showInputDialog("Tiempo estimado (min):"));
                   maraton.registrarParticipante(new Participante(nombre, edad, numero, tiempoEstimado));
               }
               case 2 -> {
                   int numeroBuscar = Integer.parseInt(JOptionPane.showInputDialog("Numero de corredor:"));
                   Participante encontrado = maraton.buscarPorNumero(numeroBuscar);
                   JOptionPane.showMessageDialog(null, (encontrado == null ? "No encontrado" : encontrado));
               }
               case 3 -> {
                   String categoria = JOptionPane.showInputDialog("Categoria (Juvenil/Adulto/Master):");
                   maraton.listarPorCategoria(categoria);
               }
               case 4 -> {
                   int numeroEliminar = Integer.parseInt(JOptionPane.showInputDialog("Numero de corredor:"));
                   maraton.eliminarParticipante(numeroEliminar);
               }
               case 5 -> maraton.generarTiemposReales();
               case 6 -> maraton.mostrarPrimerosLugares();
               case 7 -> maraton.generarReporte();
               case 0 -> JOptionPane.showMessageDialog(null, "Gracias, nos vemos en la proxima maraton!");
               default -> JOptionPane.showMessageDialog(null, "Opción invalida. Digite otra opcion");
           }
       } while (opcion != 0);
   }
}
