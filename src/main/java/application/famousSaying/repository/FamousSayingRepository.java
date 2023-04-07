package application.famousSaying.repository;

import application.famousSaying.entity.FamousSaying;

import java.util.ArrayList;
import java.util.List;

public class FamousSayingRepository {
    private int id;
    private List<FamousSaying> sayingList;
    public FamousSayingRepository() {
        this.id = 1;
        this.sayingList = new ArrayList<>();
    }

    public FamousSaying findById(int commandId) {
        for (FamousSaying famousSaying : this.sayingList) {
            if (famousSaying.getId() == commandId) {
                return famousSaying;
            }
        }
        return null;
    }

    public int record(String author, String contents) {
        this.sayingList.add(new FamousSaying(id, author, contents));
        return id++;
    }

    public List<FamousSaying> getSayingList() {
        return this.sayingList;
    }

    public void delete(FamousSaying famousSaying) {
        this.sayingList.remove(famousSaying);
    }

    public void modify(FamousSaying famousSaying, String author, String contents) {
        famousSaying.setAuthor(author);
        famousSaying.setContents(contents);
    }
}
