

import java.util.Scanner

interface Scanstring {
    fun scanners(): String{
        val sc = Scanner(System.`in`)
        return sc.nextLine()
    }
}
class Archives: Scanstring {
    val sc = Scanner(System.`in`)
    var listNote: MutableMap<Int, String> = mutableMapOf()
    var listArchive: MutableMap<String, MutableMap<Int, String>> = mutableMapOf()
    var nameArch: String = ""
    val listMenu = ListMenu.ERRORS
    fun createArchive() {
        println("Создаем архив заметок\nВведите название архива")
        var newlistNote: MutableMap<Int, String> = mutableMapOf()
        while (true) {
            var q = true
            var nameArchive = scanners()
            for (item in listArchive) {
                if (nameArchive == item.key) {
                    println("Архив с названием '$nameArchive' уже усть\nВведите другое название")
                    q = false
                }
            }
            if (q == true) {
                listArchive[nameArchive] = newlistNote
                println("Архив '$nameArchive' успешно создан. ${listArchive.size}")
                break
            }
        }
    }
    fun selectArchive() {
        if (listArchive.size != 0) {
            println("Введите название архива из списка:\n${listArchive.keys}")
            var q = true
            while (true) {
                var name = scanners()
                for (item in listArchive) {
                    if (name == item.key) {
                        listNote = item.value
                        println("выбран архив '$name'")
                        q = false
                        nameArch = item.key
                    }
                }
                if (q == false) break
                println("Архива стаким названием нет\n" +
                        "${listArchive.keys}")
            }
        } else println("Неодного архива не создано")
    }
    fun createNote() {
        if (nameArch != "") {
            var ls = listNote.size + 1
            println("Создаем заметку № $ls в архиве '$nameArch'\nНаберите текст заметки:")
            var note = sc.nextLine()
            listNote[ls] = note
            println("Заметка с номером $ls успешно записана в архив '$nameArch")
        } else println("${listMenu.error()}")
    }
    fun seeNote() {
        if (nameArch != "") {
            if (listNote.size == 0) println("Заметок в архиве '$nameArch' нету")
            else {
                println("Заметки в архиве '$nameArch'")
                for (item in listNote) {
                    println("Заметка ${item.key}   >    ${item.value}")
                }
            }
        }
         else println("${listMenu.error()}")
    }
    fun closed() {
        println("Все заметки удалены")
        listArchive.clear()
    }
}








