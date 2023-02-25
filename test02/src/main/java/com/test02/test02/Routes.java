package com.test02.test02;

import com.test02.test02.models.Book;
import com.test02.test02.models.Product;
import com.test02.test02.models.StudentData;
import com.test02.test02.models.UserData;
import com.test02.test02.mybeans.MyBean;
import com.test02.test02.services.OrdenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // sirve para defirnir rutas
public class Routes {

    //private OrdenService os = new OrdenService();

    // con inyeccion de dependencias
    private OrdenService os;
    private MyBean miBean;
    public Routes(OrdenService os, MyBean miBean){
        this.os = os;
        this.miBean = miBean;
    }

    private final Logger log = LoggerFactory.getLogger(Routes.class);

    @GetMapping("/")
    public String endpoint(){
        return "data";
    }

    // path param {id}
    @GetMapping("/book/{id}")
    public String readBooks(@PathVariable int id){
        return " id = " + id;
    }
    @GetMapping("/book/{id}/{editorial}")
    public String editorial(@PathVariable int id,@PathVariable int editorial){
        return " id = " + id + " Editorial =  " + editorial;
    }

    // query params
    // thom?params=Asdasdasd
    @GetMapping("/{name}")
    public String users(@PathVariable String name, @RequestParam String params){
        return "name = " + name + ", params = " + params;
    }

    // query params
    // tomate?a=Asdasdasd&b=2
    @GetMapping("/verdura/{name}")
    public String verduras(@PathVariable String name, @RequestParam String a,@RequestParam int b){
        return "name = " + name + ", a = " + a + " b = "+b;
    }


    // generico puede venir un json muy grande
    @PostMapping("/book")
    public String saveBook(@RequestBody Map<String,Object> book){
        log.debug(book.toString());
        var keys = book.keySet();

        keys.forEach(key -> {
            log.debug(book.get(key).toString());
            log.debug("llave {} value {}",key,book.get(key));
        });

        return "book saved";
    }

    // con una ruta especificia
    @PostMapping("/save-book")
    public String _saveBook(@RequestBody Book book){
        log.debug(book.toString());
        return "book saved";
    }

    @GetMapping("/great")
    @ResponseStatus(value = HttpStatus.OK,reason = "todo chvr")
    public String greeting(){
        return "blablabla";
    }


    @GetMapping("/algo")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY,reason = "Esta ruta esta deprecated, ir a /api/v2/algo")
    public String algo(){
        return  "";
    }


    // ResponseEntity me ayuda a enviar el cuerpo y el estatus, tambien me ayuda a enviar json
    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimals(@PathVariable String lugar){
        if(lugar.equals("granja")){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("caballo, vaca, objeja");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no existen lugares en nuestra base de datos");
    }

    @GetMapping("/secreto")
    public ResponseEntity<String> secreto(){
        throw new NullPointerException("error con las credenciales <blablabla>");
    }

    @GetMapping("/json")
    public ResponseEntity<String> getData(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Content-Type","application/json")
                .body("{\"nombre\":\"thom\"}");
    }

    @GetMapping("/json-v2")
    // Object puede ser cualquier cosa
    public Map<String,Map<String,Object>> getData2(){
        return Map.of("a",Map.of("b",1,"c",true));
    }

    @GetMapping("/json-v3")
    // Object puede ser cualquier cosa
    public ResponseEntity<Map<String,Map<String,Object>>> getData3(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Content-Type","application/json")
                .body(Map.of("a",Map.of("b",1,"c",true)));
    }

    @GetMapping("/json-v4")
    public UserData getData4(){
        return new UserData(15,"thom");
    }

    // jackson vs gson
    // serializar y deserealizar de objetos java a json y viceveersa

    @GetMapping("/students")
    public StudentData students(){
        return new StudentData(65465465,"adasdasd","asdasd");
    }


    @PostMapping("/order")
    public String createOrder(@RequestBody List<Product> products){
        this.os.saveOrder(products);
        return "saved";
    }

    @GetMapping("/bean")
    public String bean(){
        this.miBean.hello();
        return "bean completado";
    }
}
