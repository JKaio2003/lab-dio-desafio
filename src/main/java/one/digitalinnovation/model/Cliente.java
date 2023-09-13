package one.digitalinnovation.model;

import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Cliente implements Comparable<Cliente>{
    @Id
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Long idade;

    @Override
    public int compareTo(Cliente c) {
        return Long.compare(getIdade(), c.getIdade());
    }

    private static class Endereco {
        private String estado;
        private String cidade;
        private String rua;
        private String numero;

        public Endereco(String estado, String cidade, String rua, String numero) {
            this.estado = estado;
            this.cidade = cidade;
            this.rua = rua;
            this.numero = numero;
        }

        public Endereco() { }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        @Override
        public String toString() {
            return "Endereco{" +
                    "estado='" + estado + '\'' +
                    ", cidade='" + cidade + '\'' +
                    ", rua='" + rua + '\'' +
                    ", numero='" + numero + '\'' +
                    '}';
        }
    }
    private Endereco endereco;

    private Cliente(String nome, LocalDate dataNascimento, String estado, String cidade, String rua, String numero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = new Endereco(estado, cidade, rua, numero);
        this.idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Long getIdade() {
        return idade;
    }

    public static Cliente getInstance(String nome, LocalDate dataNascimento,
                                      String estado, String cidade,
                                      String rua, String numero) {
        return new Cliente(nome, dataNascimento, estado, cidade, rua, numero);
    }
}
