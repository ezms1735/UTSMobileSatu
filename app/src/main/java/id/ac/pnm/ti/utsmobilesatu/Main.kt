package id.ac.pnm.ti.utsmobilesatu

fun main() {
    val clubs = mutableListOf(
        Club("Liverpool", 19, 8, 9, 6, 3),
        Club("Manchester United", 20, 12, 6, 3, 1),
        Club("Chelsea", 6, 6, 5, 2, 2),
        Club("Manchester City", 8, 8, 8, 0, 0),
        Club("Arsenal", 13, 14, 2, 0, 0),
    )

    println("=====================================================================================")
    val sortedClubs = filterAndSort(clubs) { sortByNumberTrophyTotal(it) }
    println("Urutan klub berdasarkan jumlah total:")
    for (club in sortedClubs) {
        println("${club.name}: ${club.totalTrophy}")
    }

    println("=====================================================================================")
    val filteredClubs = filterAndSort(clubs) { filterWithoutUCLUEL(it) }
    println("Klub yang belum pernah memenangkan UCL dan UEL:")
    for (club in filteredClubs) {
        println(club.name) 
    }

    println("=====================================================================================")
    println("Rekapan semua trofi yang didapat masing-masing klub:")
    val liverpool = Club("\t\t\tLIVERPOOL", 19, 8, 9, 6, 3)
    println(liverpool.recap())
    println("-------------------------------------------------------------------------------------")
    val manchesterunited = Club("\t\tMANCHESTER UNITED", 20, 12, 6, 3, 1)
    println(manchesterunited.recap())
    println("-------------------------------------------------------------------------------------")
    val chelsea = Club("\t\t\tCHELSEA", 6, 6, 5, 2, 2)
    println(chelsea.recap())
    println("-------------------------------------------------------------------------------------")
    val manchestercity = Club("\t\tMANCHESTER CITY", 8, 8, 8, 0, 0)
    println(manchestercity.recap())
    println("-------------------------------------------------------------------------------------")
    val arsenal = Club("\t\t\tARSENAL", 13, 14, 2, 0, 0)
    println(arsenal.recap())
}


fun filterAndSort(clubs: List<Club>, options: (List<Club>) -> List<Club>): List<Club> {
    return options(clubs)
}

fun sortByNumberTrophyTotal(clubs: List<Club>): List<Club> {
    val sortedClubs = clubs.sortedByDescending { it.totalTrophy }
    return sortedClubs
}

fun filterWithoutUCLUEL(clubs: List<Club>): List<Club> {
    val filteredClubs = clubs.filter { it.ligaChampions == 0 && it.ligaEuropa == 0 }
    return filteredClubs
}