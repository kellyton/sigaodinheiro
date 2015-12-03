package models;
 
import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
class PagamentoKey implements Serializable{
        public static final long serialVersionUID = -4810725213896099801L;
        public long id;
        public String estado;
        public String cidade;
}
 
@Entity
//@IdClass(PagamentoKey.class)
public class Pagamento {
 
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Column
        private String estado;
        @Column
        private String cidade;
        @Column
        private String area;
        @Column
        private String elemento;
        @Column
        private String orgao;
        @Column
        private String cnpj;
        @Column
        private String nomeCredor;
        @Column
        private Date data;
        @Column
        private int ano;
        @Column
        private float valor;
 
        public Pagamento(){}
       
        public Pagamento(long id, String area, String elemento, String orgao, String cnpj, String estado, String cidade, float valor) {
                setId(id);
                setArea(area);
                setElemento(elemento);
                setOrgao(orgao);
                setCnpj(cnpj);
                setEstado(estado);
                setCidade(cidade);
                setValor(valor);
        }
 
        public long getId() {
                return id;
        }
 
        public void setId(long id) {
                this.id = id;
        }
 
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
 
        public String getArea() {
                return area;
        }
 
        public void setArea(String area) {
                this.area = area;
        }
 
        public String getElemento() {
                return elemento;
        }
 
        public void setElemento(String elemento) {
                this.elemento = elemento;
        }
 
        public String getOrgao() {
                return orgao;
        }
 
        public void setOrgao(String orgao) {
                this.orgao = orgao;
        }
 
        public String getCnpj() {
                return cnpj;
        }
 
        public void setCnpj(String cnpj) {
                this.cnpj = cnpj;
        }
 
        public String getNomeCredor() {
                return nomeCredor;
        }
 
        public void setNomeCredor(String nomeCredor) {
                this.nomeCredor = nomeCredor;
        }
 
        public Date getData() {
                return data;
        }
 
        public void setData(Date data) {
                this.data = data;
        }
 
        public int getAno() {
                return ano;
        }
 
        public void setAno(int ano) {
                this.ano = ano;
        }
 
        public float getValor() {
                return valor;
        }
 
        public void setValor(float valor) {
                this.valor = valor;
        }
       
}