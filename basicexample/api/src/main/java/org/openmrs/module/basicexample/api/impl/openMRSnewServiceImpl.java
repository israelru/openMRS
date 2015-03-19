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
package org.openmrs.module.basicexample.api.impl;

import java.util.List;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.basicexample.openMRSnew;
import org.openmrs.module.basicexample.api.openMRSnewService;
import org.openmrs.module.basicexample.api.db.openMRSnewDAO;

/**
 * It is a default implementation of {@link openMRSnewService}.
 */
public class openMRSnewServiceImpl extends BaseOpenmrsService implements openMRSnewService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private openMRSnewDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(openMRSnewDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public openMRSnewDAO getDao() {
	    return dao;
    }
    
    /**
     * @see org.openmrs.module.department.api.DepartmentService#getAllDepartments()
     */
    @Override
    public List<openMRSnew> getAllDepartments() {
            return dao.getAllDepartments();
    }
    /**
     * @see org.openmrs.module.department.api.DepartmentService#getDepartment(java.lang.Integer)
     */
    @Override
public openMRSnew getDepartment(Integer departmentId) {
        return dao.getDepartment(departmentId);
}
    /**
     * @see org.openmrs.module.department.api.DepartmentService#saveDepartment(org.openmrs.module.department.Department)
     */
    @Override
    public openMRSnew saveDepartment(openMRSnew department) {
            return dao.saveDepartment(department);
    }
    /**
     * @see org.openmrs.module.department.api.DepartmentService#purgeDepartment(org.openmrs.module.department.Department)
     */
    @Override
    public void purgeDepartment(openMRSnew department) {
            dao.purgeDepartment(department);
    }
    
    
    
}