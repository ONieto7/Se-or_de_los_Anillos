package Batalla_Modelo;

import Heroes.Heroe;
import Bestias.Bestia;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Guerra.
 */
public class Guerra {
    
    /** The heroes. */
    // Listas para almacenar los héroes y bestias
    private List<Heroe> heroes = new ArrayList<>();
    
    /** The bestias. */
    private List<Bestia> bestias = new ArrayList<>();

    /**
     * Gets the heroes.
     *
     * @return the heroes
     */
    public List<Heroe> getHeroes() {
        return heroes;
    }
    
    /**
     * Gets the bestias.
     *
     * @return the bestias
     */
    public List<Bestia> getBestias() {
        return bestias;
    }

    /**
     * Añadir heroe.
     *
     * @param heroe the heroe
     */
    public void anadirHeroe(Heroe heroe) {
        heroes.add(heroe); //Añadir un héroe a la lista
    }

    /**
     * Eliminar heroe.
     *
     * @param index the index
     */
    public void eliminarHeroe(int index) {
        if (index >= 0 && index < heroes.size()) {
            heroes.remove(index); //Eliminar un héroe de la lista por índice
        }
    }

    /**
     * Subir heroe.
     *
     * @param index the index
     */
    public void subirHeroe(int index) {
        if (index > 0 && index < heroes.size()) {
            Heroe heroe = heroes.remove(index);
            heroes.add(index - 1, heroe); //Mover un héroe hacia arriba en la lista
        }
    }

    /**
     * Bajar heroe.
     *
     * @param index the index
     */
    public void bajarHeroe(int index) {
        if (index >= 0 && index < heroes.size() - 1) {
            Heroe heroe = heroes.remove(index);
            heroes.add(index + 1, heroe); //Mover un héroe hacia abajo en la lista
        }
    }

    /**
     * Añadir bestia.
     *
     * @param bestia the bestia
     */
    public void anadirBestia(Bestia bestia) {
        bestias.add(bestia);
    }

    /**
     * Eliminar bestia.
     *
     * @param index the index
     */
    public void eliminarBestia(int index) {
        if (index >= 0 && index < bestias.size()) {
            bestias.remove(index);
        }
    }

    /**
     * Subir bestia.
     *
     * @param index the index
     */
    public void subirBestia(int index) {
        if (index > 0 && index < bestias.size()) {
            Bestia bestia = bestias.remove(index);
            bestias.add(index - 1, bestia);
        }
    }

    /**
     * Bajar bestia.
     *
     * @param index the index
     */
    public void bajarBestia(int index) {
        if (index >= 0 && index < bestias.size() - 1) {
            Bestia bestia = bestias.remove(index);
            bestias.add(index + 1, bestia);
        }
    }
    
    /**
     * Limpiar equipos.
     */
    public void limpiarEquipos() {
        this.heroes.clear();
        this.bestias.clear();
    }

    /**
     * Luchar.
     *
     * @return the string
     */
    //Metodo para simular una batalla
    public String luchar() {
        StringBuilder resultado = new StringBuilder();
        if (heroes.isEmpty() || bestias.isEmpty()) {
            return "No hay personajes para luchar.";
        }

        Random random = new Random();
        int turno = 1;

        while (!heroes.isEmpty() && !bestias.isEmpty()) {
            resultado.append("Turno ").append(turno).append(":\n");

            //Iterar sobre lso perssonajes, emparejando heroes con bestias
            for (int i = 0; i < Math.min(heroes.size(), bestias.size()); i++) {
                Heroe heroe = heroes.get(i);
                Bestia bestia = bestias.get(i);

                //Descripcion del enfrentamiento
                resultado.append("Lucha entre ").append(heroe.getNombre())
                        .append(" (Vida=").append(heroe.getVida())
                        .append(" Armadura=").append(heroe.getArmadura())
                        .append(") y ").append(bestia.getNombre())
                        .append(" (Vida=").append(bestia.getVida())
                        .append(" Armadura=").append(bestia.getArmadura())
                        .append(")\n");

                //Supuestos particulares de cada personaje
                int ataqueHeroe = heroe.atacarModificado(bestia);
                int armaduraBestia = bestia.getArmaduraModificada();
        

                //Calcula el daño infligido por el heroe
                int danoHeroe = Math.max(0, ataqueHeroe - armaduraBestia);
                bestia.setVida(bestia.getVida() - danoHeroe);
                resultado.append(heroe.getNombre()).append(" saca ")
                        .append(ataqueHeroe).append(" y le quita ")
                        .append(danoHeroe).append(" de vida a ")
                        .append(bestia.getNombre()).append("\n");

                if (bestia.getVida() <= 0) {
                    resultado.append("¡Muere Bestia ").append(bestia.getNombre()).append("!\n");
                    bestias.remove(i);
                    i--; // Decrementamos el índice para ajustar la lista después de la eliminación
                    continue;
                }
                
                //Calcula el daño infligido por la bestia
                int ataqueBestia = bestia.atacar();
                int danoBestia = Math.max(0, ataqueBestia - heroe.getArmadura());
                heroe.setVida(heroe.getVida() - danoBestia);
                resultado.append(bestia.getNombre()).append(" saca ")
                        .append(ataqueBestia).append(" y le quita ")
                        .append(danoBestia).append(" de vida a ")
                        .append(heroe.getNombre()).append("\n");

                if (heroe.getVida() <= 0) {
                    resultado.append("¡Muere Heroe ").append(heroe.getNombre()).append("!\n");
                    heroes.remove(i);
                    i--;                 }
            }

            turno++;
        }

        if (heroes.isEmpty() && bestias.isEmpty()) {
            resultado.append("¡Es un empate! No quedan personajes en la batalla.\n");
        } else if (heroes.isEmpty()) {
            resultado.append("¡Victoria de las Bestias! Los heroes han sido derrotados.\n");
        } else if (bestias.isEmpty()) {
            resultado.append("¡Victoria de los Heroes! Las bestias han sido derrotadas.\n");
        }

        return resultado.toString();
    }
}