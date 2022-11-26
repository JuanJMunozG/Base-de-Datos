/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;
import Modelo.Carrito;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan
 */
public class Controlador extends HttpServlet {

    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    List<Producto> productos = new ArrayList<>();
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalpago = 0.0;
    int cantidad = 1;
    int idp;
    Carrito car;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String accion = request.getParameter("accion");
      productos = pdao.listar();
        switch(accion){
            case "Comprar":
                totalpago=0.0;
                int idp = Integer.parseInt(request.getParameter("id")); 
                p = pdao.listarId(idp);
                item = item + 1;
                Carrito car = new Carrito();
                car.setItem(item);
                car.setId(p.getId());
                car.setNombre(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*p.getPrecio());
                listaCarrito.add(car);
                for(int i = 0; i < listaCarrito.size(); i++){
                    totalpago= totalpago+listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalpago",totalpago);
                request.setAttribute("carrito",listaCarrito);
                request.setAttribute("contador",listaCarrito.size());
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                
                break;
            case "Agregar":
                int pos = 0;
                cantidad = 1;
                idp = Integer.parseInt(request.getParameter("id")); 
                p = pdao.listarId(idp);
                if(listaCarrito.size() > 0){
                    for(int i = 0; i < listaCarrito.size(); i++){
                        if(idp==listaCarrito.get(i).getId()){
                            pos = i;
                        }
                    }
                    if(idp == listaCarrito.get(pos).getId()){
                        cantidad = listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioCompra()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subtotal);
                    }else{
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setId(p.getId());
                        car.setNombre(p.getNombre());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad*p.getPrecio());
                        listaCarrito.add(car);

                    }
                }else{
                item = item + 1;
                car = new Carrito();
                car.setItem(item);
                car.setId(p.getId());
                car.setNombre(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*p.getPrecio());
                listaCarrito.add(car);
                }
                request.setAttribute("contador",listaCarrito.size());
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                break;
            case "Delete":
                 int idproducto=Integer.parseInt(request.getParameter("id"));
                 System.out.println(idproducto);
                 for(int i = 0; i < listaCarrito.size(); i++){
                     if(listaCarrito.get(i).getId() == idproducto){
                         listaCarrito.remove(i);
                     }
                 }
                request.setAttribute("contador",listaCarrito.size());
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                 break;
            case "Carrito":
                totalpago = 0.0;
                request.setAttribute("carrito",listaCarrito);
                for(int i = 0; i < listaCarrito.size(); i++){
                    totalpago= totalpago+listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalpago",totalpago);
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                break;
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "No autorizado":
                request.getRequestDispatcher("NoAutorizado.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("principal.jsp").forward(request, response);
                break;

            
        }
    }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
