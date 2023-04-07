package application.famousSaying.service;

import application.famousSaying.entity.FamousSaying;
import application.famousSaying.repository.FamousSayingRepository;

import java.util.List;

public class FamousSayingService {

    FamousSayingRepository sayingRepository;

    public FamousSayingService() {
        this.sayingRepository = new FamousSayingRepository();
    }

    public FamousSaying findById(int commandId) {
        return this.sayingRepository.findById(commandId);
    }

    public int record(String author, String contents) {
        return this.sayingRepository.record(author, contents);
    }

    public List<FamousSaying> getSayingList() {
        return this.sayingRepository.getSayingList();
    }

    public void delete(FamousSaying famousSaying) {
        this.sayingRepository.delete(famousSaying);
    }

    public void modify(FamousSaying famousSaying, String author, String contents) {
        this.sayingRepository.modify(famousSaying, author, contents);
    }
}
