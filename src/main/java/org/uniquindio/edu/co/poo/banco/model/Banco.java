package org.uniquindio.edu.co.poo.banco.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Banco {
    private String nombre;
    private String ubicacion;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cajero> listaCajeros;
    private ArrayList<Administrador> listaAdministradores;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Movimiento> listaMovimientos;


    public Banco(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaClientes = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaCajeros = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();
        this.listaMovimientos = new ArrayList<>();
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

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
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

    public boolean registrarCuenta(String tipoCuenta) {

        //construye cuenta
        if (tipoCuenta.equals("Cuenta Corriente")) {
            CuentaCorriente cuentaCorriente = new CuentaCorriente(200000, 2000, LocalDate.now(), 0);
            System.out.println(cuentaCorriente.getCodigo());
            if (!verificarExistenciaCuenta(cuentaCorriente.codigo)) {
                listaCuentas.add(cuentaCorriente);
                return true;
            }

        } else if (tipoCuenta.equals("Cuenta Ahorros")) {
            CuentaAhorros cuentaAhorros = new CuentaAhorros(2000, 0, LocalDate.now(), 0);
            System.out.println(cuentaAhorros.getCodigo());
            if (!verificarExistenciaCuenta(cuentaAhorros.codigo)) {
                listaCuentas.add(cuentaAhorros);
                return true;

            } else {
                CuentaEmpresarial cuentaEmpresarial = new CuentaEmpresarial(1000000, "Coco", LocalDate.now(), 0);
                System.out.println(cuentaEmpresarial.getCodigo());
                if (!verificarExistenciaCuenta(cuentaEmpresarial.codigo)) {
                    listaCuentas.add(cuentaEmpresarial);
                }
                return true;

            }


        }
        return false;
    }

    public void registrarCuenta2(Cuenta cuenta){
        listaCuentas.add(cuenta);
    }

    public boolean verificarExistenciaCuenta(String codigo){

        for (Cuenta cuentaAux : listaCuentas) {
            if (cuentaAux.getCodigo().equals(codigo)) {

                return true;

            }
        }
        return false;
    }


    /*public boolean depositarEntreCuentas(String codigoOrigen, String codigoDestino, double monto) {
        Cuenta origen = buscarCuenta(codigoOrigen);
        Cuenta destino = buscarCuenta(codigoDestino);

        if (origen == null || destino == null) {
            System.out.println("Error: Una de las cuentas no existe.");
            return false;
        }

        if (monto <= 0) {
            System.out.println("Error: El monto debe ser positivo.");
            return false;
        }

        if (origen.realizarRetiro(monto)) {
            destino.realizarDeposito(monto);

            Cliente cliente1 = new Cliente ("Vero", "Perez", "321", "vero@");
            Cliente cliente2 = new Cliente ("Sebas", "Ramo", "098", "sebas@");
            Cuenta cuentaOrigen = new CuentaCorriente(50000, 5000, cliente1, LocalDate.now(), "345", 500000 );


            Cuenta cuentaDestino = new CuentaAhorros(8000, 2, cliente2, LocalDate.now(), "345", 200000);

            Transaccion transaccion = new Transaccion("123", LocalDateTime.now(), 5000, cuentaOrigen, cuentaDestino, TipoTransaccion.DEPOSITO );
            listaTransacciones.add(transaccion);
            System.out.println("Depósito exitoso de " + monto + " desde " + codigoOrigen + " a " + codigoDestino);
            return true;
        } else {
            System.out.println("Error: Fondos insuficientes en la cuenta origen.");
            return false;
        }
    }
    */
    private Cuenta buscarCuenta(String codigoCuenta) {
        for (Cuenta cuentaAux : listaCuentas) {
            if (cuentaAux.getCodigo().equals(codigoCuenta)) {
                return cuentaAux;
            }
        }
        return null;
    }

    public boolean realizarDeposito(Deposito deposito) {
        // Verificar que el monto sea válido
        if (deposito.getSaldoADepositar() <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return false;
        }

        // Buscar la cuenta por su código
        Cuenta cuenta = buscarCuentaPorCodigo(deposito.getCodigoCuentaADepositar());
        if (cuenta == null) {
            System.out.println("La cuenta no existe.");
            return false;
        }

        // Realizar el depósito
        cuenta.depositar(deposito.getSaldoADepositar());
        //Agregar movimiento deposito a la lista de movimientos del banco
        registrarDeposito(deposito);

        System.out.println("Depósito exitoso. Nuevo saldo: " + cuenta.getSaldo());
        return true;
    }

    public void registrarDeposito(Deposito deposito){
        listaMovimientos.add(deposito);
    }

    public Cuenta buscarCuentaPorCodigo(String codigo) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getCodigo().equals(codigo)) {
                return cuenta;
            }
        }
        return null; // No se encontró ninguna cuenta con ese código
    }


    public ArrayList<Deposito> getListaDepositos() {
        ArrayList<Deposito> listaDepositos = new ArrayList<>();
        for (Movimiento moviAux : listaMovimientos) {
            if (moviAux.getTipoTransaccion() == TipoMovimiento.DEPOSITO) {
                Deposito deposito= (Deposito) moviAux ;
                listaDepositos.add(deposito);
            }
        }
        return listaDepositos;
    }

    public ArrayList<Retiro> getListaRetiros() {
        ArrayList<Retiro> listaRetiros = new ArrayList<>();
        for (Movimiento movimiento : listaMovimientos) {
            if (movimiento.getTipoTransaccion() == TipoMovimiento.RETIRO) {
                Retiro retiro = (Retiro) movimiento ;
                listaRetiros.add(retiro);
            }
        }
        return listaRetiros;
    }

    public void registrarRetiro(Retiro retiro){
        listaMovimientos.add(retiro);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaUsuarios=" + listaUsuarios +
                ", listaCajeros=" + listaCajeros +
                ", listaAdministradores=" + listaAdministradores +
                ", listaCuentas=" + listaCuentas +
                ", listaMovimientos=" + listaMovimientos +
                '}';
    }

    public boolean realizarRetiro(Retiro retiro) {
        // Verificar que el monto sea válido
        if (retiro.getSaldoRetiro() <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return false;
        }

        // Buscar la cuenta por su código
        Cuenta cuenta = buscarCuentaPorCodigo(retiro.getCodigoCuenta());
        if (cuenta == null) {
            System.out.println("La cuenta no existe.");
            return false;
        }

        // Realizar el depósito
        cuenta.retirar(retiro.getSaldoRetiro());
        //Agregar movimiento deposito a la lista de movimientos del banco
        registrarRetiro(retiro);

        System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta.getSaldo());
        return true;
    }

    public boolean transferirDinero(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
        if (monto <= 0) {
            return false;

        }

        if (cuentaOrigen.retirar(monto)) {
            cuentaDestino.depositar(monto);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Transaccion> getListaTransacciones() {
        ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
        for (Movimiento movimiento : listaMovimientos) {
            if (movimiento.getTipoTransaccion() == TipoMovimiento.TRANSACCION) {
                Transaccion transaccion = (Transaccion) movimiento ;
                listaTransacciones.add(transaccion);
            }
        }
        return listaTransacciones;

    }

    public boolean realizarTransaccion(Transaccion transaccion) {
        // Verificar que el monto sea válido
        if (transaccion.getSaldoADepositar() <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return false;
        }

        // Buscar la cuenta por su código
        Cuenta cuentaOrigen = buscarCuentaPorCodigo(transaccion.getCuentaOrigen());
        Cuenta cuentaDestino = buscarCuentaPorCodigo(transaccion.getCuentaDestino());
        if (cuentaOrigen == null && cuentaDestino == null) {
            System.out.println("La cuenta no existe.");
            return false;
        }

        // Realizar el depósito
        cuentaDestino.depositar(transaccion.getSaldoADepositar());
        cuentaOrigen.retirar(transaccion.getSaldoADepositar());
        //Agregar movimiento deposito a la lista de movimientos del banco
        registrarTransaccion(transaccion);
        System.out.println("Transferencia exitosa. Nuevo saldo: " + cuentaOrigen.getSaldo());
        return true;
    }

    public void registrarTransaccion(Transaccion transaccion) {
        listaMovimientos.add(transaccion);

    }

    public void registrarAdministrador(Administrador administrador) {
        listaAdministradores.add(administrador);

    }
}
