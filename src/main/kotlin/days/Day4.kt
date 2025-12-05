package days

import xyz.hughjd.aocutils.Coords.Coord

class Day4 : Day(4) {

    private val grid = inputList.flatMapIndexed { y, s -> s.split("").mapIndexed { x, c -> Coord(x, y) to c }  }

    override fun partOne(): Any {
        return getAccessibleRolls(grid).count()
    }

    // todo this takes ~1m30s to run on the real input
    override fun partTwo(): Any {
        var grid2 = grid
        var accessible = getAccessibleRolls(grid2)
        var removed = 0
        while (accessible.isNotEmpty()) {
            removed += accessible.size
            grid2 = grid2.map { if (it.first !in accessible) it else it.copy(second = ".") }
            accessible = getAccessibleRolls(grid2)
        }
        return removed
    }

    private fun getAccessibleRolls(grid: List<Pair<Coord, String>>): List<Coord> {
        return grid
            .filter { it.second == "@" }
            .map { it.first }
            .fold(listOf()) { accessibleRolls, rollCoord ->
                val adjacentRolls = rollCoord.getAdjacent(true)
                    .mapNotNull { c -> grid.find { it.first == c }?.second }
                    .count { it == "@" }
                if (adjacentRolls < 4) accessibleRolls + rollCoord else accessibleRolls
            }
    }
}
