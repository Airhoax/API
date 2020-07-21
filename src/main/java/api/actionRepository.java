package api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface actionRepository extends CrudRepository<paction, Integer> {


}