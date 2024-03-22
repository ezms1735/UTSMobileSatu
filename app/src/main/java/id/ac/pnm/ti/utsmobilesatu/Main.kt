package id.ac.pnm.ti.utsmobilesatu

fun main () {
    val clubs = mutableListOf(
        Club("Liverpool", 19, 8, 9, 6, 3),
        Club("Manchester United", 20, 12, 5, 3, 1),
        Club("Chelsea", 6, 8, 5, 2, 2),
        Club("Manchester City", 8, 8, 8, 0, 0),
        Club("Arsenal", 13, 14, 2, 0, 0),
    )
    println("==============================================================================")
        val sortedClubs = filterAndSort(clubs) {sortByNumberTrophyTotal(it)}

        println("Urutan klub berdasarkan jumlah total trofi: ")
        for (club in sortedClubs) {
            println("${club.name}: ${club.totalTrophy}")
        }
    println("==============================================================================")
        val filteredClubs = filterAndSort(clubs) {filterWithoutUCLUEL(it)}

        println("Klub yang belum pernah memenangkan UCL dan UEL: ")
        for (club in filteredClubs) {
            println(club.name)
        }
    println("===============================================================================")
        val liverpool = Club(
            name = "Liverpool", epl = 19, fa = 8, efl = 9, ligaChampions = 6, ligaEuropa = 3
        )
        val recap = listOf(
            "${liverpool.epl} trofi EPL",
            "${liverpool.fa} trofi FA",
            "${liverpool.efl} trofi EFL",
            "${liverpool.ligaChampions} trofi UCL",
            "${liverpool.ligaEuropa} trofi UEL"
        ).joinToString {", "}
        println("Liverpool berhasil meraih $recap")
}

fun filterAndSort(clubs: List<Club>, options: (List<Club>) -> List<Club>): List<Club> {
    return options(clubs)
}
fun sortByNumberTrophyTotal(clubs: List<Club>): List<Club> {
    val sortedClubs = clubs.sortedByDescending {it.totalTrophy}
    return sortedClubs
}
fun filterWithoutUCLUEL(clubs: List<Club>): List<Club> {
    val filteredClubs = clubs.filter {it.ligaChampions == 0 && it.ligaEuropa == 0}
    return filteredClubs
}