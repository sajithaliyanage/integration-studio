/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.integrationstudio.gmf.esb.EndpointFlow;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.SendContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Send Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.SendContainerImpl#getEndpointFlow <em>Endpoint Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SendContainerImpl extends EsbNodeImpl implements SendContainer {
    /**
     * The cached value of the '{@link #getEndpointFlow() <em>Endpoint Flow</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpointFlow()
     * @generated
     * @ordered
     */
    protected EndpointFlow endpointFlow;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SendContainerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.SEND_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EndpointFlow getEndpointFlow() {
        return endpointFlow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEndpointFlow(EndpointFlow newEndpointFlow, NotificationChain msgs) {
        EndpointFlow oldEndpointFlow = endpointFlow;
        endpointFlow = newEndpointFlow;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW, oldEndpointFlow, newEndpointFlow);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEndpointFlow(EndpointFlow newEndpointFlow) {
        if (newEndpointFlow != endpointFlow) {
            NotificationChain msgs = null;
            if (endpointFlow != null)
                msgs = ((InternalEObject)endpointFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW, null, msgs);
            if (newEndpointFlow != null)
                msgs = ((InternalEObject)newEndpointFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW, null, msgs);
            msgs = basicSetEndpointFlow(newEndpointFlow, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW, newEndpointFlow, newEndpointFlow));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW:
                return basicSetEndpointFlow(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW:
                return getEndpointFlow();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW:
                setEndpointFlow((EndpointFlow)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW:
                setEndpointFlow((EndpointFlow)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EsbPackage.SEND_CONTAINER__ENDPOINT_FLOW:
                return endpointFlow != null;
        }
        return super.eIsSet(featureID);
    }

} // SendContainerImpl
