import org.junit.Test

import org.junit.Assert.*

class MainKtTest {


    @Test
    fun calculatePriceVK() {

        val amount = 500
        val card = CARD_VK
        val moneyTransfers = 6
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(0, result)
    }

    @Test
    fun calculatePriceMaestro() {

        val amount = 600
        val card = CARD_MAESTRO
        val moneyTransfers = 50
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(0, result)
    }

    @Test
    fun calculatePriceMaestro2() {

        val amount = 77000
        val card = CARD_MAESTRO
        val moneyTransfers = 6
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(482, result)
    }

    @Test
    fun calculatePriceMaestroLimitDay() {

        val amount = 7700000
        val card = CARD_MAESTRO
        val moneyTransfers = 6
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(ERROR_MAESTRO, result)
    }

    @Test
    fun calculatePriceMaestroLimitMonth() {

        val amount = 77000
        val card = CARD_MAESTRO
        val moneyTransfers = 620_800
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(ERROR_MAESTRO, result)
    }

    @Test
    fun calculatePriceVisa() {

        val amount = 58
        val card = CARD_VISA
        val moneyTransfers = 0
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(35, result)
    }

    @Test
    fun calculatePriceVisaNorma() {

        val amount = 5800
        val card = CARD_VISA
        val moneyTransfers = 0
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(43, result)
    }

    @Test
    fun calculatePriceVisaLimit() {

        val amount = 151_000
        val card = CARD_VISA
        val moneyTransfers = 100_000
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(ERROR_VISA, result)
    }

    @Test
    fun calculatePriceVisaLimitMonth() {

        val amount = 20
        val card = CARD_VISA
        val moneyTransfers = 600_100
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(ERROR_VISA, result)
    }

    @Test
    fun calculatePriceVKLimitMonth() {

        val amount = 15
        val card = CARD_VK
        val moneyTransfers = 500000
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(ERROR_VK, result)
    }

    @Test
    fun calculatePriceVKLimitDay2() {

        val amount = 40_000
        val card = CARD_VK
        val moneyTransfers = 0
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(ERROR_VK, result)
    }

    @Test
    fun calculatePriceCardError() {

        val amount = 50
        val card = "JJK"
        val moneyTransfers = 0
        val result = calculatePrice(amount=amount, card=card, moneyTransfers=moneyTransfers)
        assertEquals(ERROR_CARDS, result)
    }

}


