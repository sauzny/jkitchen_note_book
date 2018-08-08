package com.sauzny.jkitchen_note.db.mongodb;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class BaseMongoDao<T extends BaseMongoEntity> {

	protected Class<T> entityClass;
	
	protected String className;
	
	public BaseMongoDao(){
	     entityClass=(Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	     className=entityClass.getName();
	}
	
	@Autowired
	protected MongoTemplate mongoTemplate;

	/**
	 * 新增
	 * <br>------------------------------<br>
	 * @param user
	 */
	public void insert(T t) {
		mongoTemplate.insert(t);
	}
	
	/**
	 * 批量新增
	 * <br>------------------------------<br>
	 * @param users
	 */
	public void insertAll(List<T> tList) {
		mongoTemplate.insertAll(tList);
	}
	
	/**
	 * 删除,按主键id, 如果主键的值为null,删除会失败
	 * <br>------------------------------<br>
	 * @param id
	 */
	public void deleteById(String id) {
		T t = (T) new BaseMongoEntity(id);
		mongoTemplate.remove(t);
	}
	
	/**
	 * 按条件删除
	 * <br>------------------------------<br>
	 * @param criteriaT
	 */
	public void delete(Criteria criteria) {
		Query query = new Query(criteria);
		mongoTemplate.remove(query, BaseMongoEntity.class);
	}
	
	/**
	 * 删除全部
	 * <br>------------------------------<br>
	 */
	public void deleteAll() {
		mongoTemplate.dropCollection(entityClass);
	}
	
	/**
	 * 按主键修改,
	 * 如果文档中没有相关key 会新增 使用$set修改器
	 * <br>------------------------------<br>
	 * @param user
	 */
	public void updateById(T t, Update update) {
		Criteria criteria = Criteria.where("id").is(t.getId());
		Query query = new Query(criteria);
		mongoTemplate.updateFirst(query, update, entityClass);
	}
	
	/**
	 * 修改多条
	 * <br>------------------------------<br>
	 * @param criteriaT
	 * @param user
	 */
	public void update(Criteria criteria, Update update) {
		Query query = new Query(criteria);
		mongoTemplate.updateMulti(query, update, entityClass);
	}
	
	/**
	 * 根据主键查询
	 * <br>------------------------------<br>
	 * @param id
	 * @return
	 */
	public T findById(String id) {
		return mongoTemplate.findById(id, entityClass);
	}
	
	/**
	 * 查询全部
	 * <br>------------------------------<br>
	 * @return
	 */
	public List<T> findAll() {
		return mongoTemplate.findAll(entityClass);
	}
	
	/**
	 * 按条件查询
	 * <br>------------------------------<br>
	 * @param criteriaT
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<T> find(Criteria criteria) {
		Query query = new Query(criteria);
		return mongoTemplate.find(query, entityClass);
	}
	
	/**
	 * 按条件查询, 分页
	 * <br>------------------------------<br>
	 * @param criteriaT
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<T> find(Criteria criteria, int skip, int limit) {
		Query query = new Query(criteria);
		query.skip(skip);
		query.limit(limit);
		return mongoTemplate.find(query, entityClass);
	}
	
	/**
	 * 根据条件查询出来后 再去修改
	 * <br>------------------------------<br>
	 * @param criteriaT  查询条件
	 * @param updateT    修改的值对象
	 * @return
	 */
	public T findAndModify(Criteria criteria, Update update) {
		Query query = new Query(criteria);
		return mongoTemplate.findAndModify(query, update, entityClass);
	}
	
	/**
	 * 查询出来后 删除
	 * <br>------------------------------<br>
	 * @param criteriaT
	 * @return
	 */
	public T findAndRemove(Criteria criteria) {
		Query query = new Query(criteria);
		return mongoTemplate.findAndRemove(query, entityClass);
	}
	
	/**
	 * count
	 * <br>------------------------------<br>
	 * @param criteriaT
	 * @return
	 */
	public long count(Criteria criteria) {
		Query query = new Query(criteria);
		return mongoTemplate.count(query, entityClass);
	}

	/**
	 *
	 * <br>------------------------------<br>
	 * @param criteriaT
	 * @return
	 */
	/*
	private Query getQuery(T criteriaT) {
		if (criteriaT == null) {
			criteriaT = new T();
		}
		Query query = new Query();
		if (criteriaT.getId() != null) {
			Criteria criteria = Criteria.where("id").is(criteriaT.getId());
			query.addCriteria(criteria);
		}
		if (criteriaT.getAge() > 0) {
			Criteria criteria = Criteria.where("age").gt(criteriaT.getAge());
			query.addCriteria(criteria);
		}
		if (criteriaT.getName() != null) {
			Criteria criteria = Criteria.where("name").regex("^" + criteriaT.getName());
			query.addCriteria(criteria);
		}
		return query;
	}
	*/
}
