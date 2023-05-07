package br.com.ksi.DesafioKSICadastroDeClientes.dto;

import java.util.List;

public class JsonRetorno {

    private List<String> accepted_devices;
    private List<String> rejected_devices;

    public JsonRetorno(List<String> accepted_devices, List<String> rejected_devices) {
        this.accepted_devices = accepted_devices;
        this.rejected_devices = rejected_devices;
    }

    public List<String> getAccepted_devices() {
        return accepted_devices;
    }

    public void setAccepted_devices(List<String> accepted_devices) {
        this.accepted_devices = accepted_devices;
    }

    public List<String> getRejected_devices() {
        return rejected_devices;
    }

    public void setRejected_devices(List<String> rejected_devices) {
        this.rejected_devices = rejected_devices;
    }
}
