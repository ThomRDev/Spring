
public interface ProductDao {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void deleteById(int id);
}


// esto puede se una implementacion para mysql o postgres o oracle, yo solo inyectaria ProductDao
// indicamos que esta clase de conectara con una base de datos
@Repository
// @Component // si no se conecta a ninguna base de datos
// https://github.com/profepato/demo-spring-boot/blob/develop/src/main/java/cl/example/demo/dao/impl/ProductDaoImpl.java
// con component le decimos que esa clase este en el contenedor de objetos de spring
public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductRowMapper());
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO products (name, brand, price, stock) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getBrand(), product.getPrice(), product.getStock());
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, brand = ?, price = ?, stock = ? WHERE id = ?";
        jdbcTemplate.update(sql, product.getName(), product.getBrand(), product.getPrice(), product.getStock(), product.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String brand = resultSet.getString("brand");
            int price = resultSet.getInt("price");
            int stock = resultSet.getInt("stock");
            return new Product(id, name, brand, price, stock);
        }
    }
}

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(@Autowired ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product getProductById(int id) {
        return productDao.findById(id);
    }

    public void saveProduct(Product product) {
        productDao.save(product);
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public void deleteProductById(int id) {
        productDao.deleteById(id);
    }
}

La estructura seria de la carpeta seria igual que los servicios

dao
- imp/ProductDaoImpl
- ProductDao = interface