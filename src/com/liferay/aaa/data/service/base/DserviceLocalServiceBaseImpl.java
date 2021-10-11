/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.aaa.data.service.base;

import com.liferay.aaa.data.model.Dservice;
import com.liferay.aaa.data.service.DserviceLocalService;
import com.liferay.aaa.data.service.persistence.CustomerPersistence;
import com.liferay.aaa.data.service.persistence.DservicePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the dservice local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.aaa.data.service.impl.DserviceLocalServiceImpl}.
 * </p>
 *
 * @author Rishikesh Dubey
 * @see com.liferay.aaa.data.service.impl.DserviceLocalServiceImpl
 * @see com.liferay.aaa.data.service.DserviceLocalServiceUtil
 * @generated
 */
public abstract class DserviceLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements DserviceLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.aaa.data.service.DserviceLocalServiceUtil} to access the dservice local service.
	 */

	/**
	 * Adds the dservice to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dservice the dservice
	 * @return the dservice that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Dservice addDservice(Dservice dservice) throws SystemException {
		dservice.setNew(true);

		return dservicePersistence.update(dservice);
	}

	/**
	 * Creates a new dservice with the primary key. Does not add the dservice to the database.
	 *
	 * @param dserviceId the primary key for the new dservice
	 * @return the new dservice
	 */
	@Override
	public Dservice createDservice(long dserviceId) {
		return dservicePersistence.create(dserviceId);
	}

	/**
	 * Deletes the dservice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dserviceId the primary key of the dservice
	 * @return the dservice that was removed
	 * @throws PortalException if a dservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Dservice deleteDservice(long dserviceId)
		throws PortalException, SystemException {
		return dservicePersistence.remove(dserviceId);
	}

	/**
	 * Deletes the dservice from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dservice the dservice
	 * @return the dservice that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Dservice deleteDservice(Dservice dservice) throws SystemException {
		return dservicePersistence.remove(dservice);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Dservice.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return dservicePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.aaa.data.model.impl.DserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return dservicePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.aaa.data.model.impl.DserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return dservicePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return dservicePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return dservicePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Dservice fetchDservice(long dserviceId) throws SystemException {
		return dservicePersistence.fetchByPrimaryKey(dserviceId);
	}

	/**
	 * Returns the dservice with the matching UUID and company.
	 *
	 * @param uuid the dservice's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching dservice, or <code>null</code> if a matching dservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dservice fetchDserviceByUuidAndCompanyId(String uuid, long companyId)
		throws SystemException {
		return dservicePersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the dservice matching the UUID and group.
	 *
	 * @param uuid the dservice's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dservice, or <code>null</code> if a matching dservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dservice fetchDserviceByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return dservicePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dservice with the primary key.
	 *
	 * @param dserviceId the primary key of the dservice
	 * @return the dservice
	 * @throws PortalException if a dservice with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dservice getDservice(long dserviceId)
		throws PortalException, SystemException {
		return dservicePersistence.findByPrimaryKey(dserviceId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return dservicePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the dservice with the matching UUID and company.
	 *
	 * @param uuid the dservice's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching dservice
	 * @throws PortalException if a matching dservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dservice getDserviceByUuidAndCompanyId(String uuid, long companyId)
		throws PortalException, SystemException {
		return dservicePersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the dservice matching the UUID and group.
	 *
	 * @param uuid the dservice's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dservice
	 * @throws PortalException if a matching dservice could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dservice getDserviceByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return dservicePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the dservices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.aaa.data.model.impl.DserviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dservices
	 * @param end the upper bound of the range of dservices (not inclusive)
	 * @return the range of dservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dservice> getDservices(int start, int end)
		throws SystemException {
		return dservicePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dservices.
	 *
	 * @return the number of dservices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getDservicesCount() throws SystemException {
		return dservicePersistence.countAll();
	}

	/**
	 * Updates the dservice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dservice the dservice
	 * @return the dservice that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Dservice updateDservice(Dservice dservice) throws SystemException {
		return dservicePersistence.update(dservice);
	}

	/**
	 * Returns the customer local service.
	 *
	 * @return the customer local service
	 */
	public com.liferay.aaa.data.service.CustomerLocalService getCustomerLocalService() {
		return customerLocalService;
	}

	/**
	 * Sets the customer local service.
	 *
	 * @param customerLocalService the customer local service
	 */
	public void setCustomerLocalService(
		com.liferay.aaa.data.service.CustomerLocalService customerLocalService) {
		this.customerLocalService = customerLocalService;
	}

	/**
	 * Returns the customer remote service.
	 *
	 * @return the customer remote service
	 */
	public com.liferay.aaa.data.service.CustomerService getCustomerService() {
		return customerService;
	}

	/**
	 * Sets the customer remote service.
	 *
	 * @param customerService the customer remote service
	 */
	public void setCustomerService(
		com.liferay.aaa.data.service.CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Returns the customer persistence.
	 *
	 * @return the customer persistence
	 */
	public CustomerPersistence getCustomerPersistence() {
		return customerPersistence;
	}

	/**
	 * Sets the customer persistence.
	 *
	 * @param customerPersistence the customer persistence
	 */
	public void setCustomerPersistence(CustomerPersistence customerPersistence) {
		this.customerPersistence = customerPersistence;
	}

	/**
	 * Returns the dservice local service.
	 *
	 * @return the dservice local service
	 */
	public com.liferay.aaa.data.service.DserviceLocalService getDserviceLocalService() {
		return dserviceLocalService;
	}

	/**
	 * Sets the dservice local service.
	 *
	 * @param dserviceLocalService the dservice local service
	 */
	public void setDserviceLocalService(
		com.liferay.aaa.data.service.DserviceLocalService dserviceLocalService) {
		this.dserviceLocalService = dserviceLocalService;
	}

	/**
	 * Returns the dservice remote service.
	 *
	 * @return the dservice remote service
	 */
	public com.liferay.aaa.data.service.DserviceService getDserviceService() {
		return dserviceService;
	}

	/**
	 * Sets the dservice remote service.
	 *
	 * @param dserviceService the dservice remote service
	 */
	public void setDserviceService(
		com.liferay.aaa.data.service.DserviceService dserviceService) {
		this.dserviceService = dserviceService;
	}

	/**
	 * Returns the dservice persistence.
	 *
	 * @return the dservice persistence
	 */
	public DservicePersistence getDservicePersistence() {
		return dservicePersistence;
	}

	/**
	 * Sets the dservice persistence.
	 *
	 * @param dservicePersistence the dservice persistence
	 */
	public void setDservicePersistence(DservicePersistence dservicePersistence) {
		this.dservicePersistence = dservicePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.aaa.data.model.Dservice",
			dserviceLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.aaa.data.model.Dservice");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Dservice.class;
	}

	protected String getModelClassName() {
		return Dservice.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = dservicePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.aaa.data.service.CustomerLocalService.class)
	protected com.liferay.aaa.data.service.CustomerLocalService customerLocalService;
	@BeanReference(type = com.liferay.aaa.data.service.CustomerService.class)
	protected com.liferay.aaa.data.service.CustomerService customerService;
	@BeanReference(type = CustomerPersistence.class)
	protected CustomerPersistence customerPersistence;
	@BeanReference(type = com.liferay.aaa.data.service.DserviceLocalService.class)
	protected com.liferay.aaa.data.service.DserviceLocalService dserviceLocalService;
	@BeanReference(type = com.liferay.aaa.data.service.DserviceService.class)
	protected com.liferay.aaa.data.service.DserviceService dserviceService;
	@BeanReference(type = DservicePersistence.class)
	protected DservicePersistence dservicePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private DserviceLocalServiceClpInvoker _clpInvoker = new DserviceLocalServiceClpInvoker();
}