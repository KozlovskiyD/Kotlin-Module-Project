
enum class ListMenu(val nameMenu: String) {
    MAINMENU("1. Создать архивы \n" +
            "2. Мой созданые архивы\n" +
            "3. Выход"),
    OPENARCHIVE("1. Создать заметку\n" +
            "2. Мои созданые заметки\n"+
             "3. Выход"),
    OPENNOTES("1. Открыть заметки\n2. Выход"),
    NEWARCHIVE("1. Создать новый архив\n2. Выбор архива\n3. Выход"),
    ERRORS("Неверный символ, введите число");

    fun error(): String=
        when(this){
            MAINMENU -> "Неверное значение"
            OPENARCHIVE ->  "Неверное значение"
            OPENNOTES ->  "Неверное значение"
            NEWARCHIVE ->  "Неверное значение"
            ERRORS -> "Сначала выберете архив"
        }


}