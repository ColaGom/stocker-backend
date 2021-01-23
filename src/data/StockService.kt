package com.colagom.stocker.data

import com.colagom.stocker.entity.Stock
import org.jetbrains.exposed.sql.transactions.transaction

class StockService {
    fun getAllStock(): Iterable<Stock> = transaction {
        Stock.all()
    }

    fun addStock(stock: Stock) = transaction {
        Stock.new {
            shotnIsin = stock.shotnIsin
            isin = stock.isin
            korSecnNm = stock.korSecnNm
            engSecnNm = stock.engSecnNm
            issuDt = stock.issuDt
            issucoCustno = stock.issucoCustno
            secnKacdNm = stock.secnKacdNm
        }
    }
}