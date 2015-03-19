/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.basicexample.api.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.module.basicexample.openMRSnew;
import org.openmrs.module.basicexample.api.db.openMRSnewDAO;

/**
 * It is a default implementation of  {@link openMRSnewDAO}.
 */
public class HibernateopenMRSnewDAO implements openMRSnewDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }
    
    /**
     * @see org.openmrs.module.department.api.db.DepartmentDAO#getAllDepartments()
     */
    @Override
    public List<openMRSnew> getAllDepartments() {
            return sessionFactory.getCurrentSession().createCriteria(openMRSnew.class).list();
    }
    /**
     * @see org.openmrs.module.department.api.DepartmentService#getDepartment(java.lang.Integer)
     */
    @Override
    public openMRSnew getDepartment(Integer departmentId) {
            return (openMRSnew) sessionFactory.getCurrentSession().get(openMRSnew.class, departmentId);
    }
    /**
     * @see org.openmrs.module.department.api.db.DepartmentDAO#saveDepartment(org.openmrs.module.department.Department)
     */
    @Override
    public openMRSnew saveDepartment(openMRSnew department) {
            sessionFactory.getCurrentSession().save(department);
            return department;
    }
    /**
     * @see org.openmrs.module.department.api.db.DepartmentDAO#purgeDepartment(org.openmrs.module.department.Department)
     */
    @Override
    public void purgeDepartment(openMRSnew department) {
            sessionFactory.getCurrentSession().delete(department);
    }
}