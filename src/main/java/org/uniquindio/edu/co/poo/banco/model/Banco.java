package org.uniquindio.edu.co.poo.banco.model;

import java.util.ArrayList;

public class Banco {
    private String nombre;
    private String ubicacion;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cajero> listaCajeros;
    private ArrayList<Administrador> listaAdministradores;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Transaccion> listaTransacciones;


    public Banco(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaClientes = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaCajeros = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();
        this.listaTransacciones = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Cajero> getListaCajeros() {
        return listaCajeros;
    }

    public void setListaCajeros(ArrayList<Cajero> listaCajeros) {
        this.listaCajeros = listaCajeros;
    }

    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public boolean verificarInicioSesionUsuario(String usuario, String contrasena) {
        boolean existeUsuario = false;
        for(Usuario u : listaUsuarios) {
            if (u.getNombreUsuario().equals(usuario) && u.getContrasenia().equals(contrasena)) {
                existeUsuario = true;
                break;
            }
        }
        return existeUsuario;
    }

    public String buscarRoleUsuario(String usuario) {
        String role = "";
        for (Usuario u : listaUsuarios){
            if (u.getNombreUsuario().equals(usuario)){
                role=u.getRole();
                break;
            }

        }
        return role;
    }

    public boolean registrarCliente(Cliente cliente) {
        boolean centinela = false;
        if (!verificarCliente(cliente.getCedula())) {
            listaClientes.add(cliente);
            centinela = true;
        }
        return centinela;
    }

    public boolean verificarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }
    public boolean eliminarCliente(String cedula) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                listaClientes.remove(cliente);
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean centinela = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellidos(actualizado.getApellidos());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean eliminarCajero(String cedula) {
        boolean centinela = false;
        for (Persona persona: listaCajeros) {
            if (persona.getCedula().equals(cedula)) {
                listaCajeros.remove(persona);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean actualizarCajero(String cedula, Cajero actualizado) {
        boolean centinela = false;
        for (Cajero cajero : listaCajeros) {
            if (cajero.getCedula().equals(cedula)) {
                cajero.setCedula(actualizado.getCedula());
                cajero.setNombre(actualizado.getNombre());
                cajero.setApellidos(actualizado.getApellidos());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public boolean registrarCajero(Cajero cajero) {
        boolean centinela = false;
        if (!verificarCliente(cajero.getCedula())) {
            listaCajeros.add(cajero);
            centinela = true;
        }
        return centinela;
    }

    public boolean registrarCuenta(Cuenta nuevaCuenta) {
        for (Cuenta cuentaAux : listaCuentas) {
            if (cuentaAux.getCodigo().equals(nuevaCuenta.getCodigo())) {
                System.out.println("❌ La cuenta ya está registrada en el sistema.");
                return false;
            }
        }

        listaCuentas.add(nuevaCuenta);
        System.out.println("✅ Cuenta registrada exitosamente.");
        return true;
    }

}
