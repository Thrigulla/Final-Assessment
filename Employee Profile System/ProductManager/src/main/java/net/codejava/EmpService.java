
package net.codejava;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class EmpService {
    @Autowired
    private EmpRepository repo;
    public List<Employee> listAll()
    {
        return repo.findAll();
    }

    public void save(Employee employee)
    {
        repo.save(employee);
    }

    public Employee get(long id)
    {

        return repo.findById(id).get();
    }

    public void delete(long id) {

        repo.deleteById(id);
    }
}