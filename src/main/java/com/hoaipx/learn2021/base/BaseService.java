package com.hoaipx.learn2021.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

@FunctionalInterface
public interface BaseService<E, ID extends Serializable> {

    public BaseDAO<E, ID> getRepository();

    /**
     * According to ID
     * @param id id
     * @return Entity
     */
    public default E get(ID id) {
        return getRepository().findById(id).orElse(null);
    }

    /**
     * Get all lists
     * @return List
     */
    public default List<E> getAll() {
        return getRepository().findAll();
    }

    /**
     * Get the total
     * @return Long
     */
    public default Long getTotalCount() {
        return getRepository().count();
    }

    /**
     * Save
     * @param entity entity
     * @return Entity
     */
    public default E save(E entity) {

        return getRepository().save(entity);
    }

    /**
     * Update
     * @param entity entity
     * @return Entity
     */
    public default E update(E entity) {
        return getRepository().saveAndFlush(entity);
    }

    /**
     * Batch save and modify
     * @param entities entities
     * @return Iterable
     */
    public default Iterable<E> saveOrUpdateAll(Iterable<E> entities) {
        return getRepository().saveAll(entities);
    }

    /**
     * Delete
     * @param entity entity
     */
    public default void delete(E entity) {
        getRepository().delete(entity);
    }

    /**
     * Delete according to Id
     * @param id id
     */
    public default void delete(ID id) {
        getRepository().deleteById(id);
    }

    /**
     * Batch deletion
     * @param entities entities
     */
    public default void delete(Iterable<E> entities) {
        getRepository().deleteInBatch(entities);
    }

    /**
     * Clear the cache, submit for persistence
     */
    public default void flush() {
        getRepository().flush();
    }

    /**
     * Get based on conditional query
     * @param spec spec
     * @return List
     */
    public default List<E> findAll(Specification<E> spec) {
        return getRepository().findAll(spec);
    }

    /**
     * Paging fetch
     * @param pageable pageable
     * @return Page
     */
    public default Page<E> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    /**
     * Paging according to query conditions
     * @param spec spec
     * @param pageable pageable
     * @return Page
     */
    public default Page<E> findAll(Specification<E> spec, Pageable pageable) {
        return getRepository().findAll(spec, pageable);
    }

    /**
     * Get the number of results of the query condition
     * @param spec spec
     * @return long
     */
    public default long count(Specification<E> spec) {
        return getRepository().count(spec);
    }

}
