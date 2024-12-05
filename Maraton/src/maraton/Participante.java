/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maraton;

/**
 *
 * @author tamar
 */
public class Participante {

    private String nomCompleto;
    private int edad;
    private int numCorredor;
    private int timeEstimado;
    private int timeReal;
    private String categoria;

    public Participante(String nombreCompleto, int edad, int numeroCorredor, int tiempoEstimado) {
        this.nomCompleto = nombreCompleto;
        this.edad = edad;
        this.numCorredor = numeroCorredor;
        this.timeEstimado = tiempoEstimado;
        this.timeReal = 0; // AUTOMATICA****
        this.categoria = calcularCategoria();
    }
    // CATEGORIA SEGUN LA EDAD

    private String calcularCategoria() {
        if (edad < 18) {
            return "Juvenil";
        } else if (edad <= 40) {
            return "Adulto";
        } else {
            return "Master";
        }
    }
    // TIEMPO REAL QUE SE DEFINE AUTOMATICAMENTE

    public void generarTiempoReal() {
        this.timeReal = (int) (Math.random() * 400) + 100; // Entre 100 y 400 minutos
    }
    
    // toString PARA LA INFO DEL PARTICIPANTE
    @Override
    public String toString() {
        return "Número: " + numCorredor + ", Nombre: " + nomCompleto
                + ", Edad: " + edad + ", Categoría: " + categoria
                + ", Tiempo Estimado: " + timeEstimado + " min, Tiempo Real: " + timeReal + " min";
    }

    public int getTiempoReal() {
        return timeReal;
    }

    public int getTiempoEstimado() {
        return timeEstimado;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getNumeroCorredor() {
        return numCorredor;
    }
}
