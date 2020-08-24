package com.company.Files;

public class Caja {
    Persona persona;
    boolean isNew;

    public Caja(boolean isNew) {
        this.isNew = isNew;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public boolean estaocupada(){

        return persona!=null;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
