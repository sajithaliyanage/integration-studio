/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.gmf.esb;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clone Target Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.CloneTargetContainer#getMediatorFlow <em>Mediator Flow</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getCloneTargetContainer()
 * @model
 * @generated
 */
public interface CloneTargetContainer extends EsbNode {
    /**
     * Returns the value of the '<em><b>Mediator Flow</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mediator Flow</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mediator Flow</em>' containment reference.
     * @see #setMediatorFlow(MediatorFlow)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getCloneTargetContainer_MediatorFlow()
     * @model containment="true"
     * @generated
     */
    MediatorFlow getMediatorFlow();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.CloneTargetContainer#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
     * @see #getMediatorFlow()
     * @generated
     */
    void setMediatorFlow(MediatorFlow value);

} // CloneTargetContainer
