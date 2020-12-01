package listado;

import android.widget.Spinner;

public class listadoClientes {
    private String id;
    private  String nombre;
    private String destino;
    private String tipopromo;

    public String getTipopromo() {
        return tipopromo;
    }

    public void setTipopromo(String tipopromo) {
        this.tipopromo = tipopromo;
    }

    public listadoClientes(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return nombre +", " + destino + ", " + tipopromo ;
    }
}
