package org.wso2.integrationstudio.gmf.esb.diagram.custom.direction;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.ui.IWorkbenchPart;

public class DirectionFaultMediatorAction extends DirectionEsbNodeAction {

    EditPart editorPart;

    public DirectionFaultMediatorAction(IWorkbenchPart part) {
        super(part);
        setText("Reverse");
        setToolTipText("Set Direction Fault mediator.");
    }

    public void setEditorPart(EditPart editorPart_) {
        editorPart = editorPart_;
    }

    protected void doRun(IProgressMonitor progressMonitor) {

        Reverse(editorPart);
    }

}
