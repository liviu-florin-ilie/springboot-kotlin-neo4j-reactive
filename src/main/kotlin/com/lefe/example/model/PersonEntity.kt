package com.lefe.example.model

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node("Person")
data class PersonEntity(
    @Id
    var born: Int? = null,
    var name: String? = null
)
