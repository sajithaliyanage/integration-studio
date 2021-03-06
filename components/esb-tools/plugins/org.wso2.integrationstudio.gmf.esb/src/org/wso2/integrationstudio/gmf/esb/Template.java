/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.Template#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.Template#getTemplateType <em>Template Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.Template#getChild <em>Child</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.Template#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.Template#getOnError <em>On Error</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getTemplate()
 * @model
 * @generated
 */
public interface Template extends EsbElement {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getTemplate_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.Template#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Template Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.gmf.esb.TemplateType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Template Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Template Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.TemplateType
     * @see #setTemplateType(TemplateType)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getTemplate_TemplateType()
     * @model
     * @generated
     */
    TemplateType getTemplateType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.Template#getTemplateType <em>Template Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Template Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.TemplateType
     * @see #getTemplateType()
     * @generated
     */
    void setTemplateType(TemplateType value);

    /**
     * Returns the value of the '<em><b>Child</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child</em>' containment reference.
     * @see #setChild(EsbElement)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getTemplate_Child()
     * @model containment="true"
     * @generated
     */
    EsbElement getChild();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.Template#getChild <em>Child</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Child</em>' containment reference.
     * @see #getChild()
     * @generated
     */
    void setChild(EsbElement value);

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.integrationstudio.gmf.esb.TemplateParameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getTemplate_Parameters()
     * @model containment="true"
     * @generated
     */
    EList<TemplateParameter> getParameters();

    /**
     * Returns the value of the '<em><b>On Error</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Error</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Error</em>' containment reference.
     * @see #setOnError(RegistryKeyProperty)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getTemplate_OnError()
     * @model containment="true"
     * @generated
     */
    RegistryKeyProperty getOnError();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.Template#getOnError <em>On Error</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Error</em>' containment reference.
     * @see #getOnError()
     * @generated
     */
    void setOnError(RegistryKeyProperty value);

} // Template
