package com.chetv.binlistnet.data.model.jsonfromserver

data class JsonFromBinListNet(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)