package api;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface partRepository extends CrudRepository<part, Integer> {


}