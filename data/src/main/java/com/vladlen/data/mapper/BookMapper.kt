package com.vladlen.data.mapper

import com.vladlen.data.net.dto.BookDTO
import com.vladlen.data.persistence.entity.BookEntity
import com.vladlen.domain.model.Book
import javax.inject.Inject

/**
 * Mapper class used to transform [BookDTO] or [BookEntity] (in the data layer) to [Book]
 * in the domain layer and vice versa.
 */
class BookMapper
@Inject constructor() {

    //region DTO to MODEL
    /**
     * Transform a [BookDTO] into an [Book].
     * @param dto  Object to be transformed.
     * @return [Book] if valid [BookDTO]
     */
    fun transform(dto: BookDTO): Book =
        Book(dto.id, dto.name, dto.description, dto.url, false)

    /**
     * Transform a Collection of [BookDTO] into a List of [Book].
     * @param dtoCollection Object Collection to be transformed.
     * @param userName          Foreign key
     * @return list of [Book]
     */
    fun transformDto(dtoCollection: Collection<BookDTO>): List<Book> =
        dtoCollection.map { transform(it) }
    //endregion

    //region ENTITY to MODEL
    /**
     * Transform a [BookEntity] into an [Book].
     * @param entity Object to be transformed.
     * @return [Book] if valid [BookEntity] otherwise null.
     */
    fun transform(entity: BookEntity): Book =
        Book(
            entity.id,
            entity.authorName,
            entity.description,
            entity.link,
            entity.isFavorite,
        )

    /**
     * Transform a Collection of [BookEntity] into a List of [Book].
     * @param entityCollection Object Collection to be transformed.
     * @return list of [Book]
     */
    fun transformEntity(entityCollection: Collection<BookEntity>): List<Book> =
        entityCollection.map { transform(it) }
    //endregion

    //region MODEL to ENTITY
    /**
     * Transform a [Book] into an [BookEntity].
     * @param model Object to be transformed.
     * @return [Book] if valid [BookEntity] otherwise null.
     */
    fun transformToEntity(model: Book): BookEntity =
        BookEntity(
            model.id,
            model.authorName,
            model.description,
            model.link,
            model.isFavorite,
        )

    /**
     * Transform a Collection of [Book] into a List of [BookEntity].
     * @param modelCollection Object Collection to be transformed.
     * @return list of [BookEntity]
     */
    fun transformToEntity(modelCollection: Collection<Book>): List<BookEntity> =
        modelCollection.map { transformToEntity(it) }
    //endregion

}