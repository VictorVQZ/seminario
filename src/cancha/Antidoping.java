package cancha;

/**
 *
 * @author Angel García
 */
public class Antidoping {

    private static final int MAXATRIBUTOS = 100;

    /**
     *
     * @param equipo Array de tipo jugador, debe contener los 6 jugadores del
     * equipo al cual se desea realizar la prueba Antidoping.
     * @return El array con los jugadores del equipo, con sus atributos
     * revisados y corregidos en caso de existir inconsistencias.
     */
    public static jugador[] realizarPrueba(final jugador[] equipo) {
        assert equipo != null;
        for (int i = 0; i < equipo.length; i++) {
            if (estaDopado(equipo[i])) {
                modificarAtributos(equipo[i]);
            }

        }
        return equipo;
    }

    /**
     *
     * @param examinado Jugador al que se le desean verificar los atributos.
     * @return Verdadero si los atributos suman un valor mayor al permitido,
     * retorna Falso en caso contrario.
     */
    private static final boolean estaDopado(final jugador examinado) {
        assert examinado != null;
        return sumarAtributos(examinado) > MAXATRIBUTOS;
    }

    /**
     *
     * @param j Jugador del que se desea obtener la suma de atributos
     * @return la suma de los valores de los atributos del jugador especificado.
     */
    private static final int sumarAtributos(final jugador j) {
        assert j != null;
        return j.getPotencia()
                + j.getPrecision()
                + j.getResistencia()
                + j.getSalto()
                + j.getVelocidad();
    }

    /**
     *
     * @param j jugador al que se le desean modificar los atributos.
     */
    private static final void modificarAtributos(final jugador j) {
        assert j != null;
        int[] normalizado = normalizar(j.obtenerAtributos(), sumarAtributos(j));
        j.setPotencia(normalizado[0]);
        j.setPrecision(normalizado[1]);
        j.setResistencia(normalizado[2]);
        j.setSalto(normalizado[3]);
        j.setVelocidad(normalizado[4]);
    }

    private static final int[] normalizar(int[] atributos, double total) {

        int[] respuesta = new int[atributos.length];
        int t = 0;
        for (int i = 1; i < respuesta.length; i++) {
            respuesta[i] = (int) (MAXATRIBUTOS * atributos[i] / total);
            t += respuesta[i];
        }
        respuesta[0] = MAXATRIBUTOS - t;
        return respuesta;
    }
}
