// Step 2: Repository Interface
interface CustomerRepository {
    String findCustomerById(String id);
}

// Step 3: Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        // Dummy data for demonstration
        return "Customer{id='" + id + "', name='Tushant'}";
    }
}

// Step 4: Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Step 5: Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomer(String id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Found: " + customer);
    }
}

// Step 6: Main Class to Test Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.getCustomer("101");
    }
}
