//package com.jpaprojeto.bean;
//
//import com.jpaprojeto.entity.Pedido;
//import com.jpaprojeto.entity.Produto;
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.validator.ValidatorException;
//
//public class PedidoBean {
//
//    private Pedido pedido;
//
//    public void validaProdutoPedidoPopular(FacesContext context,
//            UIComponent component, Object value)
//            throws ValidatorException {
////objeto vem convertido
//        Produto produto = (Produto) value;
//        if (pedido.isPedidoPopular() && produto.getValor() > 200.0) {
//            
//            FacesMessage message = new FacesMessage("Pedido popular: máximo R$ 200");
//            
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            
//            throw new ValidatorException(message);
//        }
//    }
//
//}
