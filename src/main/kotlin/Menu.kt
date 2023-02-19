import java.util.Scanner

 interface Scannumber {
    fun scanners(): Int {
        val listMenu = ListMenu.ERRORS
        val scan: Int
        while (true) {
            val sc = Scanner(System.`in`)
            if (sc.hasNextInt()) {
                scan = sc.nextInt()
                break}
            else println("${listMenu.nameMenu}")
        }
            return scan
    }
}
 class Menu: Scannumber {
     val sc = Scanner(System.`in`)
     var end = true
     val archive = Archives()
         fun listArchive() {
             var end = true
             val listMenu = ListMenu.MAINMENU
             println("${listMenu.nameMenu}")
             var scan = scanners()
             when (scan) {
                 1 -> newArchive()
                 2 -> openArchive()
                 3 -> {
                     archive.closed(); end = false
                 }
                 else -> println("${listMenu.error()}")
             }
            if (end == true) listArchive()
         }
     fun newArchive() {
         var end = true
         val listMenu = ListMenu.NEWARCHIVE
         println("${listMenu.nameMenu}")
         when (scanners()) {
             1 -> archive.createArchive()
             2 -> archive.selectArchive()
             3 -> end = false
             else -> println("${listMenu.error()}")
         }
         if (end == true) newArchive()
     }
    fun openArchive() {
        var end = true
        val listMenu = ListMenu.OPENARCHIVE
        println("${listMenu.nameMenu}")
        when(scanners()) {
            1 -> archive.createNote()
            2 -> openNotes()
            3 -> end = false
            else -> println("${listMenu.error()}")
        }
        if (end == true) openArchive()
    }
    fun openNotes() {
        var end = true
        val listMenu = ListMenu.OPENNOTES
        println("${listMenu.nameMenu}")
        when(scanners()) {
            1 -> archive.seeNote()
            2 ->  end = false
            else -> println("${listMenu.error()}")
        }
        if (end == true) openNotes()
    }
}