package com.elslode.chibbistestapp.presentation.review

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DataFormatted {

    fun formatData(data: String?): String {
        val parsedDate = LocalDateTime.parse(data, DateTimeFormatter.ISO_DATE_TIME)
        return parsedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    }
}