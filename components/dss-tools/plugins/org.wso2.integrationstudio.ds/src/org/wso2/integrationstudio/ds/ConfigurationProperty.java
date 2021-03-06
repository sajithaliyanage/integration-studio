/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.integrationstudio.ds;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Property</b></em>
 * '.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.ds.ConfigurationProperty#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.ds.ConfigurationProperty#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.ds.ConfigurationProperty#getSecretAlias <em>Secret Alias</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.ds.DsPackage#getConfigurationProperty()
 * @model extendedMetaData="name='property_._type' kind='simple'"
 * @generated
 */
public interface ConfigurationProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.wso2.integrationstudio.ds.DsPackage#getConfigurationProperty_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="name=':0' kind='simple'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.ds.ConfigurationProperty#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.wso2.integrationstudio.ds.DsPackage#getConfigurationProperty_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.ds.ConfigurationProperty#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Secret Alias</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secret Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secret Alias</em>' attribute.
	 * @see #setSecretAlias(String)
	 * @see org.wso2.integrationstudio.ds.DsPackage#getConfigurationProperty_SecretAlias()
	 * @model default=""
	 * @generated
	 */
	String getSecretAlias();

	/**
	 * Sets the value of the '{@link org.wso2.integrationstudio.ds.ConfigurationProperty#getSecretAlias <em>Secret Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secret Alias</em>' attribute.
	 * @see #getSecretAlias()
	 * @generated
	 */
	void setSecretAlias(String value);

} // ConfigurationProperty
