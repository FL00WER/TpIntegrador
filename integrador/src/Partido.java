public class Partido {
    Equipo equipo1;
    Equipo equipo2;
    int golesEquipo1;
    int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum resultado(Equipo equipo) {
//        if (equipo != equipo1 && equipo != equipo2){
//            return;
//        }
        //TODO esta logica puede reducirse
        if (golesEquipo1 > golesEquipo2){
            if (equipo == equipo1){
                return ResultadoEnum.GANADOR;
            }else {
                return ResultadoEnum.PERDEDOR;
            }
        } else if (golesEquipo1 < golesEquipo2) {
            if (equipo == equipo2){
                return ResultadoEnum.GANADOR;
            }else {
                return ResultadoEnum.PERDEDOR;
            }
        } else {
            return ResultadoEnum.EMPATE;
        }
    }
}
