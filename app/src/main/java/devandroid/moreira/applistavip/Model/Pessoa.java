package devandroid.moreira.applistavip.Model;

public class Pessoa {

    private String PrimeiroNome;
    private String SobreNome;
    private String CursoDesejado;

    private String TelefoneContato;


    public void Pessoa () {

    }

    public String getPrimeiroNome() {
        return PrimeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.PrimeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return SobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.SobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return CursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.CursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return TelefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.TelefoneContato = telefoneContato;
    }




}
