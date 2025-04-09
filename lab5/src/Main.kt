fun main() {
    println("Программа запущена")

    // Проверка переменной окружения
    val filePath = System.getenv("COLLECTION_FILE")
    println("Путь к файлу: ${filePath ?: "не задан"}")
}