package org.wso2.integrationstudio.gmf.esb.diagram.custom;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.integrationstudio.gmf.esb.InputConnector;

public abstract class AbstractBaseFigureFaultInputConnectorEditPart extends AbstractInputConnectorEditPart {

    public AbstractBaseFigureFaultInputConnectorEditPart(View view) {
        super(view);
    }

    public void activate() {
        super.activate();
        toggleVisibility((InputConnector) ((Node) this.getModel()).getElement());
    }

    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        if (notification.getNotifier() instanceof InputConnector) {
            toggleVisibility((InputConnector) notification.getNotifier());
        }
    }
}
