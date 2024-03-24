package id.ac.pnm.ti.utsmobilesatu

data class Club (
    val name: String,
    val epl: Int,
    val fa: Int, //FA Cup trophy
    val efl: Int, //EFL Cup trophy
    val ligaChampions: Int, //Champions League trophy
    val ligaEuropa: Int, //Eropa League trophy
){
    val totalTrophy: Int
        get() = epl + fa + efl + ligaChampions + ligaEuropa

    fun recap(): String {
        return "$name\n" +
                "Trofi EPL                     : $epl\n" +
                "Trofi FA                      : $fa\n" +
                "Trofi EFL                     : $efl\n" +
                "Trofi Liga Champions          : $ligaChampions\n" +
                "Trofi Liga Europa             : $ligaEuropa\n" +
                "Total Trofi yang diraih adalah: $totalTrophy"
    }
}