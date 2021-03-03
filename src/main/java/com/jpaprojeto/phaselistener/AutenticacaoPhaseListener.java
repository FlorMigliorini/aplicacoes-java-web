package com.jpaprojeto.phaselistener; //código de autenticação

import java.util.regex.Pattern;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AutenticacaoPhaseListener implements PhaseListener {

    private static final String RESTRICTION_PATTERN = "^/restrito/.*";

    public PhaseId getPhaseId() { //devolve qual fase do JSF nosso listener irá escutar

        return PhaseId.RESTORE_VIEW; //ndicar que queremos ser noti?cados antes e depois de todas as fases.

    }

    public void beforePhase(PhaseEvent event) {
    }

    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();

        String viewId = context.getViewRoot().getViewId();

        boolean urlProtegida = Pattern.matches(RESTRICTION_PATTERN, viewId);

        Object usuario = context.getExternalContext()
                .getSessionMap().get("usuarioLogado");
        if (urlProtegida && usuario == null) {
            NavigationHandler navigator = context
                    .getApplication()
                    .getNavigationHandler();
            navigator.handleNavigation(context, null, "login");
        }
    }

    public void listener(ActionEvent event) {
        UIComponent source = event.getComponent();
        System.out.println("Ação executada no componente " + source.getId());
    }
}
