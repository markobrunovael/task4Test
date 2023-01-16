import kotlin.math.max
const val CARD_VISA = "Visa"
const val CARD_MAESTRO = "Maestro"
const val CARD_VK = "VK Pay"
const val ERROR_VISA = -2
const val ERROR_MAESTRO= -5
const val ERROR_CARDS = -1
const val ERROR_VK = -4
fun main() {
    println(calculatePrice(790, CARD_MAESTRO, 6))
}

fun calculatePrice(amount: Int, card: String, moneyTransfers: Int): Int {
    return when (card) {
        CARD_VISA -> if (amount <= 150_000 && amount + moneyTransfers <= 600_000) max(35, (amount * 0.0075).toInt()) else ERROR_VISA
        CARD_MAESTRO -> if (amount >= 150_000 || amount + moneyTransfers >= 600_000) ERROR_MAESTRO else if  (amount > 75000)  (amount * 0.006 + 20).toInt() else 0
        CARD_VK-> if (amount <= 15_000 && moneyTransfers <= 40_000) 0 else ERROR_VK
        else -> ERROR_CARDS


    }
}

