package com.colagom.stocker.entity

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Stocks : IntIdTable() {
    val shotnIsin = varchar("shotnIsin", 255)
    val isin = varchar("isin", 255)
    val korSecnNm = varchar("korSecnNm", 255)
    val engSecnNm = varchar("engSecnNm", 255)
    val issuDt = varchar("issuDt", 255)
    val issucoCustno = varchar("issucoCustno", 255)
    val secnKacdNm = varchar("secnKacdNm", 255)
}

class Stock(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Stock>(Stocks)

    var shotnIsin by Stocks.shotnIsin
    var isin by Stocks.isin
    var korSecnNm by Stocks.korSecnNm
    var engSecnNm by Stocks.engSecnNm
    var issuDt by Stocks.issuDt
    var issucoCustno by Stocks.issucoCustno
    var secnKacdNm by Stocks.secnKacdNm
}

object ListingInfo : IntIdTable() {
    val isin = varchar("isin", 255)
    val apliDt = varchar("apliDt", 255)
    val dlistDt = varchar("dlistDt", 255)
    val issucoCustno = varchar("issucoCustno", 255)
    val listTpcd = varchar("listTpcd", 255)
    val xpitDt = varchar("xpitDt", 255)
}

object BondInfos : IntIdTable() {
    val isin = varchar("isin", 255)
    val issucoCustno = varchar("issucoCustno", 255)
    val korSecnNm = varchar("korSecnNm", 255)
    val newstkAlocDdBfLimitDays = varchar("newstkAlocDdBfLimitDays", 255) // 신주배정일전제한일수
    val setaccEndtermLimitDays = varchar("setaccEndtermLimitDays", 255) // 결산기말제한일
    val wrtbIsin = varchar("wrtbIsin", 255) // 신주인수권증권 종목번호
    val xrcPrice = varchar("xrcPrice", 255) // 행사가
    val xrcRatio = varchar("xrcRatio", 255) // 행사비율
    val xrcStkIsin = varchar("xrcStkIsin", 255) // 행사주식종목번호
    val xrcStkIsinNm = varchar("xrcStkIsinNm", 255) //행사주식명
}