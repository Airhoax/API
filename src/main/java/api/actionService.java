package api;


import java.util.List;
import api.paction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class actionService {

    @Autowired
    private actionRepository pactionRepo;

    public List<paction> listAll() {
        return (List<paction>) pactionRepo.findAll();
    }

    public void save(paction paction) {
    	pactionRepo.save(paction);
    }
    public paction get(Integer id) {
        return pactionRepo.findById(id).get();
    }

    public void delete(Integer id) {
    	pactionRepo.deleteById(id);
    }

}