/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.integrationstudio.ds;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>Data Source Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.ds.DataSourceConfiguration#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.ds.DataSourceConfiguration#getProperty <em>Property</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.ds.DataSourceConfiguration#getId <em>Id</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.ds.DataSourceConfiguration#isEnableOData <em>Enable OData</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.ds.DsPackage#getDataSourceConfiguration()
 * @model extendedMetaData="name='config_._type' kind='mixed'"
 * @generated
 */
public interface DataSourceConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.wso2.integrationstudio.ds.DsPackage#getDataSourceConfiguration_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.integrationstudio.ds.ConfigurationProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.wso2.integrationstudio.ds.DsPackage#getDataSourceConfiguration_Property()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ConfigurationProperty> getProperty();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.wso2.integrationstudio.ds.DsPackage#getDataSourceConfiguration_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.ds.DataSourceConfiguration#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Enable OData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable OData</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable OData</em>' attribute.
	 * @see #setEnableOData(boolean)
	 * @see org.wso2.integrationstudio.ds.DsPackage#getDataSourceConfiguration_EnableOData()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean isEnableOData();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.ds.DataSourceConfiguration#isEnableOData <em>Enable OData</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable OData</em>' attribute.
	 * @see #isEnableOData()
	 * @generated
	 */
	void setEnableOData(boolean value);

} // DataSourceConfiguration
