# [apresentacao_thymeleaf_spring_boot_h_2_crud.md](https://github.com/user-attachments/files/23027161/apresentacao_thymeleaf_spring_boot_h_2_crud.md)
# 🎓 Apresentação em Slides – Configurando Thymeleaf para CRUD com Spring Boot + H2

---
## 🎯 **Objetivos da Aula**
- Entender o papel do **Thymeleaf** no Spring MVC.
- Configurar um projeto **Spring Boot + Thymeleaf + H2**.
- Implementar um **CRUD completo** (Listar, Criar, Editar, Excluir).
- Validar dados e exibir mensagens no **formulário**.

---
## 🧠 **Conceitos Fundamentais**
- O **Thymeleaf** é o elo entre **Java** e **HTML**.
- Funciona com tags `th:*` (como `th:text`, `th:each`, `th:field`).
- Arquitetura MVC:
  ```
  Request → Controller → Service → Repository → Banco (H2)
  ```

---
## ⚙️ **Dependências Essenciais (pom.xml)**
```xml
spring-boot-starter-web
spring-boot-starter-thymeleaf
spring-boot-starter-data-jpa
com.h2database:h2
```
➡️ Requer **Java 17+** (Spring Boot 3).

---
## 🗂️ **Estrutura do Projeto**
```
controller/
service/
repository/
model/
resources/
 ├─ templates/ → Páginas Thymeleaf
 └─ static/ → CSS / JS / Imagens
```

---
## 🧩 **Configuração (application.properties)**
```properties
spring.datasource.url=jdbc:h2:mem:demo;DB_CLOSE_DELAY=-1
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
✅ Banco em memória, console ativo e SQL visível.

---
## 🧱 **Model – Entidade Person**
```java
@Entity
public class Person {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
}
```
➡️ Representa uma tabela no banco H2.

---
## 🗄️ **Repository – Camada de Acesso**
```java
public interface PersonRepository extends JpaRepository<Person, Long> {}
```
➡️ CRUD pronto com `JpaRepository`.

---
## 🧩 **Service – Regras de Negócio**
```java
@Service
public class PersonService {
  @Autowired private PersonRepository repo;
  public List<Person> listAll() { return repo.findAll(); }
  public void save(Person p) { repo.save(p); }
  public void delete(Long id) { repo.deleteById(id); }
}
```

---
## 🧭 **Controller – Rotas e Views**
```java
@Controller
@RequestMapping("/people")
public class PersonController {
  @GetMapping
  public String list(Model model) {
    model.addAttribute("people", service.listAll());
    return "people/list";
  }
}
```
➡️ Define endpoints e envia dados às views.

---
## 🧩 **View – Listagem (list.html)**
```html
<table>
  <tr th:each="p : ${people}">
    <td th:text="${p.name}"></td>
    <td th:text="${p.email}"></td>
  </tr>
</table>
```
➡️ `th:each` percorre a lista enviada pelo Controller.

---
## 🧩 **View – Formulário (form.html)**
```html
<form th:object="${person}" th:action="@{/people}" method="post">
  <input th:field="*{name}" placeholder="Nome">
  <input th:field="*{email}" placeholder="Email">
  <button type="submit">Salvar</button>
</form>
```
➡️ `th:field` vincula o campo ao atributo Java.

---
## ▶️ **Execução do Projeto**
1. Rodar `mvn spring-boot:run`.
2. Acessar `http://localhost:8080/people`.
3. Console H2: `http://localhost:8080/h2-console`
   - JDBC: `jdbc:h2:mem:demo`

---
## 🧪 **Testes Rápidos**
- Cadastrar nova pessoa ✅
- Editar e atualizar dados ✏️
- Excluir registro 🗑️
- Testar validações e mensagens ⚠️

---
## 💡 **Extensões Possíveis**
- Adicionar **paginação e busca**.
- Aplicar **Bootstrap** aos templates.
- Migrar para **MySQL/MariaDB**.
- Adicionar **upload de imagens**.

---
## 🎓 **Conclusão**
> O Thymeleaf torna o ensino de CRUD muito mais visual e compreensível.
> 
> Ele mostra claramente a conexão entre **dados Java** e **HTML dinâmico**, 
> fortalecendo o entendimento do padrão **MVC**.

