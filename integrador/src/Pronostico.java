public class Pronostico {
    Partido partido;
    Equipo equipo;
    ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = partido.resultado(equipo);
    }
}
