
package DATOS;

import java.io.Serializable;


public abstract class Usuario extends Persona implements Icodigo, Serializable {
    private String usuario, password;

    public Usuario(String usuario, String password, String nombre, String apellido, long cedula, long telefono) {
        super(nombre, apellido, cedula, telefono);
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public boolean loguearse(String usuario, String password){
        if(usuario.equals(this.usuario) && password.equals(this.password)){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public long getKeys(){
        return this.getCedula();
    }
    
    public abstract boolean verPropuestas();
    
}
