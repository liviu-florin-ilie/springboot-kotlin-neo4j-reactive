package com.lefe.example.model

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship

@Node("Movie")
class MovieEntity
    (
    @field:Id var title: String,
    @field:Property("tagline") var description: String?
) {
    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    var actors: Set<PersonEntity> = HashSet()

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    var directors: Set<PersonEntity> = HashSet()
}