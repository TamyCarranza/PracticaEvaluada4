/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maraton;

/**
 *
 * @author tamar
 */
public class Maraton {
   private Participante[] participantes;
   private int contador;

   //MAX DE PARTICIPANTES
   public Maraton(int maxParticipantes) {
       this.participantes = new Participante[maxParticipantes];
       this.contador = 0;
   }
   // REGISTRO DE NUEVO PARTICIPANTE
   public void registrarParticipante(Participante participante) {
       if (contador >= participantes.length) {
           System.out.println("No se pueden registrar mas participantes.");
           return;
       }
       for (int i = 0; i < contador; i++) {
           if (participantes[i].getNumeroCorredor() == participante.getNumeroCorredor()) {
               System.out.println("El número de corredor ya se encuentra registrado.");
               return;
           }
       }
       participantes[contador++] = participante;
       System.out.println("Participante registrado con exito!");
   }
   // BUSCAR PARTI POR EL NUMERO
   public Participante buscarPorNumero(int numeroCorredor) {
       for (int i = 0; i < contador; i++) {
           if (participantes[i].getNumeroCorredor() == numeroCorredor) {
               return participantes[i];
           }
       }
       return null;
   }
   // LISTA POR CATEGORIAS
   public void listarPorCategoria(String categoria) {
       System.out.println("Participantes en la categoría " + categoria + ":");
       for (int i = 0; i < contador; i++) {
           if (participantes[i].getCategoria().equalsIgnoreCase(categoria)) {
               System.out.println(participantes[i]);
           }
       }
   }
   // ELIMINAR PARTICIPANTE
   public void eliminarParticipante(int numeroCorredor) {
       for (int i = 0; i < contador; i++) {
           if (participantes[i].getNumeroCorredor() == numeroCorredor) {
               participantes[i] = participantes[contador - 1]; // Reemplaza el eliminado con el último
               participantes[contador - 1] = null; // Limpia el último
               contador--;
               System.out.println("Participante eliminado.");
               return;
           }
       }
       System.out.println("No se encontró el participante.");
   }
   // GENERAR TIEMPOS REALES 
   public void generarTiemposReales() {
       for (int i = 0; i < contador; i++) {
           participantes[i].generarTiempoReal();
       }
       System.out.println("Tiempos reales generados.");
   }
   //TOP 3
   public void mostrarPrimerosLugares() {
       if (contador < 3) {
           System.out.println("No hay suficientes participantes para mostrar los tres primeros lugares.");
           return;
       }
       // se copian participantes a un nuevo arreglo para ordenar
       Participante[] copia = new Participante[contador];
       System.arraycopy(participantes, 0, copia, 0, contador);
       // ordenar el arreglo por tiempo real
       for (int i = 0; i < copia.length - 1; i++) {
           for (int j = 0; j < copia.length - 1 - i; j++) {
               if (copia[j].getTiempoReal() > copia[j + 1].getTiempoReal()) {
                   Participante temp = copia[j];
                   copia[j] = copia[j + 1];
                   copia[j + 1] = temp;
               }
           }
       }
       System.out.println("Los rimeros tres lugares son:");
       for (int i = 0; i < Math.min(3, contador); i++) {
           System.out.println(copia[i]);
       }
   }
   // Reporte final
   public void generarReporte() {
       int total = contador;
       System.out.println("Total de participantes registrados: " + total);
       int sumaJuvenil = 0, sumaAdulto = 0, sumaMaster = 0;
       int countJuvenil = 0, countAdulto = 0, countMaster = 0;
       Participante mejorEstimado = participantes[0];
       for (int i = 0; i < contador; i++) {
           Participante p = participantes[i];
           switch (p.getCategoria()) {
               case "Juvenil" -> {
                   sumaJuvenil += p.getTiempoEstimado();
                   countJuvenil++;
               }
               case "Adulto" -> {
                   sumaAdulto += p.getTiempoEstimado();
                   countAdulto++;
               }
               default -> {
                   sumaMaster += p.getTiempoEstimado();
                   countMaster++;
               }
           }
           if (p.getTiempoEstimado() < mejorEstimado.getTiempoEstimado()) {
               mejorEstimado = p;
           }
       }
       System.out.println("Promedio de tiempo estimado:");
       System.out.println("Juvenil: " + (countJuvenil == 0 ? 0 : sumaJuvenil / countJuvenil) + " min");
       System.out.println("Adulto: " + (countAdulto == 0 ? 0 : sumaAdulto / countAdulto) + " min");
       System.out.println("Master: " + (countMaster == 0 ? 0 : sumaMaster / countMaster) + " min");
       System.out.println("Participante con el mejor tiempo estimado: " + mejorEstimado);
   }
}