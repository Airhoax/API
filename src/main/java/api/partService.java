package api;


import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class partService {

    @Autowired
    private partRepository partRepo;

    public List<part> listAll() {
        return (List<part>) partRepo.findAll();
    }

    public void save(part part) {
    	partRepo.save(part);
    }
    public part get(Integer id) {
        return partRepo.findById(id).get();
    }

    public void delete(Integer id) {
    	partRepo.deleteById(id);
    }

}